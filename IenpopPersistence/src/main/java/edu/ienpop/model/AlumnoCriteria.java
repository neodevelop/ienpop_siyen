package edu.ienpop.model;

import java.util.Date;

public class AlumnoCriteria extends Persistent{
	private static final long serialVersionUID = 1L;
	public static final int INSCRITO=1;
	public static final int EVALUADO=2;
	public static final int CERTIFICADO=3;
	private String numeroControl;
	private String nombreCompleto;
	private long idCurso;
	private int idStatusAlumno;
	private Date fechaDesde;
	private Date fechaHasta;
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
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
