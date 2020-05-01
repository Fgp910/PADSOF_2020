package vecindApp.vistas;

import vecindApp.clases.proyecto.Proyecto;
import vecindApp.clases.proyecto.ProyectoInfraestructura;
import vecindApp.clases.proyecto.ProyectoSocial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InfoProyecto<P> extends JDialog {
    public static final int[] SIZE = {800, 600};
    private JFrame padre;
    private Proyecto proy;
    private JPanel infoGeneral = new JPanel(new GridLayout(3, 1));
    private JPanel infoProyecto = new JPanel(new GridLayout(3, 1));

    public InfoProyecto(JFrame padre, Proyecto proy) {
        super(padre);
        this.proy = proy;

        this.setLayout(new GridLayout(2, 1));
        this.setSize(new Dimension(700, 500));

        infoGeneralInit();
        add(infoGeneral);

        if (proy instanceof ProyectoSocial)
            infoSocial();
        else
            infoEstructura();

        add(infoProyecto);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void infoGeneralInit() {
        JLabel titulo = new JLabel("Titulo del proyecto: " + proy.getTitulo());
        JLabel descripcion = new JLabel("Descripcion: " + proy.getDescripcion());
        JLabel importe = new JLabel("Importe solicitado: " + proy.getImporteSolicitado());
        infoGeneral.add(titulo);
        infoGeneral.add(descripcion);
        infoGeneral.add(importe);
    }

    private void infoEstructura() {
        ProyectoInfraestructura p = (ProyectoInfraestructura) proy;
        JLabel tipo = new JLabel("Tipo de proyecto: Infraestructura");
        JLabel dist = new JLabel("Distritos Afectados: " + p.getAfectados());
        ImageIcon img = new ImageIcon(getClass().getResource(p.getImagen()));
        JLabel imagen = new JLabel(img);

        infoProyecto.add(tipo);
        infoProyecto.add(dist);
        infoProyecto.add(imagen);
    }

    private void infoSocial() {
        ProyectoSocial p = (ProyectoSocial) proy;
        JLabel tipo = new JLabel("Tipo de proyecto: Social");
        JLabel grupo = new JLabel("Grupo Social: " + p.getGrupoSocial());
        JLabel nac = new JLabel("Nacional: " + p.isNacional());
        infoProyecto.add(tipo);
        infoProyecto.add(grupo);
        infoProyecto.add(nac);
    }
}