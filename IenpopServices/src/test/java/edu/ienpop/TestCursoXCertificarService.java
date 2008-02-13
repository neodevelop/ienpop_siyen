package edu.ienpop;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import edu.ienpop.model.AlumnoXCertificar;
import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoXCertificarService;
import edu.ienpop.services.PersistenceService;

public class TestCursoXCertificarService extends
		AbstractDependencyInjectionSpringContextTests {

	CursoXCertificarService cursoXCertificarService;
	PersistenceService persistenceService;
	@Override
	protected String[] getConfigLocations() {
		// TODO Auto-generated method stub
		return new String[]{"ServicesAppCtx.xml","DataSourceAppCtx.xml"};
	}
	
	@Override
	protected void onSetUp() throws Exception {
		// TODO Auto-generated method stub
		super.onSetUp();
		if(cursoXCertificarService==null)
			cursoXCertificarService=(CursoXCertificarService)applicationContext.getBean("cursoXCertificarService");
		if(persistenceService==null)
			persistenceService=(PersistenceService)applicationContext.getBean("persistenceService");
	}
	
	public void _testCursoXCertificarService() throws BusinessException{
		CursoXCertificar curso = new CursoXCertificar();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2007, 6, 25);
		curso.setFechaHoraRegistro(Calendar.getInstance().getTime());
		curso.setFechaInicio(calendar.getTime());
		curso.setIdPuerto("ACG");
		curso.setIdTipoCurso("PATRON_DE_YATE_III");
		curso.setIdUsuario("JUANG");
		cursoXCertificarService.createNuevoCurso(curso);
	}
	
	public void _testCursoXCertificarService2() throws BusinessException{
		AlumnoXCertificar alumno = new AlumnoXCertificar();
		alumno.setFechaHoraRegistro(Calendar.getInstance().getTime());
		alumno.setNombreCompleto("MANITO1");
		alumno.setObservaciones("NADA");
		cursoXCertificarService.addAlumnoACursoXCertificar(79, alumno);
	}
	
	@SuppressWarnings("unchecked")
	public void _testCursoXCertificarService3() throws BusinessException{
		AlumnoXCertificar alumno = new AlumnoXCertificar();
		alumno.setFechaHoraRegistro(Calendar.getInstance().getTime());
		alumno.setNombreCompleto("MANITO2");
		
		AlumnoXCertificar alumno2 = new AlumnoXCertificar();
		alumno2.setFechaHoraRegistro(Calendar.getInstance().getTime());
		alumno2.setNombreCompleto("FUTANITO");
		
		AlumnoXCertificar alumno3 = new AlumnoXCertificar();
		alumno3.setFechaHoraRegistro(Calendar.getInstance().getTime());
		alumno3.setNombreCompleto("PLATANITO");
		
		CursoXCertificar curso = (CursoXCertificar)persistenceService.findById(CursoXCertificar.class, new Long(18));
		
		Set alumnos = curso.getAlumnos();
		alumnos.add(alumno);
		alumnos.add(alumno2);
		alumnos.add(alumno3);
		cursoXCertificarService.addAlumnosACursoXCertificar(79, alumnos);
	}
	
	public void _testCursoXCertificar4() throws BusinessException{
		CursoXCertificar curso = new CursoXCertificar();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2007, 6, 25);
		curso.setFechaHoraRegistro(Calendar.getInstance().getTime());
		curso.setFechaInicio(calendar.getTime());
		curso.setIdPuerto("ACG");
		curso.setIdTipoCurso("PATRON_DE_YATE_III");
		curso.setIdUsuario("JUANG");
		cursoXCertificarService.createNuevoCurso(curso);
		AlumnoXCertificar alumno = new AlumnoXCertificar();
		alumno.setFechaHoraRegistro(Calendar.getInstance().getTime());
		alumno.setNombreCompleto("MANITO1");
		alumno.setObservaciones("NADA");
		cursoXCertificarService.addAlumnoACursoXCertificar(79, alumno);
		cursoXCertificarService.removeAlumnoACursoXCertificar(79, alumno);
	}
	public void _testCursoXCertificar5() throws BusinessException{
		String[] usuarios = {"JUANG"};
		String[] puertos = {"ACG","ATL","DF"};
		@SuppressWarnings("unused")
		List cursos = cursoXCertificarService.getCursosXCertificarSinLlave(usuarios, puertos);
	}
	
	public void _testCursoXCertificar6() throws BusinessException{
		AlumnoXCertificar alumno = (AlumnoXCertificar)persistenceService.findById(AlumnoXCertificar.class, new Long(176));
		cursoXCertificarService.removeAlumnoACursoXCertificar(61, alumno);
	}
	
	public void testCursoXCertificar7() throws BusinessException{
		AlumnoXCertificar alumno = (AlumnoXCertificar)persistenceService.findById(AlumnoXCertificar.class, new Long(176));
		CursoXCertificar curso = (CursoXCertificar)persistenceService.findById(CursoXCertificar.class, new Long(79));
		curso.getAlumnos().add(alumno);
	}
}
