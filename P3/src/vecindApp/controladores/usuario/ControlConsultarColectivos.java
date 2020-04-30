package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.ConsultarColectivos;

public class ControlConsultarColectivos {
    private ConsultarColectivos vista;
    private Ventana<Notificacion, Proyecto, Ciudadano> frame;
    private Aplicacion modelo;

    public ControlConsultarColectivos(Ventana<Notificacion, Proyecto, Ciudadano> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getpConsultarColectivos();
        this.modelo = modelo;
    }
}
