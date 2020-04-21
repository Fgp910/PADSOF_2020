package vecindApp.clases.colectivo;

import vecindApp.clases.proyecto.*;

import java.io.Serializable;
import java.util.Set;

/**
 * Define la interfaz ElementoColectivo que han de implementar
 * las clases que sean contenidas por un Colectivo.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public interface ElementoColectivo extends Serializable {
    /**
     * Devuelve el set de proyectos propuestos por un elemento colectivo
     * @return set de proyectos
     */
    Set<Proyecto> getProyectos();

    /**
     * Agrega un nuevo proyecto propuesto a un elemento colectivo
     * @param proyecto proyecto a agregar
     * @return true si se agrega correctamente, false en otro caso
     */
    boolean addProyecto(Proyecto proyecto);

    /**
     * Elimina un proyecto del conjunto de propuestos de un elemento colectivo
     * @param proyecto proyecto a eliminar
     * @return true si se elimina correctamente, false en otro caso
     */
    boolean removeProyecto(Proyecto proyecto);

    /**
     * Devuelve el set de proyectos apoyados por un elemento colectivo
     * @return set de proyectos apoyados
     */
    Set<Proyecto> getProyectosApoyados();

    /**
     * Agrega un nuevo proyecto apoyado a un elemento colectivo
     * @param proyecto proyecto a agregar
     * @return true si se agrega correctamente, false en otro caso
     */
    boolean addProyectoApoyado(Proyecto proyecto);

    /**
     * Elimina un proyecto del conjunto de apoyados de un elemento colectivo
     * @param proyecto proyecto a eliminar
     * @return true si se elimina correctamente, false en otro caso
     */
    boolean removeProyectoApoyado(Proyecto proyecto);
}