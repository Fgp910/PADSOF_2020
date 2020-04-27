package vecindApp.vistas.home;

import vecindApp.vistas.*;
import vecindApp.vistas.usuario.BuscarColectivos;
import vecindApp.vistas.usuario.BuscarProyectos;
import vecindApp.vistas.usuario.ConsultarColectivos;
import vecindApp.vistas.usuario.ConsultarProyectos;

import javax.swing.*;

public class HomeUsuario extends JTabbedPane {
    private JPanel p_consultar_cols = new ConsultarColectivos();
    private JPanel p_consultar_proys = new ConsultarProyectos();
    private JPanel p_buscar_proys = new BuscarProyectos();
    private JPanel p_buscar_cols = new BuscarColectivos();
    private JPanel p_notificaciones = new Notificaciones();
    private Perfil pPerfil = new Perfil();


    public HomeUsuario() {
        add("Notificaciones", p_notificaciones);
        add("Consultar Proyectos", p_consultar_proys);
        add("Consultar Colectivos", p_consultar_cols);
        add("Buscar Proyectos", p_buscar_proys);
        add("Buscar Colectivos", p_buscar_cols);
        add("Perfil", pPerfil);
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

    public Perfil getPerfil() {
        return pPerfil;
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
