public class Aministrador extends Usuario {
    
    public Administrador(String username, String password) {
        super(username, password, pendientes);
    }

    public void actualizarRegistro(Ciudadano c) {
        Notificacion n = new Notificacion(c);
        pendientes.add(n);
    }

    public void actualizarProyectos(Proyecto p) {
        Notificacion n = new Notificacion(p);
        pendientes.add(n);
    }
}