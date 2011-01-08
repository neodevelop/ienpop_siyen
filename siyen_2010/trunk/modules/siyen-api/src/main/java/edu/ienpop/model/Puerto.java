package edu.ienpop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author neodevelop
 *
 */
@Entity
@Table(name="catalogo_puerto")
public class Puerto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id private String idPuerto;
	@Transient private String puerto;
	@Transient private String estado;
	@Transient private String direccion;
	@Transient private Boolean activo;
	
	public String getIdPuerto() {
		return idPuerto;
	}
	public void setIdPuerto(String idPuerto) {
		this.idPuerto = idPuerto;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
