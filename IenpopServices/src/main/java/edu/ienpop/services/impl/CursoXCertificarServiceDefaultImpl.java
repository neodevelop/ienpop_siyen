package edu.ienpop.services.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.ienpop.dao.CursoDao;
import edu.ienpop.model.AlumnoXCertificar;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.model.Usuario;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoXCertificarService;
import edu.ienpop.services.PersistenceService;

public class CursoXCertificarServiceDefaultImpl implements
		CursoXCertificarService {

	private PersistenceService persistenceService;
	private CursoDao cursoDao;
	
	public CursoDao getCursoDao() {
		return cursoDao;
	}

	public void setCursoDao(CursoDao cursoDao) {
		this.cursoDao = cursoDao;
	}

	public PersistenceService getPersistenceService() {
		return persistenceService;
	}

	public void setPersistenceService(PersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}

	@SuppressWarnings("unchecked")
	public void addAlumnoACursoXCertificar(long idCursoXCertificar,
			AlumnoXCertificar alumnoXCertificar) throws BusinessException {
		CursoXCertificar curso = (CursoXCertificar)getPersistenceService().findById(CursoXCertificar.class, idCursoXCertificar);
		alumnoXCertificar.setIdStatusAlumno(1);
		alumnoXCertificar.setFechaHoraRegistro(Calendar.getInstance().getTime());
		getPersistenceService().createEntity(alumnoXCertificar);
		getPersistenceService().updateEntity(alumnoXCertificar);
		curso.getAlumnos().add(alumnoXCertificar);
		getPersistenceService().updateEntity(curso);
	}

	public void addAlumnosACursoXCertificar(long idCursoXCertificar,
			Set alumnosXCertificar) throws BusinessException {
		CursoXCertificar curso = (CursoXCertificar)getPersistenceService().findById(CursoXCertificar.class, idCursoXCertificar);
		curso.setAlumnos(alumnosXCertificar);
		for(Iterator it=alumnosXCertificar.iterator();it.hasNext();){
			AlumnoXCertificar alumno = (AlumnoXCertificar)it.next();
			alumno.setIdStatusAlumno(1);
			if(alumno.getId()==null)
				getPersistenceService().createEntity(alumno);
			getPersistenceService().updateEntity(alumno);
		}
		getPersistenceService().updateEntity(curso);
	}

	public Serializable createNuevoCurso(CursoXCertificar cursoXCertificar)
			throws BusinessException {
		cursoXCertificar.setIdStatusCurso(1);
		cursoXCertificar.setFechaHoraRegistro(Calendar.getInstance().getTime());
		getPersistenceService().createEntity(cursoXCertificar);
		getPersistenceService().updateEntity(cursoXCertificar);
		return cursoXCertificar;
	}

	public void removeAlumnoACursoXCertificar(long idCursoXCertificar, AlumnoXCertificar alumnoXCertificar) throws BusinessException {
		//CursoXCertificar curso = (CursoXCertificar)getPersistenceService().findById(CursoXCertificar.class, idCursoXCertificar);
		//curso.getAlumnos().remove(alumnoXCertificar);
		//getPersistenceService().updateEntity(curso);
		getPersistenceService().deleteEntity(alumnoXCertificar);
	}

	public Set getAlumnosDeCursoXCertificar(Long idCursoXCertificar) throws BusinessException {
		CursoXCertificar curso = (CursoXCertificar) getPersistenceService().findById(CursoXCertificar.class, idCursoXCertificar);
		return curso.getAlumnos();
	}

	public void changeAlumnoACursoXCertificar(AlumnoXCertificar alumnoXCertificar) throws BusinessException {
		getPersistenceService().updateEntity(alumnoXCertificar);
	}

	public List getCursosXCertificarSinLlave(String[] idUsuario,String[] idPuerto)  throws BusinessException{
		CursoCriteria cursoCriteria = new CursoCriteria();
		cursoCriteria.setIdStatusCurso(CursoCriteria.NUEVO);
		cursoCriteria.setIdUsuario(idUsuario);
		cursoCriteria.setIdPuerto(idPuerto);
		return getCursoDao().getCursoXCertificarPorCriteria(cursoCriteria);
	}

	@SuppressWarnings("unchecked")
	public Map getMyMap() throws BusinessException {
		Map model =  new HashMap();
		Usuario usuario =  (Usuario)getPersistenceService().findById(Usuario.class, "JUANG");
		model.put("llaveCertificacion", "0123456789abcdefghti");
		model.put("usuario",usuario);
		return model;
	}

}
