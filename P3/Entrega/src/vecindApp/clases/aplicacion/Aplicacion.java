package vecindApp.clases.aplicacion;

import vecindApp.clases.colectivo.*;
import vecindApp.clases.excepciones.CCGGException;
import vecindApp.clases.excepciones.ConexionFallida;
import vecindApp.clases.notificacion.*;
import vecindApp.clases.proyecto.*;
import vecindApp.clases.usuario.*;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Define la clase Aplicacion que contiene y gestiona los distintos
 * objetos del sistema.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public class Aplicacion implements Serializable {
    public static Aplicacion VecindApp = new Aplicacion(new Administrador("admin", "password"));
    public static String PATH = "vecindapp_bin.dat";

    private static int minApoyos = 2;   //Valor por defecto
    private static LocalDate NOW = LocalDate.now();

    private Administrador admin;
    private Set<ElementoColectivo> elemCol = new TreeSet<>();
    private Set<Proyecto> proyectos = new TreeSet<>();
    private Set<Ciudadano> bloqueados = new TreeSet<>();
    private Usuario usuarioActual;
    private Persistencia varStatic;

    /**
     * Inicializa una nueva Aplicacion
     * @param admin el usuario administrador
     */
    private Aplicacion(Administrador admin) {
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
    public Set<ElementoColectivo> getElemCol() {
        return this.elemCol;
    }

    /**
     * Establece una nueva lista de elementos de colectivo
     * @param elemCol nueva lista de elementos
     */
    public void setElemCol(Set<ElementoColectivo> elemCol) {
        this.elemCol = elemCol;
    }

    /**
     * Devuelve los proyectos del sistema
     * @return lista de proyectos
     */
    public Set<Proyecto> getProyectos() {
        return this.proyectos;
    }

    /**
     * Establece una nueva lista de proyectos
     * @param proyectos nueva lista de proyectos
     */
    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    /**
     * Devuelve los ciudadanos bloqueados del sistema
     * @return lista de ciudadanos bloqueados
     */
    public Set<Ciudadano> getBloqueados() {
        return bloqueados;
    }

    /**
     * Establece una nueva lista de ciudadanos bloqueados
     * @param bloqueados nueva lista de bloqueados
     */
    public void setBloqueados(Set<Ciudadano> bloqueados) {
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
        proyectos.forEach(p -> p.actualizarCaducidad(NOW));
    }

    /**
     * Devuelve el minimo de apoyos para enc¡viar un proyecto
     * @return numero minimo de apoyos
     */
    public static int getMinApoyos() {
        return minApoyos;
    }

    /**
     * Actualiza el minimo de apoyos para todos los proyectos
     * @param minApoyos nuevo minimo de apoyos
     */
    public static void setMinApoyos(int minApoyos) {
        Aplicacion.minApoyos = minApoyos;

        for (Proyecto p:VecindApp.proyectos) {
            if (p.getEstado() == EstadoProyecto.LISTOENVAR && p.getNApoyos() < minApoyos) {
                p.setEstado(EstadoProyecto.ACEPTADO);
            }
            else if (p.getEstado() ==  EstadoProyecto.ACEPTADO && p.getNApoyos() >= minApoyos){
                p.setEstado(EstadoProyecto.LISTOENVAR);
            }
        }
    }

    /**
     * Devuelve la fecha actual del sistema
     * @return la fecha actual del sistema
     */
    public static LocalDate getNow() {
        return NOW;
    }

    /**
     * Actualiza la fecha actual del sistema
     * @param now la nueva fecha actual
     */
    public static void setNow(LocalDate now) {
        NOW = now;
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
     * Devuelve una coleccion con los ciudadanos no bloqueados
     * @return ciudadanos no bloqueados
     */
    public Collection<ElementoColectivo> getDesbloqueados() {
        Collection<ElementoColectivo> c = new ArrayList<>();
        for (ElementoColectivo e: elemCol) {
            if (e instanceof Ciudadano && !((Ciudadano)e).isBloqueado() && ((Ciudadano)e).isAdmitido()) {
                c.add(e);
            }
        }
        return c;
    }

    /**
     * Devuelve una coleccion con los ciudadanos bloqueados
     * @return ciudadanos bloqueados
     */
    public Collection<ElementoColectivo> getCollBloqueados() {
        Collection<ElementoColectivo> c = new ArrayList<>();
        c.addAll(bloqueados);
        return c;
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
     * @throws ConexionFallida en caso de error de conexion con el sistema externo de financiacion
     * @throws CCGGException en caso de error en la consulta al sistema externo de financiacion
     */
    public static Aplicacion cargar(String path) throws IOException, ClassNotFoundException, ConexionFallida, CCGGException {
        ObjectInputStream ent = new ObjectInputStream(new FileInputStream(path));
        Aplicacion app = (Aplicacion) ent.readObject();
        app.varStatic.setValues();
        //Comprobando caducidad y financiacion de proyectos
        for (Proyecto p : app.proyectos) {
            p.actualizarCaducidad(NOW);
            if (p.getEstado() == EstadoProyecto.ENVIADO) {
                p.consultarFinanciacion();
            }
        }
        Aplicacion.VecindApp = app;
        return app;
    }

    /**
     * Resetea la aplicacion VecindApp
     */
    public static void reset() {
        Aplicacion.VecindApp = new Aplicacion(new Administrador("admin", "password"));
    }

    public JTree getTree() {
        Set<ElementoColectivo> padres = elemCol.stream().filter(ec -> ec instanceof Colectivo).map(ec -> (Colectivo)ec)
                .filter(c -> c.getPadre() == null).collect(Collectors.toSet());

        DefaultMutableTreeNode root = getTreeRec(padres, "Colectivos");
        return new JTree(root);
    }

    private static DefaultMutableTreeNode getTreeRec(Set<ElementoColectivo> padres, Object nodo) {
        DefaultMutableTreeNode ret = new DefaultMutableTreeNode(nodo);
        List<Colectivo> cols = padres.stream().filter(ec -> ec instanceof Colectivo).map(ec -> (Colectivo)ec).collect(Collectors.toList());

        if (cols.size() == 0) {
            return ret;
        }
        for (Colectivo c:cols) {
            ret.add(getTreeRec(c.getElementos(), c));
        }
        return ret;
    }
}