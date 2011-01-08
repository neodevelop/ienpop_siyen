package edu.ienpop.model;

import java.io.Serializable;
import java.util.Set;

/**
 * @author neodevelop
 *
 */
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idUsuario;
	private String password;
	private String nombre;
	private String email;
	private Set<Instructor> instructores;
	private Set<Puerto> puertos;
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Instructor> getInstructores() {
		return instructores;
	}
	public void setInstructores(Set<Instructor> instructores) {
		this.instructores = instructores;
	}
	public Set<Puerto> getPuertos() {
		return puertos;
	}
	public void setPuertos(Set<Puerto> puertos) {
		this.puertos = puertos;
	}
}
