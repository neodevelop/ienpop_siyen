package edu.ienpop.dao;

import java.util.List;

import edu.ienpop.model.AlumnoCriteria;

@SuppressWarnings("unchecked")
public interface AlumnoDao {
	List getAlumnosPorCriteria(AlumnoCriteria alumnoCriteria);
	Integer getCountAlumnosPorCriteria(AlumnoCriteria alumnoCriteria);
	List getAlumnosXCertificarPorCriteria(AlumnoCriteria alumnoCriteria);
}
