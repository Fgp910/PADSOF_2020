package vecindApp.vistas;

import javax.swing.*;
import java.awt.*;

public class Notificaciones extends JPanel {
    private DefaultListModel<String> data = new DefaultListModel<>();
    private JList list = new JList(data);
    private JScrollPane scroll = new JScrollPane(list);

    public Notificaciones() {
        setLayout(new BorderLayout());
        add(scroll,BorderLayout.CENTER);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public DefaultListModel<String> getListModel() {
        return data;
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        Notificaciones noti = new Notificaciones();

        ventana.getContentPane().add(noti);
        noti.getListModel().add(0, "1");
        noti.getListModel().add(0, "2");
        noti.getListModel().add(0, "3");

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300,150);
        ventana.setVisible(true);
    }
}
