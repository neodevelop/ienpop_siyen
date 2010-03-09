package edu.ienpop.model;

public class CatalogoPuerto {
	private String idPuerto;
	private String puerto;
	private String estado;
	private String direccion;
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
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
	
}
