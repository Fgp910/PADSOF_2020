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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public boolean isAdmitido() {
        return admitido;
    }

    public void setAdmitido(boolean admitido) {
        this.admitido = admitido;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
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

    public Set<Colectivo> getColectivos() {
        return colectivos;
    }

    public void setColectivos(Set<Colectivo> colectivos) {
        this.colectivos = colectivos;
    }

    public List<Colectivo> getColectivosRepresentados() {
        return colectivosRepresentados;
    }

    public void setColectivosRepresentados(List<Colectivo> colectivosRepresentados) {
        this.colectivosRepresentados = colectivosRepresentados;
    }

    public boolean addProyecto(Proyecto proyecto) {
        return proyectos.add(proyecto);
    }

    public boolean removeProyecto(Proyecto proyecto) {
        return proyectos.remove(proyecto);
    }

    public boolean addProyectoApoyado(Proyecto proyecto) {
        return proyectosApoyados.add(proyecto);
    }

    public boolean removeProyectoApoyado(Proyecto proyecto) {
        return proyectosApoyados.remove(proyecto);
    }

    public boolean addColectivo(Colectivo colectivo) {
        return colectivos.add(colectivo);
    }

    public boolean removeColectivo(Colectivo colectivo) {
        return colectivos.remove(colectivo);
    }

    public boolean addColectivoRepresentado(Colectivo colectivo) {
        return colectivosRepresentados.add(colectivo);
    }

    public boolean removeColectivoRepresentado(Colectivo colectivo) {
        return colectivosRepresentados.remove(colectivo);
    }

    public void admitir() {
        setAdmitido(true);
    }

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