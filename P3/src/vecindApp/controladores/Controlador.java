package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.vistas.Ventana;

public class Controlador {
    private Ventana frame;
    private Aplicacion modelo;

    private ControlLoginUsuario cLogin;
    private ControlRegistroUsuario cRegistro;
    private ControlHomeUsuario cHomeU;
    private ControlHomeAdmin cHomeA;


    public Controlador(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.modelo = modelo;
        cLogin = new ControlLoginUsuario(frame, modelo);
        cRegistro = new ControlRegistroUsuario(frame, modelo);
        cHomeU = new ControlHomeUsuario(frame, modelo);
        cHomeA = new ControlHomeAdmin(frame, modelo);
    }

    public ControlLoginUsuario getControlLoginUsuario() {
        return cLogin;
    }

    public ControlRegistroUsuario getControlRegistroUsuario() {
        return cRegistro;
    }

    public ControlHomeUsuario getControlHomeUsuario() { return cHomeU; }

    public ControlHomeAdmin getControlHomeAdmin() {
        return cHomeA;
    }
}
