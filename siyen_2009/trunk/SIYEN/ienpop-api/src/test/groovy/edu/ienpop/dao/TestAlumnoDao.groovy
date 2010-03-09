package edu.ienpop.dao;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import edu.ienpop.dao.AlumnoDao;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.model.AlumnoXCertificar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=["/DataSourceAppCtx.xml"])
public class TestAlumnoDao{

	@Autowired
	AlumnoDao alumnoDao;
	
	@Test
	@SuppressWarnings("unchecked")
	public void testAlumnoDao(){
		AlumnoCriteria alumnoCriteria = new AlumnoCriteria();
		//alumnoCriteria.setId(new Long(33919));
		//alumnoCriteria.setNumeroControl("II033919");
		alumnoCriteria.setIdCurso(new Integer(7));
		List<AlumnoXCertificar> alumnos = alumnoDao.getAlumnosXCertificarPorCriteria(alumnoCriteria);
		for(AlumnoXCertificar alumno:alumnos){
			System.out.println(ToStringBuilder.reflectionToString(alumno));
		}
	}
	
	@Test
	//@Ignore
	@SuppressWarnings("unchecked")
	public void testAlumnoDao2(){
		AlumnoCriteria alumnoCriteria = new AlumnoCriteria();
		alumnoCriteria.setFirstResult(20);
		//alumnoCriteria.setId(new Long(33919));
		//alumnoCriteria.setNumeroControl("II033919");
		//alumnoCriteria.setIdCurso(new Long(33919));
		alumnoCriteria.setNombreCompleto("SARA");
		List<Alumno> alumnos = alumnoDao.getAlumnosPorCriteria(alumnoCriteria);
		for(Alumno alumno:alumnos){
			System.out.println(ToStringBuilder.reflectionToString(alumno));
		}
	}
	
	@Test
	public void testAlumnoDao3(){
		AlumnoCriteria alumnoCriteria = new AlumnoCriteria();
		alumnoCriteria.setFirstResult(0);
		//alumnoCriteria.setId(new Long(33919));
		//alumnoCriteria.setNumeroControl("II033919");
		//alumnoCriteria.setIdCurso(new Long(33919));
		alumnoCriteria.setNombreCompleto("ALUMNO");
		alumnoDao.getCountAlumnosPorCriteria(alumnoCriteria);
	}
}
