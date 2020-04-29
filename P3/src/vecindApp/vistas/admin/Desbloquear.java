package vecindApp.vistas.admin;

import vecindApp.controladores.ControlNotificaciones;
import vecindApp.controladores.admin.ControlDesbloquear;
import vecindApp.vistas.VentanaLista;
import vecindApp.vistas.usuario.ConsultarColectivos;

import javax.swing.*;
import java.awt.*;

public class Desbloquear<T> extends VentanaLista<T> {
    private JButton unblock = new JButton("Desbloquear");

    public Desbloquear() {
        super();
        getDer().add(unblock);
        unblock.setEnabled(false);
    }

    public JButton getOpenButton() {
        return unblock;
    }

    public void setControlador(ControlDesbloquear c) {
        getLista().addListSelectionListener(c);
        unblock.addActionListener(c);
    }
}
