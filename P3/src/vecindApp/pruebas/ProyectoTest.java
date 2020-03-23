package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class ProyectoTest {
    Proyecto p;

    @Before
    void setUp() {
        Ciudadano c = new Ciudadano("pepe", "c1", "12345678A");
        p = new Proyecto("miProyecto", 500, c);
    }

    @Test
    void getId() {
    }

    @Test
    void setId() {
    }

    @Test
    void getDescripcion() {
    }

    @Test
    void setDescripcion() {
    }

    @Test
    void getImporteSolicitado() {
    }

    @Test
    void setImporteSolicitado() {
    }

    @Test
    void getImporteConcedido() {
    }

    @Test
    void setImporteConcedido() {
    }

    @Test
    void getFechaCreacion() {
    }

    @Test
    void setFechaCreacion() {
    }

    @Test
    void getUltimoApoyo() {
    }

    @Test
    void setUltimoApoyo() {
    }

    @Test
    void getNApoyos() {
    }

    @Test
    void setNApoyos() {
    }

    @Test
    void getEstado() {
    }

    @Test
    void setEstado() {
    }

    @Test
    void isCaducado() {
    }

    @Test
    void setCaducado() {
    }

    @Test
    void getPropulsor() {
    }

    @Test
    void setPropulsor() {
    }

    @Test
    void getPromotores() {
    }

    @Test
    void setPromotores() {
    }

    @Test
    void getSuscriptores() {
    }

    @Test
    void setSuscriptores() {
    }

    @Test
    void getNextId() {
    }

    @Test
    void setNextId() {
    }

    @Test
    void enviarFinanciacion() {
    }

    @Test
    void caducar() {
    }

    @Test
    void aceptar() {
    }

    @Test
    void rechazar() {
    }

    @Test
    void financiar() {
    }

    @Test
    void denegarFinanciacion() {
    }

    @Test
    void recibirApoyo() {
    }

    @Test
    void testRecibirApoyo() {
        Ciudadano votante = new Ciudadano("juan", "a2", "123456J");
        recibirApoyo(votante);
        assert(p.getPromotores().contains(votante) && p.getNApoyos() == 2)
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
    }
}