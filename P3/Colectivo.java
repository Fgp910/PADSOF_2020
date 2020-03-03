import java.util.*;

public class Colectivo implements ElementoColectivo {
    private String nombre;
    private HashSet elementos;

    public Colectivo(String nombre) {
        this.nombre = nombre;
    }

    public boolean addElemento(ElementoColectivo elemento) {
        return elementos.add(elemento);
    }

    public boolean removeElemento(ElementoColectivo elemento) {
        return elementos.remove(elemento);
    }

    public void apoyar(Proyecto proyecto) {

    }
}