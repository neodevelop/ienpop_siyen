package edu.ienpop;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.dao.CursoDao;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoXCertificar;
import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoXCertificar;

public class TestCursoDao extends AbstractDependencyInjectionSpringContextTests {

	CursoDao cursoDao;
	
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[] {"DataSourceAppCtx.xml"};
	}
	
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(cursoDao==null)
			cursoDao=(CursoDao)applicationContext.getBean("cursoDao");
	}
	
	public void _testCursoDao(){
		CursoCriteria criteria = new CursoCriteria();
		//criteria.setId(new Long(111902));
		//criteria.setIdLlave(new Long(12));
		criteria.setIdTipoCurso(new String[] {"PATRON_DE_YATE_III","﻿CAPACO3234"});
		criteria.setIdStatusCurso(4);
		criteria.setFechaDesde(new GregorianCalendar(2008,1,1).getTime());
		criteria.setFechaHasta(new GregorianCalendar(2008,1,10).getTime());
		List cursos = cursoDao.getCursosPorCriteria(criteria);
		for(Iterator it = cursos.iterator();it.hasNext();){
			Curso curso = (Curso)it.next();
			System.out.println(ToStringBuilder.reflectionToString(curso));
			Set alumnos = curso.getAlumnos();
			for(Iterator it2 = alumnos.iterator();it2.hasNext();){
				Alumno alumno = (Alumno)it2.next();
				System.out.println("\t"+ToStringBuilder.reflectionToString(alumno));
			}
		}
	}
	
	public void _testCursoDao2(){
		CursoCriteria criteria = new CursoCriteria();
		//criteria.setId(new Long(18));
		//criteria.setIdLlave(new Long(12));
		criteria.setIdTipoCurso(new String[]{"FAMBT1","PATRON_DE_YATE_III"});
		criteria.setIdStatusCurso(2);
		criteria.setFechaDesde(new GregorianCalendar(2008,1,1).getTime());
		criteria.setFechaHasta(new GregorianCalendar(2008,1,10).getTime());
		List cursos = cursoDao.getCursoXCertificarPorCriteria(criteria);
		for(Iterator it = cursos.iterator();it.hasNext();){
			CursoXCertificar curso = (CursoXCertificar)it.next();
			System.out.println(ToStringBuilder.reflectionToString(curso));
			Set alumnos = curso.getAlumnos();
			for(Iterator it2 = alumnos.iterator();it2.hasNext();){
				AlumnoXCertificar alumno = (AlumnoXCertificar)it2.next();
				System.out.println("\t"+ToStringBuilder.reflectionToString(alumno));
			}
		}
	}
	
	public void _testCursoDao3(){
		assertEquals("CAPACO3234", cursoDao.getTipoCursoByIdCurso("111894"));
	}
	
	public void testCursoDao4(){
		cursoDao.getCursoByIdLlaveCertificada(53L);
	}
}
