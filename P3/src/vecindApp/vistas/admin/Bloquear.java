package vecindApp.vistas.admin;

import vecindApp.controladores.admin.ControlBloquear;
import vecindApp.vistas.VentanaLista;

import javax.swing.*;

public class Bloquear<C> extends VentanaLista<C> {
    private JButton block = new JButton("Bloquear");

    public Bloquear() {
        super();
        getBot().add(block);
        block.setEnabled(false);
    }

    public JButton getOpenButton() {
        return block;
    }

    public void setControlador(ControlBloquear c) {
        getLista().addListSelectionListener(c);
        block.addActionListener(c);
    }
}
