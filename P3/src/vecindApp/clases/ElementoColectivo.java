package vecindApp.clases;

import java.io.Serializable;
import java.util.Set;

/**
 * Define la interfaz ElementoColectivo que han de implementar
 * las clases que sean contenidas por un Colectivo.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public interface ElementoColectivo extends Serializable {
    Set<Proyecto> getProyectos();
    void setProyectos(Set<Proyecto> proyectos);
    boolean addProyecto(Proyecto proyecto);
    boolean removeProyecto(Proyecto proyecto);
    Set<Proyecto> getProyectosApoyados();
    void setProyectosApoyados(Set<Proyecto> proyectos);
    boolean addProyectoApoyado(Proyecto proyecto);
    boolean removeProyectoApoyado(Proyecto proyecto);
}