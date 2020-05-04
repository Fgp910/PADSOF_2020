package vecindApp.clases.excepciones;

/**
 * Define una extension de Exception asociada a la referencia
 * a un archivo inexistente.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ImageNotFoundException extends Exception {
    public ImageNotFoundException(String path) {
        super(path + " no existe.");
    }
}
