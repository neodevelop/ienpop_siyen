package edu.ienpop.model;

public class CatalogoStatusCurso extends Persistent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreStatusCurso;
	public String getNombreStatusCurso() {
		return nombreStatusCurso;
	}
	public void setNombreStatusCurso(String nombreStatusCurso) {
		this.nombreStatusCurso = nombreStatusCurso;
	}
}
