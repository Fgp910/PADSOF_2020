package vecindApp.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Define la vista para buscar colectivos.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Perfil extends JPanel {
    private JPanel textPanel = new JPanel(new FlowLayout());
    private JLabel text = new JLabel();
    private JPanel buttonPanel = new JPanel(new FlowLayout());
    private JButton salir = new JButton("Cerrar Sesion");

    public Perfil() {
        textPanelInit();
        buttonPanelInit();

        this.setLayout(new BorderLayout());
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void buttonPanelInit() {
        buttonPanel.add(salir);
    }

    private void textPanelInit() {
        textPanel.add(text);
    }

    public void setControlador(ActionListener c) {
        salir.addActionListener(c);
    }

    /**
     * Actualiza la vista
     * @param info informacion del usuario
     */
    public void update(String info) {
        text.setText(info);
    }
}
