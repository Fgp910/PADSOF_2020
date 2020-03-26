package vecindApp.clases;

import java.io.Serializable;
import java.util.List;

/**
 * Define la interfaz ElementoColectivo que han de implementar
 * las clases que sean contenidas por un Colectivo.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public interface ElementoColectivo extends Serializable {
    List<Proyecto> getProyectos(); //Devuelve los proyectos propuestos o los apoyados?????????????????????????????
}