package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.notificacion.*;

import static org.junit.Assert.assertEquals;

/**
 * Clase de prueba de la clase NotificacionReg
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class NotificacionRegTest {
    NotificacionReg nr;
    Ciudadano c;

    /**
     * Crea una notificacion de registro con la que realizar las pruebas
     */
    @Before
    public void setUp() {
        c = new Ciudadano("pepe", "c1", "12345678A");
        nr = new NotificacionReg(c);
    }

    /**
     * Comprueba que el sujeto de la notificacion es el asignado al crearla
     */
    @Test
    public void getSujeto() {
        assertEquals(c, nr.getSujeto());
    }

    /**
     * Comprueba que el sujeto es el asignado
     */
    @Test
    public void setSujeto() {
        Ciudadano c2 = new Ciudadano("juan", "c2", "12345678B");
        nr.setSujeto(c2);
        assertEquals(c2, nr.getSujeto());
    }

    /**
     * Comprueba que la descripcion de la notificacion es la correcta
     */
    @Test
    public void descripcion() {
        assertEquals("Nuevo registro. pepe (NIF: 12345678A)", nr.descripcion());
    }
}