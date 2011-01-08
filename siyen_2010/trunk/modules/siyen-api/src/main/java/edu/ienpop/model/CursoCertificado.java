package edu.ienpop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author neodevelop
 *
 */
@Entity
@Table(name="cursoCertificado")
public class CursoCertificado extends Curso {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column private Date fechaFin;
	@Column private Boolean certificado;
	
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Boolean getCertificado() {
		return certificado;
	}
	public void setCertificado(Boolean certificado) {
		this.certificado = certificado;
	}
}
