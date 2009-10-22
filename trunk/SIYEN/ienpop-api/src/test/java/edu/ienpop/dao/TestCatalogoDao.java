package edu.ienpop.dao;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.dao.CatalogoDao;
import edu.ienpop.dao.CursoDao;
import edu.ienpop.model.CursoCriteria;

public class TestCatalogoDao extends AbstractDependencyInjectionSpringContextTests {

	CatalogoDao catalogoDao;
	CursoDao cursoDao;
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"DataSourceAppCtx.xml"};
	}
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(catalogoDao==null)
			catalogoDao=(CatalogoDao)applicationContext.getBean("catalogoDao");
		if(cursoDao==null)
			cursoDao=(CursoDao)applicationContext.getBean("cursoDao");
	}

	public void testDao(){
		Object[] cursos = catalogoDao.getGrupoCursosXLibreta("C");
		for(int i=0;i<cursos.length;i++){
			//System.out.println(cursos[i].getClass().getName());
			System.out.println(cursos[i]);
		}
	}
	
	public void testDao2(){
		Object[] cursos = catalogoDao.getGrupoCursosXLibreta("A");
		String[] cursosArray = new String[cursos.length];
		for(int i=0;i<cursos.length;i++){
			cursosArray[i] = (String)cursos[i];
			System.out.println(cursosArray[i]);
		}
		CursoCriteria cursoCriteria = new CursoCriteria();
		cursoCriteria.setIdTipoCurso(cursosArray);
		cursoDao.getCursoXCertificarPorCriteria(cursoCriteria);
	}
}
