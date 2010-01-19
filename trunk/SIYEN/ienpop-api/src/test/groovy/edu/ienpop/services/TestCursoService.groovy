package edu.ienpop.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.model.Alumno;
import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoService;
import edu.ienpop.services.PersistenceService;

@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ["/ServicesAppCtx.xml","/DataSourceAppCtx.xml"])
public class TestCursoService {

	@Autowired
	CursoService cursoService;
	@Autowired
	PersistenceService persistenceService;

	@Before
	public void delimitadorDePrueba(){
		System.out.println("נננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננננ");
	}
	
	@Test
	public void testCursoService() {
		try {
			cursoService.addCursoCertificado(1, "JHPPK2XLQLN9UCYQH9");
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	@Ignore
	public void testSumaFechas() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.set(2007, 1, 1);
		cal2.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), cal1
				.get(Calendar.DATE));
		cal2.add(Calendar.DATE, 4);
		System.out.println("Cal1: " + cal1.getTime());
		System.out.println("Cal2: " + cal2.getTime());
	}

	@Test
	@Ignore
	public void testCursoService2() {
		// cursoService.generateCertificadosXCurso(111902);
		// GregorianCalendar cal1 = new GregorianCalendar(2008,0,1);
		// GregorianCalendar cal2 = new GregorianCalendar(2008,7,30);
		CursoCriteria cursoCriteria = new CursoCriteria();
		String[] puertos = ["ACG"]
		cursoCriteria.setIdPuerto(puertos);
		// cursoCriteria.setIdTipoCurso(new
		// String[]{"CAPATCO3232"," CAPMOT332_P"});
		String[] libretas = ["A", "B"]
		cursoCriteria.setLibretas(libretas);
		cursoCriteria.setIdStatusCurso(4);
		cursoCriteria.setPaginado(true);
		// cursoCriteria.setFechaDesde(cal1.getTime());
		// cursoCriteria.setFechaHasta(cal2.getTime());
		List<Curso> cursos;
		try {
			cursos = cursoService.getCursosXStatus(cursoCriteria);
			for (Curso curso : cursos) {
				System.out.println(curso.getId());
			}
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	@Ignore
	public void testCursoService3(){
		try {
			cursoService.getCursoByTokenCertificado("2BVKRIPVC3GS5P6SA21U");
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	@Ignore
	public void testRecoveryOverloaded(){
		try {
			Curso curso = (Curso)persistenceService.findById(Curso.class, 105355L);
			System.out.println(ToStringBuilder.reflectionToString(curso));
			curso.setIdStatusCurso(CursoCriteria.ABIERTO);
			Set<Alumno> alumnos = curso.getAlumnos();
			List<String> idsAlumnos = new ArrayList();
			for(Alumno alumno : alumnos){
				if((alumno.getId()%1)==0){
					idsAlumnos.add(alumno.getId().toString());
				}
			}
			cursoService.recoveryCursoCertificado(curso,idsAlumnos);
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	@Ignore
	public void testUpdateCursoCertificado(){
		try {
			System.out.println(cursoService.updateCursoCertificado(111906, "1INTNPJYZ0EZ1C8K19U9"));
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}
}
