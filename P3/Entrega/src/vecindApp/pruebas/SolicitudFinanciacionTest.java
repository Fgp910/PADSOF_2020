package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.proyecto.*;

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

    /**
     * Crea una solicitud de financiacion para realizar las pruebas
     */
    @Before
    public void setUp() {
        Ciudadano c = new Ciudadano("pepe", "c1", "12345678A");
        p = new ProyectoSocial("titulo", "descripcion", 500.0, c, "grupo", true);
        sf = new SolicitudFinanciacion(p);
    }

    /**
     * Comprueba que el proyecto es el asignado al crear la solicitud
     */
    @Test
    public void getProject() {
        assertEquals(p, sf.getProject());
    }

    /**
     * Comprueba que el titulo del proyecto es el asignado al crear la solicitud
     */
    @Test
    public void getProjectTitle() {
        assertEquals("titulo", sf.getProjectTitle());
    }

    /**
     * Comprueba que la descripcion del proyecto es la asignada al crear la solicitud
     */
    @Test
    public void getProjectDescription() {
        assertEquals("descripcion", sf.getProjectDescription());
    }

    /**
     * Comprueba que el importe solicitado es el asignado al crear la solicitud
     */
    @Test
    public void getRequestedAmount() {
        assertEquals(500.0, sf.getRequestedAmount(), 0.0);
    }
}