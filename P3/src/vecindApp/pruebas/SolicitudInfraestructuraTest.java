package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class SolicitudInfraestructuraTest {
    SolicitudInfraestructura si;

    @Before
    public void setUp() {
        Ciudadano c = new Ciudadano("pepe", "a1", "123456U");
        Collection<Distrito> col = new Collection<Distrito>();
        Proyecto pi = new ProyectoInfraestructura("titulo", "descripcion", 500.0, c, "imagen", col);
        si = new SolicitudInfraestructura(pi);
    }

    @Test
    public void getProjectKind() {
        assertEquals("Infraestructure", si.getProjectKind());
    }

    @Test
    public void getExtraData() {
        assertEquals("Imagen: imagen\nDistritos afectados: ", si.getExtraData());
    }
}