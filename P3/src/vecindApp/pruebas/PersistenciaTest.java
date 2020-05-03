package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.aplicacion.*;
import vecindApp.clases.proyecto.*;

import static org.junit.Assert.assertEquals;

/**
 * Clase de prueba de la clase Persistencia
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class PersistenciaTest {
    Persistencia p;

    /**
     * Crea una nueva clase Persistencia para realizar las pruebas
     */
    @Before
    public void setUp() {
        p = new Persistencia();
    }

    /**
     * Comprueba que los valores son los asignados
     */
    @Test
    public void setValues() {
        p.setValues();
        assertEquals(p.getProyectoNextId(), Proyecto.getNextId());
        assertEquals(p.getAplicacionMinApoyos(), Aplicacion.getMinApoyos());
    }

    /**
     * Comprueba que el numero minimo de apoyos es el correcto
     */
    @Test
    public void getAplicacionMinApoyos() {
        assertEquals(Aplicacion.getMinApoyos(), p.getAplicacionMinApoyos());
    }

    /**
     * Comprueba que el nextId de proyecto es el correcto
     */
    @Test
    public void getProyectoNextId() {
        assertEquals(Proyecto.getNextId(), p.getProyectoNextId());
    }
}