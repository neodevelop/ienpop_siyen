package edu.ienpop.dao;

import java.util.List;

import edu.ienpop.model.AlumnoCriteria;


public interface AlumnoDao {
	List getAlumnosPorCriteria(AlumnoCriteria alumnoCriteria);
	int getCountAlumnosPorCriteria(AlumnoCriteria alumnoCriteria);
	List getAlumnosXCertificarPorCriteria(AlumnoCriteria alumnoCriteria);
}
