package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.notificacion.*;
import vecindApp.clases.proyecto.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Clase de prueba de la clase Proyecto
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ProyectoTest {
    Proyecto p;

    /**
     * Crea un proyecto con el que realizar las pruebas
     */
    @Before
    public void setUp() {
        p = new ProyectoSocial("titulo",
                "descripcion",
                500.0,
                new Ciudadano("pepe", "c1", "12345678A"),
                "grupo",
                true);
        p.aceptar();
    }

    /**
     * Comprueba que se ha recibido el apoyo individual y que el promotor ha sido agregado a la lista
     */
    @Test
    public void recibirApoyo1() {
        Ciudadano votante = new Ciudadano("juan", "a2", "123456J");
        p.recibirApoyo(votante);
        assertTrue(p.getPromotores().contains(votante) && p.getNApoyos() == 2);
    }

    /**
     * Comprueba que se ha recibido el apoyo colectivo y que los promotares han sido agregados a la lista
     */
    @Test
    public void recibirApoyo2() {
        int actual = p.getNApoyos();
        Ciudadano votante1 = new Ciudadano("juan", "a2", "123456J");
        Ciudadano votante2 = new Ciudadano("juanito", "b3", "123456K");
        Colectivo c = new Colectivo("miColectivo", votante1);
        c.addElemento(votante2);
        p.recibirApoyo(c);
        assertTrue(p.getPromotores().contains(votante1) && p.getPromotores().contains(votante2) && p.getNApoyos() == actual + 2);
    }

    /**
     * Comprueba que se crea correctamente la notificacion para avisar de un cambio
     */
    @Test
    public void notificarCambio() {
        p.notificarCambio();
        List<Notificacion> notis = new ArrayList<>(((Ciudadano) p.getPropulsor()).getPendientes());
        assertEquals(p, ((NotificacionProy) notis.get(0)).getSujeto());
    }

    /**
     * Comprueba que el informe de popularidad es el correcto para los datos dados
     */
    @Test
    public void generarInformePopularidad() {
        assertEquals(1, p.generarInformePopularidad());
    }
}