package edu.ienpop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author neodevelop
 * 
 */
@Entity
@Table(name = "alumno_certificado")
public class AlumnoCertificado extends Alumno {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private String numeroControl;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idCurso")
	private CursoCertificado cursoCertificado;

	public CursoCertificado getCursoCertificado() {
		return cursoCertificado;
	}

	public void setCursoCertificado(CursoCertificado cursoCertificado) {
		this.cursoCertificado = cursoCertificado;
	}

	public String getNumeroControl() {
		return numeroControl;
	}

	public void setNumeroControl(String numeroControl) {
		this.numeroControl = numeroControl;
	}
}
