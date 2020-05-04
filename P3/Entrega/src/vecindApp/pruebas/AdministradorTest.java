package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.usuario.*;

import static org.junit.Assert.assertEquals;

/**
 * Clase de prueba de la clase Administrador.
 * Ver tambien pruebas de Usuario (UsuarioTest)
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class AdministradorTest {
    Administrador admin;

    /**
     * Crea un administrador con el que realizar las pruebas
     */
    @Before
    public void setUp() {
        admin = new Administrador("admin", "a1");
    }

    /**
     * comprueba que el nombre de usuario coincide con el que se le ha dado al crearlo
     */
    @Test
    public void getUsername() {
        assertEquals("admin", admin.getUsername());
    }
}