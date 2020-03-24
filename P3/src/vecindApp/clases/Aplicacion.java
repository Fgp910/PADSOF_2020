package vecindApp.clases;

import java.util.*;

public class Aplicacion {
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

    public void guardar() {

    }
}