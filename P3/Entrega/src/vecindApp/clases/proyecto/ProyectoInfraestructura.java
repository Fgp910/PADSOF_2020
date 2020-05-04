package vecindApp.clases.proyecto;

import es.uam.eps.sadp.grants.GrantRequest;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.excepciones.ImageNotFoundException;

import java.io.File;
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
     * @throws ImageNotFoundException si el archivo de imagen no existe
     */
    public ProyectoInfraestructura(String titulo,
                                   String descripcion,
                                   double importeSolicitado,
                                   Ciudadano propulsor,
                                   String img,
                                   Collection<Distrito> afectados) throws ImageNotFoundException
    {
        super(titulo, descripcion, importeSolicitado, propulsor);
        File tmp = new File(img);
        if (!tmp.exists()) {
            throw new ImageNotFoundException(img);
        }
        imagen = img;
        this.afectados = new ArrayList<>(afectados);
    }

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
                                   Colectivo propulsor,
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
     * @throws ImageNotFoundException si el archivo de imagen no existe
     */
    public void setImagen(String img) throws ImageNotFoundException {
        File tmp = new File(img);
        if (!tmp.exists()) {
            throw new ImageNotFoundException(img);
        }
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
    public void setAfectados(List<Distrito> af) {
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

    @Override
    public GrantRequest.ProjectKind getProjectKind() {
        return GrantRequest.ProjectKind.valueOf("Infrastructure");
    }

    @Override
    public String getExtraData() {
        return "Imagen: " + getImagen() + "\nDistritos afectados: " + getAfectados().toString();
    }
}