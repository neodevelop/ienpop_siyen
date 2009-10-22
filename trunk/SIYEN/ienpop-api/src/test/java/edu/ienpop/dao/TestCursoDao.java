package edu.ienpop.dao;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.dao.CursoDao;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoXCertificar;
import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoXCertificar;

@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/DataSourceAppCtx.xml" })
public class TestCursoDao {

	@Autowired
	CursoDao cursoDao;

	@Test
	public void testCursoDao() {
		CursoCriteria criteria = new CursoCriteria();
		// criteria.setId(new Long(111902));
		// criteria.setIdLlave(new Long(12));
		criteria.setIdTipoCurso(new String[] { "PATRON_DE_YATE_III",
				"﻿CAPACO3234" });
		criteria.setIdStatusCurso(4);
		criteria.setFechaDesde(new GregorianCalendar(2008, 1, 1).getTime());
		criteria.setFechaHasta(new GregorianCalendar(2008, 1, 10).getTime());
		criteria.setPaginado(true);
		List cursos = cursoDao.getCursosPorCriteria(criteria);
		for (Iterator it = cursos.iterator(); it.hasNext();) {
			Curso curso = (Curso) it.next();
			System.out.println(ToStringBuilder.reflectionToString(curso));
			Set alumnos = curso.getAlumnos();
			for (Iterator it2 = alumnos.iterator(); it2.hasNext();) {
				Alumno alumno = (Alumno) it2.next();
				System.out.println("\t"
						+ ToStringBuilder.reflectionToString(alumno));
			}
		}
	}

	public void testCursoDao2() {
		CursoCriteria criteria = new CursoCriteria();
		// criteria.setId(new Long(18));
		// criteria.setIdLlave(new Long(12));
		criteria
				.setIdTipoCurso(new String[] { "FAMBT1", "PATRON_DE_YATE_III" });
		criteria.setIdStatusCurso(2);
		criteria.setFechaDesde(new GregorianCalendar(2008, 1, 1).getTime());
		criteria.setFechaHasta(new GregorianCalendar(2008, 1, 10).getTime());
		criteria.setPaginado(true);
		List cursos = cursoDao.getCursoXCertificarPorCriteria(criteria);
		for (Iterator it = cursos.iterator(); it.hasNext();) {
			CursoXCertificar curso = (CursoXCertificar) it.next();
			System.out.println(ToStringBuilder.reflectionToString(curso));
			Set alumnos = curso.getAlumnos();
			for (Iterator it2 = alumnos.iterator(); it2.hasNext();) {
				AlumnoXCertificar alumno = (AlumnoXCertificar) it2.next();
				System.out.println("\t"
						+ ToStringBuilder.reflectionToString(alumno));
			}
		}
	}

	@Test
	public void testCursoDao3() {
		AbstractDependencyInjectionSpringContextTests.assertEquals(
				"CAPACO3234", cursoDao.getTipoCursoByIdCurso("111894"));
	}

	@Test
	public void testCursoDao4() {
		cursoDao.getCursoByIdLlaveCertificada(53L);
	}

	@Test
	public void testCursoDao5() {
		CursoCriteria criteria = new CursoCriteria();
		// criteria.setId(new Long(18));
		// criteria.setIdLlave(new Long(12));
		criteria
				.setIdTipoCurso(new String[] { "FAMBT1", "PATRON_DE_YATE_III" });
		criteria.setIdStatusCurso(4);
		criteria.setFechaDesde(new GregorianCalendar(2008, 1, 1).getTime());
		criteria.setFechaHasta(new GregorianCalendar(2008, 3, 10).getTime());
		System.out.println("Counter:"
				+ cursoDao.getCountCursosPorCriteria(criteria));
	}
}
