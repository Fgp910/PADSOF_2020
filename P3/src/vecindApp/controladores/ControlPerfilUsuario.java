package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.vistas.Perfil;
import vecindApp.vistas.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPerfilUsuario implements ActionListener{
    private Perfil vista;
    private Ventana frame;
    private Aplicacion modelo;

    public ControlPerfilUsuario(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getHomeUsuario().getPerfil();
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
