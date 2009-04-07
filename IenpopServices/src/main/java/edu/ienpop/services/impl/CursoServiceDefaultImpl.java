 package edu.ienpop.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ienpop.dao.CatalogoDao;
import edu.ienpop.dao.CursoDao;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoCriteria;
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

@Service("cursoService")
public class CursoServiceDefaultImpl implements CursoService {

	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	PersistenceService persistenceService;
	@Autowired
	LlaveService llaveService;
	@Autowired
	CursoDao cursoDao;
	@Autowired
	CatalogoDao catalogoDao;

	@SuppressWarnings("unchecked")
	public long addCursoCertificado(long idCursoXCertificar, String llave) throws BusinessException{
		// TODO Auto-generated method stub
		//Obtenemos el curso por certificar
		CursoXCertificar cursoXCertificar = (CursoXCertificar)persistenceService.findById(CursoXCertificar.class, (long)idCursoXCertificar);
		//Si el curso no existe pues hay error
		if(cursoXCertificar==null){
			throw new BusinessException("El curso a certificar no existe");
		}
		//Buscamos la llave en nuestra base de llaves para certificar
		LlaveCertificacion llaveCertificacion = llaveService.isValidaLlave(llave, idCursoXCertificar);
		//Obtenemos las caracterisiticas del curso, sobre todo la duraciÃ³n
		CatalogoCurso catalogoCurso = (CatalogoCurso)persistenceService.findById(CatalogoCurso.class, cursoXCertificar.getIdTipoCurso());
		//Creamos un nuevo curso
		Curso curso = new Curso();
		//Calculamos la fecha de termino del curso en base a la de inicio y al tipo de curso
		Calendar fechaInicio = Calendar.getInstance();
		fechaInicio.setTime(cursoXCertificar.getFechaInicio());
		Calendar fechaFin = Calendar.getInstance();
		fechaFin.set(fechaInicio.get(Calendar.YEAR), fechaInicio.get(Calendar.MONTH), fechaInicio.get(Calendar.DATE));
		fechaFin.add(Calendar.DATE, catalogoCurso.getDuracion()-1);
		//Le asignamos sus propiedades y sus calculos de fecha
		curso.setFechaInicio(cursoXCertificar.getFechaInicio());
		curso.setFechaHoraRegistro(Calendar.getInstance().getTime());
		curso.setFechaFin(fechaFin.getTime());
		curso.setIdPuerto(cursoXCertificar.getIdPuerto());
		curso.setTipoCurso((CatalogoCurso)persistenceService.findById(CatalogoCurso.class,cursoXCertificar.getIdTipoCurso()));
		curso.setIdUsuario(cursoXCertificar.getIdUsuario());
		curso.setIdLlave(llaveCertificacion.getId());
		curso.setIdStatusCurso(3);
		//Lo guardamos
		persistenceService.createEntity(curso);
		//Actualizamos el uso de la llave
		llaveCertificacion.setFechaUtilizacion(Calendar.getInstance().getTime());
		llaveCertificacion.setIdStatusLlave(1);
		persistenceService.updateEntity(llaveCertificacion);
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
			persistenceService.createEntity(alumno);
			//Le Asignamos su numero de control
			alumno.setNumeroControl("II0"+alumno.getId());
			//Actualizamos toda la infromacion del alumno
			persistenceService.updateEntity(alumno);
			//Agregamos el alumno al curso
			alumnos.add(alumno);
		}
		//Cerramos la relaciÃ³n
		curso.setAlumnos(alumnos);
		//Termina su uso el curso x certificar
		cursoXCertificar.setIdStatusCurso(3);
		persistenceService.updateEntity(cursoXCertificar);
		//Guardamos los cambios
		persistenceService.updateEntity(curso);
		return curso.getId();
	}

	@SuppressWarnings("unchecked")
	public Curso generateCertificadosXCurso(long idCurso) throws BusinessException {
		// TODO Auto-generated method stub
		Curso curso = (Curso)persistenceService.findById(Curso.class, idCurso);
		if(curso==null){
			throw new BusinessException("El curso no existe...");
		}
		if(curso.getIdStatusCurso()!=3){
			throw new BusinessException("El curso no se puede certificar, por favor verifica los datos con la Oficina de TitulaciÃ³n...");
		}
		Set alumnos = curso.getAlumnos();
		curso.setIdStatusCurso(4);
		for(Iterator it = alumnos.iterator();it.hasNext();){
			Alumno alumno = (Alumno)it.next();
			alumno.setIdStatusAlumno(3);
			persistenceService.updateEntity(alumno);
		}
		persistenceService.updateEntity(curso);
		return curso;
	}

	@SuppressWarnings("unchecked")
	public List getInformePeriodico(Date desde, Date hasta) throws BusinessException {
		//Calendar fechaDesde = Calendar.getInstance();
		//fechaDesde.set(anio, mes-1, 1);
		//Calendar fechaHasta = Calendar.getInstance();
		//fechaHasta.set(anio, mes, 1);
		//fechaHasta.add(Calendar.DATE, -1);
		CursoCriteria cursoCriteria =  new CursoCriteria();
		//cursoCriteria.setFechaDesde(fechaDesde.getTime());
		//cursoCriteria.setFechaHasta(fechaHasta.getTime());
		cursoCriteria.setFechaDesde(desde);
		cursoCriteria.setFechaHasta(hasta);
		cursoCriteria.setIdStatusCurso(CursoCriteria.CONCLUIDO);
		return cursoDao.getCursosPorCriteria(cursoCriteria);
	}

	@SuppressWarnings("unchecked")
	public List getInformeXTipoLibreta(int mes, int anio, String libreta,
			String idPuerto) throws BusinessException {
		Calendar fechaDesde = Calendar.getInstance();
		fechaDesde.set(anio, mes-1, 1);
		Calendar fechaHasta = Calendar.getInstance();
		fechaHasta.set(anio, mes, 1);
		fechaHasta.add(Calendar.DATE, -1);
		String[] idTipoCursos = (String[])catalogoDao.getGrupoCursosXLibreta(libreta);
		CursoCriteria cursoCriteria = new CursoCriteria();
		cursoCriteria.setFechaDesde(fechaDesde.getTime());
		cursoCriteria.setFechaHasta(fechaHasta.getTime());
		cursoCriteria.setIdTipoCurso(idTipoCursos);
		cursoCriteria.setIdStatusCurso(CursoCriteria.CONCLUIDO);
		return cursoDao.getCursosPorCriteria(cursoCriteria);
	}

	@SuppressWarnings("unchecked")
	public List getOficio(Date fechaInicio, Date fechaFin,
			String idPuerto) throws BusinessException {
		if(idPuerto==null)
			throw new BusinessException("No se ha especificado un puerto, posiblemente expirÃ³ la sesiÃ³n o el valor es incorrecto...");
		CursoCriteria cursoCriteria = new CursoCriteria();
		cursoCriteria.setFechaDesde(fechaInicio);
		cursoCriteria.setFechaHasta(fechaFin);
		cursoCriteria.setIdPuerto(new String[] {idPuerto});
		cursoCriteria.setIdStatusCurso(CursoCriteria.CONCLUIDO);
		return cursoDao.getCursosPorCriteria(cursoCriteria);
	}

	@SuppressWarnings("unchecked")
	public List getCursosXStatus(CursoCriteria cursoCriteria) throws BusinessException {
		if(cursoCriteria.getIdPuerto()==null){
			throw new BusinessException("No se ha especificado un puerto, posiblemente expirÃ³ la sesiÃ³n o el valor es incorrecto...");
		}else{
			log.debug(ToStringBuilder.reflectionToString(cursoCriteria.getIdPuerto()));
			log.debug(ToStringBuilder.reflectionToString(cursoCriteria.getIdTipoCurso()));
		}
		if(cursoCriteria.getIdStatusCurso()==0)
			throw new BusinessException("El status del curso no es vaÄºido para la bÃºsqueda...");
		//Recorremos las libretas para determinar los puertos a buscar
		//Si las libretas en cirteria vienen con algo
		if(cursoCriteria.getLibretas()!=null){
			//Acumulador de idTipoCurso
			List idTipoCursos = new ArrayList();
			//Comenzamos a desplegar las libretas
			String[] libretas = cursoCriteria.getLibretas(); 
			for(int i=0;i<libretas.length;i++){
				log.debug("Libreta: "+libretas[i]);
				Object[] tipoCursos = catalogoDao.getGrupoCursosXLibreta(libretas[i]);
				log.debug("Cursos de la libreta "+libretas[i]+": ");
				//Pasamos los idTipoCurso al List para despues hacerlo array
				for(int j=0;j<tipoCursos.length;j++){
					log.debug(tipoCursos[j]);
					idTipoCursos.add(tipoCursos[j]);
				}
			}
			//Hacemos Array al List y lo mandamos como parametro en el criteria
			String[] arraytipoCursos = new String[idTipoCursos.size()];
			idTipoCursos.toArray(arraytipoCursos);
			cursoCriteria.setIdTipoCurso(arraytipoCursos);
		}
		if(cursoCriteria.getIdStatusCurso()==CursoCriteria.NUEVO || cursoCriteria.getIdStatusCurso()==CursoCriteria.ABIERTO)
			return cursoDao.getCursoXCertificarPorCriteria(cursoCriteria);
		else
			return cursoDao.getCursosPorCriteria(cursoCriteria);
	}

	public String getIdTipoCursoById(String idCurso) throws BusinessException {
		return cursoDao.getTipoCursoByIdCurso(idCurso);
	}

	public Curso getCursoByTokenCertificado(String token)
			throws BusinessException {
		LlaveCertificacion llave = llaveService.getLlavebyToken(token);
		if(llave==null)
			throw new BusinessException("El c—digo es invalido...");
		Curso curso = cursoDao.getCursoByIdLlaveCertificada(llave.getId());
		return curso;
	}

	public Integer getCountCursosByCriteria(CursoCriteria cursoCriteria)
			throws BusinessException {
		return cursoDao.getCountCursosPorCriteria(cursoCriteria);
	}

	public Curso getCursoById(Long id) throws BusinessException {
		return (Curso)persistenceService.findById(Curso.class, id);
	}

	@SuppressWarnings("unchecked")
	public void recoveryCursoCertificado(Curso cursoModificar) throws BusinessException {
		//antes de actualizar hjay que recalcular las fechas y no esta pasando bien el parametro que modifica el status de los alumnos
		log.debug("Actualizando la entidad modificada ð");
		persistenceService.updateEntity(cursoModificar);
		log.debug("Obteniendo la llave del curso ð");
		LlaveCertificacion llave = (LlaveCertificacion)persistenceService.findById(LlaveCertificacion.class, cursoModificar.getIdLlave());
		log.debug("Cambio de status de la llave ð");
		llave.setIdStatusLlave(0);
		log.debug("Actualizando la llave ð");
		persistenceService.updateEntity(llave);
		log.debug("Recorriendo la lista de alumnos ð");
		Set<Alumno> alumnos = cursoModificar.getAlumnos();
		log.debug("Tama–o del curso: "+alumnos.size());
		for(Alumno alumno:alumnos){
			log.debug(alumno.getId());
		}
	}

	public void recoveryCursoCertificado(Curso cursoModificar, List<Long> alumnos)
			throws BusinessException {
		//antes de actualizar hjay que recalcular las fechas y no esta pasando bien el parametro que modifica el status de los alumnos
		log.debug("Actualizando la entidad modificada ð");
		persistenceService.updateEntity(cursoModificar);
		log.debug("Obteniendo la llave del curso ð");
		LlaveCertificacion llave = (LlaveCertificacion)persistenceService.findById(LlaveCertificacion.class, cursoModificar.getIdLlave());
		if(llave==null){
			throw new BusinessException("Este curso no tiene una llave asociada...");
		}
		log.debug("Cambio de status de la llave ð");
		llave.setIdStatusLlave(0);
		log.debug("Actualizando la llave ð");
		persistenceService.updateEntity(llave);
		log.debug("Recorriendo la lista de alumnos ð");
		for(Long idAlumno:alumnos){
			Alumno alumno = (Alumno)persistenceService.findById(Alumno.class, idAlumno);
			alumno.setIdStatusAlumno(AlumnoCriteria.EVALUADO);
			persistenceService.updateEntity(alumno);
		}
		
	}
}
