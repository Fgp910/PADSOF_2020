package vecindApp.clases;

import es.uam.eps.sadp.grants.GrantRequest;

public abstract class SolicitudFinanciacion implements GrantRequest {
    private final Proyecto p;

    public SolicitudFinanciacion(Proyecto p) {
        this.p = p;
    }

    public Proyecto getProject() {
        return p;
    }

    @Override
    public String getProjectTitle() {
        return p.getTitulo();
    }

    @Override
    public String getProjectDescription() {
        return p.getDescripcion();
    }

    @Override
    public double getRequestedAmount() {
        return p.getImporteSolicitado();
    }
}
