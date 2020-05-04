package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.vistas.LoginUsuario;
import vecindApp.vistas.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Define el controlador para la vista del perfil y cierre de sesion de los usuarios.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ControlPerfil implements ActionListener{
    private Ventana<Notificacion, Proyecto, ElementoColectivo> frame;
    private Aplicacion modelo;

    /**
     * Crea el controlador para la vista del perfil y cierre de sesion de los usuarios
     * @param frame la ventana principal del sistema
     * @param modelo la aplicacion fuente
     */
    public ControlPerfil(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
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
