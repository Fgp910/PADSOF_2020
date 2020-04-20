package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.vistas.Ventana;

public class Controlador {
    private Ventana frame;
    private Aplicacion modelo;

    private ControlLoginUsuario cLogin;

    public Controlador(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.modelo = modelo;
        cLogin = new ControlLoginUsuario(frame, modelo);
    }

    public ControlLoginUsuario getControlLoginUsuario() {
        return cLogin;
    }
}
