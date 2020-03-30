package vecindApp.pruebas;

import jdk.jfr.StackTrace;
import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        Set<ElementoColectivo> s = new HashSet<>();
        assertEquals(s, c.getElementos());
    }

    @Test
    public void setElementos() {
        Set<ElementoColectivo> s = new HashSet<>();
        s.add(new Colectivo("colectivo2", new Ciudadano("usr", "psswd", "12345678X")));
        c.setElementos(s);
        assertEquals(s, c.getElementos());
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
        List<Proyecto> p = new ArrayList<>();
        assertEquals(p, c.getProyectos());
    }

    @Test
    public void setProyectos() {
        List<Proyecto> p = new ArrayList<>();
        p.add(new ProyectoSocial("prueba", "descripcion prueba", 100, c, "a", false));
        c.setProyectos(p);
        assertEquals(p, c.getProyectos());
    }

    @Test
    public void getProyectosApoyados() {
        Set<Proyecto> pa = new HashSet<>();
        assertEquals(pa, c.getProyectosApoyados());
    }

    @Test
    public void setProyectosApoyados() {
        Set<Proyecto> pa = new HashSet<>();
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        pa.add(p);
        c.setProyectosApoyados(pa);
        assertEquals(pa, c.getProyectosApoyados());
    }

    @Test
    public void getPadre() {
        assertEquals(null, c.getPadre());
    }

    @Test
    public void setPadre() {
        Colectivo p = new Colectivo("ColectivoPadre", new Ciudadano("usr", "psswd", "12345678X"));
        c.setPadre(p);
        assertEquals(p, c.getPadre());
    }

    @Test
    public void addElemento() {
        Ciudadano ciudadano = new Ciudadano("ciudadano", "psswd", "12345678X");
        c.addElemento(ciudadano);
        assertTrue(c.getElementos().contains(ciudadano));
    }

    @Test
    public void removeElemento() {
        Ciudadano ciudadano = new Ciudadano("ciudadano", "psswd", "12345678X");
        c.addElemento(ciudadano);
        c.removeElemento(ciudadano);
        assertFalse(c.getElementos().contains(ciudadano));
    }

    @Test
    public void addProyecto() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        c.addProyecto(p);
        assertTrue(c.getProyectos().contains(p));
    }

    @Test
    public void removeProyecto() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        c.addProyecto(p);
        c.removeProyecto(p);
        assertFalse(c.getProyectos().contains(p));
    }

    @Test
    public void addProyectoApoyado() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        c.addProyectoApoyado(p);
        assertTrue(c.getProyectosApoyados().contains(p));
    }

    @Test
    public void removeProyectoApoyado() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        c.addProyectoApoyado(p);
        c.removeProyectoApoyado(p);
        assertFalse(c.getProyectosApoyados().contains(p));
    }
}