package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.BuscarProyectos;

public class ControlBuscarProyectos {
    private BuscarProyectos vista;
    private Ventana<Notificacion> frame;
    private Aplicacion modelo;

    public ControlBuscarProyectos(Ventana<Notificacion> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getpBuscarProyectos();
        this.modelo = modelo;
    }
}
