package P3;

public abstract Proyecto {
    private int id;
    private String descripcion;
    private double importeSolcitado;
    private double importeConcedido = 0;
    private Date fechaCreacion;
    private Date ultimoApoyo;
    private int minApoyos = -1;
    private int nApoyos = 1;
    private EstadoProyecto estado = INICIAL;
    private boolean caducado = false;
    private Ciudadano propulsor;
    private Set<Ciudadano> promotores;
    private Set<Ciudadano> suscriptores;

    private static int nextId = 1;

    public Proyecto(descripcion, importeSolicitado, propulsor) {
        id = nextId++;
        this.descripcion = descripcion;
        this.importeSolcitado = importeSolcitado;
        fechaCreacion = new Date();
        ultimoApoyo = new Date();
        promotores  = new HashSet<>();
        suscriptores  = new HashSet<>();
        this.propulsor = propulsor;
        promotores.add(propulsor);
        suscriptores.add(propulsor);
    }

    public void notificarCambio() {
        for (Ciudadano s: suscriptores) {
            s.actualizarProyecto(this);
        }
    }

    public int generarInformePopularidad() {
        return nApoyos;
    }
}