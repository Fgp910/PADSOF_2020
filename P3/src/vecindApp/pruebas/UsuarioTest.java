package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.notificacion.*;
import vecindApp.clases.usuario.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Clase de prueba de la clase Usuario
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class UsuarioTest {
    Usuario usr;

    @Before
    public void setUp() {
        usr = new Ciudadano("pepe", "a1", "123456Y");
    }

    @Test
    public void getUsername() {
        assertEquals("pepe", usr.getUsername());
    }

    @Test
    public void setUsername() {
        usr.setUsername("juan");
        assertEquals("juan", usr.getUsername());
    }

    @Test
    public void getPassword() {
        assertEquals("a1", usr.getPassword());
    }

    @Test
    public void setPassword() {
        usr.setPassword("b2");
        assertEquals("b2", usr.getPassword());
    }

    @Test
    public void getPendientes() {
        ArrayList<Notificacion> pendientes = new ArrayList<>();
        assertEquals(pendientes, usr.getPendientes());
    }

    @Test
    public void setPendientes() {
        ArrayList<Notificacion> newpendientes = new ArrayList<>();
        usr.setPendientes(newpendientes);
        assertEquals(newpendientes, usr.getPendientes());
    }

    @Test
    public void agregarNotificacion() {
        Usuario admin = new Administrador("admin", "psswd");
        NotificacionReg nr = new NotificacionReg(new Ciudadano("pepe", "a1", "123456U"));
        admin.agregarNotificacion(nr);
        assertTrue(admin.getPendientes().contains(nr));
    }
}