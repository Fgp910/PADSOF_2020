
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

    public Ciudadano(String username, String password, String nif) {
        super(username, password);
        this.nif = nif;
        this.admitido = false;
    }

    public String getNif() {
        return nif;
    }

    public boolean getAdmitido() {
        return admitido;
    }

    public boolean getBloqueado() {
        return bloqueado;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setAdmitido(boolean admitido) {
        this.admitido = admitido;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public void bloquear() {
        this.setBloqueado(true);
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