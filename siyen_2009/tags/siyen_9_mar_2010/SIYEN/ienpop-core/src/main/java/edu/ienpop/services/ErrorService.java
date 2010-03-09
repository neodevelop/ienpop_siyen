package edu.ienpop.services;

public interface ErrorService {
	void throwException();
	void throwIllegalArgumentException();
	void throwDataAccessException();
	void throwNoClassfoundException();
}
