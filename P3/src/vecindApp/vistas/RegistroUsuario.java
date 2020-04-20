package vecindApp.vistas;

import layout.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegistroUsuario extends JPanel {
    private JPanel textPanel = new JPanel(new SpringLayout());
    private JTextField user = new JTextField();
    private JTextField nif = new JTextField();
    private JPasswordField pssw = new JPasswordField();
    private JPasswordField confirm = new JPasswordField();

    private JButton reg = new JButton("Registrarse");

    public RegistroUsuario() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(reg);
        textPanelInit();

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

        l = new JLabel("NIF:", JLabel.TRAILING);
        l.setLabelFor(nif);
        textPanel.add(l);
        textPanel.add(nif);

        l = new JLabel("Clave:", JLabel.TRAILING);
        l.setLabelFor(pssw);
        textPanel.add(l);
        textPanel.add(pssw);

        l = new JLabel("Confirmar clave:", JLabel.TRAILING);
        l.setLabelFor(confirm);
        textPanel.add(l);
        textPanel.add(confirm);

        SpringUtilities.makeCompactGrid(textPanel, 4, 2, 6, 6, 6, 6);
    }

    public void setControlador(ActionListener c) {
        reg.addActionListener(c);
    }

    public String getUsername() {
        return user.getText();
    }

    public String getPassword() {
        return new String(pssw.getPassword());
    }

    public String getConfirm() {
        return new String(confirm.getPassword());
    }

    public String getNif() {
        return nif.getText();
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();

        ventana.getContentPane().add(new RegistroUsuario());

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300,200);
        ventana.setVisible(true);
    }
}
