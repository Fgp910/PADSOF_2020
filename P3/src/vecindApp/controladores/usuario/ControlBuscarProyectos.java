package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.BuscarProyectos;

public class ControlBuscarProyectos {
    private BuscarProyectos vista;
    private Ventana frame;
    private Aplicacion modelo;

    public ControlBuscarProyectos(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getpBuscarProyectos();
        this.modelo = modelo;
    }
}
