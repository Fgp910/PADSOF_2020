package vecindApp.clases;

import es.uam.eps.sadp.grants.GrantRequest;

public class SolicitudInfraestructura extends SolicitudFinanciacion {
    public SolicitudInfraestructura(Proyecto p) {
        super(p);
    }

    @Override
    public ProjectKind getProjectKind() {
        return GrantRequest.ProjectKind.valueOf("Infraestructure");
    }

    @Override
    public String getExtraData() {
        ProyectoInfraestructura p = (ProyectoInfraestructura) getProject();
        return "Imagen: " + p.getImagen() + "\nDistritos afectados: " + p.getAfectados().toString();
    }
}
