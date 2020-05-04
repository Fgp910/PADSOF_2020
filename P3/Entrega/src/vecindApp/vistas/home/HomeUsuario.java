package vecindApp.vistas.home;

import vecindApp.controladores.usuario.ControlHomeUsuario;
import vecindApp.vistas.usuario.*;

/**
 * Define la vista principal del ciudadano.
 * @param <N> el tipo de las notificaciones del ciudadano
 * @param <P> el tipo de los proyectos del sistema
 * @param <C> el tipo de los ciudadanos del sistema
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class HomeUsuario<N, P, C> extends Home<N> {
    private MisProyectos<P> pMisProyectos = new MisProyectos<>();
    private MisColectivos<C> pMisColectivos = new MisColectivos<>();
    private BuscarProyectos<P> pBuscarProyectos = new BuscarProyectos<>();
    private BuscarColectivos<C> pBuscarColectivos = new BuscarColectivos<>();

    public HomeUsuario() {
        add("Mis Proyectos", pMisProyectos);
        add("Mis Colectivos", pMisColectivos);
        add("Buscar Proyectos", pBuscarProyectos);
        add("Buscar Colectivos", pBuscarColectivos);
    }

    /**
     * Devuelve la vista de gestion de los proyectos del ciudadano
     * @return la vista de gestion de los proyectos del ciudadano
     */
    public MisProyectos<P> getMisProyectos() {
        return pMisProyectos;
    }

    /**
     * Devuelve la vista de gestion de los colectivos del ciudadano
     * @return la vista de gestion de los colectivos del ciudadano
     */
    public MisColectivos<C> getMisColectivos() {
        return pMisColectivos;
    }

    /**
     * Devuelve la vista de busqueda de proyectos
     * @return la vista de busqueda de proyectos
     */
    public BuscarProyectos<P> getBuscarProyectos() {
        return pBuscarProyectos;
    }

    /**
     * Devuelve la vista de busqueda de colectivos
     * @return la vista de busqueda de colectivos
     */
    public BuscarColectivos<C> getBuscarColectivos() {
        return pBuscarColectivos;
    }

    public void setControlador(ControlHomeUsuario c) {
        pPerfil.setControlador(c.getControlPerfil());
        pNotificaciones.setControlador(c.getControlNotificaciones());
        pMisProyectos.setControlador(c.getControlMisProyectos());
        pMisColectivos.setControlador(c.getControlMisColectivos());
        pBuscarProyectos.setControlador(c.getControlBuscarProyectos());
        pBuscarColectivos.setControlador(c.getControlBuscarColectivos());
    }
}
