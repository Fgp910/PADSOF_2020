package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.proyecto.*;

/**
 * Clase de prueba de la clase Colectivo
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ColectivoTest {
    Colectivo c;
    Ciudadano repre;

    @Before
    public void setUp() {
        repre = new Ciudadano("usr", "psswd", "12345678X");
        c = new Colectivo("miColectivo", repre);
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
        assertTrue(c.getElementos().contains(repre));
    }

    @Test
    public void getRepresentante() {
        assertEquals(repre, c.getRepresentante());
    }

    @Test
    public void setRepresentante() {
        Ciudadano repre = new Ciudadano("representante", "psswd", "12345678X");
        c.setRepresentante(repre);
        assertEquals(repre, c.getRepresentante());
    }

    @Test
    public void getProyectos() {
        assertTrue(c.getProyectos().isEmpty());
    }

    @Test
    public void getProyectosApoyados() {
        Set<Proyecto> pa = new HashSet<>();
        assertEquals(pa, c.getProyectosApoyados());
    }

    @Test
    public void getPadre() {
        assertNull(c.getPadre());
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

    @Test
    public void generarInformeAfinidad() {
        Colectivo c1 = new Colectivo("Colectivo1", new Ciudadano("usr1", "psswd", "12345678X"));
        Colectivo c2 = new Colectivo("Colectivo2", new Ciudadano("usr2", "psswd", "12345678Y"));
        assertTrue(0 == c1.generarInformeAfinidad(c2));
    }
}