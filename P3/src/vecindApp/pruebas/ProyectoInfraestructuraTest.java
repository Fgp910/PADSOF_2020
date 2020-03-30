package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.Distrito;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ProyectoInfraestructuraTest {
    ProyectoInfraestructura pi;

    @Before
    public void setUp() {
        Ciudadano c = new Ciudadano("pepe", "a1", "123456U");
        Collection<Distrito> col = new Collection<Distrito>();
        pi = new ProyectoInfraestructura("titulo", "descripcion", 500.0, c, "imagen", col);
    }

    @Test
    public void getImagen() {
        assertEquals("imagen", pi.getImagen());
    }

    @Test
    public void setImagen() {
        pi.setImagen("imagen2");
        assertEquals("imagen2", pi.getImagen());
    }

    @Test
    public void getAfectados() {
        List afectados = new ArrayList<Distrito>();
        assertEquals(afectados, pi.getAfectados());
    }

    @Test
    public void setAfectados() {
        List afectados = new ArrayList<Distrito>();
        Distrito d = Distrito.Arganzuela;
        afectados.add(d);
        assertEquals(afectados, pi.getAfectados());
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

    @Test
    public void crearSolicitud() {
        SolicitudInfraestructura s = new SolicitudInfraestructura(pi);
        assertEquals(pi.crearSolicitud(), s);
    }
}