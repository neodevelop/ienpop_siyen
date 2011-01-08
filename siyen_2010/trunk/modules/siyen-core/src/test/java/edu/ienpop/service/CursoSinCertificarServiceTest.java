package edu.ienpop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractTransactionalJavaConfigBaseClass;
import edu.ienpop.dao.InstructorDao;
import edu.ienpop.dao.PuertoDao;
import edu.ienpop.dao.TipoCursoDao;
import edu.ienpop.model.AlumnoSinCertificar;
import edu.ienpop.model.CursoSinCertificar;

/**
 * @author neodevelop
 * 
 */
public class CursoSinCertificarServiceTest extends
		AbstractTransactionalJavaConfigBaseClass {

	/**
	 * Inyeccion del servicio
	 */
	@Autowired
	CursoSinCertificarService cursoSinCertificarService;
	@Autowired
	InstructorDao instructorDao;
	@Autowired
	TipoCursoDao tipoCursoDao;
	@Autowired
	PuertoDao puertoDao;

	static CursoSinCertificar cursoSinCertificar;
	static List<AlumnoSinCertificar> alumnosSinCertificar;

	@After
	public void despuesDeProbar() {
		System.out
				.println("**********************************************************************");
	}

	/**
	 * Prueba la inyeccion del servicio y de sus colaboradores(daos), basados en
	 * configuracion
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(cursoSinCertificarService);
	}

	/**
	 * 
	 */
	@Test
	public void pruebaCrearCursoSinCertificar() {
		cursoSinCertificar = new CursoSinCertificar();
		cursoSinCertificar.setFechaInicio(new Date());
		cursoSinCertificar.setListoParaCertificar(false);
		cursoSinCertificar.setPuerto(puertoDao.read("DF"));
		cursoSinCertificar.setTipoCurso(tipoCursoDao.read("INICIA"));
		cursoSinCertificar.setInstructor(instructorDao.read("JUANG"));

		AlumnoSinCertificar a1 = new AlumnoSinCertificar();
		a1.setNombreCompleto("CRISTINA REYES ZU„IGA");
		a1.setObservaciones("OBSERVACIONES");
		AlumnoSinCertificar a2 = new AlumnoSinCertificar();
		a2.setNombreCompleto("FRANCISCO RAMIREZ GARCIA");
		a2.setObservaciones("OBSERVACIONES");

		alumnosSinCertificar = new ArrayList<AlumnoSinCertificar>();
		alumnosSinCertificar.add(a1);
		alumnosSinCertificar.add(a2);

		cursoSinCertificarService.crearCursoSinCertificar(cursoSinCertificar,
				alumnosSinCertificar);
	}

	@Test
	public void pruebaActualizaCursoSinCertificarSoloCurso() {
		cursoSinCertificar.setFechaHoraRegistro(new Date());
		cursoSinCertificar.setPuerto(puertoDao.read("ACG"));
		cursoSinCertificar.setTipoCurso(tipoCursoDao.read("SEGBATUR"));
		cursoSinCertificar.setInstructor(instructorDao.read("RAMIREZ"));
		cursoSinCertificarService
				.actualizaCursoSinCertificar(cursoSinCertificar);
	}

	@Test
	public void pruebaActualizaCursoSinCertificarCursoAlumnos() {
		cursoSinCertificar.setFechaHoraRegistro(new Date());
		cursoSinCertificar.setPuerto(puertoDao.read("PPS"));
		cursoSinCertificar.setTipoCurso(tipoCursoDao.read("SEGBAPES"));
		cursoSinCertificar.setInstructor(instructorDao.read("FAUSTO"));

		/**
		 * Importante el manejo de la relaci—n entre objetos
		 */
		AlumnoSinCertificar a1 = new AlumnoSinCertificar();
		a1.setNombreCompleto("RAMON ESTRADA RAMIREZ");
		a1.setObservaciones("OBSERVACIONES");
		a1.setCursoSinCertificar(cursoSinCertificar);
		AlumnoSinCertificar a2 = new AlumnoSinCertificar();
		a2.setNombreCompleto("ALICIA MACHADO VILLAREAL");
		a2.setObservaciones("OBSERVACIONES");
		a2.setCursoSinCertificar(cursoSinCertificar);

		AlumnoSinCertificar a3 = alumnosSinCertificar.get(0);
		a3.setCursoSinCertificar(null);
		alumnosSinCertificar.add(a1);
		alumnosSinCertificar.add(a2);
		alumnosSinCertificar.remove(a3);
		cursoSinCertificarService
				.actualizaCursoSinCertificar(cursoSinCertificar);
		for (AlumnoSinCertificar alumno : cursoSinCertificar
				.getAlumnosSinCertificar()) {
			Assert.isTrue(alumno.getIdAlumno() > 0, "El alumno viene sin ID");
		}
		Assert.isTrue(cursoSinCertificar.getAlumnosSinCertificar().size() == 3,
				"No es el numero de alumnos esperado...");
	}

	@Test
	public void pruebaObtenerCursoSinCertificarConAlumnos() {
		Long idCurso = cursoSinCertificar.getIdCurso();
		CursoSinCertificar curso = cursoSinCertificarService
				.obtenerCursoSinCertificarConAlumnos(idCurso);
		Assert.notNull(curso, "No se encontr— el curso...");
		Assert.notEmpty(curso.getAlumnosSinCertificar());
		Assert.isTrue(curso.getAlumnosSinCertificar().size() == 3,
				"No es el numero de alumnos esperado...");
	}

	@Test
	public void pruebaBorraCursoSinCertificar() {
		cursoSinCertificarService.borraCursoSinCertificar(cursoSinCertificar
				.getIdCurso());
		CursoSinCertificar curso = cursoSinCertificarService
				.obtenerCursoSinCertificarPorId(cursoSinCertificar.getIdCurso());
		Assert.isNull(curso);
	}
}
