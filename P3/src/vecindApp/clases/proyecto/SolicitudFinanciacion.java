package vecindApp.clases.proyecto;

import es.uam.eps.sadp.grants.GrantRequest;

import java.io.Serializable;

/**
 * Define la clase SolicitudFinanciacion que implementa la interfaz GrantRequest
 * y, entonces, aporta la informacion que el sistema externo de financiacion
 * requiere para procesar la solicitud de financiacion de un Proyecto.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public abstract class SolicitudFinanciacion implements GrantRequest, Serializable {
    private final Proyecto p;

    /**
     * Inicializa un solicitud de financiacion para un proyecto dado
     * @param p proyecto
     */
    public SolicitudFinanciacion(Proyecto p) {
        this.p = p;
    }

    /**
     * Devuelve el proyecto del que se ha creado la solicitud
     * @return proyecto
     */
    public Proyecto getProject() {
        return p;
    }

    /**
     * Devuelve el titulo del proyecto
     * @return titulo del proyecto
     */
    @Override
    public String getProjectTitle() {
        return p.getTitulo();
    }

    /**
     * Devuelve la decripcion del proyecto
     * @return descripcion del proyecto
     */
    @Override
    public String getProjectDescription() {
        return p.getDescripcion();
    }

    /**
     * Devuelve la cantidad solicitada por el proyecto
     * @return cantidad solicitada por el proyecto
     */
    @Override
    public double getRequestedAmount() {
        return p.getImporteSolicitado();
    }
}
