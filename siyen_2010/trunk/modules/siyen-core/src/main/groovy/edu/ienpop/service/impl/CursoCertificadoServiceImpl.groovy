package edu.ienpop.service.impl

import java.util.Date
import java.util.HashSet
import java.util.List

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

import edu.ienpop.dao.AlumnoCertificadoDao
import edu.ienpop.dao.CursoCertificadoDao
import edu.ienpop.dao.CursoSinCertificarDao
import edu.ienpop.dao.TipoCursoDao
import edu.ienpop.model.AlumnoCertificado
import edu.ienpop.model.AlumnoSinCertificar
import edu.ienpop.model.CursoCertificado
import edu.ienpop.model.CursoCriteria
import edu.ienpop.model.CursoSinCertificar
import edu.ienpop.service.CursoCertificadoService

class CursoCertificadoServiceImpl implements CursoCertificadoService {
	
	private static final Log logger = LogFactory.getLog(CursoCertificadoServiceImpl)
	
	private CursoSinCertificarDao cursoSinCertificarDao
	private CursoCertificadoDao cursoCertificadoDao
	private TipoCursoDao tipoCursoDao
	private AlumnoCertificadoDao alumnoCertificadoDao
	
	CursoCertificadoServiceImpl(
	CursoSinCertificarDao cursoSinCertificarDao,
	CursoCertificadoDao cursoCertificadoDao, TipoCursoDao tipoCursoDao,AlumnoCertificadoDao alumnoCertificadoDao) {
		this.cursoSinCertificarDao = cursoSinCertificarDao
		this.cursoCertificadoDao = cursoCertificadoDao
		this.tipoCursoDao = tipoCursoDao
		this.alumnoCertificadoDao = alumnoCertificadoDao
	}
	
	@Override
	long certificarCurso(Long idCursoSinCertificar) {
		logger.debug "Obtenemos el cursoSinCertificar"
		CursoSinCertificar cursoSinCertificar = cursoSinCertificarDao
				.obtenerCursoSinCertificarConRelaciones(idCursoSinCertificar)
		logger.debug "Creamos la nueva instancia del curso certificado"
		CursoCertificado cursoCertificado = new CursoCertificado()
		logger.debug "No asignamos el boolean de 'certificado' por que es false por defecto"
		logger.debug "Ponemos la fecha y hora del registro de este curso"
		cursoCertificado.setFechaHoraRegistro(new Date())
		logger.debug "Le decimos cuando empezo el curso"
		cursoCertificado.setFechaInicio(cursoSinCertificar.getFechaInicio())
		logger.debug "Calculo de la fecha de termino del curso"
		Date fechaFin = cursoSinCertificar.fechaInicio + cursoSinCertificar.tipoCurso.duracion - 1
		logger.debug "Se resta uno por que se toma como fecha de inicio el mismo d’a en el que empieza" 
		cursoCertificado.fechaFin = fechaFin
		logger.debug "Asignamos el instructor, el tipoCurso y el puerto"
		cursoCertificado.setInstructor(cursoSinCertificar.getInstructor())
		cursoCertificado.setPuerto(cursoSinCertificar.getPuerto())
		cursoCertificado.setTipoCurso(cursoSinCertificar.getTipoCurso())
		logger.debug "Iteramos la lista de alumnos del cursoSinCertificar y los asignamos al cursoCertificado"
		cursoCertificado
				.setAlumnosCertificados(new HashSet<AlumnoCertificado>())
		for (AlumnoSinCertificar alumnoSinCertificar : cursoSinCertificar
		.getAlumnosSinCertificar()) {
			logger.debug "Creamos el alumno certificado para agregarlo a la lista"
			AlumnoCertificado alumnoCertificado = new AlumnoCertificado()
			alumnoCertificado.fechaHoraRegistro = new Date()
			logger.debug "Emparejamos sus propiedades"
			alumnoCertificado.setNombreCompleto(alumnoSinCertificar
					.getNombreCompleto())
			alumnoCertificado.setObservaciones(alumnoSinCertificar
					.getObservaciones())
			logger.debug "Establecemos la relaci—n"
			alumnoCertificado.setCursoCertificado(cursoCertificado)
			logger.debug "Lo agregamos a la lista"
			cursoCertificado.getAlumnosCertificados().add(alumnoCertificado)
		}
		logger.debug "Finalmente persistimos el cursoCertificado"
		cursoCertificadoDao.create(cursoCertificado)
		return cursoCertificado.getIdCurso()
	}
	
	@Override
	CursoCertificado imprimirConstanciasCurso(Long idCursoCertificado) {
		logger.debug "Obtenemos el CursoCertificado"
		CursoCertificado cursoCertificado = cursoCertificadoDao
				.obtenerCursoCertificadoConAlumnos(idCursoCertificado)
		logger.debug "Verificamos si el curso ya esta certificado, esto por multiples consultas del mismo tipo y evitar varios update"
		if(!cursoCertificado.isCertificado()){
			logger.debug "Indicamos que el curso se ha certificado"
			cursoCertificado.setCertificado(true)
			logger.debug "Iteramos la lista de alumnos"
			logger.debug "Debemos crear los numeros de control si es necesario"
			for(AlumnoCertificado alumnoCertificado:cursoCertificado.getAlumnosCertificados()){
				alumnoCertificado.setCertificado(true)
				alumnoCertificado.setNumeroControl("II0"+alumnoCertificado.getIdAlumno())
				alumnoCertificadoDao.update alumnoCertificado
			}
		}
		return cursoCertificado
	}
	
	@Override
	CursoCertificado agregarAlumnosACursoCertificado(long idCursoCertificado, List<AlumnoCertificado> alumnosCertificados){
		logger.debug "Obtenemos el CursoCertificado"
		CursoCertificado cursoCertificado = cursoCertificadoDao.obtenerCursoCertificadoConAlumnos(idCursoCertificado)
		logger.debug "Iteramos los alumnos para agregarlos de uno en uno a la lista existente y persistirlos"
		alumnosCertificados.each { alumno ->
			logger.debug "Creamos la relaci—n entre el alumno y el curso"
			alumno.cursoCertificado = cursoCertificado
			logger.debug "Persistimos el alumno"
			cursoCertificadoDao.create alumno
			logger.debug "Agregamos el alumno a la lista de participantes existentes"
			cursoCertificado.alumnosCertificados << alumno
		}
		logger.debug "Establecemos el curso a falso para volver a certificar..."
		cursoCertificado.certificado = false
		cursoCertificado
	}
	
	@Override
	CursoCertificado obtenerCursoCertificadoConAlumnos(Long idCurso) {
		return cursoCertificadoDao.obtenerCursoCertificadoConAlumnos(idCurso)
	}
	
	@Override
	List<CursoCertificado> obtenerCursosCertificados(
	CursoCriteria cursoCriteria) {
		cursoCertificadoDao.obtenerCursosCertificadosPorCriteria(cursoCriteria)
	}
}
