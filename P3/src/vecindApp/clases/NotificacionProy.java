package vecindApp.clases;

/**
 * Define la clase NotificacionProy que implementa la clase Notificacion
 * para Proyectos.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class NotificacionProy extends Notificacion {
    private Proyecto sujeto;

    public NotificacionProy(Proyecto sujeto) {
        this.sujeto = sujeto;
    }

    public Proyecto getSujeto() {
        return sujeto;
    }

    public void setSujeto(Proyecto s) {
        sujeto = s;
    }

    @Override
    public String descripcion() {
        return "Proyecto. " + sujeto.getTitulo() + ": " + sujeto.getEstado();
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
        return true;
    }

    @Override
    public int hashCode() {
        return sujeto.hashCode();
    }
}
