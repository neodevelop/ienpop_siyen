package edu.ienpop.dao;

import java.util.List;

import edu.ienpop.model.AlumnoCriteria;


public interface AlumnoDao {
	public List getAlumnosPorCriteria(AlumnoCriteria alumnoCriteria);
	public List getAlumnosXCertificarPorCriteria(AlumnoCriteria alumnoCriteria);
}
