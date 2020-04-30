package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.clases.usuario.Administrador;
import vecindApp.clases.usuario.Usuario;
import vecindApp.vistas.LoginUsuario;
import vecindApp.vistas.RegistroUsuario;
import vecindApp.vistas.Ventana;
import vecindApp.vistas.home.Home;
import vecindApp.vistas.home.HomeAdmin;
import vecindApp.vistas.home.HomeUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ControlLoginUsuario implements ActionListener {
    private LoginUsuario vista;
    private Ventana<Notificacion, Proyecto, Ciudadano> frame;
    private Aplicacion modelo;

    public ControlLoginUsuario(Ventana<Notificacion, Proyecto, Ciudadano> frame, Aplicacion modelo) {
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

    private void updateHome(Ventana<Notificacion, Proyecto, Ciudadano> home) {
        Usuario user = modelo.getUsuarioActual();

        home.getHomeUsuario().getPerfil().update(user.toString());
        home.getHomeAdmin().getNotificaciones().update(user.getPendientes(), true);
        if (!user.equals(modelo.getAdmin())) {
            Ciudadano u = (Ciudadano) user;
            HomeUsuario<Notificacion, Proyecto> h = home.getHomeUsuario();
            h.getMisProyectos().addAll(u.getProyectos());
        }

        frame.setSize(Home.SIZE[0], Home.SIZE[1]);
        frame.setLocationRelativeTo(null);
    }
}
