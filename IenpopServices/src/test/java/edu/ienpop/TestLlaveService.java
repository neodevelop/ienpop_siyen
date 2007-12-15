package edu.ienpop;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

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
		//LlaveCertificacion llave = llaveService.isValidaLlave("T+?YPY1?6+WYÑ1ET/8UT",18);
		//System.out.println(ToStringBuilder.reflectionToString(llave));
	}

}
