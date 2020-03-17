package vecindApp.clases;

import java.util.ArrayList;

public class Aplicacion {
    private Administrador admin;
    private ArrayList<ElementoColectivo> elemCol;
    private ArrayList<Proyecto> proyectos;

    public Aplicacion(Administrador admin) {
        this.admin = admin;
        elemCol = new ArrayList<ElementoColectivo>();
        proyectos = new ArrayList<Proyecto>();
    }

    public Administrador getAdmin() {
        return this.admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public ArrayList<ElementoColectivo> getElemCol() {
        return this.elemCol;
    }

    public void setElemCol(ArrayList<ElementoColectivo> elemCol) {
        this.elemCol = elemCol;
    }

    public ArrayList<Proyecto> getProyectos() {
        return this.proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
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
                if (username.equals(((Ciudadano)c).getUsername())) {
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
        admin.agregarNotificacion(c);
    }

    public void notificarNuevoProyecto(Proyecto p) {
        admin.agregarNotificacion(p);
    }

    public double generarInformeAfinidad(Colectivo c1, Colectivo c2) {
        ArrayList<Proyecto> p1 = c1.getProyectos();
        ArrayList<Proyecto> p2 = c2.getProyectos();
        int a1 = 0, a2 = 0, n1 = p1.size(), n2 = p2.size();

        for (Proyecto p:p1) {
            if (p.esApoyado(c2)) {
                a1++;
            }
        }
        for (Proyecto p:p2) {
            if (p.esApoyado(c1)) {
                a2++;
            }
        }

        return (a1+a2)/((double)(n1+n2));
    }
}