package vecindApp.vistas.home;

import vecindApp.vistas.Notificaciones;
import vecindApp.vistas.Perfil;

import javax.swing.*;
import java.util.Collection;

public abstract class Home<N> extends JTabbedPane {
    public static final int[] SIZE = {600, 600};

    protected Perfil pPerfil = new Perfil();
    protected Notificaciones<N> pNotificaciones = new Notificaciones<>();

    public Home() {
        add("Perfil", pPerfil);
        add("Notificaciones", pNotificaciones);
    }

    public Perfil getPerfil() {
        return pPerfil;
    }

    public Notificaciones<N> getNotificaciones() {
        return pNotificaciones;
    }
}
