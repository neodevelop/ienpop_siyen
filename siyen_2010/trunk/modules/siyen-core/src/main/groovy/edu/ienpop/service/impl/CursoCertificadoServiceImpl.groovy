package edu.ienpop.service.impl

import java.util.Date
import java.util.HashSet
import java.util.List

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
	
	private CursoSinCertificarDao cursoSinCertificarDao
	private CursoCertificadoDao cursoCertificadoDao
	private TipoCursoDao tipoCursoDao
	
	CursoCertificadoServiceImpl(
	CursoSinCertificarDao cursoSinCertificarDao,
	CursoCertificadoDao cursoCertificadoDao, TipoCursoDao tipoCursoDao) {
		this.cursoSinCertificarDao = cursoSinCertificarDao
		this.cursoCertificadoDao = cursoCertificadoDao
		this.tipoCursoDao = tipoCursoDao
	}
	
	@Override
	long certificarCurso(Long idCursoSinCertificar) {
		// Obtenemos el cursoSinCertificar
		CursoSinCertificar cursoSinCertificar = cursoSinCertificarDao
				.obtenerCursoSinCertificarConRelaciones(idCursoSinCertificar)
		// Creamos la nueva instancia del curso certificado
		CursoCertificado cursoCertificado = new CursoCertificado()
		// No asignamos el boolean de 'certificado' por que es false por defecto
		// Ponemos la fecha y hora del registro de este curso
		cursoCertificado.setFechaHoraRegistro(new Date())
		// Le decimos cuando empezo el curso
		cursoCertificado.setFechaInicio(cursoSinCertificar.getFechaInicio())
		// Calculo de la fecha de termino del curso
		Date fechaFin = cursoSinCertificar.fechaInicio + cursoSinCertificar.tipoCurso.duracion - 1
		// Se resta uno por que se toma como fecha de inicio el mismo d�a en el que empieza 
		cursoCertificado.fechaFin = fechaFin
		// Asignamos el instructor, el tipoCurso y el puerto
		cursoCertificado.setInstructor(cursoSinCertificar.getInstructor())
		cursoCertificado.setPuerto(cursoSinCertificar.getPuerto())
		cursoCertificado.setTipoCurso(cursoSinCertificar.getTipoCurso())
		// Iteramos la lista de alumnos del cursoSinCertificar y los asignamos
		// al cursoCertificado
		cursoCertificado
				.setAlumnosCertificados(new HashSet<AlumnoCertificado>())
		for (AlumnoSinCertificar alumnoSinCertificar : cursoSinCertificar
		.getAlumnosSinCertificar()) {
			// Creamos el alumno certificado para agregarlo a la lista
			AlumnoCertificado alumnoCertificado = new AlumnoCertificado()
			// Emparejamos sus propiedades
			alumnoCertificado.setNombreCompleto(alumnoSinCertificar
					.getNombreCompleto())
			alumnoCertificado.setObservaciones(alumnoSinCertificar
					.getObservaciones())
			// Establecemos la relaci�n
			alumnoCertificado.setCursoCertificado(cursoCertificado)
			// Lo agregamos a la lista
			cursoCertificado.getAlumnosCertificados().add(alumnoCertificado)
		}
		// Finalmente persistimos el cursoCertificado
		cursoCertificadoDao.create(cursoCertificado)
		return cursoCertificado.getIdCurso()
	}
	
	@Override
	CursoCertificado imprimirConstanciasCurso(Long idCursoCertificado) {
		// Obtenemos el CursoCertificado
		CursoCertificado cursoCertificado = cursoCertificadoDao
				.obtenerCursoCertificadoConAlumnos(idCursoCertificado)
		// Verificamos si el curso ya esta certificado, esto por multiples consultas del mismo tipo y evitar varios update
		if(!cursoCertificado.isCertificado()){
			// Indicamos que el curso se ha certificado
			cursoCertificado.setCertificado(true)
			// Iteramos la lista de alumnos
			// Debemos crear los numeros de control si es necesario
			for(AlumnoCertificado alumnoCertificado:cursoCertificado.getAlumnosCertificados()){
				alumnoCertificado.setCertificado(true)
				alumnoCertificado.setNumeroControl("II0"+alumnoCertificado.getIdAlumno())
			}
			
		}
		return cursoCertificado
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
