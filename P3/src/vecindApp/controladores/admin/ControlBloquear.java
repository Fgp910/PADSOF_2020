package vecindApp.controladores.admin;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.admin.Bloquear;

public class ControlBloquear {
    private Bloquear vista;
    private Ventana<Notificacion> frame;
    private Aplicacion modelo;

    public ControlBloquear(Ventana<Notificacion> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeAdmin().getpBloquear();
        this.modelo = modelo;
    }
}
