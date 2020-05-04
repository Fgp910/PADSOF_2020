package vecindApp.vistas.usuario;

import vecindApp.controladores.usuario.ControlBuscarProyectos;
import vecindApp.controladores.usuario.ControlMisProyectos;
import vecindApp.vistas.VentanaLista;

import javax.swing.*;
import java.awt.*;

/**
 * Define la vista para buscar proyectos.
 * @param <P> el tipo de los proyectos a buscar
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class BuscarProyectos<P> extends VentanaLista<P> {
    private JButton info = new JButton("Ver");
    private JButton apoyar = new JButton("Apoyar");
    private JButton sub = new JButton("Suscribirse");

    public BuscarProyectos() {
        super();
        getBot().add(info).setEnabled(false);
        getBot().add(apoyar).setEnabled(false);
        getBot().add(sub).setEnabled(false);
    }

    public JButton getInfoButton() {
        return  info;
    }

    public JButton getApoyarButton() {
        return apoyar;
    }

    public JButton getSubButton() {
        return sub;
    }

    public void setControlador(ControlBuscarProyectos c) {
        super.setControlador(c);
        info.addActionListener(c);
        apoyar.addActionListener(c);
        sub.addActionListener(c);
    }
}