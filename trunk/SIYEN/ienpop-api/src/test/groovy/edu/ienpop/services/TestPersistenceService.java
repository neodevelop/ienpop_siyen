package edu.ienpop.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.PersistenceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ServicesAppCtx.xml",
		"/DataSourceAppCtx.xml" })
public class TestPersistenceService {

	@Autowired
	PersistenceService persistenceService;

	@Test
	public void testPersistenceService() {
		try {
			String m = "69 juan.reyes@ienpop.net";
			String[] datos = m.split(" ");
			String id = datos[0];
			persistenceService.findById(CursoXCertificar.class, Long
					.parseLong(id));
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}

}
