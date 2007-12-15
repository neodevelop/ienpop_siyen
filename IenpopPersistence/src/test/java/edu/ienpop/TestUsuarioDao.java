package edu.ienpop;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.dao.UsuarioDao;

public class TestUsuarioDao extends AbstractDependencyInjectionSpringContextTests {

	UsuarioDao usuarioDao;
	
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[] {"DataSourceAppCtx.xml"};
	}
	
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(usuarioDao==null)
			usuarioDao=(UsuarioDao)applicationContext.getBean("usuarioDao");
	}
	
	@SuppressWarnings("unchecked")
	public void testUsuarioDao(){
		assertEquals("COCO", usuarioDao.findSimpleUser("BORDA"));
	}

}
