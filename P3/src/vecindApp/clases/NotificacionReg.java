package vecindApp.clases;

/**
 * Define la clase NotificacionReg que implementa la clase Notificacion
 * para Ciudadanos (de cara a los registros que el administrador ha de
 * aprobar).
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class NotificacionReg extends Notificacion {
    private Ciudadano sujeto;

    public NotificacionReg(Ciudadano sujeto) {
        this.sujeto = sujeto;
    }

    public Ciudadano getSujeto() {
        return sujeto;
    }

    public void setSujeto(Ciudadano s) {
        sujeto = s;
    }
}
