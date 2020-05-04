package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.notificacion.*;
import vecindApp.clases.proyecto.*;

import static org.junit.Assert.assertEquals;

/**
 * Clase de prueba de la clase NotificacionProy
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class NotificacionProyTest {
    NotificacionProy np;
    Proyecto p;

    /**
     * Crea una notificacion de proyecto con la que realizar las pruebas
     */
    @Before
    public void setUp() {
        p = new ProyectoSocial("titulo", "descripcion", 500.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        np = new NotificacionProy(p);
    }

    /**
     * Comprueba que el sujeto de la notificacion es el asignado al crearla
     */
    @Test
    public void getSujeto() {
        assertEquals(p, np.getSujeto());
    }

    /**
     * Comprueba que el sujeto de la notificacion es el asignado
     */
    @Test
    public void setSujeto() {
        Proyecto p2 = new ProyectoSocial("titulo2", "proyecto2", 200.0, new Ciudadano("ciudadano", "psswd", "12345678X"), "grupo", true);
        np.setSujeto(p2);
        assertEquals(p2, np.getSujeto());
    }

    /**
     * Comprueba que la descripcion de la notificacion es la correcta
     */
    @Test
    public void descripcion() {
        assertEquals("Proyecto. titulo: Creado con exito.", np.descripcion());
    }
}