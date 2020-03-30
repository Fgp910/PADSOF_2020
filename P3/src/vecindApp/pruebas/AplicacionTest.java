package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.*;

import java.util.ArrayList;
import java.util.List;

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
        ad = new Administrador("admin", "psswd");
        app = new Aplicacion(ad);
    }

    @Test
    public void getAdmin() {
        assertEquals(ad, app.getAdmin());
    }

    @Test
    public void setAdmin() {
        Administrador ad2 = new Administrador("admin2", "psswd");
        assertEquals(ad2, app.getAdmin());
    }

    @Test
    public void getElemCol() {
        List<ElementoColectivo> liste = new ArrayList<>();
        assertEquals(liste, app.getElemCol());
    }

    @Test
    public void setElemCol() {
        List<ElementoColectivo> newliste = new ArrayList<>();
        sf.setElemCol(newliste);
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
        sf.setProyectos(newlistp);
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
        Usuario usr;
        assertEquals(usr, app.getUsuarioActual());
    }

    @Test
    public void setUsuarioAcutal() {
        Usuario usr = new Usuario("pepe", "a1");
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
        Notificacion n = new NotificacionReg(c);
        app.notificarRegistro(c);
        assertTrue(app.getAdmin().getPendientes().contains(n));
    }

    @Test
    public void notificarNuevoProyecto() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("usr", "psswd", "12345678X"));
        Notificacion n = new NotificacionProy(p);
        app.notificarNuevoProyecto(p);
        assertTrue(app.getAdmin().getPendientes().contains(n));
    }

    @Test
    public void generarInformeAfinidad() {
        Colectivo c1 = new Colectivo("Colectivo1", new Ciudadano("usr1", "psswd", "12345678X"));
        Colectivo c2 = new Colectivo("Colectivo2", new Ciudadano("usr2", "psswd", "12345678Y"));
        assertEquals(0, app.generarInformeAfinidad(c1, c2));
    }

    @Test
    public void guardar() {
    }

    @Test
    public void cargar() {
        app.guardar("data.txt");
        assertEquals(app, app.cargar("data.txt"));
    }
}