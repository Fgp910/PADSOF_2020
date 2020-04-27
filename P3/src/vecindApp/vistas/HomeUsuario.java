package vecindApp.vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeUsuario extends JPanel {
    private JPanel textPanel = new JPanel(new FlowLayout());
    private JPanel buttonPanel = new JPanel(new GridLayout(3, 2));
    private JButton b_consultar_cols = new JButton("Consultar mis colectivos");
    private JButton b_consultar_proys = new JButton("Consultar mis proyectos");
    private JButton b_buscar_proys = new JButton("Buscar proyectos");
    private JButton b_buscar_cols = new JButton("Buscar colectivos");
    private JButton b_notificaciones = new JButton("Notificaciones");
    private JButton b_cerrar_sesion = new JButton("Cerrar sesion");
    private JPanel p_consultar_cols; //= new ConsultarColectivos();
    private JPanel p_consultar_proys; //= new ConsultarProyectos();
    private JPanel p_buscar_proys; //= new BuscarProyectos();
    private JPanel p_buscar_cols; //= new BuscarColectivos();
    private JPanel p_notificaciones; //= new Notificaciones();
    private JPanel p_cerrar_sesion;// = new LoginUsuario();


    public HomeUsuario() {
        buttonPanelInit();
        textPanelInit();

        add(textPanel);
        add(buttonPanel);

        /*add(p_notificaciones);
        add(p_consultar_proys);
        add(p_consultar_cols);
        add(p_cerrar_sesion);
        add(p_buscar_proys);
        add(p_buscar_cols);*/

        this.setLayout(new GridLayout(2, 1));

        /*p_buscar_cols.setVisible(false);
        p_buscar_proys.setVisible(false);
        p_cerrar_sesion.setVisible(false);
        p_consultar_cols.setVisible(false);
        p_consultar_proys.setVisible(false);
        p_notificaciones.setVisible(false);*/
    }

    private void buttonPanelInit() {
        buttonPanel.add(b_consultar_cols);
        buttonPanel.add(b_consultar_proys);
        buttonPanel.add(b_buscar_cols);
        buttonPanel.add(b_buscar_proys);
        buttonPanel.add(b_notificaciones);
        buttonPanel.add(b_cerrar_sesion);
    }

    private void textPanelInit() {
        JLabel texto = new JLabel("Bienvenido Usuario");
        textPanel.add(texto);
    }

    public JPanel getTextPanel() {
        return textPanel;
    }

    public JButton getB_consultar_cols() {
        return b_consultar_cols;
    }

    public JButton getB_consultar_proys() {
        return b_consultar_proys;
    }

    public JButton getB_buscar_proys() {
        return b_buscar_proys;
    }

    public JButton getB_buscar_cols() {
        return b_buscar_cols;
    }

    public JButton getB_notificaciones() {
        return b_notificaciones;
    }

    public JButton getB_cerrar_sesion() {
        return b_cerrar_sesion;
    }

    public JPanel getP_consultar_cols() {
        return p_consultar_cols;
    }

    public JPanel getP_consultar_proys() {
        return p_consultar_proys;
    }

    public JPanel getP_buscar_proys() {
        return p_buscar_proys;
    }

    public JPanel getP_buscar_cols() {
        return p_buscar_cols;
    }

    public JPanel getP_notificaciones() {
        return p_notificaciones;
    }

    public JPanel getP_cerrar_sesion() {
        return p_cerrar_sesion;
    }

    public void setControlador(ActionListener c) {
        b_consultar_cols.addActionListener(c);
        b_buscar_cols.addActionListener(c);
        b_buscar_proys.addActionListener(c);
        b_cerrar_sesion.addActionListener(c);
        b_consultar_proys.addActionListener(c);
        b_notificaciones.addActionListener(c);
    }

    /*public void setControlador(ControlHomeUsuario c) {
        p_notificaciones.setControlador(c.getControlNotificaciones());
        p_consultar_proys.setControlador(c.getControlConsultarProyectos());
        p_consultar_cols.setControlador(c.getControlConsultarColectivos());
        p_cerrar_sesion.setControlador(c.getControlCerrarSesion());
        p_buscar_proys.setControlador(c.getControlBuscarProyectos());
        p_buscar_cols.setControlador(c.getControlBuscarColectivos());
    }*/

    public static void main(String[] args) {
        JFrame ventana = new JFrame();

        ventana.getContentPane().add(new HomeUsuario());

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600,300);
        ventana.setVisible(true);
    }
}
