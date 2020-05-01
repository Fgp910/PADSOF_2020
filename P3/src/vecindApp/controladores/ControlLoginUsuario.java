package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.Colectivo;
import vecindApp.clases.colectivo.ElementoColectivo;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.clases.usuario.Administrador;
import vecindApp.clases.usuario.Usuario;
import vecindApp.vistas.LoginUsuario;
import vecindApp.vistas.RegistroUsuario;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.VentanaLista;
import vecindApp.vistas.home.Home;
import vecindApp.vistas.home.HomeAdmin;
import vecindApp.vistas.home.HomeUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlLoginUsuario implements ActionListener {
    private LoginUsuario vista;
    private Ventana<Notificacion, Proyecto, ElementoColectivo> frame;
    private Aplicacion modelo;

    public ControlLoginUsuario(Ventana<Notificacion, Proyecto, ElementoColectivo> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getLoginUsuario();
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getRegButton())) {
            frame.setSize(RegistroUsuario.SIZE[0], RegistroUsuario.SIZE[1]);
            frame.setLocationRelativeTo(null);
            frame.getRegistroUsuario().update();
            frame.mostrarPanel("registroUsuario");
        } else if (e.getSource().equals(vista.getEntButton())) {
            String user = vista.getUsername();
            String psswd = vista.getPassword();
            Administrador admin = modelo.getAdmin();
            Ciudadano c = modelo.findCiudadano(user);

            if (user.equals(admin.getUsername()) && psswd.equals(admin.getPassword())) {    //login exitoso del admin
                modelo.setUsuarioActual(admin);
                updateHome(frame);
                frame.mostrarPanel("homeAdmin");
            } else if (c == null || !c.getPassword().equals(psswd)) {
                JOptionPane.showMessageDialog(vista,
                        "Nombre de usuario o contraseña incorrectos (haga clic en \"Registrarse\" para crear una nueva cuenta).",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (c.isAdmitido()) {
                modelo.setUsuarioActual(c);
                updateHome(frame);
                frame.mostrarPanel("home");
                if (c.isBloqueado()) {
                    JOptionPane.showMessageDialog(vista,
                            "Ha sido bloqueado por administración.\nSus apoyos a proyectos serán ignorados.",
                            "Bloqueado",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else if (c.getMotivoRechazo() != null) {
                JOptionPane.showMessageDialog(vista,
                        "Ha sido rechazado por administración porque \"" + c.getMotivoRechazo() +
                                "\"\n Sus datos de registro han sido eliminados",
                        "Registro rechazado",
                        JOptionPane.ERROR_MESSAGE);
                modelo.removeElemCol(c);
            } else {
                JOptionPane.showMessageDialog(vista,
                        "Pendiente de aprobación por administración.\nInténtelo luego.",
                        "Pendiente de aprobación",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void updateHome(Ventana<Notificacion, Proyecto, ElementoColectivo> home) {
        Usuario user = modelo.getUsuarioActual();

        if (user.equals(modelo.getAdmin())) {
            Administrador admin = modelo.getAdmin();
            HomeAdmin<Notificacion, Proyecto, ElementoColectivo> h = home.getHomeAdmin();
            h.getPerfil().update(admin.toString());
            h.getNotificaciones().update(admin.getPendientes(), true);
        } else {
            Ciudadano u = (Ciudadano) user;
            HomeUsuario<Notificacion, Proyecto, ElementoColectivo> h = home.getHomeUsuario();
            h.getPerfil().update(u.toString());
            h.getNotificaciones().update(u.getPendientes(), true);
            h.getMisProyectos().removeAll();
            h.getMisProyectos().addAll(u.getProyectos());
            h.getMisColectivos().setRoot(u.getTree());
        }

        frame.setSize(Home.SIZE[0], Home.SIZE[1]);
        frame.setLocationRelativeTo(null);
    }
}
