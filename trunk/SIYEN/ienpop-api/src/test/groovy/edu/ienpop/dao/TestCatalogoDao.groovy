package edu.ienpop.dao;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ienpop.dao.CatalogoDao;
import edu.ienpop.dao.CursoDao;
import edu.ienpop.model.CursoCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=["/DataSourceAppCtx.xml"])
public class TestCatalogoDao {
	
	@Autowired
	CatalogoDao catalogoDao;
	@Autowired
	CursoDao cursoDao;
	
	@Test
	public void testDao(){
		Object[] cursos = getCatalogoDao().getGrupoCursosXLibreta("C");
		for(int i=0;i<cursos.length;i++){
			//System.out.println(cursos[i].getClass().getName());
			System.out.println(cursos[i]);
		}
	}
	
	@Test
	public void testDao2(){
		Object[] cursos = catalogoDao.getGrupoCursosXLibreta("A");
		String[] cursosArray = cursos.collect { (String)it }
		CursoCriteria cursoCriteria = new CursoCriteria();
		cursoCriteria.setIdTipoCurso(cursosArray);
		cursoDao.getCursoXCertificarPorCriteria(cursoCriteria);
	}
}
