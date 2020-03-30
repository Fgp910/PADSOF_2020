package vecindApp.clases.Usuario;

import vecindApp.clases.Notificacion.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Define la clase Usuario que lleva registro de la informacion
 * asociada a un usuario (nombre, clave, etc.).
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public abstract class Usuario implements Serializable {
    private String username;
    private String password;
    private ArrayList<Notificacion> pendientes;

    /**
     * Inicializa un usuario
     * @param username nombre del usuario
     * @param password contraseña
     */
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        pendientes = new ArrayList<>();
    }

    /**
     * Devuelve el nombre de un usuario
     * @return nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece un nuevo nombre de usuario
     * @param usr nombre de usuario
     */
    public void setUsername(String usr) {
        username = usr;
    }

    /**
     * Devuelve la contraseña de un usuario
     * @return contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece una nueva contraseña para un usuario
     * @param psswd nueva contraseña
     */
    public void setPassword(String psswd) {
        password = psswd;
    }

    /**
     * Devuelve la lista de notificaciones pendientes del usuario
     * @return notificaciones pendientes
     */
    public ArrayList<Notificacion> getPendientes() {
        return pendientes;
    }

    /**
     * Establece una nueva lista de notificaciones pendientes
     * @param p notificaciones pendientes
     */
    public void setPendientes(ArrayList<Notificacion> p) {
        pendientes = p;
    }

    /**
     * Agrega una nueva notificacion a la lista de pendientes
     * @param n nueva notificacion
     */
    public void agregarNotificacion(Notificacion n) {
        pendientes.add(n);
    }
}