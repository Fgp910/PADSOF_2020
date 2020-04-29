package vecindApp.vistas;

import vecindApp.controladores.ControlNotificaciones;

import javax.swing.*;

public class Notificaciones<T> extends VentanaLista<T> {
    private JButton open = new JButton("Abrir");

    public Notificaciones() {
        super();
        getDer().add(open);
        open.setEnabled(false);
    }

    public JButton getOpenButton() {
        return open;
    }

    public void setControlador(ControlNotificaciones c) {
        getLista().addListSelectionListener(c);
        open.addActionListener(c);
    }
}
