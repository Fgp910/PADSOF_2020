package vecindApp.clases.colectivo;

import vecindApp.clases.proyecto.*;

import java.util.*;

/**
 * Define la clase Colectivo, que implementa la interfaz ElementoColectivo y
 * gestiona sus Ciudadanos miembros y subcolectivos (todos ElementoColectivo).
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Colectivo implements ElementoColectivo {
    private String nombre;
    private Ciudadano representante;
    private Set<ElementoColectivo> elementos = new HashSet<>();
    private Set<Proyecto> proyectos = new HashSet<>();
    private Set<Proyecto> proyectosApoyados = new HashSet<>();
    private Colectivo padre;

    /**
     * Inicializa un nuevo colectivo
     * @param nombre nombre del colectivo
     * @param representante ciudadano representante del colectivo
     */
    public Colectivo(String nombre, Ciudadano representante) {
        this.nombre = nombre;
        this.representante = representante;
        padre = null;
        addElemento(representante);
        representante.addColectivo(this);
        representante.addColectivoRepresentado(this);
    }

    /**
     * Inicializa un nuevo subcolectivo
     * @param nombre nombre del subcolectivo
     * @param padre colectivo padre
     */
    public Colectivo(String nombre, Colectivo padre) {
        this(nombre,padre.representante);
        this.padre = padre;
        this.padre.addElemento(this);
    }

    /**
     * Devuleve el nombre de un colectivo
     * @return nombre del colectivo
     */
    public String getNombre() {
		return nombre;
	}

    /**
     * Establece el nombre de un colectivo
     * @param nombre nuevo nombre
     */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    /**
     * Devuelve los elementos de un colectivo (ciudadanos y subcolectivos)
     * @return set de elementos del colectivo
     */
	public Set<ElementoColectivo> getElementos() {
		return elementos;
	}

    /**
     * Establece un nuevo conjunto de elementos del colectivo
     * @param elementos nuevo set de elementos
     */
	public void setElementos(Set<ElementoColectivo> elementos) {
		this.elementos = elementos;
	}

    /**
     * Devuelve el representante de un colectivo
     * @return ciudadano representante
     */
    public Ciudadano getRepresentante() {
        return representante;
    }

    /**
     * Establece el representante de un colectivo
     * @param representante nuevo representante
     */
    public void setRepresentante(Ciudadano representante) {
        this.representante = representante;
    }

    /**
     * Devuelve los proyectos propuestos por un colectivo
     * @return set de proyectos
     */
    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    /**
     * Establece un nuevo conjunto de proyectos propuestos para un colectivo
     * @param proyectos nuevo set de proyectos
     */
    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    /**
     * Devuelve los proyectos apoyados por un colectivo
     * @return set de proyectos apoyados
     */
    public Set<Proyecto> getProyectosApoyados() {
        return proyectosApoyados;
    }

    /**
     * Establece un nuevo conjunto de proyectos apoyados para un colectivo
     * @param proyectosApoyados nuevo set de proyectos apoyados
     */
    public void setProyectosApoyados(Set<Proyecto> proyectosApoyados) {
        this.proyectosApoyados = proyectosApoyados;
    }

    /**
     * Devuelve el padre de un colectivo
     * @return colectivo padre, null si no hubiese
     */
    public Colectivo getPadre() {
        return padre;
    }

    /**
     * Establece un nuevo colectivo padre
     * @param padre nuevo colectivo padre
     */
    public void setPadre(Colectivo padre) {
        this.padre = padre;
    }

    /**
     * Agrega un ciudadano a los elementos del colectivo
     * @param ciudadano nuevo ciudadano
     * @return true si se agrega correctamente, false en caso contrario
     */
    public boolean addElemento(Ciudadano ciudadano) {
        Colectivo c = this;

        if (perteneceHijos(ciudadano) || !elementos.add(ciudadano)) {
            return false;
        }

        ciudadano.addColectivo(this);

        for (Proyecto p: proyectosApoyados) {
            p.recibirApoyo(ciudadano, false);
        }

        while (c.padre != null) { //Un ciudadano no puede pertenecer al padre y al hijo simultaneamente
            c = c.padre;
            c.removeElemento(ciudadano);
            ciudadano.removeColectivo(c);
            for (Proyecto p: c.proyectos) {
                p.recibirApoyo(ciudadano);  //Actualiza los proyectos apoyados por supercolectivos
            }
        }

        return true;
    }

    /**
     * Agrega un subcolectivo a los elementos de un colectivo
     * @param colectivo nuevo subcolectivo
     * @return true si se agrega correctamente, false en caso contrario
     */
    public boolean addElemento(Colectivo colectivo) {
        return elementos.add(colectivo);
    }

    /**
     * Elimina un elemento del colectivo
     * @param elemento elemento a eliminar
     * @return true si se elimina correctamente, false en caso contrario
     */
    public boolean removeElemento(ElementoColectivo elemento) {
        return elementos.remove(elemento);
    }

    /**
     * Agrega un proyecto propuesto a un colectivo
     * @param proyecto proyecto a agregar
     * @return true si se agrega correctamente, false en caso contrario
     */
    public boolean addProyecto(Proyecto proyecto) {
        return proyectos.add(proyecto);
    }

    /**
     * Elimina un proyecto de la lista de propuestos
     * @param proyecto proyecto a eliminar
     * @return true si se elimina correctamente, false en caso contrario
     */
    public boolean removeProyecto(Proyecto proyecto) {
        return proyectos.remove(proyecto);
    }

    /**
     * agrega un proyecto al conjunto de apoyados del colectivo
     * @param proyecto nuevo proyecto apoyado
     * @return true si se agrega correctamente, false en caso contrario
     */
    public boolean addProyectoApoyado(Proyecto proyecto) {
        return  proyectosApoyados.add(proyecto);
    }

    /**
     * Elimina un proyecto del conjunto de apoyados del colectivo
     * @param proyecto proyecto a eliminar
     * @return true si se elimina correctamente, false en caso contrario
     */
    public boolean removeProyectoApoyado(Proyecto proyecto) {
        return proyectosApoyados.remove(proyecto);
    }

    /*Metodos privados*/

    /**
     * Comprueba si un ciudadano pertenece a los hijos de un colectivo
     * @param ciudadano ciudadano a comprobar
     * @return true si pertenece, false en caso contrario
     */
    private boolean perteneceHijos(Ciudadano ciudadano) {
        if (elementos.contains(ciudadano)) {
            return true;
        }

        for (ElementoColectivo ec:elementos) {
            if (ec instanceof Colectivo) {
                if (((Colectivo) ec).perteneceHijos(ciudadano)) {
                    return true;
                }
            }
        }

        return false;
    }
}