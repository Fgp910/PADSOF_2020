package vecindApp.puebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ProyectoSocialTest {
    ProyectoSocial ps;

    @Before
    public void setUp() {
        Ciudadano c = new Ciudadano("pepe", "a1", "123456Y");
        ps = new ProyectoSocial("titulo", "descripcion", 500.0, c, "grupo", true);
    }

    @Test
    public void getGrupoSocial() {
        assertEquals("grupo", ps.getGrupoSocial);
    }

    @Test
    public void setGrupoSocial() {
        ps.setGrupoSocial("grupo2");
        assertEquals("grupo2", ps.getGrupoSocial());
    }

    @Test
    public void isNacional() {
        assertEquals(true, ps.isNacioanl());
    }

    @Test
    public void setNacional() {
        ps.setNacional(false);
        assertEquals(false, ps.isNacioanl());
    }

    @Test
    public void crearSolicitud() {
        SolicitudSocial s = new SolicitudSocial(ps);
        assertEquals(ps.crearSolicitud(), s);
    }
}