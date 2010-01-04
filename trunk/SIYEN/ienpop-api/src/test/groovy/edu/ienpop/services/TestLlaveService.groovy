package edu.ienpop.services;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.LlaveService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ["/ServicesAppCtx.xml","/DataSourceAppCtx.xml"])
public class TestLlaveService {

	@Autowired
	LlaveService llaveService;

	@Test
	public void testLlaveService() {
		try {
			System.out.println(llaveService.generateLlaveXCurso(18));
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void testLlaveService2() {
		try {
			LlaveCertificacion llave = llaveService.isValidaLlave("AP#J33¡T¡DRJKL!K*J&%", 2);
			System.out.println(ToStringBuilder.reflectionToString(llave));
		} catch (BusinessException e) {
			System.err.println(e.getMessage());
		}
	}

}
