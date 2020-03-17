package src.vecindApp.clases;

public class ProyectoSocial extends Proyecto {
    private String grupoSocial;
    private boolean nacional;

    public ProyectoSocial(String descripcion, double importeSolicitado, Ciudadano propulsor, String grupo, boolean nac) {
        super(descripcion, importeSolicitado, propulsor);
        grupoSocial = grupo;
        nacional = nac;
    }

    public String getGrupoSocial() {
        return grupoSocial;
    }
    
    public void setGrupoSocial(String grupo) {
        grupoSocial = grupo;
    }

    public boolean getNacional() {
        return nacional;
    }
    
    public void setNacional(boolean nac) {
        nacional = nac;
    }
}