package vecindApp.vistas.usuario.nuevoProyecto;

import layout.SpringUtilities;

import javax.swing.*;

public class NuevoProyectoTexto extends JPanel {
    private JTextField desc = new JTextField();
    private JTextField importe = new JTextField();

    public NuevoProyectoTexto() {
        JLabel l;
        this.setLayout(new SpringLayout());

        l = new JLabel("Descripción:");
        l.setLabelFor(desc);
        this.add(l);
        this.add(desc);

        l = new JLabel("Importe solicitado:");
        l.setLabelFor(importe);
        this.add(l);
        this.add(importe);

        SpringUtilities.makeCompactGrid(this, 2, 2, 6, 6, 6, 6);
    }

    public String getDesc() {
        return desc.getText();
    }

    public Double getImporte() {
        try {
            return Double.parseDouble(importe.getText());
        } catch (Exception ex) {
            return null;
        }
    }

    public void update() {
        desc.setText("");
        importe.setText("");
    }
}
