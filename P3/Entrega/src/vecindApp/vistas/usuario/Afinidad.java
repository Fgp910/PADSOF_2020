package vecindApp.vistas.usuario;

import vecindApp.controladores.usuario.ControlAfinidad;
import vecindApp.vistas.VentanaArbol;

import javax.swing.*;

/**
 * Define la vista que permite solicitar el informe de afinidad.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Afinidad<T> extends VentanaArbol<T> {
    private JButton consultar = new JButton("Consultar");
    private JButton volver = new JButton("Volver");

    private T c1;

    public Afinidad() {
        super();

        getTitle().add(new JLabel("Seleccione otro colectivo"));
        JPanel bot = getBot();
        bot.add(consultar);
        bot.add(volver);
    }

    public JButton getConsultar() {
        return consultar;
    }

    public JButton getVolver() {
        return volver;
    }

    public T getC1() {
        return c1;
    }

    public void setControlador(ControlAfinidad c) {
        super.setControlador(c);

        consultar.addActionListener(c);
        volver.addActionListener(c);
    }

    /**
     * Actualiza la vista
     * @param arbol arbol con los colectivos de los que se puede pedir el informe
     * @param c1 primer colectivo para el que se pide el informe
     */
    public void updateCols(JTree arbol, T c1) {
        update(arbol);

        JPanel bot = getBot();
        getTitle().add(new JLabel("Seleccione otro colectivo"));
        bot.add(consultar);
        bot.add(volver);
        this.c1 = c1;
    }
}
