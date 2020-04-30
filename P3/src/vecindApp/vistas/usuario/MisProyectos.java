package vecindApp.vistas.usuario;

import vecindApp.clases.proyecto.Proyecto;
import vecindApp.vistas.VentanaLista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MisProyectos<P> extends VentanaLista<Proyecto> {
    private JButton iPopularidad = new JButton("Informe de Popularidad");
    private JButton enviar = new JButton("Enviar a Financiación");
    private JButton consultar = new JButton("Consultar Estado");

    public MisProyectos() {
        super();
        getBot().add(iPopularidad).setEnabled(false);
        getBot().add(enviar).setEnabled(false);
        getBot().add(consultar).setEnabled(false);
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

    public void setControlador(ActionListener c) {
        iPopularidad.addActionListener(c);
        enviar.addActionListener(c);
        consultar.addActionListener(c);
    }
}
