package vecindApp.vistas;

import layout.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginUsuario extends JPanel {
    private JPanel textPanel = new JPanel(new SpringLayout());
    private JTextField user = new JTextField();
    private JPasswordField pssw = new JPasswordField();

    private JPanel buttonPanel = new JPanel();
    private JButton reg = new JButton("Registrarse");
    private JButton enter = new JButton("Entrar");

    public LoginUsuario() {
        textPanelInit();
        buttonPanelInit();

        this.setLayout(new BorderLayout());
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
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

    private void buttonPanelInit() {
        buttonPanel.add(reg);
        buttonPanel.add(enter);
    }

    public JButton getRegButton() {
        return reg;
    }

    public JButton getEntButton() {
        return enter;
    }

    public void setControlador(ActionListener c) {
        reg.addActionListener(c);
        enter.addActionListener(c);
    }

    public void update() {
        user.setText("");
        pssw.setText("");
        user.grabFocus();
    }

    public String getUsername() {
        return user.getText();
    }

    public String getPassword() {
        return new String(pssw.getPassword());
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();

        ventana.getContentPane().add(new LoginUsuario());

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300,150);
        ventana.setVisible(true);
    }
}
