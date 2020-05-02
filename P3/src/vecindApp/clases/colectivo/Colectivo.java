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
    private Set<ElementoColectivo> elementos = new TreeSet<>();
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
     * Devuelve los proyectos apoyados por un colectivo
     * @return set de proyectos apoyados
     */
    public Set<Proyecto> getProyectosApoyados() {
        return proyectosApoyados;
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

    /**
     * Genera el informe de afinidad entre dos colectivos en funcion de los
     * apoyos a las propuestas del otro.
     * Devuelve un valor entre 0 y 1, donde 0 significa que no son afines
     * y 1 que son muy afines
     * @param c2 el segundo colectivo
     * @return el informe de afinidad entre los colectivos
     */
    public double generarInformeAfinidad(Colectivo c2) {
        int n1, n2, a1 = 0, a2 = 0;
        Set<Proyecto> apoyados;

        n1 = getProyectos().size();
        n2 = c2.getProyectos().size();

        if (n1 + n2 == 0) {
            return 0; //Definimos que no son afines si no tienen proyectos
        }

        apoyados = c2.getProyectosApoyados();
        for (Proyecto p:getProyectos()) {
            if (apoyados.contains(p)) {
                a1++;
            }
        }
        apoyados = getProyectosApoyados();
        for (Proyecto p:c2.getProyectos()) {
            if (apoyados.contains(p)) {
                a2++;
            }
        }

        return ((double)(a1 + a2)) / (n1 + n2);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Colectivo) {
            return this.nombre.equals(((Colectivo)o).nombre);
        }
        return false;
    }

    @Override
    public int compareTo(ElementoColectivo t) {
        if (t instanceof Colectivo) {
            return nombre.compareTo(((Colectivo)t).nombre);
        }
        return -1;
    }

    @Override
    public String toString() {
        return nombre;
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