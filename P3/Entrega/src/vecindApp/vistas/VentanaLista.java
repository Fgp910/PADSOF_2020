package vecindApp.vistas;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Define una vista generica que contiene una lista dinamica.
 * @param <T> el tipo de entradas de la lista
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class VentanaLista<T> extends JPanel {
    private JPanel bot = new JPanel();
    private DefaultListModel<T> cLista = new DefaultListModel<>();
    private JList<T> lista = new JList<>(cLista);
    private JScrollPane scroll = new JScrollPane(lista);

    public VentanaLista() {
        setLayout(new BorderLayout());

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroll.setPreferredSize(new Dimension(250,350));

        add(scroll, BorderLayout.CENTER);
        add(bot, BorderLayout.SOUTH);
    }

    protected JPanel getBot() {
        return bot;
    }

    public JList<T> getLista() {
        return lista;
    }

    public T getItem(int index) {
        return cLista.get(index);
    }

    public void add(T nuevo) {
        cLista.addElement(nuevo);
    }

    public void addAll(Collection<T> nuevos) {
        for (T t : nuevos) {
            cLista.addElement(t);
        }
    }

    public void remove(T t) {
        cLista.removeElement(t);
    }

    public void removeAll() {
        cLista.clear();
    }

    /**
     * Actualiza la vista borrando los elementos previa si se indica
     * @param nuevos nuevos elementos a mostrar
     * @param reset indica si se deben borrar los elementos previos
     */
    public void update(Collection<T> nuevos, boolean reset) {
        if (reset) {
            removeAll();
        }
        addAll(nuevos);
    }

    /**
     * Actualiza la vista sin borrar los elementos previos
     * @param nuevos nuevos elementos a mostrar
     */
    public void update(Collection<T> nuevos) {
        update(nuevos, false);
    }

    public void setControlador(ListSelectionListener c) {
        lista.addListSelectionListener(c);
    }
}
