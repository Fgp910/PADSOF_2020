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

    /**
     * Inicializa un nuevo Proyecto de infraestructura
     * @param titulo titulo del proyecto
     * @param descripcion descripcion del proyecto
     * @param importeSolicitado importe solicitado por el proyecto
     * @param propulsor propulsor del proyecto
     * @param img imagen del proyecto
     * @param afectados distritos afectados por el proyecto
     */
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

    /**
     * Devuelve la imagen del proyecto
     * @return imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece una nueva imagen para el proyecto
     * @param img nueva imagen
     */
    public void setImagen(String img) {
        imagen = img;
    }

    /**
     * Devuelve los distritos afectados por el proyecto
     * @return distritos afectados
     */
    public List<Distrito> getAfectados() {
        return afectados;
    }

    /**
     * Establece un nuevo set de distritos afectados por el proyecto
     * @param af distritos afectados
     */
    public void setAfectados(ArrayList<Distrito> af) {
        afectados = af;
    }

    /**
     * Añade un nuevo distrito al set de afectados
     * @param d distrito
     * @return exito de la operacion
     */
    public boolean addAfectados(Distrito d) {
        return afectados.add(d);
    }

    /**
     * Elimina un distrito del set de afectados
     * @param d distrito
     * @return exito de la operacion
     */
    public boolean removeAfectados(Distrito d) {
        return afectados.remove(d);
    }

    /**
     * Crea una nueva solicitud de financiacion para el proyecto
     * @return solicitud del proyecto
     */
    @Override
    protected GrantRequest crearSolicitud() {
        return new SolicitudInfraestructura(this);
    }
}