package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.Colectivo;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.controladores.DetalleProyecto;
import vecindApp.vistas.home.HomeUsuario;
import vecindApp.vistas.usuario.BuscarProyectos;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Define el controlador para la vista de busqueda de proyectos.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ControlBuscarProyectos implements ListSelectionListener, ActionListener {
    private BuscarProyectos<Proyecto> vista;
    private HomeUsuario<Notificacion, Proyecto, ElementoColectivo> frame;
    private Aplicacion modelo;

    /**
     * Crea el controlador para la vista de busqueda de proyectos
     * @param frame el componente padre (la vista principal del ciudadano)
     * @param modelo la aplicacion fuente
     */
    public ControlBuscarProyectos(HomeUsuario<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getBuscarProyectos();
        this.modelo = modelo;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            Proyecto selec = vista.getLista().getSelectedValue();
            if (selec == null) {
                vista.getInfoButton().setEnabled(false);
                vista.getApoyarButton().setEnabled(false);
                vista.getSubButton().setEnabled(false);
            } else {
                vista.getInfoButton().setEnabled(true);
                vista.getApoyarButton().setEnabled(!selec.isCaducado());
                vista.getSubButton().setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Proyecto proy = vista.getLista().getSelectedValue();

        if (e.getSource().equals(vista.getInfoButton())) {
            DetalleProyecto.mostrarProyecto(proy, vista);
        } else if (e.getSource().equals(vista.getApoyarButton())) {
            String[] op = {"Individual", "Colectivo"};
            int ret = JOptionPane.showOptionDialog(vista,
                    "Desea dar un apoyo:",
                    "Apoyo",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    op,
                    op[0]);

            if (ret == JOptionPane.YES_OPTION) {
                proy.recibirApoyo((Ciudadano) modelo.getUsuarioActual());
                JOptionPane.showMessageDialog(vista,
                        "Apoyo exitoso.\n(Su apoyo solo se cuenta una vez)",
                        "Apoyo",
                        JOptionPane.INFORMATION_MESSAGE);
                frame.getNotificaciones().update(modelo.getUsuarioActual().getPendientes(), true);
            } else if (ret == JOptionPane.NO_OPTION) {
                List<Colectivo> rep = ((Ciudadano)modelo.getUsuarioActual()).getColectivosRepresentados();
                if (rep.isEmpty()) {
                    JOptionPane.showMessageDialog(vista,
                            "No representa a ningún colectivo.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Object[] arr = rep.toArray();
                Colectivo col = (Colectivo)JOptionPane.showInputDialog(vista,
                        "Seleccione uno de sus colectivos:",
                        "Apoyo colectivo",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        arr,
                        arr[0]);
                if (col == null) {
                    JOptionPane.showMessageDialog(vista,
                            "Debe seleccionar un colectivo.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    proy.recibirApoyo(col);
                    JOptionPane.showMessageDialog(vista,
                            "Apoyo exitoso.\n(Su apoyo solo se cuenta una vez)",
                            "Apoyo",
                            JOptionPane.INFORMATION_MESSAGE);
                    frame.getNotificaciones().update(modelo.getUsuarioActual().getPendientes(), true);
                }
            }
        } else if (e.getSource().equals(vista.getSubButton())) {
            if (proy.addSuscriptor((Ciudadano) modelo.getUsuarioActual())) {
                JOptionPane.showMessageDialog(vista,
                        "Suscripción exitosa al proyecto.",
                        "Suscripción",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vista,
                        "Ya está suscrito a este proyecto.",
                        "Suscripción",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
