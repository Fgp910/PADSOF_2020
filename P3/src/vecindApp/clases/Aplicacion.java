package vecindApp.clases;

import java.io.*;
import java.util.*;

/**
 * Define la clase Aplicacion que contiene y gestiona los distintos
 * objetos del sistema.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Aplicacion implements Serializable {
    public static int minApoyos;

    private Administrador admin;
    private List<ElementoColectivo> elemCol;
    private List<Proyecto> proyectos;
    private List<Ciudadano> bloqueados;
    private Usuario usuarioAcutal;
    private Persistencia varStatic;

    public Aplicacion(Administrador admin) {
        this.admin = admin;
        elemCol = new ArrayList<>();
        proyectos = new ArrayList<>();
        bloqueados = new ArrayList<>();
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

    public List<Ciudadano> getBloqueados() {
        return bloqueados;
    }

    public void setBloqueados(List<Ciudadano> bloqueados) {
        this.bloqueados = bloqueados;
    }

    public Usuario getUsuarioAcutal() {
        return usuarioAcutal;
    }

    public void setUsuarioAcutal(Usuario usuarioAcutal) {
        this.usuarioAcutal = usuarioAcutal;
    }

    public boolean addElemCol(ElementoColectivo elemCol) {
        if (elemCol instanceof Ciudadano) {
            admin.agregarNotificacion(new NotificacionReg((Ciudadano) elemCol));
        }
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

    public boolean addBloqueado(Ciudadano ciudadano) {
        return bloqueados.add(ciudadano);
    }

    public boolean removeBloqueado(Ciudadano ciudadano) {
        return bloqueados.remove(ciudadano);
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
        int n1, n2, a1 = 0, a2 = 0;
        Set<Proyecto> apoyados;

        n1 = c1.getProyectos().size();
        n2 = c2.getProyectos().size();

        apoyados = c2.getProyectosApoyados();
        for (Proyecto p:c1.getProyectos()) {
            if (apoyados.contains(p)) {
                a1++;
            }
        }
        apoyados = c1.getProyectosApoyados();
        for (Proyecto p:c2.getProyectos()) {
            if (apoyados.contains(p)) {
                a2++;
            }
        }

        return ((double)(a1 + a2)) / (n1 + n2);
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
        Aplicacion app = (Aplicacion) ent.readObject();
        Date curr = new Date();
        app.varStatic.setValues();
        //Comprobando caducidad de proyectos
        for (Proyecto p : app.proyectos) {
            if (curr.getTime() - p.getUltimoApoyo().getTime() > 30*24*60*60*1000) { //30 dias en milisegundos
                p.setCaducado(true);
            }
        }
        return app;
    }
}