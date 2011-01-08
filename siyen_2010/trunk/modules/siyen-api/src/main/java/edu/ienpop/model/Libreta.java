package edu.ienpop.model;

public enum Libreta {
	TIPO_A("A","Liberta tipo 'A'"),
	TIPO_B("B","Libreta tipo 'B'"),
	TIPO_C("C","Libreta tipo 'C'"),
	TIPO_D("D","Libreta tipo 'D'");
	
	private String id;
	private String descripcion;
	
	private Libreta(String id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
