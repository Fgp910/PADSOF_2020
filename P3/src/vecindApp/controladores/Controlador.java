package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.vistas.Ventana;

public class Controlador {
    private Ventana frame;
    private Aplicacion modelo;

    private ControlLoginUsuario cLogin;
    private ControlRegistroUsuario cRegistro;
    private ControlHomeUsuario cHomeU;

    public Controlador(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.modelo = modelo;
        cLogin = new ControlLoginUsuario(frame, modelo);
        cRegistro = new ControlRegistroUsuario(frame, modelo);
        cHomeU = new ControlHomeUsuario(frame, modelo);
    }

    public ControlLoginUsuario getControlLoginUsuario() {
        return cLogin;
    }

    public ControlRegistroUsuario getControlRegistroUsuario() {
        return cRegistro;
    }

    public ControlHomeUsuario getControlHomeUsuario() {
        return cHomeU;
    }
}
