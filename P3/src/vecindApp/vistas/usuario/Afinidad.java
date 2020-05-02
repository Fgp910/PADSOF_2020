package vecindApp.vistas.usuario;

import vecindApp.controladores.Controlador;
import vecindApp.controladores.usuario.ControlAfinidad;
import vecindApp.vistas.VentanaArbol;

import javax.swing.*;

public class Afinidad<T> extends VentanaArbol<T> {
    private JButton consultar = new JButton("Consultar");
    private JButton volver = new JButton("Volver");

    private T c1;

    public Afinidad() {
        super();

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

    public void updateCols(JTree arbol, T c1) {
        update(arbol);

        JPanel bot = getBot();
        bot.add(consultar);
        bot.add(volver);
        this.c1 = c1;
    }
}
