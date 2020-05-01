package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.BuscarProyectos;

public class ControlBuscarProyectos {
    private BuscarProyectos vista;
    private Ventana<Notificacion, Proyecto, ElementoColectivo> frame;
    private Aplicacion modelo;

    public ControlBuscarProyectos(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getpBuscarProyectos();
        this.modelo = modelo;
    }
}
