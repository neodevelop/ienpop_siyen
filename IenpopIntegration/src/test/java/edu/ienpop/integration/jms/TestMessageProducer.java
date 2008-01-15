package edu.ienpop.integration.jms;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class TestMessageProducer extends AbstractDependencyInjectionSpringContextTests {

	IenpopProducer producer;
	
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"ServicesAppCtx.xml","DataSourceAppCtx.xml","IntegrationAppCtx.xml"};
	}
	
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(producer==null){
			producer=(IenpopProducer)applicationContext.getBean("ienpopProducer");
		}
	}
	
	public void testProducer(){
		producer.sendMessage();
	}
	
	public void testProducer2(){
		producer.generarLLaveQueue(1, "jreyes@ienpop.net");
	}

}
