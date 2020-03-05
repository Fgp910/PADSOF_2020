import java.util.*;

public abstract class Proyecto {
    private int id;
    private String descripcion;
    private double importeSolicitado;
    private double importeConcedido = 0;
    private Date fechaCreacion;
    private Date ultimoApoyo;
    private int minApoyos = -1;
    private int nApoyos = 1;
    private EstadoProyecto estado = EstadoProyecto.INICIAL;
    private boolean caducado = false;
    private Ciudadano propulsor;
    private Set<Ciudadano> promotores;
    private Set<Ciudadano> suscriptores;

    private static int nextId = 1;

    public Proyecto(String descripcion, double importeSolicitado, Ciudadano propulsor) {
        id = nextId++;
        this.descripcion = descripcion;
        this.importeSolicitado = importeSolicitado;
        fechaCreacion = new Date();
        ultimoApoyo = new Date();
        promotores  = new HashSet<>();
        suscriptores  = new HashSet<>();
        this.propulsor = propulsor;
        promotores.add(propulsor);
        suscriptores.add(propulsor);
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getImporteSolicitado() {
		return importeSolicitado;
	}

	public void setImporteSolicitado(double importeSolicitado) {
		this.importeSolicitado = importeSolicitado;
	}

	public double getImporteConcedido() {
		return importeConcedido;
	}

	public void setImporteConcedido(double importeConcedido) {
		this.importeConcedido = importeConcedido;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getUltimoApoyo() {
		return ultimoApoyo;
	}

	public void setUltimoApoyo(Date ultimoApoyo) {
		this.ultimoApoyo = ultimoApoyo;
	}

	public int getMinApoyos() {
		return minApoyos;
	}

	public void setMinApoyos(int minApoyos) {
		this.minApoyos = minApoyos;
	}

	public int getnApoyos() {
		return nApoyos;
	}

	public void setnApoyos(int nApoyos) {
		this.nApoyos = nApoyos;
	}

	public EstadoProyecto getEstado() {
		return estado;
	}

	public void setEstado(EstadoProyecto estado) {
		this.estado = estado;
		this.notificarCambio();
	}

	public boolean isCaducado() {
		return caducado;
	}

	public void setCaducado(boolean caducado) {
		this.caducado = caducado;
	}

	public Ciudadano getPropulsor() {
		return propulsor;
	}

	public void setPropulsor(Ciudadano propulsor) {
		this.propulsor = propulsor;
	}

	public Set<Ciudadano> getPromotores() {
		return promotores;
	}

	public void setPromotores(Set<Ciudadano> promotores) {
		this.promotores = promotores;
	}

	public Set<Ciudadano> getSuscriptores() {
		return suscriptores;
	}

	public void setSuscriptores(Set<Ciudadano> suscriptores) {
		this.suscriptores = suscriptores;
	}

	public static int getNextId() {
		return nextId;
	}

	public static void setNextId(int nextId) {
		Proyecto.nextId = nextId;
	}

	public enviarFinanciacion() {
		this.setEstado(EstadoProyecto.Enviado);
	}
	
	public caducar() {
		
	}
	
	public aceptar() {
		
	}
	
	public rechazar() {
		
	}
	
	public financiar (double importe) {
		
	}
	
	public denegarFinanciacion() {
		
	}
	
	public void notificarCambio() {
        for (Ciudadano s: suscriptores) {
            s.actualizarProyecto(this);
        }
    }

    public int generarInformePopularidad() {
        return nApoyos;
    }

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", descripcion=" + descripcion + ", importeSolicitado=" + importeSolicitado
				+ ", importeConcedido=" + importeConcedido + ", fechaCreacion=" + fechaCreacion + ", ultimoApoyo="
				+ ultimoApoyo + ", minApoyos=" + minApoyos + ", nApoyos=" + nApoyos + ", estado=" + estado
				+ ", caducado=" + caducado + ", propulsor=" + propulsor + ", promotores=" + promotores
				+ ", suscriptores=" + suscriptores + "]";
	}
}