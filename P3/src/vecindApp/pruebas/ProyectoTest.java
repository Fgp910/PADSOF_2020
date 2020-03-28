package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProyectoTest {
    Proyecto p;

    @Before
    void setUp() {
        Ciudadano c = new Ciudadano("pepe", "c1", "12345678A");
        p = new ProyectoSocial("titulo", "descripcion", 500.0, c, "grupo", true);
    }

    @Test
    void enviarFinanciacion() {
        assertEquals(EstadoProyecto.ENVIADO, p.getEstado());
    }

    @Test
    void consultarFinanciacion() {
        assertEquals(p.getImporteConcedido(), proxy.getAmountGranted(p.getIdEnvio()));
    }

    @Test
    void testRecibirApoyo() {
        Ciudadano votante = new Ciudadano("juan", "a2", "123456J");
        recibirApoyo(votante);
        assert(p.getPromotores().contains(votante) && p.getNApoyos() == 2);
    }

    @Test
    void testRecibirApoyo1() {
        int actual = p.getNApoyos();
        Ciudadano votante1 = new Ciudadano("juan", "a2", "123456J");
        Ciudadano votante2 = new Ciudadano("juanito", "b3", "123456K");
        Colectivo c = new Colectivo("miColectivo", votante1);
        c.addElemento(votante2);
        recibirApoyo(c);
        assert(p.getPromotores().contains(votante1) && p.getPromotores().contains(votante2) && p.getNApoyos() == actual + 2);
    }

    @Test
    void notificarCambio() {
        NotificacionProy np = new NotificacionProy(p);
        p.notificarCambio();
        assert(p.getPropulsor().getPendientes().contains(np));
    }

    @Test
    void generarInformePopularidad() {
        assertEquals(1, p.generarInformePopularidad());
    }
}