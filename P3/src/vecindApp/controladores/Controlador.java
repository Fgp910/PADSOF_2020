package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.controladores.admin.ControlHomeAdmin;
import vecindApp.controladores.usuario.ControlHomeUsuario;
import vecindApp.vistas.Ventana;

public class Controlador {
    private Ventana<Notificacion> frame;
    private Aplicacion modelo;

    private ControlLoginUsuario cLogin;
    private ControlRegistroUsuario cRegistro;
    private ControlPerfil cPerfil;
    private ControlHomeUsuario cHomeU;
    private ControlHomeAdmin cHomeA;


    public Controlador(Ventana<Notificacion> frame, Aplicacion modelo) {
        this.frame = frame;
        this.modelo = modelo;
        cLogin = new ControlLoginUsuario(frame, modelo);
        cRegistro = new ControlRegistroUsuario(frame, modelo);
        cPerfil = new ControlPerfil(frame, modelo);
        cHomeU = new ControlHomeUsuario(frame, modelo, cPerfil);
        cHomeA = new ControlHomeAdmin(frame, modelo, cPerfil);
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
