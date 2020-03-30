package vecindApp.pruebas;

import jdk.jfr.StackTrace;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotificacionProyTest {
    NotificacionProy np;

    @Before
    public void setUp() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        np = new NotificacionProy(p);
    }

    @Test
    public void getSujeto() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
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
        assertEquals("Nuevo proyecto. titulo: Creado con exito.", np.descripcion());
    }
}