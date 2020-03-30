package vecindApp.clases.aplicacion;

import java.io.Serializable;
import vecindApp.clases.proyecto.*;

/**
 * Almacena las variables de clase para poder reestablecerlas al arrancar la aplicacion.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Persistencia implements Serializable {
    private int proyectoNextId;
    private int aplicacionMinApoyos;

    /**
     * Inicializa la clase persistencia
     */
    public Persistencia() {
        this.proyectoNextId = Proyecto.getNextId();
        this.aplicacionMinApoyos = Aplicacion.minApoyos;
    }

    /**
     * Establece los valores correspondientes en proyecto y aplicacion
     */
    public void setValues() {
        Proyecto.setNextId(proyectoNextId);
        Aplicacion.minApoyos = aplicacionMinApoyos;
    }

    /**
     * Devuelve el minimo de apoyos
     * @return min apoyos de la aplicacion
     */
    public int getAplicacionMinApoyos() {
        return aplicacionMinApoyos;
    }

    /**
     * Devuelve el next id de un proyecto
     * @return next id de un proyecto
     */
    public int getProyectoNextId() {
        return proyectoNextId;
    }
}
