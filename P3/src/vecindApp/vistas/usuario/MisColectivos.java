package vecindApp.vistas.usuario;

import vecindApp.controladores.usuario.ControlMisColectivos;
import vecindApp.vistas.VentanaArbol;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import java.awt.event.ActionListener;

public class MisColectivos<T> extends VentanaArbol<T> {
    private JButton nuevoColectivo = new JButton("Nuevo colectivo");
    private JButton nuevoSubcolectivo = new JButton("Nuevo Subcolectivo");
    private JButton infAfinidad = new JButton("Informe de afinidad");

    public MisColectivos() {
        super();

        JPanel bot = getBot();
        bot.add(infAfinidad).setEnabled(false);
        bot.add(nuevoSubcolectivo).setEnabled(false);
        bot.add(nuevoColectivo).setEnabled(true);
    }

    public JButton getNuevoColectivo() {
        return nuevoColectivo;
    }

    public JButton getInfAfinidad() {
        return infAfinidad;
    }

    public JButton getNuevoSubcolectivo() {
        return nuevoSubcolectivo;
    }

    public void setControlador(ControlMisColectivos c) {
        super.setControlador(c);

        nuevoColectivo.addActionListener(c);
        infAfinidad.addActionListener(c);
        nuevoSubcolectivo.addActionListener(c);
    }

    public void updateCols(JTree arbol) {
        update(arbol);

        JPanel bot = getBot();
        bot.add(infAfinidad);
        bot.add(nuevoSubcolectivo);
        bot.add(nuevoColectivo);
    }
}
