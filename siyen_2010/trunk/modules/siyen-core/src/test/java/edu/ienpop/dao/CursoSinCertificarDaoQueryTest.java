package edu.ienpop.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoSinCertificar;

/**
 * @author neodevelop
 * 
 */
public class CursoSinCertificarDaoQueryTest extends AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del DAO
	 */
	@Autowired
	CursoSinCertificarDao cursoSinCertificarDao;

	public static CursoSinCertificar cursoSinCertificarPrueba;

	/**
	 * Prueba de la inyeccion(esto prueba el DataSource, SessionFactory y
	 * HibernateTemplate)
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(cursoSinCertificarDao);
	}

	/**
	 * Esta bœsqueda debe ser probada con Spock para obtener mejores resultados
	 */
	@Test
	public void pruebaObtenerCursosSinCertificarConRelacione(){
		CursoCriteria cursoCriteria = new CursoCriteria();
		List<CursoSinCertificar> cursos = cursoSinCertificarDao.obtenerCursosSinCertificarConRelaciones(cursoCriteria, 25, 15);
		Assert.notEmpty(cursos);
		Assert.isTrue(cursos.size() == 15, "El tama–o de la consulta es incorrecto...");
		for(CursoSinCertificar curso:cursos){
			Assert.notNull(curso.getInstructor());
			Assert.notNull(curso.getInstructor().getNombre());
			Assert.notNull(curso.getTipoCurso());
			Assert.notNull(curso.getTipoCurso().getNombreCurso());
			Assert.notNull(curso.getPuerto());
			Assert.notNull(curso.getPuerto().getPuerto());
		}
	}
	
}
