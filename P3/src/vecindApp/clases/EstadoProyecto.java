package vecindApp.clases;

import java.io.Serializable;

enum EstadoProyecto implements Serializable {
    INICIAL, ACEPTADO, RECHAZADO, LISTOENVAR, ENVIADO, FINANCIADO, DENEGADO;
}