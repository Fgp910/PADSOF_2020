package src.vecindApp.clases;

import java.util.ArrayList;

public abstract class Usuario {
    private String username;
    private String password;
    ArrayList<Notificacion> pendientes;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        pendientes = new ArrayList<>();
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String usr) {
        username = usr;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String psswd) {
        password = psswd;
    }

    public ArrayList<Notificacion> getPendientes() {
        return pendientes;
    }

    public void setPendientes(ArrayList<Notificacion> p) {
        pendientes = p;
    }
    
    public void agregarNotificacion(Object o) {
        pendientes.add(new Notificacion(o));
    }
}