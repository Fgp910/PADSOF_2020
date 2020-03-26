package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolicitudFinanciacionTest {
    SolicitudFinanciacion sf;

    @Before
    void setUp() {
        Ciudadano c = new Ciudadano("pepe", "c1", "12345678A");
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, c, "grupo", true);
        sf = new SolicitudSocial(p);
    }

    @Test
    void getProject() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("pepe", "c1", "12345678A"), "grupo", true);
        assertEquals(p, sf.getProject());
    }

    @Test
    void getProjectTitle() {
        assertEquals("titulo", sf.getProjectTitle());
    }

    @Test
    void getProjectDescription() {
        assertEquals("descripcion", sf.getProjectDescription());
    }

    @Test
    void getRequestedAmount() {
        assertEquals(500.0, sf.getRequestedAmount());
    }
}