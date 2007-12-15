package edu.ienpop.model;

import java.util.Date;

public class CursoCriteria extends Persistent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int NUEVO=1;
	public static final int ABIERTO=2;
	public static final int APROBADO=3;
	public static final int CONCLUIDO=4;
	public static final int RECHAZADO=5;
	private Date fechaDesde;
	private Date fechaHasta;
	private Object[] idPuerto;
	private Object[] idTipoCurso;
	private Object[] idUsuario;
	private int idStatusCurso;
	private long idLlave;
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
	public long getIdLlave() {
		return idLlave;
	}
	public void setIdLlave(long idLlave) {
		this.idLlave = idLlave;
	}
	public Object[] getIdPuerto() {
		return idPuerto;
	}
	public void setIdPuerto(Object[] idPuerto) {
		this.idPuerto = idPuerto;
	}
	public int getIdStatusCurso() {
		return idStatusCurso;
	}
	public void setIdStatusCurso(int idStatusCurso) {
		this.idStatusCurso = idStatusCurso;
	}
	public Object[] getIdTipoCurso() {
		return idTipoCurso;
	}
	public void setIdTipoCurso(Object[] idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
	}
	public Object[] getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Object[] idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
