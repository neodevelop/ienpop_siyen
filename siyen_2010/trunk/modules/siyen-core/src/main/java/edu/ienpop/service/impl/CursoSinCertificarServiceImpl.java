package edu.ienpop.service.impl;

import java.util.Date;
import java.util.List;

import edu.ienpop.dao.AlumnoSinCertificarDao;
import edu.ienpop.dao.CursoSinCertificarDao;
import edu.ienpop.model.AlumnoSinCertificar;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoSinCertificar;
import edu.ienpop.service.CursoSinCertificarService;

public class CursoSinCertificarServiceImpl implements CursoSinCertificarService {

	private CursoSinCertificarDao cursoSinCertificarDao;
	private AlumnoSinCertificarDao alumnoSinCertificaroDao;

	public CursoSinCertificarServiceImpl(
			CursoSinCertificarDao cursoSinCertificarDao,
			AlumnoSinCertificarDao alumnoSinCertificaroDao) {
		this.cursoSinCertificarDao = cursoSinCertificarDao;
		this.alumnoSinCertificaroDao = alumnoSinCertificaroDao;
	}

	public void actualizaCursoSinCertificar(CursoSinCertificar cursoSinCertificar) {
		cursoSinCertificarDao.update(cursoSinCertificar);
	}

	public void borraCursoSinCertificar(Long idCurso) {
		CursoSinCertificar cursoSinCertificar = cursoSinCertificarDao
				.read(idCurso);
		cursoSinCertificarDao.delete(cursoSinCertificar);
	}

	public void crearCursoSinCertificar(CursoSinCertificar cursoSinCertificar,
			List<AlumnoSinCertificar> alumnosSinCertificar) {

		if (!(alumnosSinCertificar.size() > 0)) {
			throw new BusinessException(
					"No se puede crear un curso sin alumnos registrados...");
		}

		for (AlumnoSinCertificar alumno : alumnosSinCertificar) {
			alumno.setFechaHoraRegistro(new Date());
			alumno.setCursoSinCertificar(cursoSinCertificar);
		}

		cursoSinCertificar.setFechaHoraRegistro(new Date());
		cursoSinCertificar.setAlumnosSinCertificar(alumnosSinCertificar);
		cursoSinCertificarDao.create(cursoSinCertificar);
		for (AlumnoSinCertificar alumnoSinCertificar : cursoSinCertificar
				.getAlumnosSinCertificar()) {
			alumnoSinCertificaroDao.create(alumnoSinCertificar);
		}
	}

	public CursoSinCertificar obtenerCursoSinCertificarConAlumnos(Long idCurso) {
		CursoSinCertificar cursoSinCertificar = cursoSinCertificarDao
				.read(idCurso);
		List<AlumnoSinCertificar> alumnosSinCertificar = alumnoSinCertificaroDao
				.obtenerAlumnosSinCertificarPorIdCurso(idCurso);
		cursoSinCertificar.setAlumnosSinCertificar(alumnosSinCertificar);
		return cursoSinCertificar;
	}

	@Override
	public CursoSinCertificar obtenerCursoSinCertificarPorId(Long idCurso) {
		return cursoSinCertificarDao.read(idCurso);
	}

	@Override
	public List<CursoSinCertificar> obtenerCursosConCriteria(
			CursoCriteria cursoCriteria, int offset, int maxSize) {
		return cursoSinCertificarDao.obtenerCursosSinCertificarConRelaciones(cursoCriteria, offset, maxSize);
	}

	@Override
	public int obtenerContadorDeCursosSinCertificar(CursoCriteria cursoCriteria) {
		return cursoSinCertificarDao.obtenerContadorDeCursosSinCertificar(cursoCriteria);
	}

}
