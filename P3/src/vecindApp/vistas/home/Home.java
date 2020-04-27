package vecindApp.vistas.home;

import vecindApp.vistas.Notificaciones;
import vecindApp.vistas.Perfil;

import javax.swing.*;

public abstract class Home extends JTabbedPane {
    private JPanel pNotificaciones = new Notificaciones();
    private JPanel pPerfil = new Perfil();
}
