package edu.ienpop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.ConditionalTestCase;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.dao.UsuarioDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/DataSourceAppCtx.xml"})
public class TestUsuarioDao {

	@Autowired
	UsuarioDao usuarioDao;
	
	@Test
	public void testUsuarioDao(){
		ConditionalTestCase.assertEquals("COCO", usuarioDao.findSimpleUser("BORDA"));
	}

}
