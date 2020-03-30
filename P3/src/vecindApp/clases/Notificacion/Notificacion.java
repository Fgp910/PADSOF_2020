package vecindApp.clases.Notificacion;

import java.io.Serializable;

/**
 * Define la clase Notificacion.
 * Los Usuarios pueden recibir notificaciones de distinto tipo.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public abstract class Notificacion implements Serializable {
    /**
     * Devuelve la descripcion de una notificacion
     * @return descripcion
     */
    public abstract String descripcion();
}