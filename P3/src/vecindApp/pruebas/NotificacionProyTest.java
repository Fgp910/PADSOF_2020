package vecindApp.pruebas;

import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotificacionProyTest {
    NotificacionProy np;

    @Before
    void setUp() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        np = new NotificacionProy(p);
    }

    @Test
    void getSujeto() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        assertEquals(p, np.getSujeto());
    }

    @Test
    void setSujeto() {
        Proyecto p2 = new ProyectoSocial("titulo2", "proyecto2", 200.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        np.setSujeto(p2);
        assertEquals(p2, np.getSujeto());
    }
}