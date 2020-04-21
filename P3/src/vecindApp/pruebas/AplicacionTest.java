package vecindApp.pruebas;

import es.uam.eps.sadp.grants.InvalidIDException;
import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.aplicacion.Aplicacion;
import vecindApp.clases.colectivo.Ciudadano;
import vecindApp.clases.colectivo.Colectivo;
import vecindApp.clases.colectivo.ElementoColectivo;
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

    @Before
    public void setUp() {
        Aplicacion.reset();
        app = Aplicacion.VecindApp;
        ad = app.getAdmin();
    }

    @Test
    public void getAdmin() {
        assertEquals(ad, app.getAdmin());
    }

    @Test
    public void setAdmin() {
        app.setAdmin(new Administrador("admin2", "psswd"));
        assertEquals("admin2", app.getAdmin().getUsername());
    }

    @Test
    public void getElemCol() {
        Set<ElementoColectivo> set = new TreeSet<>();
        assertEquals(set, app.getElemCol());
    }

    @Test
    public void setElemCol() {
        Set<ElementoColectivo> newliste = new HashSet<>();
        app.setElemCol(newliste);
        assertEquals(newliste, app.getElemCol());
    }

    @Test
    public void getProyectos() {
        List<Proyecto> listp = new ArrayList<>();
        assertEquals(listp, app.getProyectos());
    }

    @Test
    public void setProyectos() {
        List<Proyecto> newlistp = new ArrayList<>();
        app.setProyectos(newlistp);
        assertEquals(newlistp, app.getProyectos());
    }

    @Test
    public void getBloqueados() {
        List<Ciudadano> lb = new ArrayList<>();
        assertEquals(lb, app.getBloqueados());
    }

    @Test
    public void setBloqueados() {
        List<Ciudadano> lb = new ArrayList<>();
        lb.add(new Ciudadano("pepe", "psswd", "123456Y"));
        app.setBloqueados(lb);
        assertEquals(lb, app.getBloqueados());
    }

    @Test
    public void getUsuarioAcutal() {
        assertNull(app.getUsuarioActual());
    }

    @Test
    public void setUsuarioAcutal() {
        Usuario usr = new Ciudadano("pepe", "a1", "12345678Z");
        app.setUsuarioActual(usr);
        assertEquals(usr, app.getUsuarioActual());
    }

    @Test
    public void addElemCol() {
        ElementoColectivo ec = new Colectivo("colectivo", new Ciudadano("pepe", "psswd", "123456Y"));
        app.addElemCol(ec);
        assertTrue(app.getElemCol().contains(ec));
    }

    @Test
    public void removeElemCol() {
        ElementoColectivo ec = new Colectivo("colectivo", new Ciudadano("pepe", "psswd", "123456Y"));
        app.addElemCol(ec);
        app.removeElemCol(ec);
        assertFalse(app.getElemCol().contains(ec));
    }

    @Test
    public void addProyecto() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("pepe", "psswd", "123456Y"), "grupo", true);
        app.addProyecto(p);
        assertTrue(app.getProyectos().contains(p));
    }

    @Test
    public void removeProyecto() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("pepe", "psswd", "123456Y"), "grupo", true);
        app.addProyecto(p);
        app.removeProyecto(p);
        assertFalse(app.getProyectos().contains(p));
    }

    @Test
    public void addBloqueado() {
        Ciudadano c = new Ciudadano("pepe", "psswd", "123456Y");
        app.addBloqueado(c);
        assertTrue(app.getBloqueados().contains(c));
    }

    @Test
    public void removeBloqueado() {
        Ciudadano c = new Ciudadano("pepe", "psswd", "123456Y");
        app.addBloqueado(c);
        app.removeBloqueado(c);
        assertFalse(app.getBloqueados().contains(c));
    }

    @Test
    public void findColectivo() {
        Colectivo c = new Colectivo("miColectivo", new Ciudadano("usr", "psswd", "12345678X"));
        app.addElemCol(c);
        assertEquals(c, app.findColectivo("miColectivo"));
    }

    @Test
    public void findCiudadano() {
        Ciudadano c = new Ciudadano("usr", "psswd", "12345678X");
        app.addElemCol(c);
        assertEquals(c, app.findCiudadano("usr"));
    }

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

    @Test
    public void notificarRegistro() {
        Ciudadano c = new Ciudadano("usr", "psswd", "12345678X");
        app.notificarRegistro(c);
        assertEquals(c, ((NotificacionReg) app.getAdmin().getPendientes().get(0)).getSujeto());
    }

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

    @Test
    public void generarInformeAfinidad() {
        Colectivo c1 = new Colectivo("Colectivo1", new Ciudadano("usr1", "psswd", "12345678X"));
        Colectivo c2 = new Colectivo("Colectivo2", new Ciudadano("usr2", "psswd", "12345678Y"));
        assertTrue(0 == app.generarInformeAfinidad(c1, c2));
    }

    @Test
    public void guardarCargar() throws IOException, ClassNotFoundException, InvalidIDException {
        app.guardar("cargar_test.txt");
        assertEquals(app.getAdmin().getUsername(), app.cargar("cargar_test.txt").getAdmin().getUsername());
    }
}