package edu.ienpop.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.dao.InstructorDao;
import edu.ienpop.dao.PuertoDao;
import edu.ienpop.dao.TipoCursoDao;
import edu.ienpop.model.AlumnoSinCertificar;
import edu.ienpop.model.CursoSinCertificar;

/**
 * @author neodevelop
 * 
 */
public class CursoSinCertificarServiceTest extends
		AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del servicio
	 */
	@Autowired
	CursoSinCertificarService cursoSinCertificarService;
	@Autowired
	InstructorDao instructorDao;
	@Autowired
	TipoCursoDao tipoCursoDao;
	@Autowired
	PuertoDao puertoDao;
	
	static CursoSinCertificar cursoSinCertificar;
	static Set<AlumnoSinCertificar> alumnosSinCertificar;

	/**
	 * Prueba la inyeccion del servicio y de sus colaboradores(daos), basados en
	 * configuracion
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(cursoSinCertificarService);
	}

	/**
	 * 
	 */
	@Test
	public void pruebaCrearCursoSinCertificar(){
		cursoSinCertificar = new CursoSinCertificar();
		cursoSinCertificar.setFechaInicio(new Date());
		cursoSinCertificar.setListoParaCertificar(false);
		cursoSinCertificar.setPuerto(puertoDao.read("DF"));
		cursoSinCertificar.setTipoCurso(tipoCursoDao.read("INICIA"));
		cursoSinCertificar.setInstructor(instructorDao.read("JUANG"));
		
		AlumnoSinCertificar a1 = new AlumnoSinCertificar();
		a1.setNombreCompleto("CRISTINA REYES ZU„IGA");
		a1.setObservaciones("OBSERVACIONES");
		AlumnoSinCertificar a2 = new AlumnoSinCertificar();
		a2.setNombreCompleto("FRANCISCO RAMIREZ GARCIA");
		a2.setObservaciones("OBSERVACIONES");
		
		alumnosSinCertificar = new HashSet<AlumnoSinCertificar>();
		alumnosSinCertificar.add(a1);
		alumnosSinCertificar.add(a2);
		
		cursoSinCertificarService.crearCursoSinCertificar(cursoSinCertificar, alumnosSinCertificar);
	}
}
