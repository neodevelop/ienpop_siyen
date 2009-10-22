package edu.ienpop.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.ConditionalTestCase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.services.BusinessException;
import edu.ienpop.services.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ServicesAppCtx.xml",
		"/DataSourceAppCtx.xml" })
public class TestUsuarioService extends
		AbstractDependencyInjectionSpringContextTests {

	@Autowired
	UsuarioService usuarioService;
	
	@Test
	public void testService() {
		try {
			ConditionalTestCase.assertEquals(true, usuarioService.isValidUsuario("JUANG", "JUANG"));
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}

}
