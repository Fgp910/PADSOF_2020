package vecindApp.clases;

import es.uam.eps.sadp.grants.GrantRequest;

public class ProyectoSocial extends Proyecto {
    private String grupoSocial;
    private boolean nacional;

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

    public String getGrupoSocial() {
        return grupoSocial;
    }
    
    public void setGrupoSocial(String grupo) {
        grupoSocial = grupo;
    }

    public boolean isNacional() {
        return nacional;
    }
    
    public void setNacional(boolean nac) {
        nacional = nac;
    }

    @Override
    protected GrantRequest crearSolicitud() {
        return new SolicitudSocial(this);
    }
}