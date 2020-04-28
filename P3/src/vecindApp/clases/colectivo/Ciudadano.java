package vecindApp.clases.colectivo;

import vecindApp.clases.proyecto.*;
import vecindApp.clases.usuario.*;

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
    public static final int NIF_LEN = 9;

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
     * Devuelve el set de proyectos apoyados por un ciudadano
     * @return set de proyectos apoyados
     */
    public Set<Proyecto> getProyectosApoyados() {
        return proyectosApoyados;
    }

    /**
     * Devuelve los colectivos a los que pertenece un ciudadano
     * @return set de colectivos
     */
    public Set<Colectivo> getColectivos() {
        return colectivos;
    }

    /**
     * Devuelve los colectivos representados por un ciudadano
     * @return lista de colectivos representados
     */
    public List<Colectivo> getColectivosRepresentados() {
        return colectivosRepresentados;
    }

    /**
     * Agrega un nuevo proyecto propuesto a un ciudadano
     * @param proyecto proyecto a Agregar
     * @return true si se agrega correctamente, false en otro caso
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
     * Agrega un nuevo proyecto apoyado a un ciudadano
     * @param proyecto proyecto a Agregar
     * @return true si se agrega correctamente, false en otro caso
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
     * Agrega un colectivo al conjunto de un ciudadano
     * @param colectivo colectivo a Agregar
     * @return true si se agrega correctamente, false en otro caso
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
     * Agrega un colectivo representado a un ciudadano
     * @param colectivo colectivo a Agregar
     * @return true si se agrega correctamente, false en otro caso
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

    @Override
    public boolean equals(Object o) {
        if (o instanceof Ciudadano) {
            return this.nif.equals(((Ciudadano)o).nif) || this.getUsername().equals(((Ciudadano)o).getUsername());
        }
        return false;
    }

    @Override
    public int compareTo(ElementoColectivo t) {
        int d;

        if (t instanceof Ciudadano) {
            Ciudadano c = (Ciudadano)t;

            if ((d = getUsername().compareTo(c.getUsername())) != 0) {
                return d;
            }
            return nif.compareTo(c.nif);
        }
        return 1;
    }
}