package vecindApp.vistas.usuario;

import vecindApp.controladores.usuario.ControlBuscarColectivos;
import vecindApp.vistas.VentanaArbol;

import javax.swing.*;
import java.awt.*;

public class BuscarColectivos<T> extends VentanaArbol<T> {
    private JButton unirse = new JButton("Unirse");

    public BuscarColectivos() {
        super();

        unirse.setEnabled(false);
        JPanel bot = getBot();
        bot.add(unirse);
    }

    public JButton getUnirse() {
        return unirse;
    }

    public void setControlador(ControlBuscarColectivos c) {
        super.setControlador(c);

        unirse.addActionListener(c);
    }

    public void updateCols(JTree arbol) {
        update(arbol);

        unirse.setEnabled(false);
        JPanel bot = getBot();
        bot.add(unirse);
    }
}