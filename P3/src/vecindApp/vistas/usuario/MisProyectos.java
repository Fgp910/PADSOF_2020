package vecindApp.vistas.usuario;

import vecindApp.controladores.usuario.ControlMisProyectos;
import vecindApp.vistas.VentanaLista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MisProyectos<P> extends VentanaLista<P> {
    private JButton iPopularidad = new JButton("Informe de Popularidad");
    private JButton enviar = new JButton("Enviar a Financiación");
    private JButton consultar = new JButton("Consultar Estado");
    private JButton crear = new JButton("Nuevo Proyecto");

    public MisProyectos() {
        super();
        getBot().add(iPopularidad).setEnabled(false);
        getBot().add(enviar).setEnabled(false);
        getBot().add(consultar).setEnabled(false);
        getBot().add(crear);
    }

    public JButton getPopularButton() {
        return iPopularidad;
    }

    public JButton getEnviarButton() {
        return enviar;
    }

    public JButton getConsultarButton() {
        return consultar;
    }

    public JButton getCrearButton() {
        return crear;
    }

    public void setControlador(ControlMisProyectos c) {
        super.setControlador(c);
        iPopularidad.addActionListener(c);
        enviar.addActionListener(c);
        consultar.addActionListener(c);
        crear.addActionListener(c);
    }
}
