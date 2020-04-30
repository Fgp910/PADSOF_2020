package vecindApp.vistas.usuario.nuevoProyecto;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;

public class NuevoProyectoPropulsor<C> extends JPanel {
    private JRadioButton ciu = new JRadioButton("Soy ciudadano");
    private JPanel colPanel = new JPanel();
    private JRadioButton col = new JRadioButton("Soy representante de un colectivo");
    private JComboBox<C> listaCol = new JComboBox<>();
    private ButtonGroup ciuColGroup = new ButtonGroup();

    public NuevoProyectoPropulsor() {
        colPanel.add(col);
        colPanel.add(listaCol);

        ciuColGroup.add(ciu);
        ciuColGroup.add(col);

        this.add(ciu);
        this.add(colPanel);
    }

    public boolean isCiudadano() {
        return ciu.isSelected();
    }

    public boolean isColectivo() {
        return col.isSelected();
    }

    public C getSelected() {
        return (C)listaCol.getSelectedItem();
    }

    public void setList(Collection<C> list) {
        listaCol.removeAll();
        list.forEach(elem -> listaCol.addItem(elem));
    }

    public void update() {
        ciu.setSelected(false);
        col.setSelected(false);
        listaCol.setSelectedIndex(-1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        NuevoProyectoPropulsor<String> vista = new NuevoProyectoPropulsor<>();

        vista.setList(Arrays.asList("Estudiantes", "Explotados"));

        frame.getContentPane().add(vista);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setVisible(true);
    }
}
