package edu.ienpop;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.dao.AlumnoDao;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.model.AlumnoXCertificar;

public class TestAlumnoDao extends AbstractDependencyInjectionSpringContextTests {

	AlumnoDao alumnoDao;
	
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[] {"DataSourceAppCtx.xml"};
	}
	
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(alumnoDao==null)
			alumnoDao=(AlumnoDao)applicationContext.getBean("alumnoDao");
	}
	
	@SuppressWarnings("unchecked")
	public void _testAlumnoDao(){
		AlumnoCriteria alumnoCriteria = new AlumnoCriteria();
		//alumnoCriteria.setId(new Long(33919));
		//alumnoCriteria.setNumeroControl("II033919");
		alumnoCriteria.setIdCurso(new Integer(7));
		List<AlumnoXCertificar> alumnos = alumnoDao.getAlumnosXCertificarPorCriteria(alumnoCriteria);
		for(AlumnoXCertificar alumno:alumnos){
			System.out.println(ToStringBuilder.reflectionToString(alumno));
		}
	}
	@SuppressWarnings("unchecked")
	public void _testAlumnoDao2(){
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
	
	public void testAlumnoDao3(){
		AlumnoCriteria alumnoCriteria = new AlumnoCriteria();
		alumnoCriteria.setFirstResult(0);
		//alumnoCriteria.setId(new Long(33919));
		//alumnoCriteria.setNumeroControl("II033919");
		//alumnoCriteria.setIdCurso(new Long(33919));
		alumnoCriteria.setNombreCompleto("ALUMNO");
		System.out.println(alumnoDao.getCountAlumnosPorCriteria(alumnoCriteria));
	}
}
