package vecindApp.vistas.home;

//import vecindApp.controladores.Controlador;

import vecindApp.vistas.*;
import vecindApp.vistas.admin.Bloquear;
import vecindApp.vistas.admin.Desbloquear;
import vecindApp.vistas.admin.MinApoyos;

import javax.swing.*;

public class HomeAdmin extends Home {
    private Bloquear pBloquear = new Bloquear();
    private Desbloquear pDesbloquear = new Desbloquear();
    private MinApoyos pMinApoyos = new MinApoyos();

    public HomeAdmin() {
        add("Bloquear", pBloquear);
        add("Desbloquear", pDesbloquear);
        add("Min apoyos", pMinApoyos);
    }

    public Bloquear getpBloquear() {
        return pBloquear;
    }

    public Desbloquear getpDesbloquear() {
        return pDesbloquear;
    }

    public MinApoyos getpMinApoyos() {
        return pMinApoyos;
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
