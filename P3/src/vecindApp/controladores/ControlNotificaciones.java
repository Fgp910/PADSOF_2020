package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.vistas.Notificaciones;
import vecindApp.vistas.Ventana;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ControlNotificaciones implements ListSelectionListener {
    private Notificaciones vista;
    private Ventana frame;
    private Aplicacion modelo;

    public ControlNotificaciones(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        //this.vista = frame.getHomeUsuario().getNotificaciones();
        this.modelo = modelo;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
