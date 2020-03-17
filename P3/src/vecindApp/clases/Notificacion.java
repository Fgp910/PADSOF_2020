package vecindApp.clases;

public class Notificacion {
  private Object sujeto;

  public Notificacion(Object sujeto) {
      this.sujeto = sujeto; 
  }

  public Object getSujeto() {
      return sujeto;
  }

  public void setSujeto(Object s) {
      sujeto = s;
  }
}