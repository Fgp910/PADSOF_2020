package vecindApp.clases;

import java.util.*;

public class Colectivo implements ElementoColectivo {
    private String nombre;
    private Ciudadano representante;
    private Set<ElementoColectivo> elementos;
    private List<Proyecto> proyectos;

    public Colectivo(String nombre, Ciudadano representante) {
        this.nombre = nombre;
        this.representante = representante;
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
}