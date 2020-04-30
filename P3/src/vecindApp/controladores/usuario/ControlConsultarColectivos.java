package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.ConsultarColectivos;

public class ControlConsultarColectivos {
    private ConsultarColectivos vista;
    private Ventana<Notificacion, Proyecto> frame;
    private Aplicacion modelo;

    public ControlConsultarColectivos(Ventana<Notificacion, Proyecto> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getpConsultarColectivos();
        this.modelo = modelo;
    }
}
