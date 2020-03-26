package vecindApp.clases;

import java.io.Serializable;

/**
 * Define la enumeracion EstadoProyecto que codifica los distintos estados en los
 * que puede encontrarse un proyecto desde que es creado hasta que se resuelve su
 * solicitud de finenciacion.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
enum EstadoProyecto implements Serializable {
    INICIAL, ACEPTADO, RECHAZADO, LISTOENVAR, ENVIADO, FINANCIADO, DENEGADO
}