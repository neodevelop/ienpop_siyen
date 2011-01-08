package edu.ienpop.model;

import java.util.Date;
import java.util.List;

public class CursoCriteria extends Curso {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date fechaFin;
	private List<Instructor> instructores;
	private List<Puerto> puertos;
	private List<TipoCurso> tiposCursos;
	private int maxSize;
	private int offset;
	
	public CursoCriteria(){
		this.offset = 0;
		this.maxSize = 10;
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public List<Instructor> getInstructores() {
		return instructores;
	}
	public void setInstructores(List<Instructor> instructores) {
		this.instructores = instructores;
	}
	public List<Puerto> getPuertos() {
		return puertos;
	}
	public void setPuertos(List<Puerto> puertos) {
		this.puertos = puertos;
	}
	public List<TipoCurso> getTiposCursos() {
		return tiposCursos;
	}
	public void setTiposCursos(List<TipoCurso> tiposCursos) {
		this.tiposCursos = tiposCursos;
	}

	
}
