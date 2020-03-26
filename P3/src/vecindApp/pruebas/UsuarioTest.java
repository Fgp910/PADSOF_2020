package vecindApp.pruebas;

import org.junit.Assert;
import vecindApp.clases.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UsuarioTest {
    Usuario usr;

    @Before
    void setUp() {
        usr = new Usuario("pepe", "a1");
    }

    @Test
    void getUsername() {
        assertEquals("pepe", usr.getUsername());
    }

    @Test
    void setUsername() {
        usr.setUsername("juan");
        assertEquals("juan", usr.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("a1", usr.getPassword());
    }

    @Test
    void setPassword() {
        usr.setPassword("b2");
        assertEquals("b2", usr.getPassword());
    }

    @Test
    void getPendientes() {
        ArrayList<Notificacion> pendientes = new ArrayList<>();
        assertEquals(pendientes, usr.getPendientes());
    }

    @Test
    void setPendientes() {
        ArrayList<Notificacion> newpendientes = new ArrayList<>();
        usr.setPendientes(newpendientes);
        assertEquals(newpendientes, usr.getPendientes());
    }

    @Test
    void agregarNotificacion() {
        Ciudadano c = new Ciudadano("pepe", "a1", "123456U");
        NotificacionReg nr = new NotificacionReg(c);
        assertEquals(usr.getPendientes.add(nr), usr.agregarNotificacion(nr));
    }
}