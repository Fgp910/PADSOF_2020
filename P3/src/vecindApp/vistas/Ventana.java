package vecindApp.vistas;

import vecindApp.controladores.Controlador;
import vecindApp.vistas.home.HomeAdmin;
import vecindApp.vistas.home.HomeUsuario;
import vecindApp.vistas.usuario.Afinidad;
import vecindApp.vistas.usuario.nuevoProyecto.NuevoProyecto;

import javax.swing.*;
import java.awt.*;

public class Ventana<N,P,C> extends JFrame {
    private LoginUsuario vLoginUsuario = new LoginUsuario();
    private RegistroUsuario vRegistroUsuario = new RegistroUsuario();
    private HomeUsuario<N,P,C> vHomeUsuario = new HomeUsuario<>();
    private HomeAdmin<N,C> vHomeAdmin = new HomeAdmin<>();
    private NuevoProyecto<C> vNuevoProyecto = new NuevoProyecto<>();
    private Afinidad<C> vAfinidad = new Afinidad<>();

    private JPanel contentPane = new JPanel();

    public Ventana() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        contentPane.add(vAfinidad, "afinidad");
    }

    public void setControlador(Controlador c) {
        vLoginUsuario.setControlador(c.getControlLoginUsuario());
        vRegistroUsuario.setControlador(c.getControlRegistroUsuario());
        vHomeUsuario.setControlador(c.getControlHomeUsuario());
        vHomeAdmin.setControlador(c.getControlHomeAdmin());
        vNuevoProyecto.setControlador(c.getControlNuevoProyecto());
        vAfinidad.setControlador(c.getControlAfinidad());
    }

    public LoginUsuario getLoginUsuario() {
        return vLoginUsuario;
    }

    public RegistroUsuario getRegistroUsuario() {
        return vRegistroUsuario;
    }

    public HomeUsuario<N,P,C> getHomeUsuario() {
        return vHomeUsuario;
    }

    public HomeAdmin<N, C> getHomeAdmin() {
        return vHomeAdmin;
    }

    public NuevoProyecto<C> getNuevoProyecto() {
        return vNuevoProyecto;
    }

    public Afinidad<C> getAfinidad() {
        return vAfinidad;
    }

    public void mostrarPanel(String carta) {
        CardLayout l = (CardLayout)contentPane.getLayout();
        l.show(contentPane, carta);
    }
}