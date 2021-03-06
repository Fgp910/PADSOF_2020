package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.notificacion.NotificacionProy;
import vecindApp.vistas.Notificaciones;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Define el controlador para la vista de notificaciones de los usuarios.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ControlNotificaciones implements ListSelectionListener, ActionListener {
    protected Notificaciones<Notificacion> vista;
    protected Aplicacion modelo;

    /**
     * Crea el controlador para la vista de notificaciones de los usuarios
     * @param vista la vista de notificaciones correspondiente
     * @param modelo la aplicacion fuente
     */
    public ControlNotificaciones(Notificaciones<Notificacion> vista, Aplicacion modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (vista.getLista().getSelectedValue() == null) {
                vista.getOpenButton().setEnabled(false);
                vista.getInfoButton().setEnabled(false);
            } else {
                vista.getOpenButton().setEnabled(true);
                if (vista.getLista().getSelectedValue() instanceof NotificacionProy) {
                    vista.getInfoButton().setEnabled(true);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getOpenButton())) {
            Notificacion noti = vista.getLista().getSelectedValue();
            if (noti == null) {
                return;
            }
            int ret = JOptionPane.showConfirmDialog(vista,
                    noti.descripcion(),
                    "Nuevo mensaje",
                    JOptionPane.OK_CANCEL_OPTION);
            if (ret == JOptionPane.OK_OPTION) {
                modelo.getUsuarioActual().eliminarNotificacion(noti);
                vista.remove(noti);
            }
        } else if (e.getSource().equals(vista.getInfoButton())) {
            Notificacion noti = vista.getLista().getSelectedValue();
            if (noti instanceof NotificacionProy) {
                DetalleProyecto.mostrarProyecto(((NotificacionProy) noti).getSujeto(), vista);
            }
        }
    }
}
