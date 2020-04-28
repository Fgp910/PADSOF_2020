package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.ConsultarProyectos;

public class ControlConsultarProyectos {
    private ConsultarProyectos vista;
    private Ventana frame;
    private Aplicacion modelo;

    public ControlConsultarProyectos(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getpConsultarProyectos();
        this.modelo = modelo;
    }
}
