package vecindApp.puebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.Distrito;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ProyectoSocialTest {
    ProyectoSocial ps;

    @Before
    void setUp() {
        Ciudadano c = new Ciudadano("pepe", "a1", "123456Y")
        ps = new ProyectoSocial("titulo", "descripcion", 500.0, c, "grupo", true);
    }

    @Test
    void getGrupoSocial() {
        assertEquals("grupo", ps.getGrupoSocial);
    }

    @Test
    void setGrupoSocial() {
        ps.setGrupoSocial("grupo2");
        assertEquals("grupo2", ps.getGrupoSocial());
    }

    @Test
    void isNacional() {
        assertEquals(true, ps.isNacioanl());
    }

    @Test
    void setNacional() {
        ps.setNacional(false);
        assertEquals(false, ps.isNacioanl());
    }

    @Test
    void crearSolicitud() {
        SolicitudSocial s = new SolicitudSocial(ps);
        assertEquals(crearSolicitud(), s);
    }
}