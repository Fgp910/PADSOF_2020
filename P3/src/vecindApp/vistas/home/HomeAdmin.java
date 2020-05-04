package vecindApp.vistas.home;

import vecindApp.controladores.admin.ControlHomeAdmin;
import vecindApp.vistas.admin.Bloquear;
import vecindApp.vistas.admin.Desbloquear;
import vecindApp.vistas.admin.MinApoyos;

import javax.swing.*;

/**
 * Define la vista principal del administrador.
 * @param <N> el tipo de las notificaciones del administrador
 * @param <C> el tipo de los ciudadanos del sistema
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class HomeAdmin<N, C> extends Home<N> {
    private Bloquear<C> pBloquear = new Bloquear<>();
    private Desbloquear<C> pDesbloquear = new Desbloquear<>();
    private MinApoyos pMinApoyos = new MinApoyos();

    public HomeAdmin() {
        add("Bloquear", pBloquear);
        add("Desbloquear", pDesbloquear);
        add("Min apoyos", pMinApoyos);
    }

    /**
     * Devuelve la vista de ciudadanos no bloqueados
     * @return la vista de ciudadanos no bloqueados
     */
    public Bloquear<C> getBloquear() {
        return pBloquear;
    }

    /**
     * Devuelve la vista de ciudadanos bloqueados
     * @return la vista de ciudadanos bloqueados
     */
    public Desbloquear<C> getDesbloquear() {
        return pDesbloquear;
    }

    /**
     * Devuelve la vista de configuracion del minimo de apoyos
     * @return la vista de configuracion del minimo de apoyos
     */
    public MinApoyos getMinApoyos() {
        return pMinApoyos;
    }

    public void setControlador(ControlHomeAdmin c) {
        pPerfil.setControlador(c.getControlPerfil());
        pNotificaciones.setControlador(c.getControlNotificaciones());
        pMinApoyos.setControlador(c.getControlMinApoyos());
        pDesbloquear.setControlador(c.getControlDesbloquear());
        pBloquear.setControlador(c.getControlBloquear());
    }
}
