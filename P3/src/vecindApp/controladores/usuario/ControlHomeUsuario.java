package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.controladores.ControlNotificaciones;
import vecindApp.controladores.ControlPerfil;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.home.HomeUsuario;

import java.awt.event.ActionListener;


public class ControlHomeUsuario {
    private HomeUsuario<Notificacion, Proyecto> vista;
    private Ventana<Notificacion, Proyecto, ElementoColectivo>frame;
    private Aplicacion modelo;
    private ControlNotificaciones cNotificaciones;
    private ControlMisProyectos cMisProyectos;
    private ControlConsultarColectivos cConsultarColectivos;
    private ControlBuscarColectivos cBuscarColectivos;
    private ControlBuscarProyectos cBuscarProyectos;
    private ControlPerfil cPerfil;

    public ControlHomeUsuario(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo, ControlPerfil cPerfil) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario();
        this.modelo = modelo;

        cNotificaciones = new ControlNotificaciones(frame, modelo);
        cMisProyectos = new ControlMisProyectos(frame, modelo);
        cConsultarColectivos = new ControlConsultarColectivos(frame, modelo);
        cBuscarColectivos = new ControlBuscarColectivos(frame, modelo);
        cBuscarProyectos = new ControlBuscarProyectos(frame, modelo);
        this.cPerfil = cPerfil;
    }

    public ControlNotificaciones getControlNotificaciones() {
        return cNotificaciones;
    }

    public ControlMisProyectos getControlMisProyectos() {
        return cMisProyectos;
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