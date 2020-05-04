package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.Colectivo;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.excepciones.ImageNotFoundException;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Distrito;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.clases.proyecto.ProyectoInfraestructura;
import vecindApp.clases.proyecto.ProyectoSocial;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.home.HomeUsuario;
import vecindApp.vistas.usuario.nuevoProyecto.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Define el controlador para la vista de creacion de proyectos.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ControlNuevoProyecto implements ActionListener {
    private NuevoProyecto<ElementoColectivo> vista;
    private Ventana<Notificacion, Proyecto, ElementoColectivo> frame;
    private Aplicacion modelo;

    /**
     * Crea el controlador para la vista de creacion de proyectos
     * @param frame el componente padre (la ventana principal del sistema)
     * @param modelo la aplicacion fuente
     */
    public ControlNuevoProyecto(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getNuevoProyecto();
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getVolver())) {
            frame.mostrarPanel("home");
        } else if (e.getSource().equals(vista.getCrear())) {
            NuevoProyectoPropulsor<ElementoColectivo> vPropulsor = vista.getPropulsorPanel();
            NuevoProyectoTexto vTexto = vista.getTextoPanel();
            NuevoProyectoInfraestructura vInfra = vista.getInfraPanel();
            NuevoProyectoSocial vSocial = vista.getSocialPanel();

            String titulo = vTexto.getTitulo();
            String descripcion = vTexto.getDesc();
            Double importeSolicitado = vTexto.getImporte();
            ElementoColectivo propulsor;
            boolean propCiu;

            if (vPropulsor.isCiudadano()) {
                propulsor = (Ciudadano) modelo.getUsuarioActual();
                propCiu = true;
            } else if (vPropulsor.isColectivo()) {
                propulsor = vPropulsor.getSelected();
                propCiu = false;

                if (propulsor == null) {
                    JOptionPane.showMessageDialog(vista,
                            "Seleccione uno de sus colectivos para proponer el proyecto\n(o marque la opción \"Soy ciudadano\").",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vista,
                        "Seleccione si la propuesta será individual o colectiva.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (titulo == null || titulo.length() > Proyecto.MAXTIT) {
                JOptionPane.showMessageDialog(vista,
                        "Introduzca un título para su proyecto (máximo " + Proyecto.MAXTIT + " caracteres).",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (descripcion == null || descripcion.length() > Proyecto.MAXDESC) {
                JOptionPane.showMessageDialog(vista,
                        "Introduzca una descripción para su proyecto (máximo " + Proyecto.MAXDESC + " caracteres).",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (importeSolicitado == null || importeSolicitado < 100) {
                JOptionPane.showMessageDialog(vista,
                        String.format("Introduzca el importe solicitado para su proyecto (mínimo %.2f €).", Proyecto.MINIMPORTE),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (vInfra.isSelected()) {
                String imagen = vInfra.getImagePath();
                List<Distrito> distritosAfectados = vInfra.getDistritos().stream()
                        .map(Distrito::parse)
                        .collect(Collectors.toList());

                if (imagen == null) {
                    JOptionPane.showMessageDialog(vista,
                            "Introduzca la dirección de la imagen de su proyecto.",
                            "Error (infraestructura)",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                File tmp = new File(imagen);
                if (!tmp.exists()) {
                    JOptionPane.showMessageDialog(vista,
                            imagen + " no existe.",
                            "Error (infraestructura)",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (distritosAfectados.isEmpty()) {
                    JOptionPane.showMessageDialog(vista,
                            "Indique los distritos afectados por su proyecto.",
                            "Error (infraestructura)",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (propCiu) {
                    try {
                        Proyecto p = new ProyectoInfraestructura(titulo,
                                descripcion,
                                importeSolicitado,
                                (Ciudadano) propulsor,
                                imagen,
                                distritosAfectados);
                        modelo.addProyecto(p);
                    } catch (ImageNotFoundException ex) {
                        JOptionPane.showMessageDialog(vista,
                                ex.getMessage(),
                                "Error (infraestructura)",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                    modelo.addProyecto(new ProyectoInfraestructura(titulo,
                            descripcion,
                            importeSolicitado,
                            (Colectivo) propulsor,
                            imagen,
                            distritosAfectados));
                }
            } else if (vSocial.isSelected()) {
                String grupoSocial = vSocial.getGrupo();
                boolean nacional;

                if (grupoSocial == null) {
                    JOptionPane.showMessageDialog(vista,
                            "Introduzca el grupo social de su proyecto.",
                            "Error (social)",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (vSocial.isNacional()) {
                    nacional = true;
                } else if (vSocial.isInternacional()) {
                    nacional = false;
                } else {
                    JOptionPane.showMessageDialog(vista,
                            "Indique si su proyecto es nacional o internacional.",
                            "Error (social)",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (propCiu) {
                    modelo.addProyecto(new ProyectoSocial(titulo,
                            descripcion,
                            importeSolicitado,
                            (Ciudadano)propulsor,
                            grupoSocial,
                            nacional));
                } else {
                    modelo.addProyecto(new ProyectoSocial(titulo,
                            descripcion,
                            importeSolicitado,
                            (Colectivo) propulsor,
                            grupoSocial,
                            nacional));
                }
            } else {
                JOptionPane.showMessageDialog(vista,
                        "Indique el tipo de proyecto.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            frame.getHomeUsuario().getMisProyectos().removeAll();
            frame.getHomeUsuario().getMisProyectos().addAll(((Ciudadano) modelo.getUsuarioActual()).getProyectos());
        }

        frame.setSize(HomeUsuario.SIZE[0], HomeUsuario.SIZE[1]);
        frame.setLocationRelativeTo(null);
        frame.mostrarPanel("home");
    }
}
