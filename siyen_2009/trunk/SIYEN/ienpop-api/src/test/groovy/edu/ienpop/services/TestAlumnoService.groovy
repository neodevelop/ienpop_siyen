package edu.ienpop.services;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.services.AlumnoService;
import edu.ienpop.services.BusinessException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ["/ServicesAppCtx.xml","/DataSourceAppCtx.xml"] )
public class TestAlumnoService {

	@Autowired
	AlumnoService alumnoService;

	@Test
	public void testServiceAlumno() {
		AlumnoCriteria alumnoCriteria = new AlumnoCriteria();
		// alumnoCriteria.setId(new Long(33919));
		alumnoCriteria.setIdStatusAlumno(AlumnoCriteria.CERTIFICADO);
		List<Alumno> alumnos;
		try {
			alumnos = alumnoService.getAlumnosByCriteria(alumnoCriteria);
			for (Alumno alumno : alumnos) {
				System.out.println(ToStringBuilder.reflectionToString(alumno));
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void testServiceAlumno2() {
		assert alumnoService
		alumnoService.cambiaNombreDelAlumno(62543L, "JJRZ")
	}
	
	@Test
	public void testServiceAlumno3() {
		assert alumnoService
		try{
			alumnoService.cambiaNombreDelAlumno(62543L, "")
		}catch(BusinessException e){
			println e.getMessage()
		}
	}
}
