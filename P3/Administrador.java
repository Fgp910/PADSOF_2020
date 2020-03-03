public class Administrador extends Usuario {
    
    public Administrador(String username, String password) {
        super(username, password);
    }

    public void actualizarRegistro(Ciudadano c) {
        pendientes.add(new Notificacion(c));
    }

    public void actualizarProyectos(Proyecto p) {
        pendientes.add(new Notificacion(p));
    }
}