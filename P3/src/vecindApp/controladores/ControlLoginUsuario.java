package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.vistas.LoginUsuario;
import vecindApp.vistas.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlLoginUsuario {
    private LoginUsuario vista;
    private Ventana frame;
    private Aplicacion modelo;

    public ControlLoginUsuario(Ventana frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getLoginUsuario();
        this.modelo = modelo;
    }

    public ActionListener getControladorReg() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setSize(300, 200);
                frame.mostrarPanel("registroUsuario");
            }
        };
    }

    public ActionListener getControladorEnter() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = vista.getUsername();
                String psswd = vista.getPassword();
                Ciudadano c = modelo.findCiudadano(user);

                if (c == null || !c.getPassword().equals(psswd)) {
                    JOptionPane.showMessageDialog(vista,
                            "Nombre de usuario o contraseña incorrectos (haga clic en \"Registrarse\" para crear una nueva cuenta).",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                modelo.setUsuarioActual(c);
                frame.mostrarPanel("home");
            }
        };
    }
}
