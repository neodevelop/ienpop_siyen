package edu.ienpop.dao;

import java.util.Calendar;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.dao.Dao;
import edu.ienpop.dao.LlaveDao;
import edu.ienpop.model.LlaveCertificacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=["/DataSourceAppCtx.xml"])
public class TestDaoLlave {

	@Autowired
	Dao dao;
	@Autowired
	LlaveDao llaveDao;
	
	@Test
	public void testDao1(){
		LlaveCertificacion llave = new LlaveCertificacion();
		llave.setFechaGeneracion(Calendar.getInstance().getTime());
		llave.setLlave("abcde12345fghij67890");
		llave.setIdCursoXCertificar(300);
		//dao.save(llave);
		//dao.update(llave);
	}
	
	@Test
	public void testDao2() throws InterruptedException{
		Thread.sleep(2000);
		LlaveCertificacion llave = (LlaveCertificacion)dao.getByPK(LlaveCertificacion.class, new Long(11));
		llave.setFechaUtilizacion(Calendar.getInstance().getTime());
		llave.setIdStatusLlave(1);
		//dao.update(llave);
	}
	
	@Test
	public void testDao3(){
		LlaveCertificacion llave = (LlaveCertificacion)llaveDao.getLlaveByLlave("abcde12345fghij67890");
		System.out.println(ToStringBuilder.reflectionToString(llave));
	}
}
