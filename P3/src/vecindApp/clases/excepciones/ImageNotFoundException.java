package vecindApp.clases.excepciones;

public class ImageNotFoundException extends Exception {
    public ImageNotFoundException(String path) {
        super(path + " no existe.");
    }
}
