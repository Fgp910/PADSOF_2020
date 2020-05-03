package vecindApp.clases.excepciones;

public class CCGGException extends Exception {
    public CCGGException(String message, Exception cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        return getMessage() + ": \n" + getCause().toString();
    }
}
