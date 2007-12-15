package edu.ienpop.model;

import java.util.Date;

public class AlumnoXCertificar extends Persistent{
	private static final long serialVersionUID = 1L;
	private String nombreCompleto;
	private long idCursoXCertificar;
	//private CursoXCertificar cursoXCertificar;
	private int idStatusAlumno;
	private Date fechaHoraRegistro;
	private String observaciones;
	public Date getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}
	public void setFechaHoraRegistro(Date fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}
	public long getIdCursoXCertificar() {
		return idCursoXCertificar;
	}
	public void setIdCursoXCertificar(long idCursoXCertificar) {
		this.idCursoXCertificar = idCursoXCertificar;
	}
	public int getIdStatusAlumno() {
		return idStatusAlumno;
	}
	public void setIdStatusAlumno(int idStatusAlumno) {
		this.idStatusAlumno = idStatusAlumno;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
