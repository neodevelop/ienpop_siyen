package edu.ienpop.services;

import java.util.List;

import edu.ienpop.model.AlumnoCriteria;

public interface AlumnoService {
	@SuppressWarnings("unchecked")
	List getAlumnosByCriteria(AlumnoCriteria alumnoCriteria);
	int getCountAlumnosByCriteria(AlumnoCriteria alumnoCriteria);
	void cambiaNombreDelAlumno(Long alumnoId,String nombre);
}
