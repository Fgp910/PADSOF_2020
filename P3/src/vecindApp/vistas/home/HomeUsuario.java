package vecindApp.vistas.home;

import vecindApp.controladores.ControlHomeUsuario;
import vecindApp.vistas.Perfil;
import vecindApp.vistas.usuario.BuscarColectivos;
import vecindApp.vistas.usuario.BuscarProyectos;
import vecindApp.vistas.usuario.ConsultarColectivos;
import vecindApp.vistas.usuario.ConsultarProyectos;

import javax.swing.*;

public class HomeUsuario<N> extends Home<N> {
    private ConsultarColectivos pConsultarColectivos = new ConsultarColectivos();
    private ConsultarProyectos pConsultarProyectos = new ConsultarProyectos();
    private BuscarProyectos pBuscarProyectos = new BuscarProyectos();
    private BuscarColectivos pBuscarColectivos = new BuscarColectivos();

    public HomeUsuario() {
        add("Consultar Proyectos", pConsultarProyectos);
        add("Consultar Colectivos", pConsultarColectivos);
        add("Buscar Proyectos", pBuscarProyectos);
        add("Buscar Colectivos", pBuscarColectivos);
    }

    public ConsultarColectivos getpConsultarColectivos() {
        return pConsultarColectivos;
    }

    public ConsultarProyectos getpConsultarProyectos() {
        return pConsultarProyectos;
    }

    public BuscarProyectos getpBuscarProyectos() {
        return pBuscarProyectos;
    }

    public BuscarColectivos getpBuscarColectivos() {
        return pBuscarColectivos;
    }

    public void setControlador(ControlHomeUsuario c) {
        pPerfil.setControlador(c.getControlPerfil());
        pNotificaciones.setControlador(c.getControlNotificaciones());
        /*p_consultar_proys.setControlador(c.getControlConsultarProyectos());
        p_consultar_cols.setControlador(c.getControlConsultarColectivos());
        p_cerrar_sesion.setControlador(c.getControlCerrarSesion());
        p_buscar_proys.setControlador(c.getControlBuscarProyectos());
        p_buscar_cols.setControlador(c.getControlBuscarColectivos());*/
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame();

        ventana.getContentPane().add(new HomeUsuario());

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600,300);
        ventana.setVisible(true);
    }
}
