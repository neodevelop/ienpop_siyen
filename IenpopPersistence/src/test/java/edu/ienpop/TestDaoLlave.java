package edu.ienpop;

import java.util.Calendar;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.dao.Dao;
import edu.ienpop.dao.LlaveDao;
import edu.ienpop.model.LlaveCertificacion;

public class TestDaoLlave extends AbstractDependencyInjectionSpringContextTests {

	Dao dao;
	LlaveDao llaveDao;
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
			dao = (Dao)applicationContext.getBean("dao");
		if(llaveDao==null)
			llaveDao = (LlaveDao)applicationContext.getBean("llaveDao");
	}
	
	public void testDao1(){
		LlaveCertificacion llave = new LlaveCertificacion();
		llave.setFechaGeneracion(Calendar.getInstance().getTime());
		llave.setLlave("abcde12345fghij67890");
		llave.setIdCursoXCertificar(300);
		//dao.save(llave);
		//dao.update(llave);
	}
	
	public void _testDao2() throws InterruptedException{
		Thread.sleep(2000);
		LlaveCertificacion llave = (LlaveCertificacion)dao.getByPK(LlaveCertificacion.class, new Long(11));
		llave.setFechaUtilizacion(Calendar.getInstance().getTime());
		llave.setIdStatusLlave(1);
		//dao.update(llave);
	}
	
	public void testDao3(){
		LlaveCertificacion llave = (LlaveCertificacion)llaveDao.getLlaveByLlave("abcde12345fghij67890");
		System.out.println(ToStringBuilder.reflectionToString(llave));
	}
}
