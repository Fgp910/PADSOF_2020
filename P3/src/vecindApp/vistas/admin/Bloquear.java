package vecindApp.vistas.admin;

import vecindApp.controladores.admin.ControlBloquear;
import vecindApp.vistas.VentanaLista;

import javax.swing.*;
import java.awt.*;

public class Bloquear<T> extends VentanaLista<T> {
    private JButton block = new JButton("Bloquear");

    public Bloquear() {
        super();
        getDer().add(block);
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
