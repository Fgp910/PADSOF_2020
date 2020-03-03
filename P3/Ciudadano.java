import java.util.*;

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

    public void aceptar() {
        this.setAdmitido(true);
    }

    public void rechazar() {
        this.finalize();
    }

    public void apoyar(Proyecto proyecto) {

    }

    public void actualizarProyecto() {

    }
}