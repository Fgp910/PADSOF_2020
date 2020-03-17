package vecindApp.clases;

import java.util.ArrayList;

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
    private ArrayList<Proyecto> proyectos;
    private ArrayList<Colectivo> colectivosRepresentados;

    public Ciudadano(String username, String password, String nif) {
        super(username, password);
        this.nif = nif;
        this.admitido = false;
        this.bloqueado = false;
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

    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public ArrayList<Colectivo> getColectivosRepresentados() {
        return colectivosRepresentados;
    }

    public void setColectivosRepresentados(ArrayList<Colectivo> colectivosRepresentados) {
        this.colectivosRepresentados = colectivosRepresentados;
    }

    public void desbloquear() {
        this.setBloqueado(false);
    }

    public void admitir() {
        this.setAdmitido(true);
    }

    /**
     * Implementa el metodo apoyar de la interfaz ElemetoColectivo
     * para la clase Ciudadano.
     * 
     * @param p El proyecto a apoyar.
     */
    public void apoyar(Proyecto p) {
    	p.recibirApoyo(this);
    }
}