package edu.ienpop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author neodevelop
 * 
 */
@Entity
@Table(name = "catalogo_curso")
public class TipoCurso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String idTipoCurso;
	@Column
	private String nombreCurso;
	@Column
	private Integer duracion;
	@Transient
	private Libreta tipoLibreta;
	@Column
	private String libreta;
	@Column
	private Boolean activo;

	@PrePersist
	@PreUpdate
	protected void prePersist(){
		libreta = this.tipoLibreta.getId();
	}
	
	@PostLoad
	protected void postLoad(){
		tipoLibreta = Libreta.valueOf(libreta);
	}
	
	public Libreta getTipoLibreta() {
		return tipoLibreta;
	}

	public void setTipoLibreta(Libreta tipoLibreta) {
		this.tipoLibreta = tipoLibreta;
	}

	public String getLibreta() {
		return libreta;
	}

	public void setLibreta(String libreta) {
		this.libreta = libreta;
	}

	public String getIdTipoCurso() {
		return idTipoCurso;
	}

	public void setIdTipoCurso(String idTipoCurso) {
		this.idTipoCurso = idTipoCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
