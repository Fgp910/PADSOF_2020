package vecindApp.clases;

import es.uam.eps.sadp.grants.GrantRequest;

/**
 * Define la clase SolicitudSocial, que extiende la definicion de
 * SolicitudFinanciacion para aportar la informacion adicional asociada
 * a un ProyectoSocial.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
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
                "\nNacional: " + p.isNacional();
    }
}
