package vecindApp.clases;

import es.uam.eps.sadp.grants.GrantRequest;

import java.io.Serializable;

public abstract class SolicitudFinanciacion implements GrantRequest, Serializable {
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
