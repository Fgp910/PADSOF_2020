package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersistenciaTest {
    Persistencia p;

    @Before
    void setUp() {
        p = new Persistencia();
    }

    @Test
    void setValues() {
        p.setValues();
        assertEquals(p.getProyectoNextId(), Proyecto.getNextId());
        assertEquals(p.getAplicacionMinApoyos(), Aplicacion.minApoyos);
    }

    @Test
    void getAplicacionMinApoyos() {
        assertEquals(Aplicacion.minApoyos, p.getAplicacionMinApoyos());
    }

    @Test
    void getProyectoNextId() {
        assertEquals(Proyecto.getNextId(), p.getProyectoNextId());
    }
}