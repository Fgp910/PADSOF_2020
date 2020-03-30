package vecindApp.pruebas;

import es.uam.eps.sadp.grants.GrantRequest;
import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.proyecto.*;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Clase de prueba de la clase SolicitudInfraestructura
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class SolicitudInfraestructuraTest {
    SolicitudInfraestructura si;

    @Before
    public void setUp() {
        Ciudadano c = new Ciudadano("pepe", "a1", "123456U");
        Collection<Distrito> col = new ArrayList<>();
        col.add(Distrito.Carabanchel);
        Proyecto pi = new ProyectoInfraestructura("titulo", "descripcion", 500.0, c, "imagen", col);
        si = new SolicitudInfraestructura(pi);
    }

    @Test
    public void getProjectKind() {
        assertEquals(GrantRequest.ProjectKind.Infrastructure, si.getProjectKind());
    }

    @Test
    public void getExtraData() {
        assertEquals("Imagen: imagen\nDistritos afectados: [Carabanchel]", si.getExtraData());
    }
}