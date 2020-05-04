package vecindApp.vistas.admin;

import vecindApp.controladores.admin.ControlDesbloquear;
import vecindApp.vistas.VentanaLista;

import javax.swing.*;

/**
 * Define la vista de ciudadanos bloqueados.
 * @param <C> el tipo de los ciudadanos de la lista
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Desbloquear<C> extends VentanaLista<C> {
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
        super.setControlador(c);
        unblock.addActionListener(c);
    }
}
