package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.Ciudadano;
import vecindApp.clases.Colectivo;

import static org.junit.Assert.*;

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
    }

    @Test
    public void getElementos() {
    }

    @Test
    public void setElementos() {
    }

    @Test
    public void getRepresentante() {
    }

    @Test
    public void setRepresentante() {
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