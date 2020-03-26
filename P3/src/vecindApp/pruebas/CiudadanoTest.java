package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CiudadanoTest {
    Ciudadano c;

    @Before
    public void setUp() {
        c = new Ciudadano("pepe", "c1", "12345678A");
    }

    @Test
    public void addProyecto() {
        Proyecto p = new ProyectoSocial("prueba", "descripcion prueba", 100, c, "a", false);
        c.addProyecto(p);
        assertTrue(c.getProyectos().contains(p));
    }

    @Test
    public void removeProyecto() {
        Proyecto p = new ProyectoSocial("prueba", "descripcion prueba", 100, c, "a", false);
        ArrayList<Proyecto> proys = new ArrayList<>();
        proys.add(p);
        c.setProyectos(proys);
        c.remveProyecto(p);
        assertFalse(c.getProyectos().contains(p));
    }

    @Test
    public void addColectivoRepresentado() {
        Colectivo col = new Colectivo("prueba", c);
        c.addColectivoRepresentado(col);
        assertTrue(c.getColectivosRepresentados().contains(col));
    }

    @Test
    public void removeColectivoRepresentado() {
        Colectivo col = new Colectivo("prueba", c);
        ArrayList<Colectivo> cols = new ArrayList<>();
        cols.add(col);
        c.setColectivosRepresentados(cols);
        c.removeColectivoRepresentado(col);
        assertFalse(c.getColectivosRepresentados().contains(col));
    }

    @Test
    public void bloquear() {
        c.bloquear();
        assertEquals(true, c.isBloqueado());
    }

    @Test
    public void desbloquear() {
        c.setBloqueado(true);
        c.desbloquear();
        assertEquals(false, c.isBloqueado());
    }

    @Test
    public void admitir() {
        c.admitir();
        assertEquals(true, c.isAdmitido());
    }
}
