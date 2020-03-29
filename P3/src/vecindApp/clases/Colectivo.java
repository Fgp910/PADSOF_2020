package vecindApp.clases;

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
    private Set<ElementoColectivo> elementos;
    private Set<Proyecto> proyectos;
    private Set<Proyecto> proyectosApoyados;
    private Colectivo padre;

    public Colectivo(String nombre, Ciudadano representante) {
        this.nombre = nombre;
        this.representante = representante;
        elementos = new HashSet<>();
        proyectos = new HashSet<>();
        proyectosApoyados = new HashSet<>();
        padre = null;
        addElemento(representante);
        representante.addColectivo(this);
        representante.addColectivoRepresentado(this);
    }

    public Colectivo(String nombre, Colectivo padre) {
        this(nombre,padre.representante);
        this.padre = padre;
        this.padre.addElemento(this);
    }

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<ElementoColectivo> getElementos() {
		return elementos;
	}

	public void setElementos(HashSet<ElementoColectivo> elementos) {
		this.elementos = elementos;
	}

    public Ciudadano getRepresentante() {
        return representante;
    }

    public void setRepresentante(Ciudadano representante) {
        this.representante = representante;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Set<Proyecto> getProyectosApoyados() {
        return proyectosApoyados;
    }

    public void setProyectosApoyados(Set<Proyecto> proyectosApoyados) {
        this.proyectosApoyados = proyectosApoyados;
    }

    public Colectivo getPadre() {
        return padre;
    }

    public void setPadre(Colectivo padre) {
        this.padre = padre;
    }

    public boolean addElemento(Ciudadano ciudadano) {
        Colectivo c = this;

        if (perteneceHijos(ciudadano) || !elementos.add(ciudadano)) {
            return false;
        }

        for (Proyecto p: proyectosApoyados) {
            p.recibirApoyo(ciudadano, false);
        }

        while (c.padre != null) { //Un ciudadano no puede pertenecer al padre y al hijo simultaneamente
            c = c.padre;
            c.removeElemento(ciudadano);
            for (Proyecto p: c.proyectos) {
                p.recibirApoyo(ciudadano);  //Actualiza los proyectos apoyados por supercolectivos
            }
        }

        return true;
    }

    public boolean addElemento(Colectivo colectivo) {
        return elementos.add(colectivo);
    }

    public boolean removeElemento(ElementoColectivo elemento) {
        return elementos.remove(elemento);
    }

    public boolean addProyecto(Proyecto proyecto) {
        return proyectos.add(proyecto);
    }

    public boolean removeProyecto(Proyecto proyecto) {
        return proyectos.remove(proyecto);
    }

    public boolean addProyectoApoyado(Proyecto proyecto) {
        return  proyectosApoyados.add(proyecto);
    }

    public boolean removeProyectoApoyado(Proyecto proyecto) {
        return proyectosApoyados.remove(proyecto);
    }

    /*Metodos privados*/
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