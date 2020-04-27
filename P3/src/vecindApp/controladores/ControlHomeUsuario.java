/*package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.vistas.home.HomeUsuario;
import vecindApp.vistas.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlHomeUsuario implements ActionListener {
    private HomeUsuario vista;
    private Ventana frame;
    private Aplicacion modelo;
    private ControlNotificaciones cNotificaciones;
    private ControlConsultarProyectos cConsultarProyectos;
    private ControlConsultarColectivos cConsultarColectivos;
    private ControlBuscarColectivos cBuscarColectivos;
    private ControlBuscarProyectos cBuscarProyectos;
    private ControlCerrarSesion cCerrarSesion;


    public ControlHomeUsuario(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario();
        this.modelo = modelo;

        cNotificaciones = new ControlNotificaciones(frame, modelo);
        cConsultarProyectos = new ControlConsultarProyectos(frame, modelo);
        cConsultarColectivos = new ControlConsultarColectivos(frame, modelo);
        cBuscarColectivos = new ControlBuscarColectivos(frame, modelo);
        cBuscarProyectos = new ControlBuscarProyectos(frame, modelo);
        cCerrarSesion = new ControlCerrarSesion(frame, modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getB_buscar_cols())) {
            vista.getP_buscar_cols().setVisible(true);
        }
        else if (e.getSource().equals(vista.getB_buscar_proys())) {
            vista.getP_buscar_proys().setVisible(true);
        }
        else if (e.getSource().equals(vista.getB_cerrar_sesion())) {
            vista.getP_cerrar_sesion().setVisible(true);
        }
        else if (e.getSource().equals(vista.getB_consultar_cols())) {
            vista.getP_consultar_cols().setVisible(true);
        }
        else if (e.getSource().equals(vista.getB_consultar_proys())) {
            vista.getP_consultar_proys().setVisible(true);
        }
        else if (e.getSource().equals(vista.getB_notificaciones())) {
            vista.getP_notificaciones().setVisible(true);
        }
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

    public ControlCerrarSesion getControlCerrarSesion() {
        return cCerrarSesion;
    }
}*/