import java.util.ArrayList;

public abstract class Usuario {
    private String username;
    private String password;
    ArrayList<Notificacion> pendientes;

    public Usuario(String username, String password) {
        username = username;
        password = password;
        pendientes = new ArrayList<Notificacion>();
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Notificacion> getPendientes() {
        return pendientes;
    }

    public void setUsername(String usr) {
        username = usr;
    }

    public void setPassword(String psswd) {
        password = psswd;
    }

    public void setPendientes(ArrayList<Notificacion> p) {
        pendientes = p;
    }
}