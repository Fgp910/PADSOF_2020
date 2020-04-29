package vecindApp.controladores;

import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.vistas.RegistroUsuario;
import vecindApp.vistas.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlRegistroUsuario implements ActionListener {
    private RegistroUsuario vista;
    private Ventana<Notificacion> frame;
    private Aplicacion modelo;

    public ControlRegistroUsuario(Ventana<Notificacion> frame, Aplicacion modelo) {
        this.frame = frame;
        this.vista = frame.getRegistroUsuario();
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getRegButton())) {
            String user = vista.getUsername();
            String nif = vista.getNif();
            String psswd = vista.getPassword();
            String confirm = vista.getConfirm();

            if (user.equals(modelo.getAdmin().getUsername())) {
                JOptionPane.showMessageDialog(vista,
                        "Nombre de usuario inválido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (nif.length() != Ciudadano.NIF_LEN) {
                JOptionPane.showMessageDialog(vista,
                        "NIF inválido. Introduzca un NIF válido.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!psswd.equals(confirm)) {
                JOptionPane.showMessageDialog(vista,
                        "La clave y la confirmación de la clave no coinciden",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!modelo.addElemCol(new Ciudadano(user, psswd, nif))) {
                JOptionPane.showMessageDialog(vista,
                        user + " (" + nif + ") ya está registrado. Introduzca un nombre distinto.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(vista,
                    "Usuario creado con éxito.\nPendiente de aprobación por administración.",
                    "Registro con éxito" ,
                    JOptionPane.INFORMATION_MESSAGE);
        }

        frame.setSize(300, 150);
        frame.getLoginUsuario().update();
        frame.mostrarPanel("loginUsuario");
    }
}
