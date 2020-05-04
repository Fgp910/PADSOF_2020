package vecindApp.clases.notificacion;

import vecindApp.clases.colectivo.*;

/**
 * Define la clase NotificacionReg que implementa la clase Notificacion
 * para Ciudadanos (de cara a los registros que el administrador ha de
 * aprobar).
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class NotificacionReg extends Notificacion {
    private Ciudadano sujeto;

    /**
     * Crea una nueva notificacion de ciudadano
     * @param sujeto ciudadano de la notificacion
     */
    public NotificacionReg(Ciudadano sujeto) {
        this.sujeto = sujeto;
    }

    /**
     * Devuelve el sujeto de una notificacion
     * @return proyecto sujeto
     */
    public Ciudadano getSujeto() {
        return sujeto;
    }

    /**
     * Establece el sujeto de una notificacion
     * @param s nuevo sujeto de la notificacion
     */
    public void setSujeto(Ciudadano s) {
        sujeto = s;
    }

    @Override
    public String descripcion() {
        return "Nuevo registro. " + sujeto;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof NotificacionReg && ((NotificacionReg) o).getSujeto() == sujeto) {
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
        return "Nuevo registro: " + sujeto.getUsername();
    }
}
