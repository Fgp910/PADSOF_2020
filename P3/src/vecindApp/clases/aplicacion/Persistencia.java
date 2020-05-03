package vecindApp.clases.aplicacion;

import java.io.Serializable;
import java.time.LocalDate;

import vecindApp.clases.proyecto.*;

/**
 * Almacena las variables de clase para poder reestablecerlas al arrancar la aplicacion.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Persistencia implements Serializable {
    private int proyectoNextId;
    private int aplicacionMinApoyos;
    private LocalDate now;

    /**
     * Inicializa la clase persistencia
     */
    public Persistencia() {
        this.proyectoNextId = Proyecto.getNextId();
        this.aplicacionMinApoyos = Aplicacion.getMinApoyos();
        this.now = Aplicacion.getNow();
    }

    /**
     * Establece los valores correspondientes en proyecto y aplicacion
     */
    public void setValues() {
        Proyecto.setNextId(proyectoNextId);
        Aplicacion.setMinApoyos(aplicacionMinApoyos);
        Aplicacion.setNow(now); //Por motivos de la simulacion, se asigna la ultima hora almacenada.
    }                           //Podría usarse LocalDate.now() para actualizar la fecha automaticamente

    /**
     * Devuelve el next id de un proyecto
     * @return next id de un proyecto
     */
    public int getProyectoNextId() {
        return proyectoNextId;
    }

    /**
     * Devuelve el minimo de apoyos
     * @return min apoyos de la aplicacion
     */
    public int getAplicacionMinApoyos() {
        return aplicacionMinApoyos;
    }

    /**
     * Devuelve la fecha actual del sistema
     * @return fecha actual de la aplicacion
     */
    public LocalDate getAplicacionNow() {
        return now;
    }
}
