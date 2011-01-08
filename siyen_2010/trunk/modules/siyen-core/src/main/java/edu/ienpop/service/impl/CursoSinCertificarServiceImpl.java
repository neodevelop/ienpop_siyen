package edu.ienpop.service.impl;

import java.util.Set;

import edu.ienpop.dao.CursoSinCertificarDao;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.CursoSinCertificar;
import edu.ienpop.service.CursoSinCertificarService;

public class CursoSinCertificarServiceImpl implements CursoSinCertificarService {

	private CursoSinCertificarDao cursoSinCertificarDao;

	/**
	 * Constructor para las inyecciones
	 */
	public CursoSinCertificarServiceImpl(
			CursoSinCertificarDao cursoSinCertificarDao) {
		this.cursoSinCertificarDao = cursoSinCertificarDao;
	}

	@Override
	public void actualizaCursoSinCertificar(
			CursoSinCertificar cursoSinCertificar,
			Set<Alumno> alumnosSinCertificar) {
		

	}

	@Override
	public void borraCursoSinCertificar(Long idCurso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void crearCursoSinCertificar(CursoSinCertificar cursoSinCertificar,
			Set<Alumno> alumnosSinCertificar) {
		// TODO Auto-generated method stub

	}

	@Override
	public CursoSinCertificar obtenerCursoSinCertificarConAlumnos(Long idCurso) {
		// TODO Auto-generated method stub
		return null;
	}

}
