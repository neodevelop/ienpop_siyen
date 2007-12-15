package edu.ienpop.model;

public class CatalogoCurso {
	private String idTipoCurso;
	private String nombreCurso;
	private int duracion;
	private String libreta;
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getIdTipoCurso() {
		return idTipoCurso;
	}
	public void setIdTipoCurso(String idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
	}
	public String getLibreta() {
		return libreta;
	}
	public void setLibreta(String libreta) {
		this.libreta = libreta;
	}
	public String getNombreCurso() {
		return nombreCurso;
	}
	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}
	
}
