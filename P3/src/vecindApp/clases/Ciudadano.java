package vecindApp.clases;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Define la clase Ciudadano, que agrega a la clase Usuario los atributos
 * y metodos propios de un ciudadano, ademas de implementar la interfaz
 * ElementoColectivo
 * 
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Ciudadano extends Usuario implements ElementoColectivo {
    private String nif;
    private boolean admitido;
    private boolean bloqueado;
    private Set<Proyecto> proyectos;
    private Set<Proyecto> proyectosApoyados;
    private Set<Colectivo> colectivos;
    private List<Colectivo> colectivosRepresentados;

    /**
     * Inicializa un ciudadano
     * @param username nombre de usuario del ciudadano
     * @param password contraseña para el usuario
     * @param nif nif del usuario
     */
    public Ciudadano(String username, String password, String nif) {
        super(username, password);
        this.nif = nif;
        this.admitido = false;
        this.bloqueado = false;
        proyectos = new HashSet<>();
        proyectosApoyados = new HashSet<>();
        colectivos = new HashSet<>();
        colectivosRepresentados = new ArrayList<>();
    }

    /**
     * Devuelve el nif de un ciudadano
     * @return nif del ciudadano
     */
    public String getNif() {
        return nif;
    }

    /**
     * Establece un nuevo nif para un ciudadano
     * @param nif nuevo nif
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Devuelve el estado de admision de un ciudadano
     * @return true si el ciudadano esta admitido, false en caso contrario
     */
    public boolean isAdmitido() {
        return admitido;
    }

    /**
     * Establece el estado de admision de un ciudadano
     * @param admitido nuevo estado de admision
     */
    public void setAdmitido(boolean admitido) {
        this.admitido = admitido;
    }

    /**
     * Devuelve si un ciudadano esta bloqueado
     * @return true si esta bloqueado, false en caso contrario
     */
    public boolean isBloqueado() {
        return bloqueado;
    }

    /**
     * Establece el estado de bloqueo de un ciudadano
     * @param bloqueado nuevo estado de bloqueo
     */
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    /**
     * Devuelve el set de proyectos propuestos por un ciudadano
     * @return set de proyectos
     */
    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    /**
     * Establece un set de proyectos propuestos para un ciudadano
     * @param proyectos nuevo set de proyectos
     */
    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    /**
     * Devuelve el set de proyectos apoyados por un ciudadano
     * @return set de proyectos apoyados
     */
    public Set<Proyecto> getProyectosApoyados() {
        return proyectosApoyados;
    }

    /**
     * Establece un nuevo set de proyectos apoyados para un ciudadano
     * @param proyectosApoyados nuevo set de proyectos apoyados
     */
    public void setProyectosApoyados(Set<Proyecto> proyectosApoyados) {
        this.proyectosApoyados = proyectosApoyados;
    }

    /**
     * Devuelve los colectivos a los que pertenece un ciudadano
     * @return set de colectivos
     */
    public Set<Colectivo> getColectivos() {
        return colectivos;
    }

    /**
     * Establece un nuevo set de colectivos para un ciudadano
     * @param colectivos nuevo set de colectivos
     */
    public void setColectivos(Set<Colectivo> colectivos) {
        this.colectivos = colectivos;
    }

    /**
     * Devuelve los colectivos representados por un ciudadano
     * @return lista de colectivos representados
     */
    public List<Colectivo> getColectivosRepresentados() {
        return colectivosRepresentados;
    }

    /**
     * Establece una nueva lista de colectivos representados para un ciudadano
     * @param colectivosRepresentados nueva lista de colectivos representados
     */
    public void setColectivosRepresentados(List<Colectivo> colectivosRepresentados) {
        this.colectivosRepresentados = colectivosRepresentados;
    }

    /**
     * Añade un nuevo proyecto propuesto a un ciudadano
     * @param proyecto proyecto a añadir
     * @return true si se añade correctamente, false en otro caso
     */
    public boolean addProyecto(Proyecto proyecto) {
        return proyectos.add(proyecto);
    }

    /**
     * Elimina un proyecto del conjunto de propuestos de un ciudadano
     * @param proyecto proyecto a eliminar
     * @return true si se elimina correctamente, false en otro caso
     */
    public boolean removeProyecto(Proyecto proyecto) {
        return proyectos.remove(proyecto);
    }

    /**
     * Añade un nuevo proyecto apoyado a un ciudadano
     * @param proyecto proyecto a añadir
     * @return true si se añade correctamente, false en otro caso
     */
    public boolean addProyectoApoyado(Proyecto proyecto) {
        return proyectosApoyados.add(proyecto);
    }

    /**
     * Elimina un proyecto del conjunto de apoyados de un ciudadano
     * @param proyecto proyecto a eliminar
     * @return true si se elimina correctamente, false en otro caso
     */
    public boolean removeProyectoApoyado(Proyecto proyecto) {
        return proyectosApoyados.remove(proyecto);
    }

    /**
     * Añade un colectivo al conjunto de un ciudadano
     * @param colectivo colectivo a añadir
     * @return true si se añade correctamente, false en otro caso
     */
    public boolean addColectivo(Colectivo colectivo) {
        return colectivos.add(colectivo);
    }

    /**
     * Elimina un colectivo del conjunto de un ciudadano
     * @param colectivo a eliminar
     * @return true si se elimina correctamente, false en otro caso
     */
    public boolean removeColectivo(Colectivo colectivo) {
        return colectivos.remove(colectivo);
    }

    /**
     * Añade un colectivo representado a un ciudadano
     * @param colectivo colectivo a añadir
     * @return true si se añade correctamente, false en otro caso
     */
    public boolean addColectivoRepresentado(Colectivo colectivo) {
        return colectivosRepresentados.add(colectivo);
    }

    /**
     * ELimina un colectivo representado de la lista de un ciudadano
     * @param colectivo colectivo a eliminar
     * @return true si se elimina correctamente, false en otro caso
     */
    public boolean removeColectivoRepresentado(Colectivo colectivo) {
        return colectivosRepresentados.remove(colectivo);
    }

    /**
     * Admite a un ciudadano
     */
    public void admitir() {
        setAdmitido(true);
    }

    /**
     * Bloquea a un ciudadano y actualiza sus apoyos
     */
    public void bloquear() {
        Set<Proyecto> aux = new HashSet<>();

        if (isBloqueado()) {
            return;
        }

        setBloqueado(true);

        for (Proyecto p: proyectosApoyados) {
            if (aux.add(p)) {
                p.bloquearApoyo(this);
            }
        }

        for (Colectivo c: colectivos) {
            Colectivo padre = c.getPadre();
            while (padre != null) {
                for (Proyecto p: padre.getProyectosApoyados()) {
                    if (aux.add(p)) {
                        p.bloquearApoyo(this);
                    }
                }
                padre = padre.getPadre();
            }
        }
    }

    /**
     * Desbloquea a un ciudadano y actualiza sus apoyos
     */
    public void desbloquear() {
        Set<Proyecto> aux = new HashSet<>();

        if (!isBloqueado()) {
            return;
        }

        setBloqueado(false);

        for (Proyecto p: proyectosApoyados) {
            if (aux.add(p)) {
                p.recibirApoyo(this);
            }
        }

        for (Colectivo c: colectivos) {
            Colectivo padre = c.getPadre();
            while (padre != null) {
                for (Proyecto p: padre.getProyectosApoyados()) {
                    if (aux.add(p)) {
                        p.recibirApoyo(this, false);    //apoyo indirecto
                    }
                }
                padre = padre.getPadre();
            }
        }
    }
}