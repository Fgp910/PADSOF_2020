package vecindApp.clases;

import java.io.Serializable;

/**
 * Almacena las variables de clase para poder reestablecerlas al arrancar la aplicacion.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Persistencia implements Serializable {
    private int proyectoNextId;
    private int aplicacionMinApoyos;

    public Persistencia() {
        this.proyectoNextId = Proyecto.getNextId();
        this.aplicacionMinApoyos = Aplicacion.minApoyos;
    }

    public void setValues() {
        Proyecto.setNextId(proyectoNextId);
        Aplicacion.minApoyos = aplicacionMinApoyos;
    }

    public int getAplicacionMinApoyos() {
        return aplicacionMinApoyos;
    }

    public int getProyectoNextId() {
        return proyectoNextId;
    }
}
