package vecindApp.pruebas;

import es.uam.eps.sadp.grants.GrantRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.proyecto.*;

import static org.junit.Assert.assertEquals;

/**
 * Clase de prueba de la clase SolicitudSocial
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class SolicitudSocialTest {
    SolicitudSocial ss;

    @Before
    public void setUp() {
        Ciudadano c = new Ciudadano("pepe", "a1", "123456Y");
        Proyecto ps = new ProyectoSocial("titulo", "descripcion", 500.0, c, "grupo", true);
        ss = new SolicitudSocial(ps);
    }

    @Test
    public void getProjectKind() {
        assertEquals(GrantRequest.ProjectKind.Social, ss.getProjectKind());
    }

    @Test
    public void getExtraData() {
        assertEquals("Grupo social: grupo\nNacional: true", ss.getExtraData());
    }
}