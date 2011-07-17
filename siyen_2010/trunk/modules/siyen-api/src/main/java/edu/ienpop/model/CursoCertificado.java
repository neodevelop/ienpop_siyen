package edu.ienpop.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author neodevelop
 *
 */
@Entity
@Table(name="curso_certificado")
public class CursoCertificado extends Curso {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column private Date fechaFin;
	@Column private boolean certificado;
	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="cursoCertificado")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
          org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<AlumnoCertificado> alumnosCertificados;
	
	public Set<AlumnoCertificado> getAlumnosCertificados() {
		return alumnosCertificados;
	}
	public void setAlumnosCertificados(Set<AlumnoCertificado> alumnosCertificados) {
		this.alumnosCertificados = alumnosCertificados;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public boolean isCertificado() {
		return certificado;
	}
	public void setCertificado(boolean certificado) {
		this.certificado = certificado;
	}
	
}
