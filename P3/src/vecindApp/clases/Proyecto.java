package vecindApp.clases;

import es.uam.eps.sadp.grants.CCGG;
import es.uam.eps.sadp.grants.GrantRequest;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Define la clase Proyecto, que lleva registro de los datos, apoyos
 * y estado en general de un Proyecto.
 *
 * @author Ana Calzada, Leandro Garcia, Fabian Gutierrez
 */
public abstract class Proyecto implements Serializable {
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
        propulsor.addProyecto(this);
        propulsor.addProyectoApoyado(this);
    }

    public Proyecto(String titulo, String descripcion, double importeSolicitado, Colectivo propulsor) {
		this(titulo, descripcion, importeSolicitado, propulsor.getRepresentante());
    	propulsor.addProyecto(this);
    	propulsor.addProyectoApoyado(this);
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
		recibirApoyo(propulsor); //En caso de ser colectivo, se agregan los apoyos de sus miembros
	}
	
	public void rechazar() {
		setEstado(EstadoProyecto.RECHAZADO);
	}

	protected abstract GrantRequest crearSolicitud();

	public void enviarFinanciacion() throws Exception {
		GrantRequest req;
		if (estado != EstadoProyecto.LISTOENVAR) {
			return;
		}
		req = crearSolicitud();
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

	public void notificarCambio() {
		for (Ciudadano s: suscriptores) {
			s.agregarNotificacion(new NotificacionProy(this));
		}
	}

	public int generarInformePopularidad() {
		return nApoyos;
	}

	public boolean bloquearApoyo(Ciudadano c) {
		boolean ret = promotores.remove(c);
		if (ret && (--nApoyos < Aplicacion.minApoyos) && (estado == EstadoProyecto.LISTOENVAR)) {
			setEstado(EstadoProyecto.ACEPTADO);
		}
		return ret;
	}

	/**
	 * Recibe el apoyo directo de un ElementoColectivo.
	 * @param ec el ElementoColectivo que apoya al proyecto.
	 */
	public void recibirApoyo(ElementoColectivo ec) {
		if (caducado ||
			(estado == EstadoProyecto.INICIAL) ||
			(estado == EstadoProyecto.FINANCIADO) ||
			(estado == EstadoProyecto.DENEGADO)) {
			return;
		}

		ec.addProyectoApoyado(this); //Por defecto una llamada fuera de Proyecto implica un apoyo directo de ec
		if (ec instanceof Ciudadano) {
    		recibirApoyo((Ciudadano) ec);
		} else if (ec instanceof  Colectivo) {
			suscriptores.add(((Colectivo) ec).getRepresentante());
			recibirApoyo((Colectivo) ec);
		}
		setUltimoApoyo(new Date());
	}

	/**
	 * Recibe el apoyo directo o indirecto de un ElementoCiudadano.
	 * @param ec el ElementoColectivo que apoya al proyecto.
	 * @param directo si el apoyo es directo (es indirecto en caso contrario).
	 */
	public void recibirApoyo(ElementoColectivo ec, boolean directo) {
		recibirApoyo(ec);
		if (!directo) {
			ec.removeProyectoApoyado(this);	//Un ElementoColectivo guarda los proyectos que apoya directamente
		}
	}

	/*Metodos privados*/
	private void recibirApoyo(Ciudadano c) {
		if (!c.isBloqueado() && promotores.add(c)) {//Es un ciudadano que no esta bloqueado ni era promotor
			if ((++nApoyos >= Aplicacion.minApoyos) && (estado == EstadoProyecto.ACEPTADO)) {
				setEstado(EstadoProyecto.LISTOENVAR);
			}
		}
	}

	private void recibirApoyo(Colectivo c) {
    	if (promotores.add(c)) { //El colectivo no apoyaba previamente el proyecto
    		for (ElementoColectivo ec: c.getElementos()) {
    			recibirApoyo(ec);
			}
		}
	}
}