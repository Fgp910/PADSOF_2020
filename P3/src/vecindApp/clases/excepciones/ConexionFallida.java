package vecindApp.clases.excepciones;

public class ConexionFallida extends Exception {
    public ConexionFallida(Exception cause) {
        super(cause);
    }
    @Override
    public String toString() {
        return "Conexion con el sistema externo fallida.\n";
    }
}
