package edu.ienpop.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author neodevelop
 *
 */
@Entity
@Table(name="llave_certificacion")
public class LlaveCertificacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id private Long idLlaveCertificacion;
	@Transient private String llave;
	@Transient private Curso curso;
	@Transient private Date fechaGeneracion;
	@Transient private Date fechaUtilizacion;
	@Transient private Boolean activo;
	
	public Long getIdLlaveCertificacion() {
		return idLlaveCertificacion;
	}
	public void setIdLlaveCertificacion(Long idLlaveCertificacion) {
		this.idLlaveCertificacion = idLlaveCertificacion;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public Date getFechaUtilizacion() {
		return fechaUtilizacion;
	}
	public void setFechaUtilizacion(Date fechaUtilizacion) {
		this.fechaUtilizacion = fechaUtilizacion;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
