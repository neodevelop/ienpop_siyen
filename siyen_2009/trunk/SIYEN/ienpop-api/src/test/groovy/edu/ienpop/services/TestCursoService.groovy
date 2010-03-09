package edu.ienpop.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.velocity.app.event.NullSetEventHandler.ShouldLogOnNullSetExecutor;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.model.Alumno;
import edu.ienpop.model.CatalogoCurso;
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
	@Ignore
	public void testCursoService() {
		try {
			cursoService.addCursoCertificado(1, "JHPPK2XLQLN9UCYQH9");
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	@Ignore
	public void testGeneraOficio(){
		def date1 = new Date() - 90
		def date2 = new Date()
		println date1
		println date2
		def cursos = cursoService.getOficio(date1, date2 , "GYS")
		assert cursos.size()>0
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
		CursoCriteria cursoCriteria = new CursoCriteria();
		String[] puertos = [] as String[]
		cursoCriteria.setIdPuerto();
		// cursoCriteria.setIdTipoCurso(new
		// String[]{"CAPATCO3232"," CAPMOT332_P"});
		//String[] libretas = ["A", "B"]
		//cursoCriteria.setLibretas(libretas);
		cursoCriteria.setIdStatusCurso(4);
		cursoCriteria.setPaginado(true)
		String[] idTipoCursos = ["INICIA","INICIA1"] as String[]
		cursoCriteria.setIdTipoCurso(idTipoCursos)
		cursoCriteria.setFechaDesde(new Date()-60);
		cursoCriteria.setFechaHasta(new Date()-30);
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
	
	@Test
	@Ignore
	public void testCountPorCriteria(){
		CursoCriteria cursoCriteria = new CursoCriteria(idStatusCurso:4)
		assert cursoService.getCountCursosByCriteria(cursoCriteria) > 0
	}
	
	@Test
	@ExpectedException(BusinessException)
	void pruebaCambiarAgregarAlumnosACurso(){
		cursoService.cambiarAgregarAlumnosACurso null, null
	}
	
	@Test
	void pruebaCambiarAgregarAlumnosACurso2(){
		def curso = new Curso(fechaHoraRegistro:new Date(),idPuerto:'ACG',idUsuario:'RAMIREZ',idStatusCurso:4,idLlave:0)
		curso.tipoCurso = persistenceService.findById(CatalogoCurso.class, "INICIA")
		curso.fechaHoraRegistro = new Date()
		curso.idPuerto = 'ACG'
		curso.idUsuario = 'RAMIREZ'
		curso.idStatusCurso = 4
		curso.idLlave = 0
		def alumnos = []
		alumnos << new Alumno(nombreCompleto:'JOSE JUAN REYES ZU„IGA',idStatusAlumno:3,fechaHoraRegistro:new Date())
		alumnos << persistenceService.findById(Alumno.class, 63031L)
		cursoService.cambiarAgregarAlumnosACurso(alumnos, curso)
	}
}
