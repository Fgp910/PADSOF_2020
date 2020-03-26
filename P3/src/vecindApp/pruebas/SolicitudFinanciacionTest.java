package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolicitudFinanciacionTest {
    SolicitudFinanciacion sf;

    @Before
    void setUp() {
        Ciudadano c = new Ciudadano("pepe", "c1", "12345678A");
        p = new Proyecto("titulo", "miProyecto", 500, c);
        sf = new SolicitudFinanciacion(sf);
    }

    @Test
    void getProject() {
        assertEquals(p, sf.getProject());
    }

    @Test
    void getProjectTitle() {
        assertEquals("titulo", sf.getProjectTitle());
    }

    @Test
    void getProjectDescription() {
        assertEquals("miProyecto", sf.getProjectDescription());
    }

    @Test
    void getRequestedAmount() {
        assertEquals(500, sf.getRequestedAmount());
    }
}