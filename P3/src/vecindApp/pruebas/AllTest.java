package vecindApp.pruebas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({AdministradorTest.class,
                    AplicacionTest.class,
                    CiudadanoTest.class,
                    ColectivoTest.class,
                    NotificacionProyTest.class,
                    NotificacionRegTest.class,
                    PersistenciaTest.class,
                    ProyectoInfraestructuraTest.class,
                    ProyectoSocialTest.class,
                    ProyectoTest.class,
                    SolicitudFinanciacionTest.class,
                    SolicitudInfraestructuraTest.class,
                    SolicitudSocialTest.class,
                    UsuarioTest.class})
/**
 * Clase de prueba general
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class AllTest {}
