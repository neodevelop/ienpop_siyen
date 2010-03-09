package edu.ienpop.dao;

import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.dao.Dao;
import edu.ienpop.model.CatalogoPuerto;
import edu.ienpop.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=["/DataSourceAppCtx.xml"])
public class TestPersistenceDao {

	@Autowired
	Dao dao;

	@SuppressWarnings("unchecked")
	@Test
	public void testDao(){
		Usuario usuario = (Usuario)dao.getByPK(Usuario.class, "JUANG");
		System.out.println(ToStringBuilder.reflectionToString(usuario));
		Set<CatalogoPuerto> puertos = usuario.getPuertos(); 
		for(CatalogoPuerto puerto:puertos){
			System.out.println(ToStringBuilder.reflectionToString(puerto));
		}
	}

}
