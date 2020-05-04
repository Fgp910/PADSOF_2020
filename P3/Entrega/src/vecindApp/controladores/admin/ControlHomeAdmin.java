package vecindApp.controladores.admin;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.controladores.ControlPerfil;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.home.HomeAdmin;

/**
 * Define el controlador para la vista principal del administrador.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ControlHomeAdmin {
    private HomeAdmin<Notificacion, ElementoColectivo> vista;
    private Ventana<Notificacion, Proyecto, ElementoColectivo> frame;
    private Aplicacion modelo;
    private ControlNotificacionesAdmin cNotificaciones;
    private ControlPerfil cPerfil;
    private ControlBloquear cBloquear;
    private ControlDesbloquear cDesbloquear;
    private ControlMinApoyos cMinApoyos;

    /**
     * Crea el controlador para la vista principal del administrador
     * @param frame el componente padre (la ventana principal del sistema)
     * @param modelo la aplicacion fuente
     */
    public ControlHomeAdmin(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo, ControlPerfil cPerfil) {
        this.frame = frame;
        this.vista = frame.getHomeAdmin();
        this.modelo = modelo;

        cNotificaciones = new ControlNotificacionesAdmin(frame, modelo);
        cBloquear = new ControlBloquear(vista, modelo);
        cDesbloquear = new ControlDesbloquear(vista, modelo);
        cMinApoyos = new ControlMinApoyos(vista, modelo);
        this.cPerfil = cPerfil;
    }

    public ControlNotificacionesAdmin getControlNotificaciones() {
        return cNotificaciones;
    }

    public ControlPerfil getControlPerfil() {
        return cPerfil;
    }

    public ControlBloquear getControlBloquear() {
        return cBloquear;
    }

    public ControlDesbloquear getControlDesbloquear() {
        return cDesbloquear;
    }

    public ControlMinApoyos getControlMinApoyos() {
        return cMinApoyos;
    }
}