package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.excepciones.ImageNotFoundException;
import vecindApp.clases.proyecto.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Clase de prueba de la clase ProyectoInfraestructura
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ProyectoInfraestructuraTest {
    ProyectoInfraestructura pi;
    Ciudadano c;
    Collection<Distrito> afectados;

    @Before
    public void setUp() throws ImageNotFoundException {
        c = new Ciudadano("pepe", "a1", "123456U");
        afectados = new ArrayList<>();
        pi = new ProyectoInfraestructura("titulo",
                "descripcion",
                500.0,
                c,
                "imagen.jpg",
                afectados);
    }

    @Test
    public void getImagen() {
        assertEquals("imagen.jpg", pi.getImagen());
    }

    @Test
    public void setImagen() throws ImageNotFoundException {
        pi.setImagen("imagen2.jpg");
        assertEquals("imagen2.jpg", pi.getImagen());
    }

    @Test
    public void getAfectados() {
        assertEquals(afectados, pi.getAfectados());
    }

    @Test
    public void setAfectados() {
        List<Distrito> afectados2 = new ArrayList<>();
        afectados2.add(Distrito.Arganzuela);
        pi.setAfectados(afectados2);
        assertEquals(afectados2, pi.getAfectados());
    }

    @Test
    public void addAfectados() {
        Distrito d = Distrito.Arganzuela;
        pi.addAfectados(d);
        assertTrue(pi.getAfectados().contains(d));
    }

    @Test
    public void removeAfectados() {
        Distrito d = Distrito.Arganzuela;
        pi.addAfectados(d);
        pi.removeAfectados(d);
        assertFalse(pi.getAfectados().contains(d));
    }
}