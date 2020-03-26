package vecindApp.clases;

import es.uam.eps.sadp.grants.GrantRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Define la clase ProyectoInfraestructura, que extiende la definicion
 * de la clase Proyecto para agregar la informacion asociada a este
 * tipo de proyecto.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class ProyectoInfraestructura extends Proyecto {
    private String imagen;
    private List<Distrito> afectados;

    public ProyectoInfraestructura(String titulo,
                                   String descripcion,
                                   double importeSolicitado,
                                   Ciudadano propulsor,
                                   String img,
                                   Collection<Distrito> afectados) {
        super(titulo, descripcion, importeSolicitado, propulsor);
        imagen = img;
        this.afectados = new ArrayList<>(afectados);
    }

    public String getImagen() {
        return imagen;
    }
    
    public void setImagen(String img) {
        imagen = img;
    }

    public List<Distrito> getAfectados() {
        return afectados;
    }
    
    public void setAfectados(ArrayList<Distrito> af) {
        afectados = af;
    }

    public boolean addAfectados(Distrito d) {
        return afectados.add(d);
    }

    public boolean removeAfectados(Distrito d) {
        return afectados.remove(d);
    }

    @Override
    protected GrantRequest crearSolicitud() {
        return new SolicitudInfraestructura(this);
    }
}