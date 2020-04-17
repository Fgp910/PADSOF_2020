package vecindApp.vistas;

import layout.SpringUtilities;

import javax.swing.*;
import java.awt.*;

public class loginUsuario extends JPanel {
    private JPanel textPanel = new JPanel(new SpringLayout());
    private JTextField user = new JTextField();
    private JPasswordField pssw = new JPasswordField();

    private JButton enter = new JButton("Entrar");

    public loginUsuario() {
        textPanelInit();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(textPanel);
        add(enter);
        enter.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void textPanelInit() {
        JLabel l;
        l = new JLabel("Nombre de usuario:", JLabel.TRAILING);
        l.setLabelFor(user);
        textPanel.add(l);
        //((JLabel) textPanel.add(new JLabel("Nombre de usuario:", JLabel.TRAILING))).setLabelFor(user);
        textPanel.add(user);

        l = new JLabel("Clave:", JLabel.TRAILING);
        l.setLabelFor(pssw);
        textPanel.add(l);
        textPanel.add(pssw);

        SpringUtilities.makeCompactGrid(textPanel, 2, 2, 6, 6, 6, 6);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();

        ventana.getContentPane().add(new loginUsuario());

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300,200);
        ventana.setVisible(true);
    }
}
