package vecindApp.pruebas;

import es.uam.eps.sadp.grants.InvalidIDException;
import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.Colectivo;
import vecindApp.clases.colectivo.ElementoColectivo;

import vecindApp.clases.excepciones.ConexionFallida;
import vecindApp.clases.notificacion.Notificacion;
import vecindApp.clases.notificacion.NotificacionProy;
import vecindApp.clases.notificacion.NotificacionReg;
import vecindApp.clases.proyecto.Proyecto;
import vecindApp.clases.proyecto.ProyectoSocial;
import vecindApp.clases.usuario.Administrador;
import vecindApp.clases.usuario.Usuario;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Clase de prueba de la clase Aplicacion
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class AplicacionTest {
    Aplicacion app;
    Administrador ad;

    /**
     * Crea una aplicacion con la que realizar las pruebas,
     * con su correspondiente administrador
     */
    @Before
    public void setUp() {
        Aplicacion.reset();
        app = Aplicacion.VecindApp;
        ad = app.getAdmin();
    }

    /**
     * Comprueba que el administrador de la aplicacion es el que se le ha asignado al crearla
     */
    @Test
    public void getAdmin() {
        assertEquals(ad, app.getAdmin());
    }

    /**
     * Comprueba que el administrador es el asignado
     */
    @Test
    public void setAdmin() {
        app.setAdmin(new Administrador("admin2", "psswd"));
        assertEquals("admin2", app.getAdmin().getUsername());
    }

    /**
     * Comprueba que la lista de elementos colectivos está vacia
     */
    @Test
    public void getElemCol() {
        Set<ElementoColectivo> set = new TreeSet<>();
        assertEquals(set, app.getElemCol());
    }

    /**
     * Comprueba que la lista de elementos colectivos es la asignada
     */
    @Test
    public void setElemCol() {
        Set<ElementoColectivo> newliste = new HashSet<>();
        app.setElemCol(newliste);
        assertEquals(newliste, app.getElemCol());
    }

    /**
     * Comprueba que la lista de proyectos esta vacia
     */
    @Test
    public void getProyectos() {
        Set<Proyecto> setp = new TreeSet<>();
        assertEquals(setp, app.getProyectos());
    }

    /**
     * Comprueba que la lista de proyecto
     */
    @Test
    public void setProyectos() {
        Set<Proyecto> newlistp = new TreeSet<>();
        app.setProyectos(newlistp);
        assertEquals(newlistp, app.getProyectos());
    }

    /**
     * Comprueba que la lista de bloqueados está vacía
     */
    @Test
    public void getBloqueados() {
        Set<Ciudadano> lb = new TreeSet<>();
        assertEquals(lb, app.getBloqueados());
    }

    /**
     * Comprueba que la lista de bloqueados es la asignada
     */
    @Test
    public void setBloqueados() {
        Set<Ciudadano> lb = new TreeSet<>();
        lb.add(new Ciudadano("pepe", "psswd", "123456Y"));
        app.setBloqueados(lb);
        assertEquals(lb, app.getBloqueados());
    }

    /**
     * Comprueba que getUsuarioActual devuelve null, ya que no hay ninguno
     */
    @Test
    public void getUsuarioAcutal() {
        assertNull(app.getUsuarioActual());
    }

    /**
     * Comprueba que el usuario actual es el asignado
     */
    @Test
    public void setUsuarioAcutal() {
        Usuario usr = new Ciudadano("pepe", "a1", "12345678Z");
        app.setUsuarioActual(usr);
        assertEquals(usr, app.getUsuarioActual());
    }

    /**
     * Comprueba que el elemento añadido está en el conjunto
     */
    @Test
    public void addElemCol() {
        ElementoColectivo ec = new Colectivo("colectivo", new Ciudadano("pepe", "psswd", "123456Y"));
        app.addElemCol(ec);
        assertTrue(app.getElemCol().contains(ec));
    }

    /**
     * Comprueba que el elemento eliminado ya no está en el conjunto
     */
    @Test
    public void removeElemCol() {
        ElementoColectivo ec = new Colectivo("colectivo", new Ciudadano("pepe", "psswd", "123456Y"));
        app.addElemCol(ec);
        app.removeElemCol(ec);
        assertFalse(app.getElemCol().contains(ec));
    }

    /**
     * Comprueba que el proyecto añadido está en el conjunto
     */
    @Test
    public void addProyecto() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("pepe", "psswd", "123456Y"), "grupo", true);
        app.addProyecto(p);
        assertTrue(app.getProyectos().contains(p));
    }

    /**
     * Comprueba que el proyecto eliminado ya no está en el conjunto
     */
    @Test
    public void removeProyecto() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("pepe", "psswd", "123456Y"), "grupo", true);
        app.addProyecto(p);
        app.removeProyecto(p);
        assertFalse(app.getProyectos().contains(p));
    }

    /**
     * Comprueba que el ciudadano bloqueado añadido está en el conjunto
     */
    @Test
    public void addBloqueado() {
        Ciudadano c = new Ciudadano("pepe", "psswd", "123456Y");
        app.addBloqueado(c);
        assertTrue(app.getBloqueados().contains(c));
    }

    /**
     * Comprueba que el ciudadano bloqueado eliminado ya no está en el conjunto
     */
    @Test
    public void removeBloqueado() {
        Ciudadano c = new Ciudadano("pepe", "psswd", "123456Y");
        app.addBloqueado(c);
        app.removeBloqueado(c);
        assertFalse(app.getBloqueados().contains(c));
    }

    /**
     * Comprueba que el elemento buscado es el correcto
     */
    @Test
    public void findColectivo() {
        Colectivo c = new Colectivo("miColectivo", new Ciudadano("usr", "psswd", "12345678X"));
        app.addElemCol(c);
        assertEquals(c, app.findColectivo("miColectivo"));
    }

    /**
     * Comprueba que el ciudadano buscado es el correcto
     */
    @Test
    public void findCiudadano() {
        Ciudadano c = new Ciudadano("usr", "psswd", "12345678X");
        app.addElemCol(c);
        assertEquals(c, app.findCiudadano("usr"));
    }

    /**
     * Comprueba que el proyecto buscado es el correcto
     */
    @Test
    public void findProyecto() {
        Proyecto p = new ProyectoSocial("titulo",
                "descripcion",
                500.0,
                new Ciudadano("usr", "psswd", "12345678X"),
                "Autonomos",
                true);
        app.addProyecto(p);
        assertEquals(p, app.findProyecto(p.getId()));
    }

    /**
     * Comprueba que el administrador ha recibido la notificacion de registro
     */
    @Test
    public void notificarRegistro() {
        Ciudadano c = new Ciudadano("usr", "psswd", "12345678X");
        app.notificarRegistro(c);
        List<Notificacion> notis = new ArrayList<>(app.getAdmin().getPendientes());
        assertEquals(c, ((NotificacionReg) notis.get(0)).getSujeto());
    }

    /**
     * Comprueba que el administrador ha recibido la notificacion de proyecto
     */
    @Test
    public void notificarNuevoProyecto() {
        Proyecto p = new ProyectoSocial("titulo",
                "descripcion",
                500.0,
                new Ciudadano("usr", "psswd", "12345678X"),
                "grupo",
                true);
        Notificacion n = new NotificacionProy(p);
        app.notificarNuevoProyecto(p);
        assertTrue(app.getAdmin().getPendientes().contains(n));
    }

    /**
     * Comprueba que se guarda bien la aplicacion
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws ConexionFallida
     */
    @Test
    public void guardarCargar() throws IOException, ClassNotFoundException, ConexionFallida {
        app.guardar("cargar_test.txt");
        //assertEquals(app.getAdmin().getUsername(), app.cargar("cargar_test.txt").getAdmin().getUsername());
    }
}