package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.proyecto.*;

/**
 * Clase de prueba de la clase Ciudadano
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class CiudadanoTest {
    Ciudadano c;

    /**
     * Crea un ciudadano con el que realizar las pruebas
     */
    @Before
    public void setUp() {
        c = new Ciudadano("pepe", "c1", "12345678A");
    }

    /**
     * Comprueba que el proyecto añadido está en el conjunto
     */
    @Test
    public void addProyecto() {
        Proyecto p = new ProyectoSocial("prueba", "descripcion prueba", 100, c, "a", false);
        c.addProyecto(p);
        assertTrue(c.getProyectos().contains(p));
    }

    /**
     * Comprueba que el proyecto eliminado ya no está en el conjunto
     */
    @Test
    public void removeProyecto() {
        Proyecto p = new ProyectoSocial("prueba", "descripcion prueba", 100, c, "a", false);
        c.addProyecto(p);
        c.removeProyecto(p);
        assertFalse(c.getProyectos().contains(p));
    }

    /**
     * Comprueba que el colectivo añadido está en el conjunto
     */
    @Test
    public void addColectivoRepresentado() {
        Colectivo col = new Colectivo("prueba", c);
        c.addColectivoRepresentado(col);
        assertTrue(c.getColectivosRepresentados().contains(col));
    }

    /**
     * Comprueba que el colectivo eliminado ya no está en el conjunto
     */
    @Test
    public void removeColectivoRepresentado() {
        Colectivo col = new Colectivo("prueba", c);
        c.removeColectivoRepresentado(col);
        assertFalse(c.getColectivosRepresentados().contains(col));
    }

    /**
     * Comprueba que se ha bloqueado al ciudadano
     */
    @Test
    public void bloquear() {
        c.bloquear();
        assertTrue(c.isBloqueado());
    }

    /**
     * Comprueba que se ha desbloqueado al ciudadano
     */
    @Test
    public void desbloquear() {
        c.setBloqueado(true);
        c.desbloquear();
        assertFalse(c.isBloqueado());
    }

    /**
     * Comprueba que el ciudadano está admitido
     */
    @Test
    public void admitir() {
        c.admitir();
        assertTrue(c.isAdmitido());
    }
}
