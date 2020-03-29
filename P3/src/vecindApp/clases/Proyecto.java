package vecindApp.clases;

import es.uam.eps.sadp.grants.CCGG;
import es.uam.eps.sadp.grants.GrantRequest;
import es.uam.eps.sadp.grants.InvalidIDException;
import es.uam.eps.sadp.grants.InvalidRequestException;

import java.io.IOException;
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

	/**
	 * Inicializa un nuevo proyecto propuesto individualmente
	 * @param titulo titulo del proyecto
	 * @param descripcion descripcion del proyecto
	 * @param importeSolicitado importe solicitado por el proyecto
	 * @param propulsor ciudadano propulsor del proyecto
	 */
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

	/**
	 * Inicializa un nuevo proyecto propuesto por un colectivo
	 * @param titulo titulo del proyecto
	 * @param descripcion descripcion del proyecto
	 * @param importeSolicitado importe solicitado por el proyecto
	 * @param propulsor colectivo propulsor del proyecto
	 */
    public Proyecto(String titulo, String descripcion, double importeSolicitado, Colectivo propulsor) {
		this(titulo, descripcion, importeSolicitado, propulsor.getRepresentante());
    	propulsor.addProyecto(this);
    	propulsor.addProyectoApoyado(this);
	}

	/**
	 * Devuelve el id del proyecto
	 * @return id
	 */
    public int getId() {
		return id;
	}

	/**
	 * Establece el id del proyecto
	 * @param id nuevo id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve el id del envio
	 * @return id del envio
	 */
	public String getIdEnvio() {
		return idEnvio;
	}

	/**
	 * Establece el id del envio
	 * @param idEnvio nuevo id del envio
	 */
	public void setIdEnvio(String idEnvio) {
		this.idEnvio = idEnvio;
	}

	/**
	 * Devuelve el titulo del proyecto
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el titulo del proyecto
	 * @param titulo nuevo titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Devuelve la descripcion del proyecto
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripcion del proyecto
	 * @param descripcion nueva descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Devuelve el importe solicitado por el proyecto
	 * @return importe solicitado
	 */
	public double getImporteSolicitado() {
		return importeSolicitado;
	}

	/**
	 * Establece el importe solicitado por el proyecto
	 * @param importeSolicitado nuevo importe solicitado
	 */
	public void setImporteSolicitado(double importeSolicitado) {
		this.importeSolicitado = importeSolicitado;
	}

	/**
	 * Devuelve el importe concedido al proyecto
	 * @return importe concedido
	 */
	public double getImporteConcedido() {
		return importeConcedido;
	}

	/**
	 * Establece el importe concedido al proyecto
	 * @param importeConcedido nuevo importe concedido
	 */
	public void setImporteConcedido(double importeConcedido) {
		this.importeConcedido = importeConcedido;
	}

	/**
	 * Devuelve la fecha de creacion del proyecto
	 * @return fecha de creacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Establece la fecha de creacion del proyecto
	 * @param fechaCreacion fecha de creacion
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Devuelve la fecha del ultimo apoyo al proyecto
	 * @return fecha del ultimo apoyo
	 */
	public Date getUltimoApoyo() {
		return ultimoApoyo;
	}

	/**
	 * Establece la fecha del ultimo apoyo al proyecto
	 * @param ultimoApoyo la fecha a asignar
	 */
	public void setUltimoApoyo(Date ultimoApoyo) {
		this.ultimoApoyo = ultimoApoyo;
	}

	/**
	 * Devuelve el numero de apoyos recibido por el proyecto
	 * @return numero de apoyos
	 */
	public int getNApoyos() {
		return nApoyos;
	}

	/**
	 * Establece el numero de apoyos recibido por el proyecto
	 * @param nApoyos numero de apoyos
	 */
	public void setNApoyos(int nApoyos) {
		this.nApoyos = nApoyos;
	}

	/**
	 * Devuelve el estado del proyecto
	 * @return estado del proyecto
	 */
	public EstadoProyecto getEstado() {
		return estado;
	}

	/**
	 * Establece el estado del proyecto
	 * @param estado nuevo estado del proyecto
	 */
	public void setEstado(EstadoProyecto estado) {
		this.estado = estado;
		this.notificarCambio();
	}

	/**
	 * Devuelve si el proyecto esta caducaco o no
	 * @return true si caducado, false si no
	 */
	public boolean isCaducado() {
		return caducado;
	}

	/**
	 * Establece si el proyecto esta caducado o no
	 * @param caducado el valor a asignar
	 */
	public void setCaducado(boolean caducado) {
		this.caducado = caducado;
	}

	/**
	 * Devuelve el propulsor del proyecto (individual o colectivo)
	 * @return propulsor
	 */
	public ElementoColectivo getPropulsor() {
		return propulsor;
	}

	/**
	 * Establece el propulsor del proyecto (individual o colectivo)
	 * @param propulsor el ElementoColectivo a asignar
	 */
	public void setPropulsor(ElementoColectivo propulsor) {
		this.propulsor = propulsor;
	}

	/**
	 * Devuelve el set de promotores del proyecto
	 * @return set de promotores
	 */
	public Set<ElementoColectivo> getPromotores() {
		return promotores;
	}

	/**
	 * Establece el set de promotores del proyecto
	 * @param promotores nuevo set de promotores
	 */
	public void setPromotores(Set<ElementoColectivo> promotores) {
		this.promotores = promotores;
	}

	/**
	 * Devuelve el set de suscriptores del proyecto
	 * @return set de suscriptores
	 */
	public Set<Ciudadano> getSuscriptores() {
		return suscriptores;
	}

	/**
	 * Establece un nuevo set de suscriptores del proyecto
	 * @param suscriptores nuevo set de suscriptores
	 */
	public void setSuscriptores(Set<Ciudadano> suscriptores) {
		this.suscriptores = suscriptores;
	}

	/**
	 * Devuelve el next id
	 * @return next id
	 */
	public static int getNextId() {
		return nextId;
	}

	/**
	 * Establece el next id
	 * @param nextId nuevo next id
	 */
	public static void setNextId(int nextId) {
		Proyecto.nextId = nextId;
	}

	/**
	 * pone el estado de un proyecto en caducado
	 */
	public void caducar() {
		setCaducado(true);
	}

	/**
	 * pone el estado de un proyecto en aceptado
	 */
	public void aceptar() {
		setEstado(EstadoProyecto.ACEPTADO);
		recibirApoyo(propulsor); //En caso de ser colectivo, se agregan los apoyos de sus miembros
	}

	/**
	 * pone el estado de un proyecto en rechazado
	 */
	public void rechazar() {
		setEstado(EstadoProyecto.RECHAZADO);
	}

	/**
	 * Crea una solicitud de financiacion para el proyecto
	 * @return solicitud del proyecto
	 */
	protected abstract GrantRequest crearSolicitud();

	/**
	 * Envia el proyecto a financiacion
	 *
	 * @throws IOException en caso de fallos en la comunicacion
	 * @throws InvalidRequestException en caso de enviar una solicitud no valida
	 */
	public void enviarFinanciacion() throws IOException, InvalidRequestException {
		GrantRequest req;
		if (estado != EstadoProyecto.LISTOENVAR) {
			return;
		}
		req = crearSolicitud();
		CCGG proxy = CCGG.getGateway();
		this.idEnvio = proxy.submitRequest(req);
		setEstado(EstadoProyecto.ENVIADO);
	}

	/**
	 * consulta el estado de un proyecto enviado
	 * @throws IOException en caso de fallos en la comunicacion
	 * @throws InvalidIDException en caso de consultar un id no valido
	 */
	public void consultarFinanciacion() throws IOException, InvalidIDException {
		CCGG proxy = CCGG.getGateway();
		Double aux = proxy.getAmountGranted(this.idEnvio); //Si no esta resuelto, getAmountGranted devuelve null
		if (aux != null) {
			importeConcedido = aux;
			if (importeConcedido == 0) {
				setEstado(EstadoProyecto.DENEGADO);
			} else {
				setEstado(EstadoProyecto.FINANCIADO);
			}
		}
	}

	/**
	 * pone el estado de un proyecto en denegado
	 */
	public void denegarFinanciacion() {
		setEstado(EstadoProyecto.DENEGADO);
	}

	/**
	 * notifica a los suscriptores un cambio en el estado en el proyecto
	 */
	public void notificarCambio() {
		for (Ciudadano s: suscriptores) {
			s.agregarNotificacion(new NotificacionProy(this));
		}
	}

	/**
	 * Devuelve el informe de popularidad de un proyecto
	 * @return informe de popularidad
	 */
	public int generarInformePopularidad() {
		return nApoyos;
	}

	/**
	 * Bloquea el apoyo de un ciudadano
	 * @param c ciudadano bloqueado
	 * @return resultado de la operacion
	 */
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
	 * Recibe el apoyo directo o indirecto de un ElementoColectivo.
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

	/**
	 * Recibe el apoyo de un ciudadano
	 * @param c ciudadano que apoya el proyecto
	 */
	private void recibirApoyo(Ciudadano c) {
		if (!c.isBloqueado() && promotores.add(c)) {//Es un ciudadano que no esta bloqueado ni era promotor
			if ((++nApoyos >= Aplicacion.minApoyos) && (estado == EstadoProyecto.ACEPTADO)) {
				setEstado(EstadoProyecto.LISTOENVAR);
			}
		}
	}

	/**
	 * Recibe el apoyo de un colectivo
	 * @param c colectivo que apoya el proyecto
	 */
	private void recibirApoyo(Colectivo c) {
		if (promotores.add(c)) { //El colectivo no apoyaba previamente el proyecto
    		for (ElementoColectivo ec: c.getElementos()) {
    			recibirApoyo(ec);
			}
		}
	}
}