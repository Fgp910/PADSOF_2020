package vecindApp.clases;

import java.io.Serializable;
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
    private List<Proyecto> proyectos;
    private Set<Proyecto> proyectosApoyados;
    private Set<Colectivo> colectivos;
    private List<Colectivo> colectivosRepresentados;

    public Ciudadano(String username, String password, String nif) {
        super(username, password);
        this.nif = nif;
        this.admitido = false;
        this.bloqueado = false;
        proyectos = new ArrayList<>();
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

    public boolean remveProyecto(Proyecto proyecto) {
        return proyectos.remove(proyecto);
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

    public boolean addProyectoApoyado(Proyecto proyecto) {
        return proyectosApoyados.add(proyecto);
    }

    public boolean removeProyectoApoyado(Proyecto proyecto) {
        return proyectosApoyados.remove(proyecto);
    }

    public void bloquear() {
        Set<Proyecto> buffer = new HashSet<Proyecto>();

        if (isBloqueado() == true) {
            return;
        }

        setBloqueado(true);

        for (Proyecto p:proyectos) {
            if (buffer.add(p)) {
                p.setnBloqueados(p.getnBloqueados() + 1);
            }
        }
        for (Proyecto p:proyectosApoyados) {
            if (buffer.add(p)) {
                p.setnBloqueados(p.getnBloqueados() + 1);
            }
        }
        for (Colectivo c:colectivos) {
            Colectivo actual = c;

            do {
                for (Proyecto p:actual.getProyectos()) {
                    if (buffer.add(p)) {
                        p.setnBloqueados(p.getnBloqueados() + 1);
                    }
                }
            } while ((actual = actual.getPadre()) != null);
        }
    }

    public void desbloquear() {
        Set<Proyecto> buffer = new HashSet<Proyecto>();

        if (isBloqueado() == false) {
            return;
        }

        setBloqueado(false);

        for (Proyecto p:proyectos) {
            if (buffer.add(p)) {
                p.setnBloqueados(p.getnBloqueados() - 1);
            }
        }
        for (Proyecto p:proyectosApoyados) {
            if (buffer.add(p)) {
                p.setnBloqueados(p.getnBloqueados() - 1);
            }
        }
        for (Colectivo c:colectivos) {
            Colectivo actual = c;

            do {
                for (Proyecto p:actual.getProyectos()) {
                    if (buffer.add(p)) {
                        p.setnBloqueados(p.getnBloqueados() - 1);
                    }
                }
            } while ((actual = actual.getPadre()) != null);
        }
    }

    public void admitir() {
        setAdmitido(true);
    }
}