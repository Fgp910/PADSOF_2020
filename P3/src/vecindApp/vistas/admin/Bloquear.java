package vecindApp.vistas.admin;

import vecindApp.controladores.admin.ControlBloquear;
import vecindApp.vistas.VentanaLista;

import javax.swing.*;

/**
 * Define la vista de ciudadanos no bloqueados.
 * @param <C> el tipo de los ciudadanos de la lista
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Bloquear<C> extends VentanaLista<C> {
    private JButton block = new JButton("Bloquear");

    public Bloquear() {
        super();
        getBot().add(block);
        block.setEnabled(false);
    }

    public JButton getBlockButton() {
        return block;
    }

    public void setControlador(ControlBloquear c) {
        super.setControlador(c);
        block.addActionListener(c);
    }
}
