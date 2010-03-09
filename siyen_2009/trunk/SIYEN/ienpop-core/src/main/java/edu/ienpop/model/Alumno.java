package edu.ienpop.model;

import java.util.Date;

public class Alumno extends Persistent{
	private static final long serialVersionUID = 1L;
	private String numeroControl;
	private String nombreCompleto;
	private long idCurso;
	private int idStatusAlumno;
	private Date fechaHoraRegistro;
	private Curso curso;
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Date getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}
	public void setFechaHoraRegistro(Date fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}
	public long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
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
	public String getNumeroControl() {
		return numeroControl;
	}
	public void setNumeroControl(String numeroControl) {
		this.numeroControl = numeroControl;
	}
	
}
