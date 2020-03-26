package vecindApp.pruebas;

import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotificacionProyTest {
    NotificacionProy np;

    @Before
    void setUp() {
        Ciudadano c = new Ciudadano("pepe", "c1", "12345678A");
        Proyecto p1 = new Proyecto(titulo, "proyecto1", 200, c);
        np = new NotificacionProy(p);
    }

    @Test
    void getSujeto() {
        assertEquals(p, np.getSujeto());
    }

    @Test
    void setSujeto() {
        Ciudadano c = new Ciudadano("pepe", "c1", "12345678A");
        Proyecto p2 = new Proyecto(titulo, "proyecto2", 500, c);
        np.setSujeto(p);
        assertEquals(p, np.getSujeto());
    }
}