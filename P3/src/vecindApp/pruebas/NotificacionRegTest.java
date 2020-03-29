package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotificacionRegTest {
    NotificacionReg nr;

    @Before
    void setUp() {
        Ciudadano c = new Ciudadano("pepe", "c1", "12345678A");
        nr = new NotificacionReg(c);
    }

    @Test
    void getSujeto() {
        Ciudadano c = new Ciudadano("pepe", "c1", "12345678A");
        assertEquals(c, nr.getSujeto()
    }

    @Test
    void setSujeto() {
        Ciudadano c2 = new Ciudadano("juan", "c2", "12345678B");
        nr.setSujeto(c2);
        assertEquals(c2, nr.getSujeto());
    }

    @Test
    void descripcion() {
        assertEquals("Nuevo registro. pepe (NIF: 12345678A).", nr.descripcion());
    }
}