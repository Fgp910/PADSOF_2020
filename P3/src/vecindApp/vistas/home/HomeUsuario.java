package vecindApp.vistas.home;

import vecindApp.controladores.usuario.ControlHomeUsuario;
import vecindApp.vistas.usuario.*;

public class HomeUsuario<N, P, C> extends Home<N> {
    private MisProyectos<P> pMisProyectos = new MisProyectos<>();
    private MisColectivos<C> pMisColectivos = new MisColectivos<>();
    private BuscarProyectos<P> pBuscarProyectos = new BuscarProyectos<>();
    private BuscarColectivos pBuscarColectivos = new BuscarColectivos();

    public HomeUsuario() {
        add("Mis Proyectos", pMisProyectos);
        add("Mis Colectivos", pMisColectivos);
        add("Buscar Proyectos", pBuscarProyectos);
        add("Buscar Colectivos", pBuscarColectivos);
    }

    public MisProyectos<P> getMisProyectos() {
        return pMisProyectos;
    }

    public MisColectivos<C> getMisColectivos() {
        return pMisColectivos;
    }

    public BuscarProyectos<P> getBuscarProyectos() {
        return pBuscarProyectos;
    }

    public BuscarColectivos getpBuscarColectivos() {
        return pBuscarColectivos;
    }

    public void setControlador(ControlHomeUsuario c) {
        pPerfil.setControlador(c.getControlPerfil());
        pNotificaciones.setControlador(c.getControlNotificaciones());
        pMisProyectos.setControlador(c.getControlMisProyectos());
        pMisColectivos.setControlador(c.getControlMisColectivos());
        pBuscarProyectos.setControlador(c.getControlBuscarProyectos());
    }
}
