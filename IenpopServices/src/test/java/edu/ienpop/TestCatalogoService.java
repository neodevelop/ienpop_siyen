package edu.ienpop;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CatalogoService;

public class TestCatalogoService extends AbstractDependencyInjectionSpringContextTests {

	CatalogoService catalogoService;
	
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"ServicesAppCtx.xml","DataSourceAppCtx.xml"};
	}
	
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(catalogoService==null){
			catalogoService=(CatalogoService)applicationContext.getBean("catalogoService");
		}
	}
	
	public void testCatalogoService() throws BusinessException{
		List catalogo = catalogoService.getCatalogoCurso();
		for(Iterator it = catalogo.iterator();it.hasNext();){
			System.out.println(ToStringBuilder.reflectionToString(it.next()));
		}
	}
	
	public void testCatalogoService2() throws BusinessException{
		List catalogo = catalogoService.getCatalogoPuerto();
		for(Iterator it = catalogo.iterator();it.hasNext();){
			System.out.println(ToStringBuilder.reflectionToString(it.next()));
		}
	}
	
	public void testCatalogoService3() throws BusinessException{
		List catalogo = catalogoService.getCatalogoStatusAlumno();
		for(Iterator it = catalogo.iterator();it.hasNext();){
			System.out.println(ToStringBuilder.reflectionToString(it.next()));
		}
	}
	
	public void testCatalogoService4() throws BusinessException{
		List catalogo = catalogoService.getCatalogoStatusCurso();
		for(Iterator it = catalogo.iterator();it.hasNext();){
			System.out.println(ToStringBuilder.reflectionToString(it.next()));
		}
	}

}
