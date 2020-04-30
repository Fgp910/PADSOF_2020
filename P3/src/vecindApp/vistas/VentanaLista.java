package vecindApp.vistas;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

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

    public void update(Collection<T> nuevos, boolean reset) {
        if (reset) {
            removeAll();
        }
        addAll(nuevos);
    }

    public void update(Collection<T> nuevos) {
        update(nuevos, false);
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        VentanaLista<String> vLista = new VentanaLista<>();

        vLista.addAll(Arrays.asList("Ana", "Leandro", "Fabian", "Rajoy", "El coletas", "Kazaros", "Hulia", "Foo",
                "Miabuela", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r" +
                        "s", "t", "u", "v", "w", "x", "y", "z"));

        ventana.getContentPane().add(vLista);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600,400);
        ventana.setVisible(true);
    }
}
