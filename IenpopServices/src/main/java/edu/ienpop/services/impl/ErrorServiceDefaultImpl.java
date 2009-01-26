package edu.ienpop.services.impl;

import org.springframework.stereotype.Service;

import edu.ienpop.services.ErrorService;

@Service("errorService")
public class ErrorServiceDefaultImpl implements ErrorService {

	public void throwDataAccessException(){
		// TODO Auto-generated method stub
		
	}

	public void throwException() {
		// TODO Auto-generated method stub
		try {
			throw new Exception("Only Exception");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void throwIllegalArgumentException() {
		// TODO Auto-generated method stub
		throw new IllegalArgumentException("Illegal Exception");
	}

	public void throwNoClassfoundException() {
		// TODO Auto-generated method stub
		try {
			throw new NoSuchFieldException("Field Exception");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
