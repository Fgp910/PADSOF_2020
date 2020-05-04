package vecindApp.vistas.usuario.nuevoProyecto;

import layout.SpringUtilities;

import javax.swing.*;

/**
 * Define la parte de la vista de nuevos proyectos dedicada a la informacion general.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class NuevoProyectoTexto extends JPanel {
    private JTextField titulo = new JTextField();
    private JTextField desc = new JTextField();
    private JTextField importe = new JTextField();

    public NuevoProyectoTexto() {
        JLabel l;
        this.setLayout(new SpringLayout());

        l = new JLabel("Titulo:", JLabel.TRAILING);
        l.setLabelFor(titulo);
        this.add(l);
        this.add(titulo);

        l = new JLabel("Descripción:", JLabel.TRAILING);
        l.setLabelFor(desc);
        this.add(l);
        this.add(desc);

        l = new JLabel("Importe solicitado:", JLabel.TRAILING);
        l.setLabelFor(importe);
        this.add(l);
        this.add(importe);

        SpringUtilities.makeCompactGrid(this, 3, 2, 6, 6, 6, 6);
    }

    public String getTitulo() {
        return titulo.getText();
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

    /**
     * Actualiza la vista
     */
    public void update() {
        titulo.setText("");
        desc.setText("");
        importe.setText("");
    }
}
