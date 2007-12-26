package edu.ienpop.model;

import java.io.Serializable;
import java.util.Set;

public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idUsuario;
	private String password;
	private String nombre;
	private int tipoUsuario;
	private String numOficio;
	private String email;
	private Set puertos;
	public Set getPuertos() {
		return puertos;
	}
	public void setPuertos(Set puertos) {
		this.puertos = puertos;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
