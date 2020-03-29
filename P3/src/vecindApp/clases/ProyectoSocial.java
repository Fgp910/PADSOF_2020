package vecindApp.clases;

import es.uam.eps.sadp.grants.GrantRequest;

/**
 * Define la clase ProyectoSocial, que extiende la definicion de
 * la clase Proyecto para agregar la informacion asociada a este
 * tipo de proyecto.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ProyectoSocial extends Proyecto {
    private String grupoSocial;
    private boolean nacional;

    /**
     * Inicializa un nuevo proyecto social
     * @param titulo titulo del proyecto
     * @param descripcion descripcion del proyecto
     * @param importeSolicitado importe solicitado por el proyecto
     * @param propulsor propulsor del proyecto
     * @param grupo grupo al que afecta el proyecto
     * @param nac internacionalidad del proyecto
     */
    public ProyectoSocial(String titulo,
                          String descripcion,
                          double importeSolicitado,
                          Ciudadano propulsor,
                          String grupo,
                          boolean nac) {
        super(titulo, descripcion, importeSolicitado, propulsor);
        grupoSocial = grupo;
        nacional = nac;
    }

    /**
     * Devuelve el grupo social al que afecta el proyecto
     * @return grupo social afectado
     */
    public String getGrupoSocial() {
        return grupoSocial;
    }

    /**
     * Establece el grupo social al que afecta el proyecto
     * @param grupo grupo social afectado
     */
    public void setGrupoSocial(String grupo) {
        grupoSocial = grupo;
    }

    /**
     * Devuelve si el proyecto es naciona o no
     * @return internacionalidad
     */
    public boolean isNacional() {
        return nacional;
    }

    /**
     * Establece si el proyecto es nacional o no
     * @param nac internacionalidad
     */
    public void setNacional(boolean nac) {
        nacional = nac;
    }

    /**
     * Crea una nueva solicitud de financiacion para el proyecto
     * @return solicitud del proyecto
     */
    @Override
    protected GrantRequest crearSolicitud() {
        return new SolicitudSocial(this);
    }
}