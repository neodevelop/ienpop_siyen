package edu.ienpop.model;

import java.util.Date;

public class LlaveCertificacion extends Persistent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String llave;
	private long idCursoXCertificar;
	private Date fechaGeneracion;
	private Date fechaUtilizacion;
	private int idStatusLlave;
	
	public long getIdCursoXCertificar() {
		return idCursoXCertificar;
	}
	public void setIdCursoXCertificar(long idCursoXCertificar) {
		this.idCursoXCertificar = idCursoXCertificar;
	}
	public int getIdStatusLlave() {
		return idStatusLlave;
	}
	public void setIdStatusLlave(int idStatusLlave) {
		this.idStatusLlave = idStatusLlave;
	}
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public Date getFechaUtilizacion() {
		return fechaUtilizacion;
	}
	public void setFechaUtilizacion(Date fechaUtilizacion) {
		this.fechaUtilizacion = fechaUtilizacion;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
}
