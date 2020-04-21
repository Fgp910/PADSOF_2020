package vecindApp.vistas;

import vecindApp.controladores.Controlador;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private LoginUsuario vLoginUsuario = new LoginUsuario();
    private RegistroUsuario vRegistroUsuario = new RegistroUsuario();

    private JPanel contentPane = new JPanel();

    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 150);
        setLocationRelativeTo(null);    //Centra la ventana en la pantalla
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout());

        contentPane.add(vLoginUsuario, "loginUsuario");
        contentPane.add(vRegistroUsuario, "registroUsuario");
    }

    public void setControlador(Controlador c) {
        vLoginUsuario.setControlador(c.getControlLoginUsuario());
        vRegistroUsuario.setControlador(c.getControlRegistroUsuario());
    }

    public LoginUsuario getLoginUsuario() {
        return vLoginUsuario;
    }

    public RegistroUsuario getRegistroUsuario() {
        return vRegistroUsuario;
    }

    public void mostrarPanel(String carta) {
        CardLayout l = (CardLayout)contentPane.getLayout();
        l.show(contentPane, carta);
    }
}
