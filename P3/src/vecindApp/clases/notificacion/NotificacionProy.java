package vecindApp.clases.notificacion;

import vecindApp.clases.proyecto.*;

/**
 * Define la clase NotificacionProy que implementa la clase Notificacion
 * para Proyectos.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class NotificacionProy extends Notificacion {
    private Proyecto sujeto;

    /**
     * Crea una nueva notificacion de proyecto
     * @param sujeto proyecto de la notificacion
     */
    public NotificacionProy(Proyecto sujeto) {
        this.sujeto = sujeto;
    }

    /**
     * Devuelve el sujeto de una notificacion
     * @return proyecto sujeto
     */
    public Proyecto getSujeto() {
        return sujeto;
    }

    /**
     * Establece el sujeto de una notificacion
     * @param s nuevo sujeto de la notificacion
     */
    public void setSujeto(Proyecto s) {
        sujeto = s;
    }

    /**
     * Devuelve la descripcion de una notificacion
     * @return descripcion
     */
    @Override
    public String descripcion() {
        return "Proyecto. " + sujeto;
    }

    /*
     * Si hay una notificacion pendiente asociada al cambio de estado de un proyecto
     * y el proyecto vuelve a cambiar de estado, se actualiza la notificacion, no se
     * crea una nueva (tendria el mismo contenido)
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof NotificacionProy && ((NotificacionProy) o).getSujeto() == sujeto) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return sujeto.hashCode();
    }

    @Override
    public String toString() {
        return "Proyecto: " + sujeto.getTitulo();
    }
}
