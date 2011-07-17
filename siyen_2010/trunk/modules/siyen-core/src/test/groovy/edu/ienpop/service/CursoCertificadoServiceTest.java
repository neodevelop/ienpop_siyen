package edu.ienpop.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.GeneradorDatos;
import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.config.AbstractTransactionalJavaConfigBaseClass;
import edu.ienpop.dao.InstructorDao;
import edu.ienpop.dao.PuertoDao;
import edu.ienpop.dao.TipoCursoDao;
import edu.ienpop.model.AlumnoCertificado;
import edu.ienpop.model.AlumnoSinCertificar;
import edu.ienpop.model.CursoCertificado;
import edu.ienpop.model.CursoSinCertificar;

/**
 * @author neodevelop
 * 
 */
public class CursoCertificadoServiceTest extends AbstractJavaConfigBaseClass {

	private static final Log logger = LogFactory.getLog(CursoCertificadoServiceTest.class);
	/**
	 * Inyeccion del servicio
	 */
	@Autowired
	CursoCertificadoService cursoCertificadoService;
	@Autowired
	CursoSinCertificarService cursoSinCertificarService;
	@Autowired
	LlaveCertificacionService llaveCertificacionService;
	@Autowired
	InstructorDao instructorDao;
	@Autowired
	TipoCursoDao tipoCursoDao;
	@Autowired
	PuertoDao puertoDao;

	private static CursoSinCertificar cursoSinCertificar;
	private static List<AlumnoSinCertificar> alumnosSinCertificar;
	private static long idCursoCertificadoParaDiplomas;

	/**
	 * Prueba la inyeccion del servicio y de sus colaboradores(daos), basados en
	 * configuracion
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(cursoCertificadoService);
	}

	@Test
	public void testObtenerValidacionDeCursoConLlave() {
		logger.debug("************* testObtenerValidacionDeCursoConLlave *************");
		creaCursoSinCertificarDePrueba();
		long idCursoCertificado = cursoCertificadoService.certificarCurso(cursoSinCertificar.getIdCurso());
		logger.debug("El curso tiene un id asignado");
		Assert.isTrue(idCursoCertificado > 0,"El curso est‡ vac’o...");
		CursoCertificado cursoCertificado = cursoCertificadoService.obtenerCursoCertificadoConAlumnos(idCursoCertificado);
		logger.debug("El curso existe");
		Assert.isTrue(cursoCertificado != null,"No se ha encontrado el curso...");
		logger.debug("El curso tiene alumnos");
		Assert.isTrue(cursoCertificado.getAlumnosCertificados().size() > 0,"El curso no tiene alumnos...");
		for (AlumnoCertificado alumno : cursoCertificado
				.getAlumnosCertificados()) {
			logger.debug("Todos los alumnos tienen un identificador asignado");
			Assert.isTrue(alumno.getIdAlumno() > 0);
		}
		logger.debug("La fecha de Inicio es menor a la fecha Final");
		logger.debug("Fecha inicio: " + cursoCertificado.getFechaInicio() + " -- FechaFin: " + cursoCertificado.getFechaFin());
		Assert.isTrue(cursoCertificado.getFechaFin().after(cursoCertificado.getFechaInicio()),"Las fechas de inicio y fin no son correctas...");
		logger.debug("Es el mismo instructor antes y despœes de certificar");
		Assert.isTrue(cursoCertificado.getInstructor().getIdInstructor().equals(cursoSinCertificar.getInstructor().getIdInstructor()) ,"Los instructores no son los mismos...");
		logger.debug("Es el mismo puerto antes y despues de certificar");
		Assert.isTrue(cursoCertificado.getPuerto().getIdPuerto().equals(cursoSinCertificar.getPuerto().getIdPuerto()),"Los puertos no son los mismos....");
		logger.debug("Es el mismo puerto antes y despues de certificar");
		Assert.isTrue(cursoCertificado.getTipoCurso().getIdTipoCurso().equals(cursoSinCertificar.getTipoCurso().getIdTipoCurso()),"El tipo de curso no es el mismo...");
		logger.debug("Las fechas de inicio y fin corresponden al tipo de curso, y su diferencia es como se solicita...");
		Calendar inicio = new GregorianCalendar();
		Calendar fin = new GregorianCalendar();
		inicio.setTime(cursoCertificado.getFechaInicio());
		fin.setTime(cursoCertificado.getFechaFin());
		double diferencia = fin.getTime().getTime() - inicio.getTime().getTime();
		long dias = Math.round((diferencia/(1000*60*60*24))+1);
		Assert.isTrue(dias == cursoCertificado.getTipoCurso().getDuracion(),"La duraci—n del curso no corresponde...");
		logger.debug("Corroborar que el curso no se ha certificado");
		Assert.isTrue(cursoCertificado.isCertificado() == false,"Por alguna raz—n el curso se certific— antes de lo planeado...");
		logger.debug("El curso debe tener alumnos");
		Assert.isTrue(cursoCertificado.getAlumnosCertificados().size() > 0,"El curso no tiene alumnos...");
		Assert.notNull(cursoCertificado.getAlumnosCertificados(),
				"No hay alumnos...");
		logger.debug("Ningun alumno se ha certificado aun");
		for (AlumnoCertificado alumno : cursoCertificado.getAlumnosCertificados()) {
			Assert.isTrue(alumno.isCertificado() == false,"Un alumno ya viene certificado, mal comportamiento...");
		}
		logger.debug("Corroborando que traemos la llave de certificacion");
		Assert.notNull(cursoCertificado.getLlaveCertificacion(),"No tiene la llave de certificaci—n asignada...");
		logger.debug("Verificando que la llave de certificacion ya tiene un curso asociado");
		Assert.notNull(cursoCertificado.getLlaveCertificacion().getCursoCertificado(), "No hay un curso relacionado con esta llave...");
		idCursoCertificadoParaDiplomas = idCursoCertificado;
	}

	@Test
	public void testImprimirConstanciasCurso() {
		logger.debug("************* testImprimirConstanciasCurso *************");
		cursoCertificadoService.imprimirConstanciasCurso(idCursoCertificadoParaDiplomas);
		CursoCertificado curso = cursoCertificadoService.obtenerCursoCertificadoConAlumnos(idCursoCertificadoParaDiplomas);
		logger.debug("Como ya se ha certificado el curso, los alumnos deben de contar con un numero de control y el valor de su certificado debe ser true");
		for (AlumnoCertificado alumno : curso
				.getAlumnosCertificados()) {
			Assert.isTrue(alumno.isCertificado() == true,"El alumno no se certific—...");
			Assert.isTrue(alumno.getNumeroControl() != null,"No se gener— el numero de control para el alumno...");
			Assert.isTrue(alumno.getNumeroControl().startsWith("II0"),"El nœmero de control no comienza con II0...");
		}
		logger.debug("El curso ya se ha certificado");
		Assert.isTrue(curso.isCertificado() == true,"El curso no se certific—...");
		logger.debug("La llave de certificac—n ya se uso...");
		Assert.notNull(curso.getLlaveCertificacion().getFechaUtilizacion(), "No se ha utilizado la llave");
		Assert.isTrue(curso.getLlaveCertificacion().isActivo(), "La llave no esta activa...");
	}
	
	@Test
	public void testAgregarAlumnosACursoCertificado(){
		logger.debug("************* testAgregarAlumnosACursoCertificado *************");
		//cursoCertificadoService.imprimirConstanciasCurso(idCursoCertificadoParaDiplomas);
		CursoCertificado curso = cursoCertificadoService.obtenerCursoCertificadoConAlumnos(idCursoCertificadoParaDiplomas);
		Assert.notNull(curso);
		logger.debug("Determinamos el tama–o de los cursos");
		Assert.isTrue(curso.getAlumnosCertificados().size() > 0);
		logger.debug("Agregamos algunos alumnos que no estaban contemplados en el curso");
		List<AlumnoCertificado> alumnos = new ArrayList<AlumnoCertificado>();
		int n = (int) (Math.random() * 10);
		if(n == 0) 
			n = 1;
		for (int i = 0; i < n; i++) {
			AlumnoCertificado alumno = new AlumnoCertificado();
			alumno.setNombreCompleto(GeneradorDatos.getNombreCompletoAleatorio().toUpperCase());
			alumno.setObservaciones(GeneradorDatos.creaObservcacionesSinSentido());
			alumnos.add(alumno);
		}
		logger.debug("Obtenemos nuevamente el curso en otro objeto");
		cursoCertificadoService.agregarAlumnosACursoCertificado(alumnos,idCursoCertificadoParaDiplomas);
		CursoCertificado nuevoCurso = cursoCertificadoService.obtenerCursoCertificadoConAlumnos(idCursoCertificadoParaDiplomas);
		logger.debug("Corroboramos que el curso anterior tiene menos alumnos que el nuevo");
		Assert.isTrue(curso.getAlumnosCertificados().size() < nuevoCurso.getAlumnosCertificados().size(), "El nœmero de alumnos no cambio...");
		logger.debug("El nuevo curso no debe de estar certificado");
		Assert.isTrue(nuevoCurso.isCertificado() == false,"El curso se qued— en el estado original...");
	}
	
	@Test
	public void reimprimirConstancias(){
		// Maldita prueba
		
	}

	private void creaCursoSinCertificarDePrueba() {
		alumnosSinCertificar = new ArrayList<AlumnoSinCertificar>();
		cursoSinCertificar = new CursoSinCertificar();
		cursoSinCertificar.setFechaInicio(GeneradorDatos.getDateAleatorio());
		cursoSinCertificar.setListoParaCertificar(false);
		cursoSinCertificar.setPuerto(puertoDao.read(GeneradorDatos.getPuertoAleatorio()));
		cursoSinCertificar.setTipoCurso(tipoCursoDao.read(GeneradorDatos.getCursoAleatorio()));
		cursoSinCertificar.setInstructor(instructorDao.read(GeneradorDatos.getInstructorAleatorio()));

		int n = (int) (Math.random() * 10);
		if(n == 0) 
			n = 1;
		for (int i = 0; i < n; i++) {
			AlumnoSinCertificar alumno = new AlumnoSinCertificar();
			alumno.setNombreCompleto(GeneradorDatos.getNombreCompletoAleatorio().toUpperCase());
			alumno.setObservaciones(GeneradorDatos.creaObservcacionesSinSentido());
			alumnosSinCertificar.add(alumno);
		}

		logger.debug("Creaci—n del curso para certificar");
		cursoSinCertificarService.crearCursoSinCertificar(cursoSinCertificar,alumnosSinCertificar);
		logger.debug("Creaci—n de la llave de certificaci—n");
		llaveCertificacionService.crearLlaveParaCertificacion(cursoSinCertificar.getIdCurso());
	}

}
