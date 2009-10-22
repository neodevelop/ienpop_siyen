package edu.ienpop.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CatalogoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ServicesAppCtx.xml",
		"/DataSourceAppCtx.xml" })
public class TestThrowsAdvice {

	//ErrorService errorService;
	@Autowired
	CatalogoService catalogoService;
	
	@Test
	public void test() {
		//errorService.throwDataAccessException();
		try {
			catalogoService.getCatalogoCurso();
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}
}
