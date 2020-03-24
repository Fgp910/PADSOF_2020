package vecindApp.clases;

import java.io.*;
import java.util.*;

public class Aplicacion implements Serializable {
    public static int minApoyos;

    private Administrador admin;
    private List<ElementoColectivo> elemCol;
    private List<Proyecto> proyectos;
    private Usuario usuarioAcutal;
    private Persistencia varStatic;

    public Aplicacion(Administrador admin) {
        this.admin = admin;
        elemCol = new ArrayList<>();
        proyectos = new ArrayList<>();
    }

    public Administrador getAdmin() {
        return this.admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public List<ElementoColectivo> getElemCol() {
        return this.elemCol;
    }

    public void setElemCol(List<ElementoColectivo> elemCol) {
        this.elemCol = elemCol;
    }

    public List<Proyecto> getProyectos() {
        return this.proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Usuario getUsuarioAcutal() {
        return usuarioAcutal;
    }

    public void setUsuarioAcutal(Usuario usuarioAcutal) {
        this.usuarioAcutal = usuarioAcutal;
    }

    public boolean addElemCol(ElementoColectivo elemCol) {
        return this.elemCol.add(elemCol);
    }

    public boolean removeElemCol(ElementoColectivo elemCol) {
        return this.elemCol.remove(elemCol);
    }

    public boolean addProyecto(Proyecto p){
        return proyectos.add(p);
    }

    public boolean removeProyecto(Proyecto p) {
        return proyectos.remove(p);
    }

    public Colectivo findColectivo(String nombre) {
        for (ElementoColectivo c:elemCol) {
            if (c instanceof Colectivo) {
                if (nombre.equals(((Colectivo) c).getNombre())) {
                    return (Colectivo)c;
                }
            }
        }
        return null;
    }

    public Ciudadano findCiudadano(String username) {
        for (ElementoColectivo c:elemCol) {
            if (c instanceof Ciudadano) {
                if (username.equals(((Ciudadano) c).getUsername())) {
                    return (Ciudadano)c;
                }
            }
        }
        return null;
    }

    public Proyecto findProyecto(int id) {
        for (Proyecto p:proyectos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void notificarRegistro(Ciudadano c) {
        admin.agregarNotificacion(new NotificacionReg(c));
    }

    public void notificarNuevoProyecto(Proyecto p) {
        admin.agregarNotificacion(new NotificacionProy(p));
    }

    public double generarInformeAfinidad(Colectivo c1, Colectivo c2) {
        int a1 = 0;
        int a2 = 0;
        
        return 0;
    }

    public void guardar(String path) {
        varStatic = new Persistencia(); //Guarda el valor actual de las variables estaticas del sistema
        try {
            ObjectOutputStream sal = new ObjectOutputStream(new FileOutputStream(path));
            sal.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Aplicacion cargar(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream ent = new ObjectInputStream(new FileInputStream(path));
        return (Aplicacion) ent.readObject();
    }
}