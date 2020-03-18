package vecindApp.clases;

public class NotificacionReg extends Notificacion {
    private Ciudadano sujeto;

    public NotificacionReg(Ciudadano sujeto) {
        this.sujeto = sujeto;
    }

    public Ciudadano getSujeto() {
        return sujeto;
    }

    public void setSujeto(Ciudadano s) {
        sujeto = s;
    }
}
