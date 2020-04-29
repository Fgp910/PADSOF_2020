package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.ConsultarProyectos;

public class ControlConsultarProyectos {
    private ConsultarProyectos vista;
    private Ventana<Notificacion> frame;
    private Aplicacion modelo;

    public ControlConsultarProyectos(Ventana<Notificacion> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getpConsultarProyectos();
        this.modelo = modelo;
    }
}
