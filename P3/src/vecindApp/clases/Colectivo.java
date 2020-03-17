package vecindApp.clases;

import java.util.*;

public class Colectivo implements ElementoColectivo {
    private String nombre;
    private HashSet<ElementoColectivo> elementos;

    public Colectivo(String nombre) {
        this.nombre = nombre;
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

	public boolean addElemento(ElementoColectivo elemento) {
        return elementos.add(elemento);
    }

    public boolean removeElemento(ElementoColectivo elemento) {
        return elementos.remove(elemento);
    }

    public void apoyar(Proyecto proyecto) {

    }
}