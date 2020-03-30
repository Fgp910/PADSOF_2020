package vecindApp.pruebas;

import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Clase de prueba de la clase Administrador.
 * Ver tambien pruebas de Usuario (UsuarioTest)
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class AdministradorTest {
    Administrador admin;

    @Before
    public void setUp() {
        admin = new Administrador("admin", "a1");
    }

    @Test
    public void getUsername() {
        assertEquals("admin", admin.getUsername());
    }
}