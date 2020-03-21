package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CiudadanoTest {
    Ciudadano c;

    @Before
    public void setUp() {
        c = new Ciudadano("pepe", "c1", "12345678A");
    }

    @Test
    public void getNif() {
        assertEquals("12345678A", c.getNif());
    }

    @Test
    public void setNif() {
        String nif = new String("987654321B");
        c.setNif(nif);

        assertEquals(nif, c.getNif());
    }

    @Test
    public void isAdmitido() {
        assertEquals(false, c.isAdmitido());
    }

    @Test
    public void setAdmitido() {
        c.setAdmitido(true);
        assertEquals(true, c.isAdmitido());
    }

    @Test
    public void isBloqueado() {
        assertEquals(false, c.isBloqueado());
    }

    @Test
    public void setBloqueado() {
        c.setBloqueado(true);
        assertEquals(true, c.isBloqueado());
    }

    @Test
    public void getProyectos() {
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>;
        proyectos.add(new ProyectoInfraestructura("P1", 100, c, null));
        proyectos.add(new ProyectoInfraestructura("P1", 211, c,"Img.jpg"));
        proyectos.add(new ProyectoInfraestructura("P3", 300, c, "proy.png"));

        c.setProyectos(proyectos);
        Assert.assertArrayEquals(proyectos, c.getProyectos());
    }

    @Test
    public void setProyectos() {
            }

    @Test
    public void getColectivosRepresentados() {
            }

    @Test
    public void setColectivosRepresentados() {
            }

    @Test
    public void desbloquear() {
            }

    @Test
    public void admitir() {
            }
}
