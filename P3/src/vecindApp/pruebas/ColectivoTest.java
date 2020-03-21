package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ColectivoTest {
    Colectivo c;

    @Before
    public void setUp() {
        c = new Colectivo("miColectivo", new Ciudadano("usr", "psswd", "12345678X"));
    }

    @Test
    public void getNombre() {
        assertEquals("miColectivo", c.getNombre());
    }

    @Test
    public void setNombre() {
        c.setNombre("nuevoColectivo");
        assertEquals("nuevoColectivo", c.getNombre());
    }

    @Test
    public void getElementos() {
        Set<ElementoColectivo> s = new Set<ElementoColectivo>;
        assertEquals(s, c.getElementos());
    }

    @Test
    public void setElementos() {
    }

    @Test
    public void getRepresentante() {
        Ciudadano ciu = new Ciudadano("usr", "psswd", "12345678X");
        assertEquals(ciu, c.getRepresentante());
    }

    @Test
    public void setRepresentante() {
        Ciudadano repre = new Ciudadano("representante", "psswd", "12345678X");
        c.setRepresentante(repre);
        assertEquals(repre, c.getRepresentante());
    }

    @Test
    public void getProyectos() {
    }

    @Test
    public void setProyectos() {
    }

    @Test
    public void addElemento() {
    }

    @Test
    public void removeElemento() {
    }

    @Test
    public void addProyecto() {
    }

    @Test
    public void removeProyecto() {
    }
}