package vecindApp.vistas;

import layout.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginUsuario extends JPanel {
    public static final int[] SIZE = {300, 150};

    private JPanel textPanel = new JPanel(new SpringLayout());
    private JTextField user = new JTextField();
    private JPasswordField pssw = new JPasswordField();

    private JPanel buttonPanel = new JPanel();
    private JButton reg = new JButton("Registrarse");
    private JButton enter = new JButton("Entrar");
    private JButton time = new JButton("30 días");

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
        buttonPanel.add(time);
    }

    public JButton getRegButton() {
        return reg;
    }

    public JButton getEntButton() {
        return enter;
    }

    public JButton getTimeButton() {
        return time;
    }

    public void setControlador(ActionListener c) {
        reg.addActionListener(c);
        enter.addActionListener(c);
        time.addActionListener(c);
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
}
