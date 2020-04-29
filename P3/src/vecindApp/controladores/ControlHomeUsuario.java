package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.controladores.usuario.*;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.home.HomeUsuario;

import java.awt.event.ActionListener;


public class ControlHomeUsuario {
    private HomeUsuario<Notificacion> vista;
    private Ventana<Notificacion>frame;
    private Aplicacion modelo;
    private ControlNotificaciones cNotificaciones;
    private ControlConsultarProyectos cConsultarProyectos;
    private ControlConsultarColectivos cConsultarColectivos;
    private ControlBuscarColectivos cBuscarColectivos;
    private ControlBuscarProyectos cBuscarProyectos;
    private ControlPerfil cPerfil;

    public ControlHomeUsuario(Ventana<Notificacion> frame, Aplicacion modelo, ControlPerfil cPerfil) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario();
        this.modelo = modelo;

        cNotificaciones = new ControlNotificaciones(vista.getNotificaciones(), modelo);
        cConsultarProyectos = new ControlConsultarProyectos(frame, modelo);
        cConsultarColectivos = new ControlConsultarColectivos(frame, modelo);
        cBuscarColectivos = new ControlBuscarColectivos(frame, modelo);
        cBuscarProyectos = new ControlBuscarProyectos(frame, modelo);
        this.cPerfil = cPerfil;
    }

    public ControlNotificaciones getControlNotificaciones() {
        return cNotificaciones;
    }

    public ControlConsultarProyectos getControlConsultarProyectos() {
        return cConsultarProyectos;
    }

    public ControlConsultarColectivos getControlConsultarColectivos() {
        return cConsultarColectivos;
    }

    public ControlBuscarColectivos getControlBuscarColectivos() {
        return cBuscarColectivos;
    }

    public ControlBuscarProyectos getControlBuscarProyectos() {
        return cBuscarProyectos;
    }

    public ControlPerfil getControlPerfil() {
        return cPerfil;
    }
}