package vecindApp.vistas;

import vecindApp.controladores.ControlLoginUsuario;
import vecindApp.controladores.Controlador;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private LoginUsuario vLoginUsuario = new LoginUsuario();

    private ControlLoginUsuario cLoginUsuario;

    private JPanel contentPane = new JPanel();

    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 300, 150);
        setLocationRelativeTo(null);    //Centra la ventana en la pantalla
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout());

        contentPane.add(vLoginUsuario, "loginUsuario");
    }

    public void setControlador(Controlador c) {
        cLoginUsuario = c.getControlLoginUsuario();
        vLoginUsuario.setControlador(cLoginUsuario.getControladorReg(), cLoginUsuario.getControladorEnter());
    }

    public LoginUsuario getLoginUsuario() {
        return vLoginUsuario;
    }

    public void mostrarPanel(String carta) {
        CardLayout l = (CardLayout)contentPane.getLayout();
        l.show(contentPane, carta);
    }
}
