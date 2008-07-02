package edu.ienpop;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.services.AlumnoService;
import edu.ienpop.services.BusinessException;

public class TestAlumnoService extends
		AbstractDependencyInjectionSpringContextTests {

	AlumnoService alumnoService;
	
	@Override
	protected void onSetUp() throws Exception {
		super.onSetUp();
		if(alumnoService==null)
			alumnoService = (AlumnoService)applicationContext.getBean("alumnoService");
	}
	
	@Override
	protected String[] getConfigLocations() {
		return new String[]{"ServicesAppCtx.xml","DataSourceAppCtx.xml"};
	}
	
	public void testServiceAlumno() throws BusinessException{
		AlumnoCriteria alumnoCriteria = new AlumnoCriteria();
		//alumnoCriteria.setId(new Long(33919));
		alumnoCriteria.setIdStatusAlumno(AlumnoCriteria.CERTIFICADO);
		List<Alumno> alumnos = alumnoService.getAlumnosByCriteria(alumnoCriteria);
		for(Alumno alumno:alumnos){
			System.out.println(ToStringBuilder.reflectionToString(alumno));
		}
	}
}
