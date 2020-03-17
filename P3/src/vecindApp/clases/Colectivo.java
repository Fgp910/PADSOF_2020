package src.vecindApp.clases;

import java.util.*;

public class Colectivo implements ElementoColectivo {
    private String nombre;
    private Ciudadano representante;
    private HashSet<ElementoColectivo> elementos;
    private ArrayList<Proyecto> proyectos;

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

	public HashSet<ElementoColectivo> getElementos() {
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

    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
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

    public void apoyar(Proyecto proyecto) {

    }
}