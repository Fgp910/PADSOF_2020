package vecindApp.vistas.usuario.nuevoProyecto;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Define la parte de la vista de nuevos proyectos dedicada a su propulsor.
 * @param <C> el tipo de los colectivos representados
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
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

    public void setList(Collection<? extends C> list) {
        listaCol.removeAll();
        list.forEach(elem -> listaCol.addItem(elem));
    }

    /**
     * Actualiza la vista
     * @param list lista de colectivos representados
     */
    public void update(Collection<? extends C> list) {
        ciu.setSelected(false);
        col.setSelected(false);
        setList(list);
        listaCol.setSelectedIndex(-1);
    }
}
