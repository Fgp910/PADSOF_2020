package vecindApp.vistas.usuario;

import vecindApp.vistas.VentanaArbol;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MisColectivos<T> extends VentanaArbol<T> {
    private JButton nuevoColectivo = new JButton("Nuevo colectivo");
    private JButton infAfinidad = new JButton("Informe de afinidad");

    public MisColectivos() {
        super();

        getTitle().add(new JLabel("Mis Colectivos"));

        JPanel bot = getBot();
        bot.add(nuevoColectivo).setEnabled(true);
        bot.add(infAfinidad).setEnabled(false);
    }

    public JButton getNuevoColectivo() {
        return nuevoColectivo;
    }

    public JButton getInfAfinidad() {
        return infAfinidad;
    }

    public void setControlador(ActionListener c) {
        nuevoColectivo.addActionListener(c);
        infAfinidad.addActionListener(c);
    }
}
