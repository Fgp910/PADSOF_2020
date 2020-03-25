package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class AplicacionTest {
    Aplicacion app;

    @Before
    void setUp() {
        Administrador ad = new Administrador("admin", "psswd");
        app = new Aplicacion(ad);
    }

    @Test
    void getAdmin() {
        assertEquals(ad, sf.getAdmin());
    }

    @Test
    void setAdmin() {
        Administrador ad2 = new Administrador("admin2", "psswd");
        assertEquals(ad2, sf.getAdmin());
    }

    @Test
    void getElemCol() {
        List<ElementoColectivo> liste = new ArrayList<>();
        assertEquals(liste, sf.getelemCol());
    }

    @Test
    void setElemCol() {
        List<ElementoColectivo> newliste = new ArrayList<>();
        sf.setElemCol(newliste);
        assertEquals(newliste, sf.getelemCol());
    }

    @Test
    void getProyectos() {
        List<Proyecto> listp = new ArrayList<>();
        assertEquals(listp, sf.getProyectos());
    }

    @Test
    void setProyectos() {
        List<Proyecto> newlistp = new ArrayList<>();
        sf.setProyectos(newlistp);
        assertEquals(newlistp, sf.getProyectos());
    }

    @Test
    void getUsuarioAcutal() {
        Usuario usr;
        assertEquals(usr, sf.getUsuarioActual());
    }

    @Test
    void setUsuarioAcutal() {
        Usuario usr = new Usuario("pepe", "a1");
        sf.setUsuarioActual(usr);
        assertEquals(usr, sf.getUsuarioActual());
    }

    @Test
    void addElemCol() {
        ElementoColectivo c = new Ciudadano("pepe", "c1", "12345678A");
        assertEquals(sf.getElemCol.add(c), sf.addElemCol(c));
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
    }

    @Test
    void findCiudadano() {
    }

    @Test
    void findProyecto() {
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