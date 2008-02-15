package edu.ienpop;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.dao.Dao;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.CatalogoCurso;
import edu.ienpop.model.Curso;

public class TestDao2 extends AbstractDependencyInjectionSpringContextTests {

	Dao dao;
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"DataSourceAppCtx.xml"};
	}
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(dao==null)
			dao=(Dao)applicationContext.getBean("dao");
	}

	public void _testDao(){
		Curso nuevoCurso = new Curso();
		Calendar fechaInicio = Calendar.getInstance();
		Calendar fechaFin = Calendar.getInstance();
		fechaInicio.set(2007, 6, 15);
		nuevoCurso.setFechaInicio(fechaInicio.getTime());
		fechaFin.set(fechaInicio.get(Calendar.YEAR), fechaInicio.get(Calendar.MONTH), fechaInicio.get(Calendar.DATE));		
		fechaFin.add(Calendar.DATE, 2);
		nuevoCurso.setFechaFin(fechaFin.getTime());
		nuevoCurso.setIdPuerto("ATS");
		nuevoCurso.setTipoCurso((CatalogoCurso)dao.getByPK(CatalogoCurso.class, "INICIA1"));
		nuevoCurso.setFechaHoraRegistro(Calendar.getInstance().getTime());
		nuevoCurso.setIdUsuario("JUANG");
		nuevoCurso.setIdStatusCurso(3);
		dao.save(nuevoCurso);
		dao.update(nuevoCurso);
	}
	
	public void _testDao2(){
		Alumno alumnoNuevo = new Alumno();
		Curso curso = (Curso)dao.getByPK(Curso.class, new Long(111893));
		alumnoNuevo.setFechaHoraRegistro(Calendar.getInstance().getTime());
		//alumnoNuevo.setIdCurso(111893);
		alumnoNuevo.setCurso(curso);
		alumnoNuevo.setIdStatusAlumno(2);
		alumnoNuevo.setNombreCompleto("JUAN LUIS CALDERON ARREDONDO");
		dao.save(alumnoNuevo);
		alumnoNuevo.setNumeroControl("II0"+alumnoNuevo.getId());
		dao.update(alumnoNuevo);
	}
	
	@SuppressWarnings("unchecked")
	public void _testDao3(){
		Curso nuevoCurso = new Curso(); 
		nuevoCurso = (Curso)dao.getByPK(Curso.class, new Long(111893));
		
		Alumno alumnoNuevo = new Alumno();
		alumnoNuevo.setFechaHoraRegistro(Calendar.getInstance().getTime());
		alumnoNuevo.setIdStatusAlumno(3);
		alumnoNuevo.setNombreCompleto("SARA ESPINOSA PEREZ");
		alumnoNuevo.setCurso(nuevoCurso);
		dao.save(alumnoNuevo);
		alumnoNuevo.setNumeroControl("II0"+alumnoNuevo.getId());
		dao.update(alumnoNuevo);
		
		Alumno alumnoNuevo2 = new Alumno();
		alumnoNuevo2.setFechaHoraRegistro(Calendar.getInstance().getTime());
		alumnoNuevo2.setIdStatusAlumno(3);
		alumnoNuevo2.setNombreCompleto("JUANIS REYES ZU�IGA");
		alumnoNuevo2.setCurso(nuevoCurso);
		dao.save(alumnoNuevo2);
		alumnoNuevo2.setNumeroControl("II0"+alumnoNuevo2.getId());
		dao.update(alumnoNuevo2);
		
		Alumno alumnoNuevo3 = new Alumno();
		alumnoNuevo3.setFechaHoraRegistro(Calendar.getInstance().getTime());
		alumnoNuevo3.setIdStatusAlumno(3);
		alumnoNuevo3.setNombreCompleto("CRISTINA REYES ZU�IGA");
		alumnoNuevo3.setCurso(nuevoCurso);
		dao.save(alumnoNuevo3);
		alumnoNuevo3.setNumeroControl("II0"+alumnoNuevo3.getId());
		dao.update(alumnoNuevo3);
		Set alumnos = nuevoCurso.getAlumnos();
		
		//nuevoCurso.getAlumnos().add(alumnoNuevo);
		//nuevoCurso.getAlumnos().add(alumnoNuevo2);
		//nuevoCurso.getAlumnos().add(alumnoNuevo3);
		alumnos.add(alumnoNuevo);
		alumnos.add(alumnoNuevo2);
		alumnos.add(alumnoNuevo3);
		nuevoCurso.setAlumnos(alumnos);
		
		//dao.update(nuevoCurso);
	}
	
	public void _testDao4(){
		Curso curso = (Curso)dao.getByPK(Curso.class, new Long(111893));
		System.out.println(ToStringBuilder.reflectionToString(curso));
		Set set = curso.getAlumnos();
		for(Iterator it=set.iterator();it.hasNext();){
			Alumno alumno = (Alumno)it.next();
			System.out.println(alumno.getId());
		}
	}
	
	public void testDao11(){
		Alumno alumno = (Alumno)dao.getByPK(Alumno.class, new Long(33924));
		System.out.println(alumno.getId());
		System.out.println(alumno.getIdCurso());
	}
}
