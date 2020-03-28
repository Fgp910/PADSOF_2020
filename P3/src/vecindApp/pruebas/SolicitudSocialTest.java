package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolicitudSocialTest {
    SolicitudSocial ss;

    @Before
    void setUp() {
        Ciudadano c = new Ciudadano("pepe", "a1", "123456Y");
        Proyecto ps = new ProyectoSocial("titulo", "descripcion", 500.0, c, "grupo", true);
        ss = new SolicitudSocial(ps);
    }

    @Test
    void getProjectKind() {
        assertEquals("Social", ss.getProjectKind());
    }

    @Test
    void getExtraData() {
        assertEquals("Grupo social: grupo\nNacional: true", ss.getExtraData());
    }
}