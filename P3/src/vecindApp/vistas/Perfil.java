package vecindApp.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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

    public void update(String info) {
        text.setText(info);
    }
}
