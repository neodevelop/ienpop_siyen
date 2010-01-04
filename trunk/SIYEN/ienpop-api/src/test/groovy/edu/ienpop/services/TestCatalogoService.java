package edu.ienpop.services;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CatalogoService;

@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/ServicesAppCtx.xml","/DataSourceAppCtx.xml"})
public class TestCatalogoService {

	@Autowired
	CatalogoService catalogoService;
	
	@Test
	public void testCatalogoService() throws BusinessException{
		List catalogo = catalogoService.getCatalogoCurso();
		for(Iterator it = catalogo.iterator();it.hasNext();){
			System.out.println(ToStringBuilder.reflectionToString(it.next()));
		}
	}
	
	@Test
	public void testCatalogoService2() throws BusinessException{
		List catalogo = catalogoService.getCatalogoPuerto();
		for(Iterator it = catalogo.iterator();it.hasNext();){
			System.out.println(ToStringBuilder.reflectionToString(it.next()));
		}
	}
	
	@Test
	public void testCatalogoService3() throws BusinessException{
		List catalogo = catalogoService.getCatalogoStatusAlumno();
		for(Iterator it = catalogo.iterator();it.hasNext();){
			System.out.println(ToStringBuilder.reflectionToString(it.next()));
		}
	}
	
	@Test
	public void testCatalogoService4() throws BusinessException{
		List catalogo = catalogoService.getCatalogoStatusCurso();
		for(Iterator it = catalogo.iterator();it.hasNext();){
			System.out.println(ToStringBuilder.reflectionToString(it.next()));
		}
	}

}
