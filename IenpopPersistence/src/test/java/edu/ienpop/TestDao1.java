package edu.ienpop;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.dao.Dao;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoXCertificar;
import edu.ienpop.model.CatalogoCurso;
import edu.ienpop.model.CatalogoPuerto;
import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.model.Usuario;

public class TestDao1 extends AbstractDependencyInjectionSpringContextTests {

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
		List list = dao.getAll("Alumno");
		for(Iterator it=list.iterator();it.hasNext();){
			Alumno alumno = (Alumno)it.next();
			System.out.println(ToStringBuilder.reflectionToString(alumno));
		}
	}
	
	public void _testDao2(){
		List list = dao.getAll("Curso");
		for(Iterator it=list.iterator();it.hasNext();){
			Curso curso = (Curso)it.next();
			System.out.println(ToStringBuilder.reflectionToString(curso));
		}
	}
	
	public void _testDao3(){
		List list = dao.getAll("Usuario");
		for(Iterator it=list.iterator();it.hasNext();){
			Usuario usuario = (Usuario)it.next();
			System.out.println(ToStringBuilder.reflectionToString(usuario));
		}
	}
	
	public void _testDao4(){
		List list = dao.getAll("CatalogoCurso");
		for(Iterator it=list.iterator();it.hasNext();){
			CatalogoCurso catalogoCurso = (CatalogoCurso)it.next();
			System.out.println(ToStringBuilder.reflectionToString(catalogoCurso));
		}
	}
	
	public void _testDao5(){
		List list = dao.getAll("CatalogoPuerto");
		for(Iterator it=list.iterator();it.hasNext();){
			CatalogoPuerto catalogoPuerto = (CatalogoPuerto)it.next();
			System.out.println(ToStringBuilder.reflectionToString(catalogoPuerto));
		}
	}
	
	public void _testDao6(){
		CursoXCertificar nuevoCurso = new CursoXCertificar();
		nuevoCurso.setIdPuerto("ACG");
		nuevoCurso.setIdTipoCurso("CAPACO3234");
		nuevoCurso.setFechaHoraRegistro(new Date());
		nuevoCurso.setIdUsuario("JUANG");
		Calendar calendar = Calendar.getInstance();
		calendar.set(2007, 6, 10);
		nuevoCurso.setFechaInicio(calendar.getTime());
		nuevoCurso.setIdStatusCurso(1);
		dao.save(nuevoCurso);
		dao.update(nuevoCurso);
	}
	
	public void _testDao7(){
		AlumnoXCertificar alumnoNuevo = new AlumnoXCertificar();
		alumnoNuevo.setFechaHoraRegistro(new Date());
		alumnoNuevo.setIdCursoXCertificar(2);
		alumnoNuevo.setIdStatusAlumno(1);
		alumnoNuevo.setNombreCompleto("SARA ESPINOSA PEREZ");
		dao.save(alumnoNuevo);
		dao.update(alumnoNuevo);
	}
	
	@SuppressWarnings("unchecked")
	public void _testDao8(){
		CursoXCertificar nuevoCurso = new CursoXCertificar();
		nuevoCurso.setIdPuerto("ACG");
		nuevoCurso.setIdTipoCurso("CAPACO3234");
		nuevoCurso.setFechaHoraRegistro(new Date());
		nuevoCurso.setIdUsuario("JUANG");
		Calendar calendar = Calendar.getInstance();
		calendar.set(2007, 6, 10);
		nuevoCurso.setFechaInicio(calendar.getTime());
		nuevoCurso.setIdStatusCurso(1);
		
		dao.save(nuevoCurso);
		dao.update(nuevoCurso);
		
	}
	
	@SuppressWarnings("unchecked")
	public void testDao9(){
		CursoXCertificar nuevoCurso = (CursoXCertificar)dao.getByPK(CursoXCertificar.class, new Long(7));
		
		AlumnoXCertificar alumnoNuevo = new AlumnoXCertificar();
		alumnoNuevo.setFechaHoraRegistro(new Date());
		alumnoNuevo.setIdStatusAlumno(1);
		alumnoNuevo.setNombreCompleto("SARA ESPINOSA PEREZ");
		//alumnoNuevo.setCursoXCertificar(nuevoCurso);
		dao.save(alumnoNuevo);
		dao.update(alumnoNuevo);
		
		AlumnoXCertificar alumnoNuevo2 = new AlumnoXCertificar();
		alumnoNuevo2.setFechaHoraRegistro(new Date());
		alumnoNuevo2.setIdStatusAlumno(1);
		alumnoNuevo2.setNombreCompleto("JUANIS REYES ZU�IGA");
		//alumnoNuevo2.setCursoXCertificar(nuevoCurso);
		dao.save(alumnoNuevo2);
		dao.update(alumnoNuevo2);
		
		AlumnoXCertificar alumnoNuevo3 = new AlumnoXCertificar();
		alumnoNuevo3.setFechaHoraRegistro(new Date());
		alumnoNuevo3.setIdStatusAlumno(1);
		alumnoNuevo3.setNombreCompleto("CRISTINA REYES ZU�IGA");
		//alumnoNuevo3.setCursoXCertificar(nuevoCurso);
		dao.save(alumnoNuevo3);
		dao.update(alumnoNuevo3);
		Set alumnos = new HashSet();
		
		//nuevoCurso.getAlumnos().add(alumnoNuevo);
		//nuevoCurso.getAlumnos().add(alumnoNuevo2);
		//nuevoCurso.getAlumnos().add(alumnoNuevo3);
		alumnos.add(alumnoNuevo);
		alumnos.add(alumnoNuevo2);
		alumnos.add(alumnoNuevo3);
		nuevoCurso.setAlumnos(alumnos);
		
		dao.update(nuevoCurso);
	}
	
	public void testDao10(){
		CursoXCertificar curso = (CursoXCertificar)dao.getByPK(CursoXCertificar.class, new Long(6));
		System.out.println(ToStringBuilder.reflectionToString(curso));
		Set set = curso.getAlumnos();
		for(Iterator it=set.iterator();it.hasNext();){
			AlumnoXCertificar alumnoXCertificar = (AlumnoXCertificar)it.next();
			System.out.println(ToStringBuilder.reflectionToString(alumnoXCertificar));
		}
	}
	
	public void _testDao11(){
		AlumnoXCertificar alumno = (AlumnoXCertificar)dao.getByPK(AlumnoXCertificar.class, new Long(5));
		System.out.println(ToStringBuilder.reflectionToString(alumno));
		//System.out.println(ToStringBuilder.reflectionToString(alumno.getCursoXCertificar()));
	}
}
