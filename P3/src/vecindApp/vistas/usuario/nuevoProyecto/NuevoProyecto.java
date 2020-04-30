package vecindApp.vistas.usuario.nuevoProyecto;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class NuevoProyecto<C> extends JPanel {
    public static final int[] SIZE = {600, 600};

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

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        NuevoProyecto<String> vista = new NuevoProyecto<>();

        vista.infra.setList(Arrays.asList("Chamartín", "Hortaleza"));

        frame.getContentPane().add(vista);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setVisible(true);
    }
}
