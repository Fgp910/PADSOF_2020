package vecindApp.pruebas;

import org.junit.Before;
import org.junit.Test;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.proyecto.*;

import static org.junit.Assert.assertEquals;

/**
 * Clase de prueba de la clase ProyectoSocial
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ProyectoSocialTest {
    ProyectoSocial ps;
    Ciudadano c;

    /**
     * Crea un proyecto social con el que realizar las pruebas
     */
    @Before
    public void setUp() {
        c = new Ciudadano("pepe", "a1", "123456Y");
        ps = new ProyectoSocial("titulo", "descripcion", 500.0, c, "grupo", true);
    }

    /**
     * Comprueba que el grupo social es el asignado al crear el proyecto
     */
    @Test
    public void getGrupoSocial() {
        assertEquals("grupo", ps.getGrupoSocial());
    }

    /**
     * Comprueba que el grupo social es el asignado
     */
    @Test
    public void setGrupoSocial() {
        ps.setGrupoSocial("grupo2");
        assertEquals("grupo2", ps.getGrupoSocial());
    }

    /**
     * Comprueba que la internacionalidad del proyecto es la asignada al crearlo
     */
    @Test
    public void isNacional() {
        assertEquals(true, ps.isNacional());
    }

    /**
     * Comprueba que la internacionalidad del proyecto es la asignada
     */
    @Test
    public void setNacional() {
        ps.setNacional(false);
        assertEquals(false, ps.isNacional());
    }
}