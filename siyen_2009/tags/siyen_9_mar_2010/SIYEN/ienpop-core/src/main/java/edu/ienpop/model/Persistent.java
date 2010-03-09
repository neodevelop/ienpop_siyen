package edu.ienpop.model;

import java.io.Serializable;

public abstract class Persistent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
