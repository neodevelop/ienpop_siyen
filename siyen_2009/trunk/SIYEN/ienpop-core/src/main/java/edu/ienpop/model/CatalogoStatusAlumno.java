package edu.ienpop.model;

public class CatalogoStatusAlumno extends Persistent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreStatusAlumno;
	public String getNombreStatusAlumno() {
		return nombreStatusAlumno;
	}
	public void setNombreStatusAlumno(String nombreStatusAlumno) {
		this.nombreStatusAlumno = nombreStatusAlumno;
	}
}
