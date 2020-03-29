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

    /**
     * Inicializa una nueva solicitud para un proyecto social
     * @param p proyecto
     */
    public SolicitudSocial(Proyecto p) {
        super(p);
    }

    /**
     * Devuelve el tipo de proyecto (social o infraestructura)
     * @return tipo del proyecto
     */
    @Override
    public ProjectKind getProjectKind() {
        return GrantRequest.ProjectKind.valueOf("Social");
    }

    /**
     * Devuelve la informacion extra relacionada con el proyecto
     * @return grupo social e internacionalidad
     */
    @Override
    public String getExtraData() {
        ProyectoSocial p = (ProyectoSocial) getProject();
        return "Grupo social: " + p.getGrupoSocial() +
                "\nNacional: " + p.isNacional();
    }
}
