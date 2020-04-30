package vecindApp.controladores.admin;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.admin.MinApoyos;

public class ControlMinApoyos {
    private MinApoyos vista;
    private Ventana<Notificacion, Proyecto> frame;
    private Aplicacion modelo;

    public ControlMinApoyos(Ventana<Notificacion, Proyecto> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeAdmin().getpMinApoyos();
        this.modelo = modelo;
    }
}
