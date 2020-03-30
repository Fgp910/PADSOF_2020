package vecindApp.clases.usuario;

/**
 * Define la clase Administrador, que especializa la clase Usuario
 * para agregar las funcionalidades del administrador.
 * 
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Administrador extends Usuario {
    /**
     * Inicializa un nuevo administrador
     * @param username nombre de usuario del administrador
     * @param password contraseña para el administrador
     */
    public Administrador(String username, String password) {
        super(username, password);
    }
}