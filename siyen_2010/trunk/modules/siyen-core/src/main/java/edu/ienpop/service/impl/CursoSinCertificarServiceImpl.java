package edu.ienpop.service.impl;

import java.util.Date;
import java.util.Set;

import edu.ienpop.dao.AlumnoSinCertificarDao;
import edu.ienpop.dao.CursoSinCertificarDao;
import edu.ienpop.model.AlumnoSinCertificar;
import edu.ienpop.model.CursoSinCertificar;
import edu.ienpop.service.CursoSinCertificarService;

public class CursoSinCertificarServiceImpl implements CursoSinCertificarService {

	private CursoSinCertificarDao cursoSinCertificarDao;
	private AlumnoSinCertificarDao alumnoSinCertificarDao;

	public CursoSinCertificarServiceImpl(
			CursoSinCertificarDao cursoSinCertificarDao,
			AlumnoSinCertificarDao alumnoSinCertificarDao) {
		this.cursoSinCertificarDao = cursoSinCertificarDao;
		this.alumnoSinCertificarDao = alumnoSinCertificarDao;
	}

	public void actualizaCursoSinCertificar(
			CursoSinCertificar cursoSinCertificar,
			Set<AlumnoSinCertificar> alumnosSinCertificar) {
		
	}

	public void borraCursoSinCertificar(Long idCurso) {
		// TODO Auto-generated method stub

	}

	public void crearCursoSinCertificar(CursoSinCertificar cursoSinCertificar,
			Set<AlumnoSinCertificar> alumnosSinCertificar) {
		if(!(alumnosSinCertificar.size()>0)){
			throw new BusinessException("No se puede crear un curso sin alumnos registrados...");
		}
		for(AlumnoSinCertificar alumno:alumnosSinCertificar){
			alumno.setFechaHoraRegistro(new Date());
			alumnoSinCertificarDao.create(alumno);
		}
		cursoSinCertificar.setAlumnosSinCertificar(alumnosSinCertificar);
		cursoSinCertificarDao.update(cursoSinCertificar);
	}

	public CursoSinCertificar obtenerCursoSinCertificarConAlumnos(Long idCurso) {
		// TODO Auto-generated method stub
		return null;
	}

}
