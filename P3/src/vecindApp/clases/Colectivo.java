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
    private List<Proyecto> proyectos;
    private Set<Proyecto> proyectosApoyados;
    private Colectivo padre;

    public Colectivo(String nombre, Ciudadano representante) {
        this.nombre = nombre;
        this.representante = representante;
        elementos = new HashSet<>();
        elementos.add(representante);
        proyectos = new ArrayList<>();
        proyectosApoyados = new HashSet<>();
        padre = null;
    }

    public Colectivo(String nombre, Colectivo padre) {
        this.nombre = nombre;
        this.representante = padre.representante;
        elementos = new HashSet<>();
        elementos.add(representante);
        proyectos = new ArrayList<>();
        proyectosApoyados = new HashSet<>();
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

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
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

    public boolean addElemento(ElementoColectivo elemento) {
        return elementos.add(elemento);
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
}