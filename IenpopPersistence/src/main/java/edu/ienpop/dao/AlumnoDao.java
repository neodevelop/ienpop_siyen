package edu.ienpop.dao;

import java.util.List;

import edu.ienpop.model.AlumnoCriteria;


public interface AlumnoDao {
	List getAlumnosPorCriteria(AlumnoCriteria alumnoCriteria);
	List getAlumnosXCertificarPorCriteria(AlumnoCriteria alumnoCriteria);
}
