package vecindApp.pruebas;

import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Clase de prueba de la clase SolicitudFinanciacion
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class SolicitudFinanciacionTest {
    SolicitudFinanciacion sf;
    Proyecto p;

    @Before
    public void setUp() {
        Ciudadano c = new Ciudadano("pepe", "c1", "12345678A");
        p = new ProyectoSocial("titulo", "descripcion", 500.0, c, "grupo", true);
        sf = new SolicitudSocial(p);
    }

    @Test
    public void getProject() {
        assertEquals(p, sf.getProject());
    }

    @Test
    public void getProjectTitle() {
        assertEquals("titulo", sf.getProjectTitle());
    }

    @Test
    public void getProjectDescription() {
        assertEquals("descripcion", sf.getProjectDescription());
    }

    @Test
    public void getRequestedAmount() {
        assertTrue(500.0 == sf.getRequestedAmount());
    }
}