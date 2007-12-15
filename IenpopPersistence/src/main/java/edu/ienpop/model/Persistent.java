package edu.ienpop.model;

import java.io.Serializable;

public abstract class Persistent implements Serializable {
	private transient Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
