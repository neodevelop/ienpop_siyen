package edu.ienpop.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.GeneradorDatos;
import edu.ienpop.config.AbstractJavaConfigBaseClass;
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

	/**
	 * Inyeccion del servicio
	 */
	@Autowired
	CursoCertificadoService cursoCertificadoService;
	@Autowired
	CursoSinCertificarService cursoSinCertificarService;
	@Autowired
	InstructorDao instructorDao;
	@Autowired
	TipoCursoDao tipoCursoDao;
	@Autowired
	PuertoDao puertoDao;

	private CursoSinCertificar cursoSinCertificar;
	private List<AlumnoSinCertificar> alumnosSinCertificar;
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
		creaCursoSinCertificarDePrueba();
		long idCursoCertificado = cursoCertificadoService
				.certificarCurso(cursoSinCertificar.getIdCurso());
		// El curso tiene un id asignado
		assert idCursoCertificado > 0;
		CursoCertificado cursoCertificado = cursoCertificadoService
				.obtenerCursoCertificadoConAlumnos(idCursoCertificado);
		// El curso existe
		assert cursoCertificado != null;
		// El curso tiene alumnos
		assert cursoCertificado.getAlumnosCertificados().size() > 0;
		for (AlumnoCertificado alumno : cursoCertificado
				.getAlumnosCertificados()) {
			// Todos los alumnos tienen un identificador asignado
			assert alumno.getIdAlumno() > 0;
		}
		// La fecha de Inicio es menor a la fecha Final
		assert cursoCertificado.getFechaFin().after(
				cursoCertificado.getFechaInicio());
		// Es el mismo instructor antes y despœes de certificar
		assert cursoCertificado.getInstructor() == cursoSinCertificar
				.getInstructor();
		// Es el mismo puerto antes y despues de certificar
		assert cursoCertificado.getPuerto() == cursoSinCertificar.getPuerto();
		// Es el mismo puerto antes y despues de certificar
		assert cursoCertificado.getTipoCurso() == cursoSinCertificar
				.getTipoCurso();
		// Las fechas de inicio y fin corresponden al tipo de curso
		GregorianCalendar diff = new GregorianCalendar();
		diff.setTime(cursoCertificado.getFechaFin());
		diff.add(Calendar.DATE, (-1) * (cursoCertificado.getTipoCurso().getDuracion() + 1));
		assert cursoSinCertificar.getFechaInicio().getTime() == diff.getTimeInMillis();
		// Corroborar que el curso no se ha certificado
		assert cursoCertificado.isCertificado() == false;
		// El curso debe tener alumnos
		System.out.println("Tama–o:"
				+ cursoCertificado.getAlumnosCertificados().size());
		assert cursoCertificado.getAlumnosCertificados().size() > 0;
		Assert.notNull(cursoCertificado.getAlumnosCertificados(),
				"No hay alumnos...");
		// Ningun alumno se ha certificado aun
		for (AlumnoCertificado alumno : cursoCertificado.getAlumnosCertificados()) {
			assert alumno.isCertificado() == false;
		}
		idCursoCertificadoParaDiplomas = idCursoCertificado;
	}

	@Test
	public void testImprimirConstanciasCurso() {
		CursoCertificado curso = cursoCertificadoService
				.imprimirConstanciasCurso(idCursoCertificadoParaDiplomas);
		// El curso ya se ha certificado
		assert curso.isCertificado() == true;
		// Como ya se ha certificado el curso, los alumnos deben de contar con
		// un numero de control y el valor de su certificado debe ser true
		for (AlumnoCertificado alumno : curso
				.getAlumnosCertificados()) {
			assert alumno.isCertificado() == true;
			assert alumno.getNumeroControl() != null;
			assert alumno.getNumeroControl().startsWith("II0");
		}
	}

	private void creaCursoSinCertificarDePrueba() {
		alumnosSinCertificar = new ArrayList<AlumnoSinCertificar>();
		cursoSinCertificar = new CursoSinCertificar();
		cursoSinCertificar.setFechaInicio(GeneradorDatos.getDateAleatorio());
		cursoSinCertificar.setListoParaCertificar(false);
		cursoSinCertificar.setPuerto(puertoDao.read(GeneradorDatos
				.getPuertoAleatorio()));
		cursoSinCertificar.setTipoCurso(tipoCursoDao.read(GeneradorDatos
				.getCursoAleatorio()));
		cursoSinCertificar.setInstructor(instructorDao.read(GeneradorDatos
				.getInstructorAleatorio()));

		int n = (int) (Math.random() * 10);
		if(n == 0) 
			n = 1;
		for (int i = 0; i < n; i++) {
			AlumnoSinCertificar alumno = new AlumnoSinCertificar();
			alumno.setNombreCompleto(GeneradorDatos
					.getNombreCompletoAleatorio().toUpperCase());
			alumno.setObservaciones(GeneradorDatos
					.creaObservcacionesSinSentido());
			alumnosSinCertificar.add(alumno);
		}

		cursoSinCertificarService.crearCursoSinCertificar(cursoSinCertificar,
				alumnosSinCertificar);
	}

}
