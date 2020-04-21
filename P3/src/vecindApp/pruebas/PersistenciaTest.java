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

    @Before
    public void setUp() {
        p = new Persistencia();
    }

    @Test
    public void setValues() {
        p.setValues();
        assertEquals(p.getProyectoNextId(), Proyecto.getNextId());
        assertEquals(p.getAplicacionMinApoyos(), Aplicacion.getMinApoyos());
    }

    @Test
    public void getAplicacionMinApoyos() {
        assertEquals(Aplicacion.getMinApoyos(), p.getAplicacionMinApoyos());
    }

    @Test
    public void getProyectoNextId() {
        assertEquals(Proyecto.getNextId(), p.getProyectoNextId());
    }
}