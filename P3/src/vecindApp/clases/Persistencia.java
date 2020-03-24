package vecindApp.clases;

import java.io.Serializable;

/**
 * Almacena las variables de clase para poder reestablecerlas al arrancar la aplicacion
 */
public class Persistencia implements Serializable {
    private int proyectoNextId;
    private int aplicacionMinApoyos;

    public Persistencia() {
        this.proyectoNextId = Proyecto.getNextId();
        this.aplicacionMinApoyos = Aplicacion.minApoyos;
    }
}
