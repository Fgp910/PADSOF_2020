public abstract class Notificacion {
    private Object sujeto;

    public Notificacion(Object sujeto) {
        sujeto = sujeto; 
    }

    public Object getSujeto() {
        return sujeto;
    }

    public void setSujeto(Object s) {
        sujeto = s;
    }
}