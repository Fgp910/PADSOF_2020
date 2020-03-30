package vecindApp.pruebas;

import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Clase de prueba de la clase NotificacionProy
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class NotificacionProyTest {
    NotificacionProy np;
    Proyecto p;

    @Before
    public void setUp() {
        p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        np = new NotificacionProy(p);
    }

    @Test
    public void getSujeto() {
        assertEquals(p, np.getSujeto());
    }

    @Test
    public void setSujeto() {
        Proyecto p2 = new ProyectoSocial("titulo2", "proyecto2", 200.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        np.setSujeto(p2);
        assertEquals(p2, np.getSujeto());
    }

    @Test
    public void descripcion() {
        assertEquals("Proyecto. titulo: Creado con exito.", np.descripcion());
    }
}