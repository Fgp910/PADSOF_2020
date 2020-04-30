package vecindApp.vistas;

import vecindApp.controladores.Controlador;
import vecindApp.vistas.home.HomeAdmin;
import vecindApp.vistas.home.HomeUsuario;

import javax.swing.*;
import java.awt.*;

public class Ventana<N,P,C> extends JFrame {
    private LoginUsuario vLoginUsuario = new LoginUsuario();
    private RegistroUsuario vRegistroUsuario = new RegistroUsuario();
    private HomeUsuario<N,P> vHomeUsuario = new HomeUsuario<>();
    private HomeAdmin<N,C,P> vHomeAdmin = new HomeAdmin<>();

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
    }

    public void setControlador(Controlador c) {
        vLoginUsuario.setControlador(c.getControlLoginUsuario());
        vRegistroUsuario.setControlador(c.getControlRegistroUsuario());
        vHomeUsuario.setControlador(c.getControlHomeUsuario());
        vHomeAdmin.setControlador(c.getControlHomeAdmin());
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

    public HomeAdmin<N,C,P> getHomeAdmin() {
        return vHomeAdmin;
    }

    public void mostrarPanel(String carta) {
        CardLayout l = (CardLayout)contentPane.getLayout();
        l.show(contentPane, carta);
    }
}