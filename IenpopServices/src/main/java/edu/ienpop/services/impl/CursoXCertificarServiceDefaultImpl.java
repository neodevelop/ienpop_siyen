package edu.ienpop.services.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ienpop.dao.CursoDao;
import edu.ienpop.model.AlumnoXCertificar;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoXCertificarService;
import edu.ienpop.services.PersistenceService;

@SuppressWarnings("unchecked")
@Service("cursoXCertificarService")
public class CursoXCertificarServiceDefaultImpl implements
		CursoXCertificarService {

	@Autowired
	private PersistenceService persistenceService;
	@Autowired
	private CursoDao cursoDao;

	public void addAlumnoACursoXCertificar(long idCursoXCertificar,
			AlumnoXCertificar alumnoXCertificar) throws BusinessException {
		CursoXCertificar curso = (CursoXCertificar) persistenceService
				.findById(CursoXCertificar.class, idCursoXCertificar);
		alumnoXCertificar.setIdStatusAlumno(1);
		alumnoXCertificar
				.setFechaHoraRegistro(Calendar.getInstance().getTime());
		persistenceService.createEntity(alumnoXCertificar);
		persistenceService.updateEntity(alumnoXCertificar);
		curso.getAlumnos().add(alumnoXCertificar);
		persistenceService.updateEntity(curso);
	}

	public void addAlumnosACursoXCertificar(long idCursoXCertificar,
			Set alumnosXCertificar) throws BusinessException {
		CursoXCertificar curso = (CursoXCertificar) persistenceService
				.findById(CursoXCertificar.class, idCursoXCertificar);
		curso.setAlumnos(alumnosXCertificar);
		for (Iterator it = alumnosXCertificar.iterator(); it.hasNext();) {
			AlumnoXCertificar alumno = (AlumnoXCertificar) it.next();
			alumno.setIdStatusAlumno(1);
			if (alumno.getId() == null)
				persistenceService.createEntity(alumno);
			persistenceService.updateEntity(alumno);
		}
		persistenceService.updateEntity(curso);
	}

	public Serializable createNuevoCurso(CursoXCertificar cursoXCertificar)
			throws BusinessException {
		cursoXCertificar.setIdStatusCurso(1);
		cursoXCertificar.setFechaHoraRegistro(Calendar.getInstance().getTime());
		persistenceService.createEntity(cursoXCertificar);
		persistenceService.updateEntity(cursoXCertificar);
		return cursoXCertificar;
	}

	public void removeAlumnoACursoXCertificar(long idCursoXCertificar,
			AlumnoXCertificar alumnoXCertificar) throws BusinessException {
		// CursoXCertificar curso =
		// (CursoXCertificar)persistenceService.findById(CursoXCertificar.class,
		// idCursoXCertificar);
		// curso.getAlumnos().remove(alumnoXCertificar);
		// persistenceService.updateEntity(curso);
		if (alumnoXCertificar == null) {
			throw new BusinessException(
					"El alumno ya ha sido borrado previamente...");
		}
		persistenceService.deleteEntity(alumnoXCertificar);
	}

	public Set getAlumnosDeCursoXCertificar(Long idCursoXCertificar)
			throws BusinessException {
		CursoXCertificar curso = (CursoXCertificar) persistenceService
				.findById(CursoXCertificar.class, idCursoXCertificar);
		return curso.getAlumnos();
	}

	public void changeAlumnoACursoXCertificar(
			AlumnoXCertificar alumnoXCertificar) throws BusinessException {
		persistenceService.updateEntity(alumnoXCertificar);
	}

	public List getCursosXCertificarSinLlave(String[] idUsuario,
			String[] idPuerto) throws BusinessException {
		CursoCriteria cursoCriteria = new CursoCriteria();
		cursoCriteria.setIdStatusCurso(CursoCriteria.NUEVO);
		cursoCriteria.setIdUsuario(idUsuario);
		cursoCriteria.setIdPuerto(idPuerto);
		return cursoDao.getCursoXCertificarPorCriteria(cursoCriteria);
	}

	public List getCursosXCertificarConLlave(String[] idUsuario,
			String[] idPuerto) throws BusinessException {
		CursoCriteria cursoCriteria = new CursoCriteria();
		cursoCriteria.setIdStatusCurso(CursoCriteria.ABIERTO);
		cursoCriteria.setIdUsuario(idUsuario);
		cursoCriteria.setIdPuerto(idPuerto);
		//Usamos una lista para obtener los cursos por certificar
		List cursosXCertificar = cursoDao.getCursoXCertificarPorCriteria(cursoCriteria);
		//Le a–adimos los cursos certificados pero que se recuperaron
		cursosXCertificar.addAll(cursoDao.getCursosPorCriteria(cursoCriteria));
		return cursosXCertificar;
	}

}
