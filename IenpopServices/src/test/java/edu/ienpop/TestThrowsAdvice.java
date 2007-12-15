package edu.ienpop;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CatalogoService;
import edu.ienpop.services.ErrorService;

public class TestThrowsAdvice extends
		AbstractDependencyInjectionSpringContextTests {

	ErrorService errorService;
	CatalogoService catalogoService;
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"ServicesAppCtx.xml","DataSourceAppCtx.xml"};
	}
	
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(errorService==null)
			errorService=(ErrorService)applicationContext.getBean("errorService");
		if(catalogoService==null)
			catalogoService=(CatalogoService)applicationContext.getBean("catalogoService");
	}
	
	public void test() throws BusinessException{
		//errorService.throwDataAccessException();
		catalogoService.getCatalogoCurso();
	}
}
