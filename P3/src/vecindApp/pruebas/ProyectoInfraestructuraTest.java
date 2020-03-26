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
    void setUp() {
        Ciudadano c = new Ciudadano("pepe", "a1", "123456U");
        Collection<Distrito> col = new Collection<Distrito>;
        pi = new ProyectoInfraestructura("titulo", "descripcion", 500.0, c, "imagen", col);
    }

    @Test
    void getImagen() {
        assertEquals("imagen", pi.getImagen());
    }

    @Test
    void setImagen() {
        pi.setImagen("imagen2");
        assertEquals("imagen2", pi.getImagen());
    }

    @Test
    void getAfectados() {
        List afectados = new ArrayList<Distrito>();
        assertEquals(afectados, pi.getAfectados());
    }

    @Test
    void setAfectados() {
        List afectados = new ArrayList<Distrito>();
        Distrito d = Distrito.Arganzuela;
        afectados.add(d);
        assertEquals(afectados, pi.getAfectados());
    }

    @Test
    void addAfectados() {
    }

    @Test
    void removeAfectados() {
    }

    @Test
    void crearSolicitud() {
        SolicitudInfraestructura s = new SolicitudInfraestructura(pi);
        assertEquals(crearSolicitud(), s);
    }
}