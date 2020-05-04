package vecindApp.vistas.home;

import vecindApp.vistas.Notificaciones;
import vecindApp.vistas.Perfil;

import javax.swing.*;
import java.util.Collection;

/**
 * Define una vista principal de usuario generica.
 * @param <N> el tipo de las notificaciones del usuario
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public abstract class Home<N> extends JTabbedPane {
    public static final int[] SIZE = {800, 600};

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
