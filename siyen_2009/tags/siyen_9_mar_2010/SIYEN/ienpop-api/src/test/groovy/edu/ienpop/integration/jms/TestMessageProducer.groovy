package edu.ienpop.integration.jms;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.integration.jms.IenpopProducer;
import edu.ienpop.model.Usuario;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.PersistenceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=["/ServicesAppCtx.xml","/DataSourceAppCtx.xml","/IntegrationAppCtx.xml","/mailAppCtx.xml"])
public class TestMessageProducer extends AbstractDependencyInjectionSpringContextTests {
	
	@Autowired
	IenpopProducer producer;
	@Autowired
	PersistenceService service;

	@Test
	public void testProducer() throws BusinessException{
		producer.sendMessage("Este es un mensaje de prueba...");
	}
	
	@Test
	@Ignore
	public void testProducer2() throws BusinessException{
		producer.generarLLaveQueue(8, "juan.reyes@ienpop.net");
	}
	
	@Test
	@Ignore
	public void testProducer3() throws BusinessException{
		Usuario usuario = (Usuario)service.findById(Usuario.class, "MAGALI");
		producer.notificarAcceso(usuario);
	}
}
