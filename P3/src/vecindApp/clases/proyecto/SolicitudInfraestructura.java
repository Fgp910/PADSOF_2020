package vecindApp.clases.proyecto;

import es.uam.eps.sadp.grants.GrantRequest;

/**
 * Define la clase SolicitudInfraestructura, que extiende la definicion de
 * SolicitudFinanciacion para aportar la informacion adicional asociada a
 * un ProyectoInfraestructura.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class SolicitudInfraestructura extends SolicitudFinanciacion {

    /**
     * Inicializa una nueva solicitud para un proyecto de infraestructura
     * @param p proyecto
     */
    public SolicitudInfraestructura(Proyecto p) {
        super(p);
    }

    /**
     * Devuelve el tipo de proyecto (social o infrestructura)
     * @return tipo de proyecto
     */
    @Override
    public ProjectKind getProjectKind() {
        return GrantRequest.ProjectKind.valueOf("Infrastructure");
    }

    /**
     * Devuelve la informacion extra relacionada con el proyecto
     * @return imagen y distritos afectados
     */
    @Override
    public String getExtraData() {
        ProyectoInfraestructura p = (ProyectoInfraestructura) getProject();
        return "Imagen: " + p.getImagen() + "\nDistritos afectados: " + p.getAfectados().toString();
    }
}
