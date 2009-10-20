package edu.ienpop.integration.jms;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.integration.jms.impl.IenpopProducer;
import edu.ienpop.model.Usuario;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.PersistenceService;

public class TestMessageProducer extends AbstractDependencyInjectionSpringContextTests {

	IenpopProducer producer;
	PersistenceService service;
	
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"ServicesAppCtx.xml","DataSourceAppCtx.xml","IntegrationAppCtx.xml","mailAppCtx.xml"};
	}
	
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(producer==null){
			producer=(IenpopProducer)applicationContext.getBean("ienpopProducer");
		}
		if(service==null){
			service=(PersistenceService)applicationContext.getBean("persistenceService");
		}
	}
	
	public void testProducer() throws BusinessException{
		producer.sendMessage("Este es un mensaje de prueba...");
	}
	
	public void _testProducer2() throws BusinessException{
		producer.generarLLaveQueue(8, "juan.reyes@ienpop.net");
	}

	public void _testProducer3() throws BusinessException{
		Usuario usuario = (Usuario)service.findById(Usuario.class, "MAGALI");
		producer.notificarAcceso(usuario);
	}
}
