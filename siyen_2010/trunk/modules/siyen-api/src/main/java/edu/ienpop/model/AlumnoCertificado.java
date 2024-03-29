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
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idCurso")
	private CursoCertificado cursoCertificado;
	@Column
	private boolean certificado;

	public boolean isCertificado() {
		return certificado;
	}

	public void setCertificado(boolean certificado) {
		this.certificado = certificado;
	}

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
