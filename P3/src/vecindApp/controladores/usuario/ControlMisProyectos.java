package vecindApp.controladores.usuario;

import jdk.nashorn.internal.scripts.JO;
import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.excepciones.CCGGException;
import vecindApp.clases.excepciones.ConexionFallida;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.EstadoProyecto;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.ConsultarProyectos;
import vecindApp.vistas.usuario.MisProyectos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMisProyectos implements ListSelectionListener, ActionListener {
    private MisProyectos<Proyecto> vista;
    private Aplicacion modelo;

    public ControlMisProyectos(MisProyectos<Proyecto> vista, Aplicacion modelo) {
        this.vista = vista;
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
            } else {
                vista.getPopularButton().setEnabled(true);
                if (selec.getEstado().equals(EstadoProyecto.LISTOENVAR)) {
                    vista.getEnviarButton().setEnabled(true);
                }
                if (selec.getEstado().equals(EstadoProyecto.ENVIADO)) {
                    vista.getConsultarButton().setEnabled(true);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Proyecto proy = vista.getLista().getSelectedValue();
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
                        "Informe de Popularidad (número de apoyos): " + proy.generarInformePopularidad(),
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
                        "Proyecto financiado.\nImporte concedido: " + proy.getImporteConcedido(),
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
        }
    }
}
