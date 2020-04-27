package vecindApp.vistas;

import javax.swing.*;
import java.awt.*;

public class ConsultarProyectos extends JPanel {
    private JPanel textPanel = new JPanel(new SpringLayout());

    public ConsultarProyectos() {
        textPanelInit();

        this.setLayout(new BorderLayout());
        add(textPanel, BorderLayout.CENTER);
    }

    private void textPanelInit() {
        JLabel texto = new JLabel("Consultar Proyectos");
        textPanel.add(texto);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();

        ventana.getContentPane().add(new ConsultarColectivos());

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300,150);
        ventana.setVisible(true);
    }
}
