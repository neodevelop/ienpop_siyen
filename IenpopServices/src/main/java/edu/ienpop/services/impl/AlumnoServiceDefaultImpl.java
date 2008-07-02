package edu.ienpop.services.impl;

import java.util.List;

import edu.ienpop.dao.AlumnoDao;
import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.services.AlumnoService;
import edu.ienpop.services.BusinessException;

public class AlumnoServiceDefaultImpl implements AlumnoService {
	
	private AlumnoDao alumnoDao;

	public AlumnoDao getAlumnoDao() {
		return alumnoDao;
	}


	public void setAlumnoDao(AlumnoDao alumnoDao) {
		this.alumnoDao = alumnoDao;
	}


	@SuppressWarnings("unchecked")
	public List getAlumnosByCriteria(AlumnoCriteria alumnoCriteria)
			throws BusinessException {
		List alumnos = null;
		if(alumnoCriteria.getIdStatusAlumno()==AlumnoCriteria.INSCRITO || alumnoCriteria.getIdStatusAlumno()==AlumnoCriteria.EVALUADO)
			alumnos = getAlumnoDao().getAlumnosXCertificarPorCriteria(alumnoCriteria);
		else if(alumnoCriteria.getIdStatusAlumno()==AlumnoCriteria.CERTIFICADO)
			alumnos = getAlumnoDao().getAlumnosPorCriteria(alumnoCriteria);
		if(alumnos==null)
			throw new BusinessException("Error en la busqueda de alumnos, intentar nuevamente...");
		return alumnos;
	}


	public int getCountAlumnosByCriteria(AlumnoCriteria alumnoCriteria)
			throws BusinessException {
		return getAlumnoDao().getCountAlumnosPorCriteria(alumnoCriteria);
	}

}
