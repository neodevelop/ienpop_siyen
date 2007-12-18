package edu.ienpop;

import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.dao.Dao;
import edu.ienpop.model.CatalogoPuerto;
import edu.ienpop.model.Usuario;

public class TestPersistenceDao extends AbstractDependencyInjectionSpringContextTests {

	Dao dao;
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"DataSourceAppCtx.xml"};
	}
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(dao==null)
			dao=(Dao)applicationContext.getBean("dao");
	}

	@SuppressWarnings("unchecked")
	public void testDao(){
		Usuario usuario = (Usuario)dao.getByPK(Usuario.class, "JUANG");
		System.out.println(ToStringBuilder.reflectionToString(usuario));
		Set<CatalogoPuerto> puertos = usuario.getPuertos(); 
		for(CatalogoPuerto puerto:puertos){
			System.out.println(ToStringBuilder.reflectionToString(puerto));
		}
	}

}
