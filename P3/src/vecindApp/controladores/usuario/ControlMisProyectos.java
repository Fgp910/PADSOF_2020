package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.excepciones.CCGGException;
import vecindApp.clases.excepciones.ConexionFallida;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.*;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.MisProyectos;
import vecindApp.vistas.usuario.nuevoProyecto.NuevoProyecto;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ControlMisProyectos implements ListSelectionListener, ActionListener {
    private Ventana<Notificacion, Proyecto, ElementoColectivo> frame;
    private MisProyectos<Proyecto> vista;
    private Aplicacion modelo;

    public ControlMisProyectos(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getMisProyectos();
        this.modelo = modelo;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            Proyecto selec = vista.getLista().getSelectedValue();
            if (selec == null) {
                vista.getPopularButton().setEnabled(false);
                vista.getEnviarButton().setEnabled(false);
                vista.getConsultarButton().setEnabled(false);
                vista.getInfoButton().setEnabled(false);
            } else {
                vista.getPopularButton().setEnabled(true);
                vista.getInfoButton().setEnabled(true);
                if (selec.getEstado().equals(EstadoProyecto.LISTOENVAR)) {
                    vista.getEnviarButton().setEnabled(true);
                    vista.getConsultarButton().setEnabled(false);
                }
                if (selec.getEstado().equals(EstadoProyecto.ENVIADO) || selec.getEstado().equals(EstadoProyecto.FINANCIADO) || selec.getEstado().equals(EstadoProyecto.DENEGADO)) {
                    vista.getEnviarButton().setEnabled(false);
                    vista.getConsultarButton().setEnabled(true);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Proyecto proy = vista.getLista().getSelectedValue();
        if (e.getSource().equals(vista.getCrearButton())) {
            frame.setSize(NuevoProyecto.SIZE[0], NuevoProyecto.SIZE[1]);
            frame.setLocationRelativeTo(null);
            frame.getNuevoProyecto().update(Arrays.stream(Distrito.values())
                    .filter(d -> !d.equals(Distrito.Desconocido))
                    .map(Distrito::toString)
                    .collect(Collectors.toList()));
            frame.mostrarPanel("nuevoProyecto");
        }

        if (proy == null) {
            return;
        }
        if (e.getSource().equals(vista.getPopularButton())) {
            if (proy.getEstado().equals(EstadoProyecto.INICIAL)) {
                JOptionPane.showMessageDialog(vista,
                        "Proyecto pendiente de aprobación",
                        "Pendiente",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista,
                        "Número de apoyos: " + proy.generarInformePopularidad(),
                        "Popularidad",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource().equals(vista.getEnviarButton())) {
            try {
                proy.enviarFinanciacion();
                JOptionPane.showMessageDialog(vista,
                        "Enviado a financiación con éxito",
                        "Financiación",
                        JOptionPane.INFORMATION_MESSAGE);
                vista.getEnviarButton().setEnabled(false);
                vista.getConsultarButton().setEnabled(true);
            } catch (ConexionFallida ex) {
                JOptionPane.showMessageDialog(vista,
                        "Error de conexión con el sistema externo:\n" + ex.toString() + "\nEl proyecto no pudo ser enviado.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch (CCGGException ex) {
                JOptionPane.showMessageDialog(vista,
                        "Error de comunicación con el sistema externo:\n" + ex.toString() + "\nNo se pudo procesar la consulta.",
                        "Error con sistema externo",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource().equals(vista.getConsultarButton())) {
            if (proy.getEstado().equals(EstadoProyecto.ENVIADO)) {
                try {
                    proy.consultarFinanciacion();
                } catch (ConexionFallida ex) {
                    JOptionPane.showMessageDialog(vista,
                            "Error de conexión con el sistema externo:\n" + ex.toString() + "\nNo se pudo procesar la consulta.",
                            "Error de conexión",
                            JOptionPane.ERROR_MESSAGE);
                } catch (CCGGException ex) {
                    JOptionPane.showMessageDialog(vista,
                            "Error de comunicación con el sistema externo:\n" + ex.toString() + "\nNo se pudo procesar la consulta.",
                            "Error con sistema externo",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            if (proy.getEstado().equals(EstadoProyecto.FINANCIADO)) {
                JOptionPane.showMessageDialog(vista,
                        String.format("Proyecto financiado.\nImporte concedido: %.2f", proy.getImporteConcedido()),
                        "Consulta",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (proy.getEstado().equals(EstadoProyecto.DENEGADO)) {
                JOptionPane.showMessageDialog(vista,
                        "Proyecto denegado.",
                        "Consulta",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista,
                        "Pendiente de revisión.\nInténtelo en otro momento.",
                        "Consulta",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (e.getSource().equals(vista.getInfoButton())) {
            if (proy instanceof ProyectoSocial) {
                String nac;
                if (((ProyectoSocial) proy).isNacional())
                    nac = "\nProyecto nacional";
                else
                    nac = "\nProyecto internacional";
                JOptionPane.showMessageDialog(vista, "Titulo: " + proy.getTitulo() +
                                            "\nDescripcion: " + proy.getDescripcion() +
                                            "\nImporte solicitado: " + new DecimalFormat("#.00").format(proy.getImporteSolicitado()) +
                                            "\nTipo de proyecto: Social" +
                                            "\nGrupo Social: " + ((ProyectoSocial)proy).getGrupoSocial() +
                                            nac, "Info", JOptionPane.INFORMATION_MESSAGE);
            }
            else if (proy instanceof ProyectoInfraestructura) {
                String path = ((ProyectoInfraestructura) proy).getImagen();
                ImageIcon img;
                java.net.URL imgURL = getClass().getResource(path);
                if (imgURL != null) {
                    img = new ImageIcon(imgURL, "imagen proyecto");
                } else {
                    System.err.println("Couldn't find file: " + path);
                    img = null;
                }
                JLabel imagen = new JLabel(img);
                JOptionPane.showMessageDialog(vista, "Titulo: " + proy.getTitulo() +
                                            "\nDescripcion: " + proy.getDescripcion() +
                                            "\nImporte solicitado: " + proy.getImporteSolicitado() +
                                            "\nTipo de proyecto: Infraestructura" +
                                            "\nDistritos Afectados: " + ((ProyectoInfraestructura)proy).getAfectados()
                                            , "Info", JOptionPane.INFORMATION_MESSAGE, img);
            }
        }
    }
}
