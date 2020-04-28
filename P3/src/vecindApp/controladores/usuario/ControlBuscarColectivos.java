package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.BuscarColectivos;

public class ControlBuscarColectivos {
    private BuscarColectivos vista;
    private Ventana frame;
    private Aplicacion modelo;

    public ControlBuscarColectivos(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getpBuscarColectivos();
        this.modelo = modelo;
    }
}
