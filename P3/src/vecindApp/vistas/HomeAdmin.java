package vecindApp.vistas;

//import vecindApp.controladores.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeAdmin extends JPanel {
    private JPanel textPanel = new JPanel(new FlowLayout());
    private JPanel buttonPanel = new JPanel(new GridLayout(3, 2));
    private JButton b_bloquear = new JButton("Bloquear usuarios");
    private JButton b_desbloquear = new JButton("Desbloquear usuarios");
    private JButton b_notificaciones = new JButton("Notificaciones");
    private JButton b_min_apoyos = new JButton("Cambiar minimo de apoyos");
    private JButton b_cerrar_sesion = new JButton("Cerrar sesion");
    private JPanel p_bloquear; //= new Bloquear();
    private JPanel p_desbloquear; //= new Desbloquear();
    private JPanel p_min_apoyos; //= new MinApoyos();
    private JPanel p_notificaciones; //= new Notificaciones();
    private JPanel p_cerrar_sesion; //= new LoginUsuario();


    public HomeAdmin() {
        buttonPanelInit();
        textPanelInit();

        this.setLayout(new GridLayout(2, 1));

        add(textPanel);
        add(buttonPanel);

        /*add(p_bloquear);
        add(p_cerrar_sesion);
        add(p_desbloquear);
        add(p_min_apoyos);
        add(p_notificaciones);*/

        /*p_bloquear.setVisible(false);
        p_cerrar_sesion.setVisible(false);
        p_desbloquear.setVisible(false);
        p_min_apoyos.setVisible(false);
        p_notificaciones.setVisible(false);*/
    }

    private void buttonPanelInit() {
        buttonPanel.add(b_bloquear);
        buttonPanel.add(b_desbloquear);
        buttonPanel.add(b_min_apoyos);
        buttonPanel.add(b_notificaciones);
        buttonPanel.add(b_cerrar_sesion);
    }

    private void textPanelInit() {
        JLabel texto = new JLabel("Bienvenido Aministrador");
        textPanel.add(texto);
    }

    public JPanel getTextPanel() {
        return textPanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public JButton getB_bloquear() {
        return b_bloquear;
    }

    public JButton getB_desbloquear() {
        return b_desbloquear;
    }

    public JButton getB_notificaciones() {
        return b_notificaciones;
    }

    public JButton getB_min_apoyos() {
        return b_min_apoyos;
    }

    public JButton getB_cerrar_sesion() {
        return b_cerrar_sesion;
    }

    public JPanel getP_bloquear() {
        return p_bloquear;
    }

    public JPanel getP_desbloquear() {
        return p_desbloquear;
    }

    public JPanel getP_min_apoyos() {
        return p_min_apoyos;
    }

    public JPanel getP_notificaciones() {
        return p_notificaciones;
    }

    public JPanel getP_cerrar_sesion() {
        return p_cerrar_sesion;
    }

    public void setControlador(ActionListener c) {
        b_bloquear.addActionListener(c);
        b_desbloquear.addActionListener(c);
        b_min_apoyos.addActionListener(c);
        b_cerrar_sesion.addActionListener(c);
        b_notificaciones.addActionListener(c);
    }

    /*public void setControlador(Controlador c) {
        p_notificaciones.setControlador(c.getControlNotificaciones());
        p_min_apoyos.setControlador(c.getControlMinApoyos());
        p_desbloquear.setControlador(c.getControlDesbloquear());
        p_cerrar_sesion.setControlador(c.getControlCerrarSesion());
        p_bloquear.setControlador(c.getControlBloquear());
    }*/

    public static void main(String[] args) {
        JFrame ventana = new JFrame();

        ventana.getContentPane().add(new HomeAdmin());

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600,400);
        ventana.setVisible(true);
    }
}
