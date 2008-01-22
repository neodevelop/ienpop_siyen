package edu.ienpop;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.PersistenceService;

public class TestPersistenceService extends AbstractDependencyInjectionSpringContextTests {

	PersistenceService persistenceService;
	
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"ServicesAppCtx.xml","DataSourceAppCtx.xml"};
	}
	
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(persistenceService==null){
			persistenceService=(PersistenceService)applicationContext.getBean("persistenceService");
		}
	}
	
	public void testPersistenceService() throws BusinessException{
		String m="69 juan.reyes@ienpop.net";
		String[] datos = m.split(" ");
		String id =datos[0];
		persistenceService.findById(CursoXCertificar.class, Long.parseLong(id));
	}

}
