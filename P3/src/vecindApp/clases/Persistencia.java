package vecindApp.clases;

/**
 * Almacena las variables de clase para poder reestablecerlas al arrancar la aplicacion
 */
public class Persistencia {
    private int proyectoNextId;
    private int aplicacionMinApoyos;

    public Persistencia() {
        this.proyectoNextId = Proyecto.getNextId();
        this.aplicacionMinApoyos = Aplicacion.minApoyos;
    }
}
