package vecindApp.vistas.home;

//import vecindApp.controladores.Controlador;

import vecindApp.vistas.*;
import vecindApp.vistas.admin.Bloquear;
import vecindApp.vistas.admin.Desbloquear;
import vecindApp.vistas.admin.MinApoyos;

import javax.swing.*;

public class HomeAdmin extends JTabbedPane {
    private JPanel p_bloquear = new Bloquear();
    private JPanel p_desbloquear = new Desbloquear();
    private JPanel p_min_apoyos = new MinApoyos();
    private JPanel p_notificaciones = new Notificaciones();
    private JPanel p_cerrar_sesion = new Perfil();


    public HomeAdmin() {
        add("Bloquear", p_bloquear);
        add("Desbloquear", p_desbloquear);
        add("Min apoyos", p_min_apoyos);
        add("Notificaciones", p_notificaciones);
        add("Cerrar sesion", p_cerrar_sesion);
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
