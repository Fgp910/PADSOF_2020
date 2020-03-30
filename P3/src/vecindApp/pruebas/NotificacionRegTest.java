package vecindApp.pruebas;

import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Clase de prueba de la clase NotificacionReg
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class NotificacionRegTest {
    NotificacionReg nr;
    Ciudadano c;

    @Before
    public void setUp() {
        c = new Ciudadano("pepe", "c1", "12345678A");
        nr = new NotificacionReg(c);
    }

    @Test
    public void getSujeto() {
        assertEquals(c, nr.getSujeto());
    }

    @Test
    public void setSujeto() {
        Ciudadano c2 = new Ciudadano("juan", "c2", "12345678B");
        nr.setSujeto(c2);
        assertEquals(c2, nr.getSujeto());
    }

    @Test
    public void descripcion() {
        assertEquals("Nuevo registro. pepe (NIF: 12345678A).", nr.descripcion());
    }
}