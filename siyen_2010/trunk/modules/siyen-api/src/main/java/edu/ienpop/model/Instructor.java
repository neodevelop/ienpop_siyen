package edu.ienpop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * @author neodevelop
 *
 */
@Entity
@Table(name="instructor")
public class Instructor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id private String idInstructor;
	@Column private String nombre;
	@Column private String numOficio;
	@Column private Boolean activo;
	
	@Override
	public boolean equals(Object obj) {
		EqualsBuilder builder = new EqualsBuilder().append(this.getIdInstructor(), ((Instructor)obj).getIdInstructor());
		return builder.isEquals();
	}
	
	public String getIdInstructor() {
		return idInstructor;
	}
	public void setIdInstructor(String idInstructor) {
		this.idInstructor = idInstructor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumOficio() {
		return numOficio;
	}
	public void setNumOficio(String numOficio) {
		this.numOficio = numOficio;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
