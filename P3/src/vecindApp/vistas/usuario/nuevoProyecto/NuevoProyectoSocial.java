package vecindApp.vistas.usuario.nuevoProyecto;

import layout.SpringUtilities;

import javax.swing.*;

public class NuevoProyectoSocial extends JPanel {
    private JRadioButton opc = new JRadioButton("Proyecto social");
    private JPanel textPanel = new JPanel(new SpringLayout());
    private JTextField grupo = new JTextField();
    private JPanel nacPanel = new JPanel();
    private JRadioButton nac = new JRadioButton("Nacional");
    private JRadioButton inter = new JRadioButton("Internacional");

    public NuevoProyectoSocial() {
        JLabel l = new JLabel("Grupo social:");
        ButtonGroup bg = new ButtonGroup();

        l.setLabelFor(grupo);
        textPanel.add(l);
        textPanel.add(grupo);
        SpringUtilities.makeCompactGrid(textPanel, 1, 2, 6, 6, 6, 6);

        bg.add(nac);
        bg.add(inter);
        nacPanel.add(nac);
        nacPanel.add(inter);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(opc);
        this.add(textPanel);
        this.add(nacPanel);
    }

    public JRadioButton getButton() {
        return opc;
    }

    public boolean isSelected() {
        return opc.isSelected();
    }

    public String getGrupo() {
        return grupo.getText();
    }

    public boolean isNacional() {
        return nac.isSelected();
    }

    public boolean isInternacional() {
        return inter.isSelected();
    }

    public void update() {
        opc.setSelected(false);
        grupo.setText("");
        nac.setSelected(false);
        inter.setSelected(false);
    }
}
