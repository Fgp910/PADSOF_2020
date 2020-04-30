package vecindApp.vistas.home;

import vecindApp.controladores.admin.ControlHomeAdmin;
import vecindApp.vistas.admin.Bloquear;
import vecindApp.vistas.admin.Desbloquear;
import vecindApp.vistas.admin.MinApoyos;

import javax.swing.*;

public class HomeAdmin<N,C,P> extends Home<N,C> {
    private Bloquear<C> pBloquear = new Bloquear<>();
    private Desbloquear<C> pDesbloquear = new Desbloquear<>();
    private MinApoyos<P> pMinApoyos = new MinApoyos<>();

    public HomeAdmin() {
        add("Bloquear", pBloquear);
        add("Desbloquear", pDesbloquear);
        add("Min apoyos", pMinApoyos);
    }

    public Bloquear<C> getpBloquear() {
        return pBloquear;
    }

    public Desbloquear<C> getpDesbloquear() {
        return pDesbloquear;
    }

    public MinApoyos<P> getpMinApoyos() {
        return pMinApoyos;
    }

    public void setControlador(ControlHomeAdmin c) {
        pPerfil.setControlador(c.getControlPerfil());
        pNotificaciones.setControlador(c.getControlNotificaciones());
        //pMinApoyos.setControlador(c.getControlMinApoyos());
        pDesbloquear.setControlador(c.getControlDesbloquear());
        pBloquear.setControlador(c.getControlBloquear());
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();

        ventana.getContentPane().add(new HomeAdmin<String, String, String>());

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600,400);
        ventana.setVisible(true);
    }
}
