package vecindApp.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private List<Colectivo> colectivosRepresentados;

    public Ciudadano(String username, String password, String nif) {
        super(username, password);
        this.nif = nif;
        this.admitido = false;
        this.bloqueado = false;
        proyectos = new ArrayList<>();
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

    public List<Colectivo> getColectivosRepresentados() {
        return colectivosRepresentados;
    }

    public void setColectivosRepresentados(List<Colectivo> colectivosRepresentados) {
        this.colectivosRepresentados = colectivosRepresentados;
    }

    public boolean addProyecto(Proyecto p) {
        return proyectos.add(p);
    }

    public boolean remveProyecto(Proyecto p) {
        return proyectos.remove(p);
    }

    public boolean addColectivoRepresentado(Colectivo c) {
        return colectivosRepresentados.add(c);
    }

    public boolean removeColectivoRepresentado(Colectivo c) {
        return colectivosRepresentados.remove(c);
    }

    public void bloquear() {
        setBloqueado(true);
    }

    public void desbloquear() {
        setBloqueado(false);
    }

    public void admitir() {
        setAdmitido(true);
    }
}