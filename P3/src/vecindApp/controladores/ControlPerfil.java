package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.vistas.LoginUsuario;
import vecindApp.vistas.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPerfil implements ActionListener{
    private Ventana<Notificacion> frame;
    private Aplicacion modelo;

    public ControlPerfil(Ventana<Notificacion> frame, Aplicacion modelo) {
        this.frame = frame;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.guardar(Aplicacion.PATH);
        frame.setSize(LoginUsuario.SIZE[0], LoginUsuario.SIZE[1]);
        frame.setLocationRelativeTo(null);
        frame.getLoginUsuario().update();
        frame.mostrarPanel("loginUsuario");
    }
}
