package vecindApp.vistas;

import vecindApp.controladores.Controlador;
import vecindApp.vistas.home.HomeAdmin;
import vecindApp.vistas.home.HomeUsuario;
import vecindApp.vistas.usuario.nuevoProyecto.NuevoProyecto;

import javax.swing.*;
import java.awt.*;

public class Ventana<N,P,C> extends JFrame {
    private LoginUsuario vLoginUsuario = new LoginUsuario();
    private RegistroUsuario vRegistroUsuario = new RegistroUsuario();
    private HomeUsuario<N,P> vHomeUsuario = new HomeUsuario<>();
    private HomeAdmin<N,P,C> vHomeAdmin = new HomeAdmin<>();
    private NuevoProyecto<C> vNuevoProyecto = new NuevoProyecto<>();

    private JPanel contentPane = new JPanel();

    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 150);
        setLocationRelativeTo(null);    //Centra la ventana en la pantalla
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout());
        setTitle("VecindApp");

        contentPane.add(vLoginUsuario, "loginUsuario");
        contentPane.add(vRegistroUsuario, "registroUsuario");
        contentPane.add(vHomeUsuario, "home");
        contentPane.add(vHomeAdmin, "homeAdmin");
        contentPane.add(vNuevoProyecto, "nuevoProyecto");
    }

    public void setControlador(Controlador c) {
        vLoginUsuario.setControlador(c.getControlLoginUsuario());
        vRegistroUsuario.setControlador(c.getControlRegistroUsuario());
        vHomeUsuario.setControlador(c.getControlHomeUsuario());
        vHomeAdmin.setControlador(c.getControlHomeAdmin());
        vNuevoProyecto.setControlador(c.getControlNuevoProyecto());
    }

    public LoginUsuario getLoginUsuario() {
        return vLoginUsuario;
    }

    public RegistroUsuario getRegistroUsuario() {
        return vRegistroUsuario;
    }

    public HomeUsuario<N,P> getHomeUsuario() {
        return vHomeUsuario;
    }

    public HomeAdmin<N,P,C> getHomeAdmin() {
        return vHomeAdmin;
    }

    public NuevoProyecto<C> getNuevoProyecto() {
        return vNuevoProyecto;
    }

    public void mostrarPanel(String carta) {
        CardLayout l = (CardLayout)contentPane.getLayout();
        l.show(contentPane, carta);
    }
}