package edu.ienpop;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.model.AlumnoXCertificar;
import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoXCertificarService;
import edu.ienpop.services.PersistenceService;

@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ServicesAppCtx.xml",
		"/DataSourceAppCtx.xml" })
public class TestCursoXCertificarService {

	@Autowired
	CursoXCertificarService cursoXCertificarService;
	@Autowired
	PersistenceService persistenceService;

	@Test
	public void testCursoXCertificarService() {
		try {
			CursoXCertificar curso = new CursoXCertificar();
			Calendar calendar = Calendar.getInstance();
			calendar.set(2007, 6, 25);
			curso.setFechaHoraRegistro(Calendar.getInstance().getTime());
			curso.setFechaInicio(calendar.getTime());
			curso.setIdPuerto("ACG");
			curso.setIdTipoCurso("PATRON_DE_YATE_III");
			curso.setIdUsuario("JUANG");
			cursoXCertificarService.createNuevoCurso(curso);
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}

	public void testCursoXCertificarService2() {
		try {
			AlumnoXCertificar alumno = new AlumnoXCertificar();
			alumno.setFechaHoraRegistro(Calendar.getInstance().getTime());
			alumno.setNombreCompleto("MANITO1");
			alumno.setObservaciones("NADA");
			cursoXCertificarService.addAlumnoACursoXCertificar(79, alumno);
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testCursoXCertificarService3() {
		try {
			AlumnoXCertificar alumno = new AlumnoXCertificar();
			alumno.setFechaHoraRegistro(Calendar.getInstance().getTime());
			alumno.setNombreCompleto("MANITO2");

			AlumnoXCertificar alumno2 = new AlumnoXCertificar();
			alumno2.setFechaHoraRegistro(Calendar.getInstance().getTime());
			alumno2.setNombreCompleto("FUTANITO");

			AlumnoXCertificar alumno3 = new AlumnoXCertificar();
			alumno3.setFechaHoraRegistro(Calendar.getInstance().getTime());
			alumno3.setNombreCompleto("PLATANITO");
			CursoXCertificar curso;
			curso = (CursoXCertificar) persistenceService.findById(
					CursoXCertificar.class, new Long(18));
			Set alumnos = curso.getAlumnos();
			alumnos.add(alumno);
			alumnos.add(alumno2);
			alumnos.add(alumno3);
			cursoXCertificarService.addAlumnosACursoXCertificar(curso.getId(), alumnos);
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testCursoXCertificar4() {
		try {
			CursoXCertificar curso = new CursoXCertificar();
			Calendar calendar = Calendar.getInstance();
			calendar.set(2007, 6, 25);
			curso.setFechaHoraRegistro(Calendar.getInstance().getTime());
			curso.setFechaInicio(calendar.getTime());
			curso.setIdPuerto("ACG");
			curso.setIdTipoCurso("PATRON_DE_YATE_III");
			curso.setIdUsuario("JUANG");
			cursoXCertificarService.createNuevoCurso(curso);
			AlumnoXCertificar alumno = new AlumnoXCertificar();
			alumno.setFechaHoraRegistro(Calendar.getInstance().getTime());
			alumno.setNombreCompleto("MANITO1");
			alumno.setObservaciones("NADA");
			cursoXCertificarService.addAlumnoACursoXCertificar(curso.getId(), alumno);
			cursoXCertificarService.removeAlumnoACursoXCertificar(curso.getId(), alumno);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testCursoXCertificar5() {
		try {
			String[] usuarios = { "JUANG" };
			String[] puertos = { "ACG", "ATL", "DF" };
			List cursos;
			cursos = cursoXCertificarService.getCursosXCertificarSinLlave(
					usuarios, puertos);
			System.out.println(cursos);
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testCursoXCertificar6() {
		try {
			AlumnoXCertificar alumno = (AlumnoXCertificar) persistenceService
					.findById(AlumnoXCertificar.class, new Long(2));
			cursoXCertificarService.removeAlumnoACursoXCertificar(2, alumno);
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testCursoXCertificar7() {
		try {
			AlumnoXCertificar alumno = (AlumnoXCertificar) persistenceService
					.findById(AlumnoXCertificar.class, new Long(2));
			CursoXCertificar curso;
			curso = (CursoXCertificar) persistenceService.findById(
					CursoXCertificar.class, new Long(2));
			curso.getAlumnos().add(alumno);
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}
}
