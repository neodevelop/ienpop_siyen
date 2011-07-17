package edu.ienpop.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.ienpop.dao.AlumnoCertificadoDao;
import edu.ienpop.dao.CursoCertificadoDao;
import edu.ienpop.dao.CursoSinCertificarDao;
import edu.ienpop.dao.LlaveCertificacionDao;
import edu.ienpop.dao.TipoCursoDao;
import edu.ienpop.model.AlumnoCertificado;
import edu.ienpop.model.AlumnoSinCertificar;
import edu.ienpop.model.CursoCertificado;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoSinCertificar;
import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.service.CursoCertificadoService;



public class CursoCertificadoServiceImpl implements CursoCertificadoService {

	private static final Log logger = LogFactory.getLog(CursoCertificadoServiceImpl.class);

	private CursoSinCertificarDao cursoSinCertificarDao;
	private CursoCertificadoDao cursoCertificadoDao;
	private TipoCursoDao tipoCursoDao;
	private AlumnoCertificadoDao alumnoCertificadoDao;
	private LlaveCertificacionDao llaveCertificacionDao;

	public CursoCertificadoServiceImpl(
		CursoSinCertificarDao cursoSinCertificarDao,
		CursoCertificadoDao cursoCertificadoDao, 
		TipoCursoDao tipoCursoDao,
		AlumnoCertificadoDao alumnoCertificadoDao,
		LlaveCertificacionDao llaveCertificacionDao) {
			this.cursoSinCertificarDao = cursoSinCertificarDao;
			this.cursoCertificadoDao = cursoCertificadoDao;
			this.tipoCursoDao = tipoCursoDao;
			this.alumnoCertificadoDao = alumnoCertificadoDao;
			this.llaveCertificacionDao = llaveCertificacionDao;
	}

	@Override
	public long certificarCurso(Long idCursoSinCertificar) {
		logger.debug("Obtenemos el cursoSinCertificar");
		CursoSinCertificar cursoSinCertificar = cursoSinCertificarDao.obtenerCursoSinCertificarConRelaciones(idCursoSinCertificar);
		logger.debug("Creamos la nueva instancia del curso certificado");
		CursoCertificado cursoCertificado = new CursoCertificado();
		logger.debug("No asignamos el boolean de 'certificado' por que es false por defecto");
		logger.debug("Ponemos la fecha y hora del registro de este curso");
		cursoCertificado.setFechaHoraRegistro(new Date());
		logger.debug("Le decimos cuando empezo el curso");
		cursoCertificado.setFechaInicio(cursoSinCertificar.getFechaInicio());
		logger.debug("Calculo de la fecha de termino del curso");
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(cursoSinCertificar.getFechaInicio());
		calendar.add(Calendar.DATE, cursoSinCertificar.getTipoCurso().getDuracion() - 1);
		Date fechaFin = calendar.getTime();
		logger.debug("Fecha de inicio: "+ cursoSinCertificar.getFechaInicio() + " -- Fecha fin: " + fechaFin);
		logger.debug("Se resta uno por que se toma como fecha de inicio el mismo d’a en el que empieza");
		cursoCertificado.setFechaFin(fechaFin);
		logger.debug("Asignamos el instructor, el tipoCurso y el puerto");
		cursoCertificado.setInstructor(cursoSinCertificar.getInstructor());
		cursoCertificado.setPuerto(cursoSinCertificar.getPuerto());
		cursoCertificado.setTipoCurso(cursoSinCertificar.getTipoCurso());
		logger.debug("Asignamos la llave de certificaci—n correspondiente");
		LlaveCertificacion llave = llaveCertificacionDao.read(cursoSinCertificar.getLlaveCertificacion().getIdLlave());
		cursoCertificado.setLlaveCertificacion(llave);
		llave.setCursoCertificado(cursoCertificado);
		logger.debug("Iteramos la lista de alumnos del cursoSinCertificar y los asignamos al cursoCertificado");
		cursoCertificado.setAlumnosCertificados(new HashSet<AlumnoCertificado>());
		for (AlumnoSinCertificar alumnoSinCertificar : cursoSinCertificar.getAlumnosSinCertificar()) {
			logger.debug("Creamos el alumno certificado para agregarlo a la lista");
			AlumnoCertificado alumnoCertificado = new AlumnoCertificado();
			alumnoCertificado.setFechaHoraRegistro(new Date());
			logger.debug("Emparejamos sus propiedades");
			alumnoCertificado.setNombreCompleto(alumnoSinCertificar.getNombreCompleto());
			alumnoCertificado.setObservaciones(alumnoSinCertificar.getObservaciones());
			logger.debug("Establecemos la relaci—n");
			alumnoCertificado.setCursoCertificado(cursoCertificado);
			logger.debug("Lo agregamos a la lista");
			cursoCertificado.getAlumnosCertificados().add(alumnoCertificado);
		}
		logger.debug("Finalmente persistimos el cursoCertificado");
		cursoCertificadoDao.create(cursoCertificado);
		return cursoCertificado.getIdCurso();
	}

	@Override
	public void imprimirConstanciasCurso(Long idCursoCertificado) {
		
		logger.debug("Obtenemos la llave de certificacion para modificarla");
		LlaveCertificacion llaveCertificacion = llaveCertificacionDao.obtenerLlaveDeCursoCertificado(idCursoCertificado);
		logger.debug("Establecemos la utiiizaci—n junto con la fecha");
		llaveCertificacion.setActivo(true);
		llaveCertificacion.setFechaUtilizacion(new Date());
		llaveCertificacionDao.update(llaveCertificacion);
		
		logger.debug("Obtenemos el curso con el id ${idCursoCertificado} a modificar");
		CursoCertificado cursoCertificado = cursoCertificadoDao.read(idCursoCertificado);
		logger.debug("Establecemos que se ha certificado por la impresi—n");
		cursoCertificado.setCertificado(true);
		logger.debug("Persistimos el objeto(Hace el update)");
		cursoCertificadoDao.update(cursoCertificado);
		
		logger.debug("Obtenemos el curso certificado con alumnos para modificarlos");
		CursoCertificado cursoCertificadoConAlumnos = cursoCertificadoDao.obtenerCursoCertificadoConAlumnos(idCursoCertificado);
		logger.debug("Iteramos la lista de alumnos");
		logger.debug("Debemos crear los numeros de control si es necesario");
		for(AlumnoCertificado alumnoCertificado:cursoCertificadoConAlumnos.getAlumnosCertificados()){
			if(!alumnoCertificado.isCertificado()){
				alumnoCertificado.setCertificado(true);
				alumnoCertificado.setNumeroControl("II0" +alumnoCertificado.getIdAlumno());
				alumnoCertificadoDao.update(alumnoCertificado);
			}
		}
	}

	@Override
	public void agregarAlumnosACursoCertificado(List<AlumnoCertificado> alumnosCertificados, long idCursoCertificado){
		logger.debug("Obtenemos el curso con el id ${idCursoCertificado}");
		CursoCertificado curso = cursoCertificadoDao.read(idCursoCertificado);
		logger.debug("Regresamos el curso a su estado antes de certificar...");
		curso.setCertificado(false);
		logger.debug("Persistimos el curso con el nuevo estado...");
		cursoCertificadoDao.update(curso);
		
		logger.debug("Obtenemos la llave de certificacion para modificarla");
		LlaveCertificacion llaveCertificacion = llaveCertificacionDao.obtenerLlaveDeCursoCertificado(idCursoCertificado);
		logger.debug("Establecemos la utiiizaci—n junto con la fecha");
		llaveCertificacion.setActivo(false);
		llaveCertificacion.setFechaUtilizacion(null);
		llaveCertificacionDao.update(llaveCertificacion);
		
		logger.debug("Iteramos la nueva lista de alumnos");
		for(AlumnoCertificado alumno:alumnosCertificados){
			alumno.setFechaHoraRegistro(new Date());
			alumno.setCursoCertificado(curso);
			logger.debug("Persistimos el alumno" + ToStringBuilder.reflectionToString(alumno));
			alumnoCertificadoDao.create(alumno);
		}
	}

	@Override
	public CursoCertificado obtenerCursoCertificadoConAlumnos(Long idCurso) {
		return cursoCertificadoDao.obtenerCursoCertificadoConAlumnos(idCurso);
	}

	@Override
	public List<CursoCertificado> obtenerCursosCertificados(
			CursoCriteria cursoCriteria) {
		return cursoCertificadoDao.obtenerCursosCertificadosPorCriteria(cursoCriteria);
	}
}
