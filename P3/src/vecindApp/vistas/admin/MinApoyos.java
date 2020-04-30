package vecindApp.vistas.admin;

import vecindApp.controladores.admin.ControlBloquear;
import vecindApp.controladores.admin.ControlMinApoyos;
import vecindApp.vistas.VentanaLista;
import vecindApp.vistas.usuario.ConsultarColectivos;

import javax.swing.*;
import java.awt.*;

public class MinApoyos<P> extends VentanaLista<P> {
    private JButton change = new JButton("Cambiar min apoyos");

    public MinApoyos() {
        super();
        getBot().add(change);
        change.setEnabled(false);
    }

    public JButton getChangeButton() {
        return change;
    }

    /*public void setControlador(ControlMinApoyos c) {
        getLista().addListSelectionListener(c);
        change.addActionListener(c);
    }*/
}
