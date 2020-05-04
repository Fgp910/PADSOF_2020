package vecindApp.vistas.usuario.nuevoProyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;

/**
 * Define la vista de nuevos proyectos.
 * @param <C> el tipo de los colectivos representados
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class NuevoProyecto<C> extends JPanel {
    public static final int[] SIZE = {850, 750};

    private JPanel global = new JPanel();
    private NuevoProyectoPropulsor<C> propulsor = new NuevoProyectoPropulsor<>();
    private NuevoProyectoTexto texto = new NuevoProyectoTexto();
    private NuevoProyectoInfraestructura infra = new NuevoProyectoInfraestructura();
    private NuevoProyectoSocial social = new NuevoProyectoSocial();
    private JPanel tipoPanel = new JPanel(new GridLayout(1,2));
    private JPanel buttonPanel = new JPanel();
    private JButton crear = new JButton("Crear");
    private JButton volver = new JButton("Volver");

    public NuevoProyecto() {
        ButtonGroup bg = new ButtonGroup();

        bg.add(infra.getButton());
        bg.add(social.getButton());

        tipoPanel.add(infra);
        tipoPanel.add(social);

        buttonPanel.add(crear);
        buttonPanel.add(volver);

        global.setLayout(new BoxLayout(global, BoxLayout.Y_AXIS));
        global.add(propulsor);
        global.add(texto);
        global.add(tipoPanel);

        this.setLayout(new BorderLayout());
        this.add(global, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setControlador(ActionListener c) {
        crear.addActionListener(c);
        volver.addActionListener(c);
    }

    public JButton getCrear() {
        return crear;
    }

    public JButton getVolver() {
        return volver;
    }

    public NuevoProyectoPropulsor<C> getPropulsorPanel() {
        return propulsor;
    }

    public NuevoProyectoTexto getTextoPanel() {
        return texto;
    }

    public NuevoProyectoInfraestructura getInfraPanel() {
        return infra;
    }

    public NuevoProyectoSocial getSocialPanel() {
        return social;
    }

    /**
     * Actualiza la vista
     * @param colectivos colectivos representados por el usuario
     * @param distritos distritos a los que puede afectar el proyecto
     */
    public void update(Collection<? extends C> colectivos, Collection<String> distritos) {
        propulsor.update(colectivos);
        texto.update();
        infra.setList(distritos);
        infra.update();
        social.update();
    }
}
