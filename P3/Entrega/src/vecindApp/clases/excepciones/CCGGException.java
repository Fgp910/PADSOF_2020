package vecindApp.clases.excepciones;

/**
 * Define una extension de Exception asociada a excepciones del
 * sistema externo de financiacion.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class CCGGException extends Exception {
    public CCGGException(String message, Exception cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        return getMessage() + ": \n" + getCause().toString();
    }
}
