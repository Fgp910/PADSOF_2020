package vecindApp.clases;

import es.uam.eps.sadp.grants.CCGG;
import es.uam.eps.sadp.grants.GrantRequest;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public abstract class Proyecto {
	private static int nextId = 1;

	private int id;
	private String idEnvio;
	private String titulo;
    private String descripcion;
    private double importeSolicitado;
    private double importeConcedido = 0;
    private Date fechaCreacion;
    private Date ultimoApoyo;
    private int nApoyos = 1;
    private EstadoProyecto estado = EstadoProyecto.INICIAL;
    private boolean caducado = false;
    private ElementoColectivo propulsor;
    private Set<ElementoColectivo> promotores;
    private Set<Ciudadano> suscriptores;

    public Proyecto(String titulo, String descripcion, double importeSolicitado, Ciudadano propulsor) {
		id = nextId++;
		this.titulo = titulo;
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

	public String getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(String idEnvio) {
		this.idEnvio = idEnvio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public int getNApoyos() {
		return nApoyos;
	}

	public void setNApoyos(int nApoyos) {
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

	public ElementoColectivo getPropulsor() {
		return propulsor;
	}

	public void setPropulsor(ElementoColectivo propulsor) {
		this.propulsor = propulsor;
	}

	public Set<ElementoColectivo> getPromotores() {
		return promotores;
	}

	public void setPromotores(Set<ElementoColectivo> promotores) {
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
	
	public void caducar() {
		setCaducado(true);
	}
	
	public void aceptar() {
		setEstado(EstadoProyecto.ACEPTADO);
	}
	
	public void rechazar() {
		setEstado(EstadoProyecto.RECHAZADO);
	}

	protected abstract GrantRequest crearSolicitud();

	public void enviarFinanciacion() throws Exception {
		GrantRequest req = crearSolicitud();
		CCGG proxy = CCGG.getGateway();
		this.idEnvio = proxy.submitRequest(req);
		setEstado(EstadoProyecto.ENVIADO);
	}

	public void consultarFinanciacion() throws Exception {
		CCGG proxy = CCGG.getGateway();
		importeConcedido = proxy.getAmountGranted(this.idEnvio); //Si no esta resuelto, getAmountGranted devuelve null
	}
	
	public void denegarFinanciacion() {
		setEstado(EstadoProyecto.DENEGADO);
	}
	
	public void recibirApoyo(ElementoColectivo ec) {
    	if (ec instanceof Ciudadano) {
    		recibirApoyo((Ciudadano) ec);
		} else if (ec instanceof  Colectivo) {
    		recibirApoyo((Colectivo) ec);
		}
	}

	public void recibirApoyo(Ciudadano c) {
		if (promotores.add(c)) {	//Es un ciudadano que no era promotor
			if (++nApoyos >= Aplicacion.minApoyos && estado == EstadoProyecto.ACEPTADO) {
				setEstado(EstadoProyecto.LISTOENVAR);
			}
		}
	}

	public void recibirApoyo(Colectivo c) {
    	if (promotores.add(c)) { //El colectivo no apoyaba previamente el proyecto
    		for (ElementoColectivo ec: c.getElementos()) {
    			recibirApoyo(ec);
			}
		}
	}

	public void notificarCambio() {
        for (Ciudadano s: suscriptores) {
            s.agregarNotificacion(new NotificacionProy(this));
        }
    }

    public int generarInformePopularidad() {
        return nApoyos;
    }
}