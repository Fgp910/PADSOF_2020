package vecindApp.vistas;

import vecindApp.clases.proyecto.Proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

public class VentanaLista<T> extends JPanel {
    private JPanel izq = new JPanel();
    private JPanel der = new JPanel();

    private DefaultListModel<T> cLista = new DefaultListModel<T>();
    private JList<T> lista = new JList<T>(cLista);
    JScrollPane scroll = new JScrollPane(lista);

    public VentanaLista() {
        setLayout(new GridLayout(1, 2));

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroll.setPreferredSize(new Dimension(250,350));
        izq.add(scroll);

        add(izq);
        add(der);
    }

    protected JPanel getIzq() {
        return izq;
    }

    protected JPanel getDer() {
        return der;
    }

    public void add(T nuevo) {
        cLista.addElement(nuevo);
    }

    public void addAll(Collection<T> nuevos) {
        for (T t:nuevos) {
            cLista.addElement(t);
        }
    }

    public void remove(T t) {
        cLista.removeElement((Object)t);
    }

    public void removeAll() {
        cLista.clear();
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
