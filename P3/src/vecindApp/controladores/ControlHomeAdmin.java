package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.controladores.admin.ControlBloquear;
import vecindApp.controladores.admin.ControlDesbloquear;
import vecindApp.controladores.admin.ControlMinApoyos;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.home.HomeAdmin;


public class ControlHomeAdmin {
    private HomeAdmin vista;
    private Ventana frame;
    private Aplicacion modelo;
    private ControlNotificaciones cNotificaciones;
    private ControlPerfilUsuario cPerfil;
    private ControlBloquear cBloquear;
    private ControlDesbloquear cDesbloquear;
    private ControlMinApoyos cMinApoyos;


    public ControlHomeAdmin(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeAdmin();
        this.modelo = modelo;

        cNotificaciones = new ControlNotificaciones(frame, modelo);
        cBloquear = new ControlBloquear(frame, modelo);
        cDesbloquear = new ControlDesbloquear(frame, modelo);
        cMinApoyos = new ControlMinApoyos(frame, modelo);
        cPerfil = new ControlPerfilUsuario(frame, modelo);
    }

    public ControlNotificaciones getcNotificaciones() {
        return cNotificaciones;
    }

    public ControlPerfilUsuario getcPerfil() {
        return cPerfil;
    }

    public ControlBloquear getcBloquear() {
        return cBloquear;
    }

    public ControlDesbloquear getcDesbloquear() {
        return cDesbloquear;
    }

    public ControlMinApoyos getcMinApoyos() {
        return cMinApoyos;
    }
}