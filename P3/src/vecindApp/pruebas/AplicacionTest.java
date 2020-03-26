package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AplicacionTest {
    @Before
    void setUp() {
        Administrador ad = new Administrador("admin", "psswd");
        Aplicacion app = new Aplicacion(ad);
    }

    @Test
    void getAdmin() {
        assertEquals(ad, sf.getAdmin());
    }

    @Test
    void setAdmin() {
        Administrador ad2 = new Administrador("admin2", "psswd");
        assertEquals(ad2, app.getAdmin());
    }

    @Test
    void getElemCol() {
        List<ElementoColectivo> liste = new ArrayList<>();
        assertEquals(liste, app.getelemCol());
    }

    @Test
    void setElemCol() {
        List<ElementoColectivo> newliste = new ArrayList<>();
        sf.setElemCol(newliste);
        assertEquals(newliste, app.getelemCol());
    }

    @Test
    void getProyectos() {
        List<Proyecto> listp = new ArrayList<>();
        assertEquals(listp, app.getProyectos());
    }

    @Test
    void setProyectos() {
        List<Proyecto> newlistp = new ArrayList<>();
        sf.setProyectos(newlistp);
        assertEquals(newlistp, app.getProyectos());
    }

    @Test
    void getUsuarioAcutal() {
        Usuario usr;
        assertEquals(usr, app.getUsuarioActual());
    }

    @Test
    void setUsuarioAcutal() {
        Usuario usr = new Usuario("pepe", "a1");
        sf.setUsuarioActual(usr);
        assertEquals(usr, app.getUsuarioActual());
    }

    @Test
    void addElemCol() {
    }

    @Test
    void removeElemCol() {
    }

    @Test
    void addProyecto() {
    }

    @Test
    void removeProyecto() {
    }

    @Test
    void findColectivo() {
        Colectivo c = new Colectivo("miColectivo", new Ciudadano("usr", "psswd", "12345678X"));
        app.addElemCol(c);
        assertEquals(c, app.findColectivo("miColectivo"));
    }

    @Test
    void findCiudadano() {
        Ciudadano c = new Ciudadano("usr", "psswd", "12345678X");
        app.addElemCol(c);
        assertEquals(c, app.findCiudadano("usr"));
    }

    @Test
    void findProyecto() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("usr", "psswd", "12345678X"));
        p.setId(1);
        app.addProyecto(p);
        assertEquals(p, app.findProyecto(1));
    }

    @Test
    void notificarRegistro() {
    }

    @Test
    void notificarNuevoProyecto() {
    }

    @Test
    void generarInformeAfinidad() {
    }

    @Test
    void guardar() {
    }

    @Test
    void cargar() {
    }
}