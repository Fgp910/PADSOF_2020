package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.usuario.Administrador;
import vecindApp.vistas.LoginUsuario;
import vecindApp.vistas.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlLoginUsuario implements ActionListener {
    private LoginUsuario vista;
    private Ventana frame;
    private Aplicacion modelo;

    public ControlLoginUsuario(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getLoginUsuario();
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getRegButton())) {
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.getRegistroUsuario().update();
            frame.mostrarPanel("registroUsuario");
        } else if (e.getSource().equals(vista.getEntButton())) {
            String user = vista.getUsername();
            String psswd = vista.getPassword();
            Administrador admin = modelo.getAdmin();
            Ciudadano c = modelo.findCiudadano(user);

            if (user.equals(admin.getUsername()) && psswd.equals(admin.getPassword())) {
                modelo.setUsuarioActual(admin);
                frame.setSize(600,600);
                frame.setLocationRelativeTo(null);
                frame.mostrarPanel("homeAdmin");
            } else if (c == null || !c.getPassword().equals(psswd)) {
                JOptionPane.showMessageDialog(vista,
                        "Nombre de usuario o contraseña incorrectos (haga clic en \"Registrarse\" para crear una nueva cuenta).",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (c.isAdmitido()) {
                modelo.setUsuarioActual(c);
                frame.mostrarPanel("home");
                if (c.isBloqueado()) {
                    JOptionPane.showMessageDialog(vista,
                            "Ha sido bloqueado por administración.\nSus apoyos a proyectos serán ignorados.",
                            "Bloqueado",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(vista,
                        "Pendiente de aprobación por administración.\nInténtelo luego.",
                        "Pendiente de aprobación",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
