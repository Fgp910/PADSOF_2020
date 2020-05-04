package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.notificacion.*;
import vecindApp.clases.usuario.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Clase de prueba de la clase Usuario
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class UsuarioTest {
    Usuario usr;

    /**
     * Crea un usuario para realizar las pruebas
     */
    @Before
    public void setUp() {
        usr = new Ciudadano("pepe", "a1", "123456Y");
    }

    /**
     * Comprueba que el nombre del usuario es el asignado al crearlo
     */
    @Test
    public void getUsername() {
        assertEquals("pepe", usr.getUsername());
    }

    /**
     * Comprueba que el nombre de usuario es el asignado
     */
    @Test
    public void setUsername() {
        usr.setUsername("juan");
        assertEquals("juan", usr.getUsername());
    }

    /**
     * Comprueba que la contraseña es la asignada al crear el usuario
     */
    @Test
    public void getPassword() {
        assertEquals("a1", usr.getPassword());
    }

    /**
     * Comprueba que la contraseña es la asignada
     */
    @Test
    public void setPassword() {
        usr.setPassword("b2");
        assertEquals("b2", usr.getPassword());
    }

    /**
     * Comprueba que la lista de pendientes está vacía
     */
    @Test
    public void getPendientes() {
        Set<Notificacion> pendientes = new HashSet<>();
        assertEquals(pendientes, usr.getPendientes());
    }

    /**
     * Comprueba que la lista de pendientes es la asignada
     */
    @Test
    public void setPendientes() {
        Set<Notificacion> newpendientes = new HashSet<>();
        usr.setPendientes(newpendientes);
        assertEquals(newpendientes, usr.getPendientes());
    }

    /**
     * Comprueba que la notificacion añadida está en las pendientes
     */
    @Test
    public void agregarNotificacion() {
        Usuario admin = new Administrador("admin", "psswd");
        NotificacionReg nr = new NotificacionReg(new Ciudadano("pepe", "a1", "123456U"));
        admin.agregarNotificacion(nr);
        assertTrue(admin.getPendientes().contains(nr));
    }
}