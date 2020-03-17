package vecindApp.clases;

import java.util.ArrayList;

public class ProyectoInfraestructura extends Proyecto {
    private String imagen;
    private ArrayList<Distrito> afectados;

    public ProyectoInfraestructura(String descripcion, double importeSolicitado, Ciudadano propulsor, String img) {
        super(descripcion, importeSolicitado, propulsor);
        imagen = img;
        afectados = new ArrayList<Distrito>();
    }

    public String getImagen() {
        return imagen;
    }
    
    public void setImagen(String img) {
        imagen = img;
    }

    public ArrayList<Distrito> getAfectados() {
        return afectados;
    }
    
    public void setAfectados(ArrayList<Distrito> af) {
        afectados = af;
    }
}