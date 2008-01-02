package edu.ienpop;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.LlaveService;

public class TestLlaveService extends
		AbstractDependencyInjectionSpringContextTests {

	LlaveService llaveService;
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"ServicesAppCtx.xml","DataSourceAppCtx.xml"};
	}
	
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(llaveService==null)
			llaveService=(LlaveService)applicationContext.getBean("llaveService");
	}
	
	public void testLlaveService() throws BusinessException{
		//System.out.println(llaveService.generateLlaveXCurso(18));
	}
	
	public void testLlaveService2() throws BusinessException{
		LlaveCertificacion llave = llaveService.isValidaLlave("AP#J33¡T¡D$NVC!K*J&%",2);
		System.out.println(ToStringBuilder.reflectionToString(llave));
	}

}
