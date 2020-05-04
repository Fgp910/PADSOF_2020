package vecindApp.clases.proyecto;

import java.io.Serializable;

/**
 * Define la enumeracion EstadoProyecto que codifica los distintos estados en los
 * que puede encontrarse un proyecto desde que es creado hasta que se resuelve su
 * solicitud de finenciacion.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public enum EstadoProyecto implements Serializable {
    INICIAL, ACEPTADO, RECHAZADO, LISTOENVAR, ENVIADO, FINANCIADO, DENEGADO;

    /**
     * Convierte un elemento de la enumeracion a cadena de caracteres
     * @return cadena de caracteres resultante
     */
    @Override
    public final String toString() {
        switch (this) {
            case INICIAL: return "Creado con éxito.";
            case ACEPTADO: return "Admitido por la administración.";
            case RECHAZADO: return "Rechazado por la administración.";
            case LISTOENVAR: return "Ha alcanzado los apoyos mínimos.";
            case ENVIADO: return "Enviado a financiacion.";
            case FINANCIADO: return "Aprobada su financiación.";
            case DENEGADO: return "Denegada su financiación.";
            default: return null;
        }
    }
}