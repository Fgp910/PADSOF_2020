package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.usuario.ConsultarColectivos;

public class ControlConsultarColectivos {
    private ConsultarColectivos vista;
    private Ventana frame;
    private Aplicacion modelo;

    public ControlConsultarColectivos(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getpConsultarColectivos();
        this.modelo = modelo;
    }
}
