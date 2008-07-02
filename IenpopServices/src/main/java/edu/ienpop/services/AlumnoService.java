package edu.ienpop.services;

import java.util.List;

import edu.ienpop.model.AlumnoCriteria;

public interface AlumnoService {
	List getAlumnosByCriteria(AlumnoCriteria alumnoCriteria) throws BusinessException;
	int getCountAlumnosByCriteria(AlumnoCriteria alumnoCriteria) throws BusinessException;
}
