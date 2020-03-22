package vecindApp.clases;

import es.uam.eps.sadp.grants.GrantRequest;

public class SolicitudSocial extends SolicitudFinanciacion {
    public SolicitudSocial(Proyecto p) {
        super(p);
    }

    @Override
    public ProjectKind getProjectKind() {
        return GrantRequest.ProjectKind.valueOf("Social");
    }

    @Override
    public String getExtraData() {
        ProyectoSocial p = (ProyectoSocial) getProject();
        return "Grupo social: " + p.getGrupoSocial() +
                "\nNacional: " + Boolean.toString(p.isNacional());
    }
}
