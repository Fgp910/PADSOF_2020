package vecindApp.vistas;

import javax.swing.*;

public class Notificaciones<T> extends VentanaLista<T> {
    private JButton open = new JButton("Abrir");

    public Notificaciones() {
        super();
        getDer().add(open);
    }
}
