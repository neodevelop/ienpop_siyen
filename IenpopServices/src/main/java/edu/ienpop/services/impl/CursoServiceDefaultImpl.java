 package edu.ienpop.services.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import edu.ienpop.dao.CatalogoDao;
import edu.ienpop.dao.CursoDao;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoXCertificar;
import edu.ienpop.model.CatalogoCurso;
import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoService;
import edu.ienpop.services.LlaveService;
import edu.ienpop.services.PersistenceService;

public class CursoServiceDefaultImpl implements CursoService {

	PersistenceService persistenceService;
	LlaveService llaveService;
	CursoDao cursoDao;
	CatalogoDao catalogoDao;
	
	public CatalogoDao getCatalogoDao() {
		return catalogoDao;
	}

	public void setCatalogoDao(CatalogoDao catalogoDao) {
		this.catalogoDao = catalogoDao;
	}

	public CursoDao getCursoDao() {
		return cursoDao;
	}

	public void setCursoDao(CursoDao cursoDao) {
		this.cursoDao = cursoDao;
	}

	public LlaveService getLlaveService() {
		return llaveService;
	}

	public void setLlaveService(LlaveService llaveService) {
		this.llaveService = llaveService;
	}

	public PersistenceService getPersistenceService() {
		return persistenceService;
	}

	public void setPersistenceService(PersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}

	@SuppressWarnings("unchecked")
	public long addCursoCertificado(long idCursoXCertificar, String llave) throws BusinessException{
		// TODO Auto-generated method stub
		//Obtenemos el curso por certificar
		CursoXCertificar cursoXCertificar = (CursoXCertificar)getPersistenceService().findById(CursoXCertificar.class, (long)idCursoXCertificar);
		//Si el curso no existe pues hay error
		if(cursoXCertificar==null){
			throw new BusinessException("El curso a certificar no existe");
		}
		//Buscamos la llave en nuestra base de llaves para certificar
		LlaveCertificacion llaveCertificacion = getLlaveService().isValidaLlave(llave, idCursoXCertificar);
		//Obtenemos las caracterisiticas del curso, sobre todo la duración
		CatalogoCurso catalogoCurso = (CatalogoCurso)getPersistenceService().findById(CatalogoCurso.class, cursoXCertificar.getIdTipoCurso());
		//Creamos un nuevo curso
		Curso curso = new Curso();
		//Calculamos la fecha de termino del curso en base a la de inicio y al tipo de curso
		Calendar fechaInicio = Calendar.getInstance();
		fechaInicio.setTime(cursoXCertificar.getFechaInicio());
		Calendar fechaFin = Calendar.getInstance();
		fechaFin.set(fechaInicio.get(Calendar.YEAR), fechaInicio.get(Calendar.MONTH), fechaInicio.get(Calendar.DATE));
		fechaFin.add(Calendar.DATE, catalogoCurso.getDuracion()-1);
		//Lo guardamos
		getPersistenceService().createEntity(curso);
		//Le asignamos sus propiedades y sus calculos de fecha
		curso.setFechaInicio(cursoXCertificar.getFechaInicio());
		curso.setFechaHoraRegistro(Calendar.getInstance().getTime());
		curso.setFechaFin(fechaFin.getTime());
		curso.setIdPuerto(cursoXCertificar.getIdPuerto());
		curso.setIdTipoCurso(cursoXCertificar.getIdTipoCurso());
		curso.setIdUsuario(cursoXCertificar.getIdUsuario());
		curso.setIdLlave(llaveCertificacion.getId());
		curso.setIdStatusCurso(3);
		//Actualizamos el uso de la llave
		llaveCertificacion.setFechaUtilizacion(Calendar.getInstance().getTime());
		llaveCertificacion.setIdStatusLlave(1);
		getPersistenceService().updateEntity(llaveCertificacion);
		//Creamos el conjunto donde van a estar los alumnos certificados
		Set alumnos = new HashSet();
		Set alumnosXCertificar = cursoXCertificar.getAlumnos();
		//Agregamos a los alumnos uno por uno
		for(Iterator it = alumnosXCertificar.iterator();it.hasNext();){
			AlumnoXCertificar alumnoXCertificar = (AlumnoXCertificar)it.next();
			//Creamos el alumno
			Alumno alumno = new Alumno();
			//Le asignamos sus propiedades
			alumno.setFechaHoraRegistro(Calendar.getInstance().getTime());
			alumno.setNombreCompleto(alumnoXCertificar.getNombreCompleto());
			alumno.setIdStatusAlumno(2);
			//Establecemos la relacion con el curso
			alumno.setCurso(curso);
			//Guardamos el nuevo alumno
			getPersistenceService().createEntity(alumno);
			//Le Asignamos su numero de control
			alumno.setNumeroControl("II0"+alumno.getId());
			//Actualizamos toda la infromacion del alumno
			getPersistenceService().updateEntity(alumno);
			//Agregamos el alumno al curso
			alumnos.add(alumno);
		}
		//Cerramos la relación
		curso.setAlumnos(alumnos);
		//Termina su uso el curso x certificar
		cursoXCertificar.setIdStatusCurso(3);
		getPersistenceService().updateEntity(cursoXCertificar);
		//Guardamos los cambios
		getPersistenceService().updateEntity(curso);
		return curso.getId();
	}

	@SuppressWarnings("unchecked")
	public Curso generateCertificadosXCurso(long idCurso) throws BusinessException {
		// TODO Auto-generated method stub
		Curso curso = (Curso)getPersistenceService().findById(Curso.class, idCurso);
		if(curso==null){
			throw new BusinessException("El curso no existe...");
		}
		if(curso.getIdStatusCurso()!=3){
			throw new BusinessException("El curso no se puede certificar, por favor verifica los datos con la Oficina de Titulación...");
		}
		Set alumnos = curso.getAlumnos();
		curso.setIdStatusCurso(4);
		for(Iterator it = alumnos.iterator();it.hasNext();){
			Alumno alumno = (Alumno)it.next();
			alumno.setIdStatusAlumno(3);
			getPersistenceService().updateEntity(alumno);
		}
		getPersistenceService().updateEntity(curso);
		return curso;
	}

	public List getInformeMensual(int mes, int anio) throws BusinessException {
		Calendar fechaDesde = Calendar.getInstance();
		fechaDesde.set(anio, mes-1, 1);
		Calendar fechaHasta = Calendar.getInstance();
		fechaHasta.set(anio, mes, 1);
		fechaHasta.add(Calendar.DATE, -1);
		CursoCriteria cursoCriteria =  new CursoCriteria();
		cursoCriteria.setFechaDesde(fechaDesde.getTime());
		cursoCriteria.setFechaHasta(fechaHasta.getTime());
		cursoCriteria.setIdStatusCurso(4);
		return getCursoDao().getCursosPorCriteria(cursoCriteria);
	}

	public List getInformeXTipoLibreta(int mes, int anio, String libreta,
			String idPuerto) throws BusinessException {
		Calendar fechaDesde = Calendar.getInstance();
		fechaDesde.set(anio, mes-1, 1);
		Calendar fechaHasta = Calendar.getInstance();
		fechaHasta.set(anio, mes, 1);
		fechaHasta.add(Calendar.DATE, -1);
		Object[] idTipoCursos = getCatalogoDao().getGrupoCursosXLibreta(libreta);
		CursoCriteria cursoCriteria = new CursoCriteria();
		cursoCriteria.setFechaDesde(fechaDesde.getTime());
		cursoCriteria.setFechaHasta(fechaHasta.getTime());
		cursoCriteria.setIdTipoCurso(idTipoCursos);
		cursoCriteria.setIdStatusCurso(4);
		return getCursoDao().getCursosPorCriteria(cursoCriteria);
	}

	public List getOficio(Date fechaInicio, Date fechaFin,
			String idPuerto) throws BusinessException {
		if(idPuerto==null)
			throw new BusinessException("No se ha especificado un puerto, posiblemente expiró la sesión o el valor es incorrecto...");
		CursoCriteria cursoCriteria = new CursoCriteria();
		cursoCriteria.setFechaDesde(fechaInicio);
		cursoCriteria.setFechaHasta(fechaFin);
		cursoCriteria.setIdPuerto(new String[] {idPuerto});
		return getCursoDao().getCursosPorCriteria(cursoCriteria);
	}

	public List getCursosXStatus(CursoCriteria cursoCriteria) throws BusinessException {
		if(cursoCriteria.getIdPuerto()==null)
			throw new BusinessException("No se ha especificado un puerto, posiblemente expiró la sesión o el valor es incorrecto...");
		if(cursoCriteria.getIdStatusCurso()==0)
			throw new BusinessException("El status del curso no es vaĺido para la búsqueda...");
		if(cursoCriteria.getIdStatusCurso()==CursoCriteria.NUEVO || cursoCriteria.getIdStatusCurso()==CursoCriteria.ABIERTO)
			return getCursoDao().getCursoXCertificarPorCriteria(cursoCriteria);
		else
			return getCursoDao().getCursosPorCriteria(cursoCriteria);
	}

}
