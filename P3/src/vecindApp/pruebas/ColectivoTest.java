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

    /**
     * Crea un colectivo con el que realizar las pruebas
     */
    @Before
    public void setUp() {
        repre = new Ciudadano("usr", "psswd", "12345678X");
        c = new Colectivo("miColectivo", repre);
    }

    /**
     * Comprueba que el nombre del colectivo es el asignado al crearlo
     */
    @Test
    public void getNombre() {
        assertEquals("miColectivo", c.getNombre());
    }

    /**
     * Comprueba que el nombre del colectivo es el asignado
     */
    @Test
    public void setNombre() {
        c.setNombre("nuevoColectivo");
        assertEquals("nuevoColectivo", c.getNombre());
    }

    /**
     * Comprueba que el representante está en la lista de elementos
     */
    @Test
    public void getElementos() {
        assertTrue(c.getElementos().contains(repre));
    }

    /**
     * Comprueba que el representante del colectivo es el asignado al crearlo
     */
    @Test
    public void getRepresentante() {
        assertEquals(repre, c.getRepresentante());
    }

    /**
     * Comprueba que el representante es el asignado
     */
    @Test
    public void setRepresentante() {
        Ciudadano repre = new Ciudadano("representante", "psswd", "12345678X");
        c.setRepresentante(repre);
        assertEquals(repre, c.getRepresentante());
    }

    /**
     * Comprueba que la lista de proyectos está vacía
     */
    @Test
    public void getProyectos() {
        assertTrue(c.getProyectos().isEmpty());
    }

    /**
     * Comprueba que la lista de proyectos apoyados está vacía
     */
    @Test
    public void getProyectosApoyados() {
        Set<Proyecto> pa = new HashSet<>();
        assertEquals(pa, c.getProyectosApoyados());
    }

    /**
     * Comprueba que el colectivo no tiene padre (devuelve null)
     */
    @Test
    public void getPadre() {
        assertNull(c.getPadre());
    }

    /**
     * Comprueba que el colectivo padre es el asignado
     */
    @Test
    public void setPadre() {
        Colectivo p = new Colectivo("ColectivoPadre", new Ciudadano("usr", "psswd", "12345678X"));
        c.setPadre(p);
        assertEquals(p, c.getPadre());
    }

    /**
     * Comprueba que el elemento añadido está en el conjunto
     */
    @Test
    public void addElemento() {
        Ciudadano ciudadano = new Ciudadano("ciudadano", "psswd", "12345678X");
        c.addElemento(ciudadano);
        assertTrue(c.getElementos().contains(ciudadano));
    }

    /**
     * Comprueba que el elemento eliminado ya no está en el conjunto
     */
    @Test
    public void removeElemento() {
        Ciudadano ciudadano = new Ciudadano("ciudadano", "psswd", "12345678X");
        c.addElemento(ciudadano);
        c.removeElemento(ciudadano);
        assertFalse(c.getElementos().contains(ciudadano));
    }

    /**
     * Comprueba que el proyecto añadido está en el conjunto
     */
    @Test
    public void addProyecto() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        c.addProyecto(p);
        assertTrue(c.getProyectos().contains(p));
    }

    /**
     * Comprueba que el proyecto eliminado ya no está en el conjunto
     */
    @Test
    public void removeProyecto() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        c.addProyecto(p);
        c.removeProyecto(p);
        assertFalse(c.getProyectos().contains(p));
    }

    /**
     * Comprueba que el proyecto apoyado añadido está en el conjunto
     */
    @Test
    public void addProyectoApoyado() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        c.addProyectoApoyado(p);
        assertTrue(c.getProyectosApoyados().contains(p));
    }

    /**
     * Comprueba que el proyecto apoyado eliminado ya no está en el conjunto
     */
    @Test
    public void removeProyectoApoyado() {
        Proyecto p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        c.addProyectoApoyado(p);
        c.removeProyectoApoyado(p);
        assertFalse(c.getProyectosApoyados().contains(p));
    }

    /**
     * Comprueba que el informe de afinidad generado es correcto
     */
    @Test
    public void generarInformeAfinidad() {
        Colectivo c1 = new Colectivo("Colectivo1", new Ciudadano("usr1", "psswd", "12345678X"));
        Colectivo c2 = new Colectivo("Colectivo2", new Ciudadano("usr2", "psswd", "12345678Y"));
        assertTrue(0 == c1.generarInformeAfinidad(c2));
    }
}