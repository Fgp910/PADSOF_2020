package vecindApp.clases;

import java.io.Serializable;
import java.util.List;

public interface ElementoColectivo extends Serializable {
    public abstract List<Proyecto> getProyectos();
}