package vecindApp.clases.excepciones;

public class ConexionFallida extends Exception {
    @Override
    public String toString() {
        return "Conexion con el sistema externo fallida.\n";
    }
}
