package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.controladores.admin.ControlHomeAdmin;
import vecindApp.controladores.usuario.ControlAfinidad;
import vecindApp.controladores.usuario.ControlHomeUsuario;
import vecindApp.controladores.usuario.ControlNuevoProyecto;
import vecindApp.vistas.Ventana;

import java.awt.event.ActionListener;

/**
 * Define el controlador general del sistema.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Controlador {
    private Ventana<Notificacion, Proyecto, ElementoColectivo> frame;
    private Aplicacion modelo;

    private ControlLoginUsuario cLogin;
    private ControlRegistroUsuario cRegistro;
    private ControlPerfil cPerfil;
    private ControlHomeUsuario cHomeU;
    private ControlHomeAdmin cHomeA;
    private ControlNuevoProyecto cNuevoProyecto;
    private ControlAfinidad cAfinidad;

    /**
     * Crea el controlador general del sistema
     * @param frame la ventana principal del sistema
     * @param modelo la aplicacion fuente
     */
    public Controlador(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.modelo = modelo;
        cLogin = new ControlLoginUsuario(frame, modelo);
        cRegistro = new ControlRegistroUsuario(frame, modelo);
        cPerfil = new ControlPerfil(frame, modelo);
        cHomeU = new ControlHomeUsuario(frame, modelo, cPerfil);
        cHomeA = new ControlHomeAdmin(frame, modelo, cPerfil);
        cNuevoProyecto = new ControlNuevoProyecto(frame, modelo);
        cAfinidad = new ControlAfinidad(frame, modelo);
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

    public ActionListener getControlNuevoProyecto() {
        return cNuevoProyecto;
    }

    public ControlAfinidad getControlAfinidad() {
        return cAfinidad;
    }
}
