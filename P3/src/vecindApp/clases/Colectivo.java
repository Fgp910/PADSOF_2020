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
        padre = null;
    }

    public Colectivo(String nombre, Ciudadano representante, Colectivo padre) {
        this.nombre = nombre;
        this.representante = representante;
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

    public boolean addElemento(Ciudadano ciudadano) {
        Colectivo c = this;

        if (comprobarHijos(ciudadano) == false) {
            return false;
        }

        boolean ret =  elementos.add((ElementoColectivo)ciudadano);
        if (!ret) {
            return ret;
        }

        for (Proyecto p:proyectos) {
            p.recibirApoyo(ciudadano);
        }

        while (c.padre != null) {
            c = c.padre;
            c.elementos.remove((ElementoColectivo)ciudadano);
            for (Proyecto p:c.proyectos) {
                p.recibirApoyo(ciudadano);
            }
        }

        return ret;
    }

    public boolean addElemento(Colectivo colectivo) {
        return elementos.add((ElementoColectivo) colectivo);
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

    /*Métodos privados*/
    private boolean comprobarHijos(Ciudadano ciudadano) {
        if (elementos.contains((ElementoColectivo)ciudadano)) {
            return false;
        }

        for (ElementoColectivo ec:elementos) {
            if (ec instanceof Colectivo) {
                if (((Colectivo)ec).comprobarHijos(ciudadano) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}