package edu.ienpop;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.services.BusinessException;
import edu.ienpop.services.UsuarioService;

public class TestUsuarioService extends
		AbstractDependencyInjectionSpringContextTests {

	UsuarioService usuarioService;
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"ServicesAppCtx.xml","DataSourceAppCtx.xml"};
	}
	
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(usuarioService==null)
			usuarioService=(UsuarioService)applicationContext.getBean("usuarioService");
	}
	
	public void testService() throws BusinessException{
		System.out.println(usuarioService.isValidUsuario("BORDA", "COCO"));
	}

}
