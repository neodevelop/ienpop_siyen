package edu.ienpop.model;

import java.util.Date;

public class CursoCriteria extends Persistent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int MAX_RESULTS = 10;
	public static final int NUEVO=1;
	public static final int ABIERTO=2;
	public static final int APROBADO=3;
	public static final int CONCLUIDO=4;
	public static final int RECHAZADO=5;
	private int firstResult;
	private Date fechaDesde;
	private Date fechaHasta;
	private String[] idPuerto;
	private String[] idTipoCurso;
	private String[] idUsuario;
	private int idStatusCurso;
	private long idLlave;
	private String[] libretas;
	private boolean paginado;

	public boolean isPaginado() {
		return paginado;
	}
	public boolean getPaginado(){
		return paginado;
	}
	public void setPaginado(boolean paginado) {
		this.paginado = paginado;
	}
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
	public String[] getIdPuerto() {
		return idPuerto;
	}
	public void setIdPuerto(String[] idPuerto) {
		this.idPuerto = idPuerto;
	}
	public String[] getIdTipoCurso() {
		return idTipoCurso;
	}
	public void setIdTipoCurso(String[] idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
	}
	public String[] getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String[] idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdStatusCurso() {
		return idStatusCurso;
	}
	public void setIdStatusCurso(int idStatusCurso) {
		this.idStatusCurso = idStatusCurso;
	}
	public long getIdLlave() {
		return idLlave;
	}
	public void setIdLlave(long idLlave) {
		this.idLlave = idLlave;
	}
	public String[] getLibretas() {
		return libretas;
	}
	public void setLibretas(String[] libretas) {
		this.libretas = libretas;
	}
	public int getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}
	
}
