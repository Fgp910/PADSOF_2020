package vecindApp.clases;

import es.uam.eps.sadp.grants.GrantRequest;

/**
 * Define la clase SolicitudInfraestructura, que extiende la definicion de
 * SolicitudFinanciacion para aportar la informacion adicional asociada a
 * un ProyectoInfraestructura.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class SolicitudInfraestructura extends SolicitudFinanciacion {
    public SolicitudInfraestructura(Proyecto p) {
        super(p);
    }

    @Override
    public ProjectKind getProjectKind() {
        return GrantRequest.ProjectKind.valueOf("Infrastructure");
    }

    @Override
    public String getExtraData() {
        ProyectoInfraestructura p = (ProyectoInfraestructura) getProject();
        return "Imagen: " + p.getImagen() + "\nDistritos afectados: " + p.getAfectados().toString();
    }
}
