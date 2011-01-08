package edu.ienpop.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author neodevelop
 * 
 */
@Entity
@Table(name = "llave_certificacion")
public class LlaveCertificacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLlave;
	@Column
	private String llave;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="idCursoCertificado")
	private CursoCertificado cursoCertificado;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="idCursoSinCertificar")
	private CursoSinCertificar cursoSinCertificar;
	@Column
	private Date fechaGeneracion;
	@Column
	private Date fechaUtilizacion;
	@Column
	private boolean activo;

	public CursoCertificado getCursoCertificado() {
		return cursoCertificado;
	}

	public void setCursoCertificado(CursoCertificado cursoCertificado) {
		this.cursoCertificado = cursoCertificado;
	}

	public CursoSinCertificar getCursoSinCertificar() {
		return cursoSinCertificar;
	}

	public void setCursoSinCertificar(CursoSinCertificar cursoSinCertificar) {
		this.cursoSinCertificar = cursoSinCertificar;
	}

	public Long getIdLlave() {
		return idLlave;
	}

	public void setIdLlave(Long idLlave) {
		this.idLlave = idLlave;
	}

	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
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

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
