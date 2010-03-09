package edu.ienpop.services.impl;

import edu.ienpop.dao.AlumnoDao;
import edu.ienpop.dao.Dao;
import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.model.Alumno;
import edu.ienpop.services.AlumnoService;
import edu.ienpop.services.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service("alumnoService")
public class AlumnoServiceDefaultImpl implements AlumnoService {
	
	@Autowired
	private AlumnoDao alumnoDao;
	@Autowired
	private Dao dao;

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
	
	public void cambiaNombreDelAlumno(Long alumnoId,String nombre) throws BusinessException{
		Alumno alumno = dao.getByPK(Alumno.class, alumnoId)
		if(nombre){
			alumno.setNombreCompleto(nombre)
			dao.update(alumno)
		}else{
			throw new BusinessException("El nombre no puede ser vac’o o nulo...");
		}		
	}
	
	Alumno getAlumnoPorNumeroControl(String numeroControl){
		Long id = numeroControl.substring(2) as Long
		dao.getByPK(Alumno.class, id) as Alumno
	}
}
