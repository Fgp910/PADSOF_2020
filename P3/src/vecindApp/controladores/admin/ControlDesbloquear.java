package vecindApp.controladores.admin;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.admin.Desbloquear;

public class ControlDesbloquear {
    private Desbloquear vista;
    private Ventana<Notificacion> frame;
    private Aplicacion modelo;

    public ControlDesbloquear(Ventana<Notificacion> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeAdmin().getpDesbloquear();
        this.modelo = modelo;
    }
}
