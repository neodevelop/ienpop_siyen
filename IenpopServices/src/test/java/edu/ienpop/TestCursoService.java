package edu.ienpop;

import java.util.Calendar;
import java.util.List;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoService;

public class TestCursoService extends
		AbstractDependencyInjectionSpringContextTests {

	CursoService cursoService;
	
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"DataSourceAppCtx.xml","ServicesAppCtx.xml"};
	}
	
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(cursoService==null)
			cursoService=(CursoService)applicationContext.getBean("cursoService");;
	}

	public void _testCursoService() throws BusinessException{
		cursoService.addCursoCertificado(18, "IST5¡T036EPY¿+Q?R37K");
	}
	
	public void _testSumaFechas(){
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.set(2007, 1, 1);
		cal2.set(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), cal1.get(Calendar.DATE));
		cal2.add(Calendar.DATE, 4);
		System.out.println("Cal1: "+cal1.getTime());
		System.out.println("Cal2: "+cal2.getTime());
	}
	
	@SuppressWarnings("unchecked")
	public void testCursoService2() throws BusinessException{
		//cursoService.generateCertificadosXCurso(111902);
		//GregorianCalendar cal1 = new GregorianCalendar(2008,0,1);
		//GregorianCalendar cal2 = new GregorianCalendar(2008,7,30);
		CursoCriteria cursoCriteria =  new CursoCriteria();
		cursoCriteria.setIdPuerto(new String[]{"ACG"});
		//cursoCriteria.setIdTipoCurso(new String[]{"CAPATCO3232"," CAPMOT332_P"});
		cursoCriteria.setLibretas(new String[]{"A","B"});
		cursoCriteria.setIdStatusCurso(4);
		cursoCriteria.setPaginado(true);
		//cursoCriteria.setFechaDesde(cal1.getTime());
		//cursoCriteria.setFechaHasta(cal2.getTime());
		List<Curso> cursos = cursoService.getCursosXStatus(cursoCriteria);
		for(Curso curso:cursos){
			System.out.println(curso.getId());
		}
	}
	
	public void _testCursoService3() throws BusinessException{
		cursoService.getCursoByTokenCertificado("2BVKRIPVC3GS5P6SA21U");
	}
}
