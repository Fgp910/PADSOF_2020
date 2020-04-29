package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.vistas.Perfil;
import vecindApp.vistas.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPerfilUsuario implements ActionListener{
    private Perfil vista;
    private Ventana<Notificacion> frame;
    private Aplicacion modelo;

    public ControlPerfilUsuario(Ventana<Notificacion> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getPerfil();
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
