package vecindApp.pruebas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import vecindApp.clases.ProyectoSocial;

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
public class AllTest {}
