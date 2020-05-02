package vecindApp.controladores.usuario;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.controladores.ControlNotificaciones;
import vecindApp.controladores.ControlPerfil;
import vecindApp.controladores.admin.ControlNotificacionesAdmin;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.home.HomeUsuario;


public class ControlHomeUsuario {
    private HomeUsuario<Notificacion, Proyecto, ElementoColectivo> vista;
    private Ventana<Notificacion, Proyecto, ElementoColectivo>frame;
    private Aplicacion modelo;
    private ControlNotificaciones cNotificaciones;
    private ControlMisProyectos cMisProyectos;
    private ControlMisColectivos cMisColectivos;
    private ControlBuscarColectivos cBuscarColectivos;
    private ControlBuscarProyectos cBuscarProyectos;
    private ControlPerfil cPerfil;

    public ControlHomeUsuario(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo, ControlPerfil cPerfil) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario();
        this.modelo = modelo;

        cNotificaciones = new ControlNotificaciones(vista.getNotificaciones(), modelo);
        cMisProyectos = new ControlMisProyectos(frame, modelo);
        cMisColectivos = new ControlMisColectivos(frame, modelo);
        cBuscarColectivos = new ControlBuscarColectivos(vista, modelo);
        cBuscarProyectos = new ControlBuscarProyectos(vista, modelo);
        this.cPerfil = cPerfil;
    }

    public ControlNotificaciones getControlNotificaciones() {
        return cNotificaciones;
    }

    public ControlMisProyectos getControlMisProyectos() {
        return cMisProyectos;
    }

    public ControlMisColectivos getControlMisColectivos() {
        return cMisColectivos;
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