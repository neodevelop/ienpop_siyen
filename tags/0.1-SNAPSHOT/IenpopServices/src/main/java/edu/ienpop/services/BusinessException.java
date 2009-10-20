package edu.ienpop.services;

import org.springframework.core.NestedCheckedException;

public class BusinessException extends NestedCheckedException {

	public BusinessException(String mensaje) {
		super(mensaje);
		// TODO Auto-generated constructor stub
	}

	public BusinessException(String mensaje, Throwable causa) {
		// TODO Auto-generated constructor stub
		super(mensaje,causa);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
