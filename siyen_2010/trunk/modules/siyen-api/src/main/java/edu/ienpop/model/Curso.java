package edu.ienpop.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * @author neodevelop
 * 
 */
@MappedSuperclass
public abstract class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCurso;
	@Column
	private Date fechaInicio;
	@Column
	private Date fechaHoraRegistro;
	@ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name = "idPuerto")
	private Puerto puerto;
	@ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name = "idTipoCurso")
	private TipoCurso tipoCurso;
	@ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name = "idInstructor")
	private Instructor instructor;
	@OneToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name = "idLlave")
	private LlaveCertificacion llaveCertificacion;

	public LlaveCertificacion getLlaveCertificacion() {
		return llaveCertificacion;
	}

	public void setLlaveCertificacion(LlaveCertificacion llaveCertificacion) {
		this.llaveCertificacion = llaveCertificacion;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}

	public void setFechaHoraRegistro(Date fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}

	public Puerto getPuerto() {
		return puerto;
	}

	public void setPuerto(Puerto puerto) {
		this.puerto = puerto;
	}

	public TipoCurso getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(TipoCurso tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
}
