package edu.ienpop;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.services.AlumnoService;
import edu.ienpop.services.BusinessException;

@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ServicesAppCtx.xml",
		"/DataSourceAppCtx.xml" })
public class TestAlumnoService extends
		AbstractDependencyInjectionSpringContextTests {

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
}
