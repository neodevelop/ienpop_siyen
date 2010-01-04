package edu.ienpop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ienpop.dao.AlumnoDao;
import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.services.AlumnoService;
import edu.ienpop.services.BusinessException;

@Service("alumnoService")
public class AlumnoServiceDefaultImpl implements AlumnoService {
	
	@Autowired
	private AlumnoDao alumnoDao;

	@SuppressWarnings("unchecked")
	public List getAlumnosByCriteria(AlumnoCriteria alumnoCriteria)
			throws BusinessException {
		List alumnos = null;
		if(alumnoCriteria.getIdStatusAlumno()==AlumnoCriteria.INSCRITO || alumnoCriteria.getIdStatusAlumno()==AlumnoCriteria.EVALUADO)
			alumnos = alumnoDao.getAlumnosXCertificarPorCriteria(alumnoCriteria);
		else if(alumnoCriteria.getIdStatusAlumno()==AlumnoCriteria.CERTIFICADO)
			alumnos = alumnoDao.getAlumnosPorCriteria(alumnoCriteria);
		if(alumnos==null)
			throw new BusinessException("Error en la busqueda de alumnos, intentar nuevamente...");
		return alumnos;
	}


	public int getCountAlumnosByCriteria(AlumnoCriteria alumnoCriteria)
			throws BusinessException {
		return alumnoDao.getCountAlumnosPorCriteria(alumnoCriteria);
	}

}
