package vecindApp.pruebas;

import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Clase de prueba de la clase ProyectoSocial
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ProyectoSocialTest {
    ProyectoSocial ps;
    Ciudadano c;

    @Before
    public void setUp() {
        c = new Ciudadano("pepe", "a1", "123456Y");
        ps = new ProyectoSocial("titulo", "descripcion", 500.0, c, "grupo", true);
    }

    @Test
    public void getGrupoSocial() {
        assertEquals("grupo", ps.getGrupoSocial());
    }

    @Test
    public void setGrupoSocial() {
        ps.setGrupoSocial("grupo2");
        assertEquals("grupo2", ps.getGrupoSocial());
    }

    @Test
    public void isNacional() {
        assertEquals(true, ps.isNacional());
    }

    @Test
    public void setNacional() {
        ps.setNacional(false);
        assertEquals(false, ps.isNacional());
    }
}