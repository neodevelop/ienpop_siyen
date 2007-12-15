package edu.ienpop.model;

import java.util.Date;
import java.util.Set;

public class Curso extends Persistent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaHoraRegistro;
	private String idPuerto;
	private String idTipoCurso;
	private String idUsuario;
	private int idStatusCurso;
	private long idLlave;
	private Set alumnos;
	
	public long getIdLlave() {
		return idLlave;
	}
	public void setIdLlave(long idLlave) {
		this.idLlave = idLlave;
	}
	public Set getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(Set alumnos) {
		this.alumnos = alumnos;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getIdPuerto() {
		return idPuerto;
	}
	public void setIdPuerto(String idPuerto) {
		this.idPuerto = idPuerto;
	}
	public int getIdStatusCurso() {
		return idStatusCurso;
	}
	public void setIdStatusCurso(int idStatusCurso) {
		this.idStatusCurso = idStatusCurso;
	}
	public String getIdTipoCurso() {
		return idTipoCurso;
	}
	public void setIdTipoCurso(String idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Date getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}
	public void setFechaHoraRegistro(Date fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}
	
}
