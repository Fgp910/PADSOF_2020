package vecindApp.vistas;

import vecindApp.controladores.ControlNotificaciones;

import javax.swing.*;

public class Notificaciones<T> extends VentanaLista<T> {
    private JButton open = new JButton("Abrir");
    private JButton info = new JButton("Ver");

    public Notificaciones() {
        super();
        getBot().add(open);
        open.setEnabled(false);
        getBot().add(info);
        info.setEnabled(false);
    }

    public JButton getOpenButton() {
        return open;
    }

    public JButton getInfoButton() {
        return info;
    }

    public void setControlador(ControlNotificaciones c) {
        super.setControlador(c);
        open.addActionListener(c);
        info.addActionListener(c);
    }
}
