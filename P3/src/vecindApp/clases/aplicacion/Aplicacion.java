package vecindApp.clases.aplicacion;

import es.uam.eps.sadp.grants.InvalidIDException;
import vecindApp.clases.colectivo.*;
import vecindApp.clases.notificacion.*;
import vecindApp.clases.proyecto.*;
import vecindApp.clases.usuario.*;


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
    private List<ElementoColectivo> elemCol = new ArrayList<>();
    private List<Proyecto> proyectos = new ArrayList<>();
    private List<Ciudadano> bloqueados = new ArrayList<>();
    private Usuario usuarioActual;
    private Persistencia varStatic;

    /**
     * Inicializa una nueva Aplicacion
     * @param admin el usuario administrador
     */
    public Aplicacion(Administrador admin) {
        this.admin = admin;
    }

    /**
     * Devuelve el usuario administrador de la Aplicacion
     * @return el usuario administrador
     */
    public Administrador getAdmin() {
        return this.admin;
    }

    /**
     * Establece el usuario administrador de la Aplicacion
     * @param admin nuevo administrador
     */
    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    /**
     * Devuelve los elementos de colectivo del sistema
     * @return lista de elementos de colectivo
     */
    public List<ElementoColectivo> getElemCol() {
        return this.elemCol;
    }

    /**
     * Establece una nueva lista de elementos de colectivo
     * @param elemCol nueva lista de elementos
     */
    public void setElemCol(List<ElementoColectivo> elemCol) {
        this.elemCol = elemCol;
    }

    /**
     * Devuelve los proyectos del sistema
     * @return lista de proyectos
     */
    public List<Proyecto> getProyectos() {
        return this.proyectos;
    }

    /**
     * Establece una nueva lista de proyectos
     * @param proyectos nueva lista de proyectos
     */
    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    /**
     * Devuelve los ciudadanos bloqueados del sistema
     * @return lista de ciudadanos bloqueados
     */
    public List<Ciudadano> getBloqueados() {
        return bloqueados;
    }

    /**
     * Establece una nueva lista de ciudadanos bloqueados
     * @param bloqueados nueva lista de bloqueados
     */
    public void setBloqueados(List<Ciudadano> bloqueados) {
        this.bloqueados = bloqueados;
    }

    /**
     * Devuelve el usuario de la sesion actual
     * @return el usuario actual
     */
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    /**
     * Establece el usuario de la sesion actual
     * @param usuarioActual el usuario actual
     */
    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    /**
     * Agrega un ElementoColectivo al sistema. Notifica al amdministrador si
     * procede
     * @param elemCol el elemento a agregar
     * @return true si el elemento es nuevo, false si ya estaba en el sistema
     */
    public boolean addElemCol(ElementoColectivo elemCol) {
        boolean ret = this.elemCol.add(elemCol);

        if (ret && (elemCol instanceof Ciudadano)) {
            notificarRegistro((Ciudadano) elemCol);
        }
        return ret;
    }

    /**
     * Elimina un elemento de los elementos de colectivo del sistema
     * @param elemCol elemento a eliminar
     * @return true si se elimina correctamente, false en caso contrario
     */
    public boolean removeElemCol(ElementoColectivo elemCol) {
        return this.elemCol.remove(elemCol);
    }

    /**
     * Agrega un Proyecto al sistema y notifica al amdministrador
     * @param p el elemento a agregar
     * @return true si el proyecto es nuevo, false si ya estaba en el sistema
     */
    public boolean addProyecto(Proyecto p){
        boolean ret = proyectos.add(p);

        if (ret) {
            notificarNuevoProyecto(p);
        }

        return ret;
    }

    /**
     * Elimina un proyecto de los proyectos del sistema
     * @param p proyecto a eliminar
     * @return true si se elimina correctamente, false en caso contrario
     */
    public boolean removeProyecto(Proyecto p) {
        return proyectos.remove(p);
    }

    /**
     * Agrega un ciudadano a los ciudadanos bloqueados del sistema
     * @param ciudadano ciudadano a agregar
     * @return true si se agrega correctamente, false en caso contrario
     */
    public boolean addBloqueado(Ciudadano ciudadano) {
        return bloqueados.add(ciudadano);
    }

    /**
     * Elimina un ciudadano de los ciudadanos bloqueados del sistema
     * @param ciudadano ciudadano a eliminar
     * @return true si se elimina correctamente, false en caso contrario
     */
    public boolean removeBloqueado(Ciudadano ciudadano) {
        return bloqueados.remove(ciudadano);
    }

    /**
     * Busca un colectivo por nombre
     * @param nombre el nombre del colectivo
     * @return el colectivo buscado, null en caso de error
     */
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

    /**
     * Busca un ciudadano por nombre de usuario
     * @param username el nombre del ciudadano
     * @return el ciudadano buscado, null en caso de error
     */
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

    /**
     * Busca un proyecto por id
     * @param id el identificador del proyecto
     * @return el proyecto buscado, null en caso de error
     */
    public Proyecto findProyecto(int id) {
        for (Proyecto p:proyectos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    /**
     * Notifica al administrador de una nueva solicitud de registro
     * @param c el ciudadano que solicita el registro
     */
    public void notificarRegistro(Ciudadano c) {
        admin.agregarNotificacion(new NotificacionReg(c));
    }

    /**
     * Notifica al administrador de un nuevo proyecto
     * @param p el proyecto a evaluar
     */
    public void notificarNuevoProyecto(Proyecto p) {
        admin.agregarNotificacion(new NotificacionProy(p));
    }

    /**
     * Genera el informe de afinidad entre dos colectivos en funcion de los
     * apoyos a las propuestas del otro.
     * Devuelve un valor entre 0 y 1, donde 0 significa que no son afines
     * y 1 que son muy afines
     * @param c1 el primer colectivo
     * @param c2 el segundo colectivo
     * @return el informe de afinidad entre c1 y c2
     */
    public double generarInformeAfinidad(Colectivo c1, Colectivo c2) {
        int n1, n2, a1 = 0, a2 = 0;
        Set<Proyecto> apoyados;

        n1 = c1.getProyectos().size();
        n2 = c2.getProyectos().size();

        if (n1 + n2 == 0) {
            return 0; //Definimos que no son afines si no tienen proyectos
        }

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

    /**
     * Almacena todos los objetos y variables del sistema en un fichero
     * @param path el path de fichero de destino
     */
    public void guardar(String path) {
        varStatic = new Persistencia(); //Guarda el valor actual de las variables estaticas del sistema
        try {
            ObjectOutputStream sal = new ObjectOutputStream(new FileOutputStream(path));
            sal.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga todos los objetos y variables del sistema desde fichero
     * @param path el path de origen
     * @return la Aplicacion leida
     * @throws IOException en caso de error de E/S
     * @throws ClassNotFoundException en caso de error con la declaracion de clases
     * @throws InvalidIDException en caso de error en la consulta al sistema externo de financiacion
     */
    public Aplicacion cargar(String path) throws IOException, ClassNotFoundException, InvalidIDException {
        ObjectInputStream ent = new ObjectInputStream(new FileInputStream(path));
        Aplicacion app = (Aplicacion) ent.readObject();
        Date curr = new Date();
        app.varStatic.setValues();
        //Comprobando caducidad y financiacion de proyectos
        for (Proyecto p : app.proyectos) {
            if ((curr.getTime() - p.getUltimoApoyo().getTime())/1000.0 > 30 * 24 * 3600) { //30 dias en segundos
                p.caducar();
            }
            if (p.getEstado() == EstadoProyecto.ENVIADO) {
                p.consultarFinanciacion();
            }
        }
        return app;
    }
}