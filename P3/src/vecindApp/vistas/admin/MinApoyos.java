package vecindApp.vistas.admin;

import layout.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Define la vista de configuracion del minimo de apoyos.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class MinApoyos extends JPanel {
    public static final int[] SIZE = {300, 150};

    private JPanel textPanel = new JPanel(new SpringLayout());
    private JTextField newMin = new JTextField();
    private JPanel buttonPanel = new JPanel();
    private JLabel min = new JLabel("300");
    private JButton change = new JButton("Cambiar");

    public MinApoyos() {
        textPanelInit();
        buttonPanelInit();

        this.setLayout(new BorderLayout());
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void textPanelInit() {
        JLabel texto = new JLabel("El minimo actual es: ");
        textPanel.add(texto);
        textPanel.add(min);

        JLabel l;
        l = new JLabel("Nuevo minimo: ", JLabel.TRAILING);
        l.setLabelFor(newMin);
        textPanel.add(l);
        textPanel.add(newMin);
        SpringUtilities.makeCompactGrid(textPanel, 2, 2, 6, 6, 6, 6);
    }

    private void buttonPanelInit() {
        buttonPanel.add(change);
    }

    /**
     * Actualiza la vista
     * @param info el nuevo valor minimo de apoyos
     */
    public void update(String info) {
        newMin.setText("");
        min.setText(info);
    }

    public void setControlador(ActionListener c) {
        change.addActionListener(c);
    }

    public String getNewMin() {
        return newMin.getText();
    }
}
