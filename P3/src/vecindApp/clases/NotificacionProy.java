package vecindApp.clases;

public class NotificacionProy extends Notificacion {
    private Proyecto sujeto;

    public NotificacionProy(Proyecto sujeto) {
        this.sujeto = sujeto;
    }

    public Proyecto getSujeto() {
        return sujeto;
    }

    public void setSujeto(Proyecto s) {
        sujeto = s;
    }
}
