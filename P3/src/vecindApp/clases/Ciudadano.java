package vecindApp.clases;

import java.util.List;

/**
 * Define la clase Ciudadano, que agrega a la clase Usuario los atributos
 * y metodos propios de un ciudadano.
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
        proyectos = new List<Proyecto>();
        colectivosRepresentados = new List<Proyecto>();
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

    public void desbloquear() {
        this.setBloqueado(false);
    }

    public void admitir() {
        this.setAdmitido(true);
    }
}