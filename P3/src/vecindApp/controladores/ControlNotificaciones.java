package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.notificacion.NotificacionProy;
import vecindApp.vistas.Notificaciones;
import vecindApp.vistas.Ventana;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlNotificaciones implements ListSelectionListener, ActionListener {
    private Notificaciones<Notificacion> vista;
    private Ventana frame;
    private Aplicacion modelo;

    public ControlNotificaciones(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        //this.vista = frame.getHomeUsuario().getNotificaciones();
        this.modelo = modelo;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            if (vista.getLista().getSelectedIndex() == -1) {
                vista.getOpenButton().setEnabled(false);
            } else {
                vista.getOpenButton().setEnabled(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = vista.getLista().getSelectedIndex();
        if (index > -1) {
            Notificacion noti = vista.getItem(index);
            int ret = JOptionPane.showConfirmDialog(vista,
                    noti.descripcion(),
                    "Nuevo mensaje",
                    JOptionPane.OK_CANCEL_OPTION);
            if (ret == JOptionPane.OK_OPTION) {
                vista.remove(noti);
            }
        }
    }
}
