package vecindApp.vistas.home;

import vecindApp.vistas.Notificaciones;
import vecindApp.vistas.Perfil;

import javax.swing.*;

public abstract class Home extends JTabbedPane {
    protected Notificaciones<?> pNotificaciones = new Notificaciones<>();
    protected Perfil pPerfil = new Perfil();

    public Home() {
        add("Notificaciones", pNotificaciones);
        add("Perfil", pPerfil);
    }

    public Notificaciones<?> getNotificaciones() {
        return pNotificaciones;
    }

    public Perfil getPerfil() {
        return pPerfil;
    }
}
