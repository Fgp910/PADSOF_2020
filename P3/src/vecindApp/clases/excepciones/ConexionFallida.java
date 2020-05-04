package vecindApp.clases.excepciones;

/**
 * Define una extension de Exception asociada a fallos de comunicacion
 * con el sistema externo de financiacion.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ConexionFallida extends Exception {
    public ConexionFallida(Exception cause) {
        super(cause);
    }
    @Override
    public String toString() {
        return "Conexion con el sistema externo fallida.\n";
    }
}
