package edu.ienpop.service.impl;

import org.springframework.core.NestedRuntimeException;

/**
 * @author neodevelop
 *
 */
public class BusinessException extends NestedRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String msg) {
		super(msg);
	}
	
	public BusinessException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
