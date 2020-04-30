package vecindApp.vistas.admin;

import vecindApp.controladores.admin.ControlDesbloquear;
import vecindApp.vistas.VentanaLista;

import javax.swing.*;

public class Desbloquear<T> extends VentanaLista<T> {
    private JButton unblock = new JButton("Desbloquear");

    public Desbloquear() {
        super();
        getBot().add(unblock);
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
