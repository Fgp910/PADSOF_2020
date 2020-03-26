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
        return "Nuevo proyecto. "+ sujeto.getTitulo() + ": " + sujeto.getEstado();
    }
}
