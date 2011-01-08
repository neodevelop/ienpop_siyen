package edu.ienpop.dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoSinCertificar;
import edu.ienpop.model.Instructor;
import edu.ienpop.model.Puerto;
import edu.ienpop.model.TipoCurso;

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
	@Autowired
	InstructorDao instructorDao;
	@Autowired
	PuertoDao puertoDao;
	@Autowired
	TipoCursoDao tipoCursoDao;

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
	public void pruebaObtenerCursosSinCertificarConRelacione() {
		CursoCriteria cursoCriteria = new CursoCriteria();
		cursoCriteria.setOffset(15);
		cursoCriteria.setMaxSize(15);
		List<CursoSinCertificar> cursos = cursoSinCertificarDao
				.obtenerCursosSinCertificarConRelaciones(cursoCriteria);
		Assert.notEmpty(cursos);
		Assert.isTrue(cursos.size() == 15,
				"El tama–o de la consulta es incorrecto...");
		for (CursoSinCertificar curso : cursos) {
			Assert.notNull(curso.getInstructor());
			Assert.notNull(curso.getInstructor().getNombre());
			Assert.notNull(curso.getTipoCurso());
			Assert.notNull(curso.getTipoCurso().getNombreCurso());
			Assert.notNull(curso.getPuerto());
			Assert.notNull(curso.getPuerto().getPuerto());
		}
	}

	@Test
	public void pruebaObtenerCursosSinCertificarConRelacionesCondiciones() {
		List<CursoSinCertificar> cursos = cursoSinCertificarDao
				.obtenerCursosSinCertificarConRelaciones(
						formulaCursoCriteria());
		Assert.notEmpty(cursos);
	}

	@Test
	public void pruebaObtenerContadorCursosSinCertificar() {
		int contador = cursoSinCertificarDao
				.obtenerContadorDeCursosSinCertificar(formulaCursoCriteria());
		Assert.isTrue(contador > 0);
	}

	private CursoCriteria formulaCursoCriteria() {
		CursoCriteria cursoCriteria = new CursoCriteria();
		Instructor instructor1 = instructorDao.read("RAMIREZ");
		Assert.notNull(instructor1);
		Instructor instructor2 = instructorDao.read("JUANG");
		Assert.notNull(instructor2);
		Puerto puerto1 = puertoDao.read("ACG");
		Assert.notNull(puerto1);
		Puerto puerto2 = puertoDao.read("DF");
		Assert.notNull(puerto2);
		TipoCurso tipoCurso1 = tipoCursoDao.read("INICIA");
		Assert.notNull(tipoCurso1);
		TipoCurso tipoCurso2 = tipoCursoDao.read("STCW95_1");
		Assert.notNull(tipoCurso2);
		cursoCriteria.setInstructores(new ArrayList<Instructor>());
		cursoCriteria.getInstructores().add(instructor1);
		cursoCriteria.getInstructores().add(instructor2);
		cursoCriteria.setPuertos(new ArrayList<Puerto>());
		cursoCriteria.getPuertos().add(puerto1);
		cursoCriteria.getPuertos().add(puerto2);
		cursoCriteria.setTiposCursos(new ArrayList<TipoCurso>());
		cursoCriteria.getTiposCursos().add(tipoCurso1);
		cursoCriteria.getTiposCursos().add(tipoCurso2);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(2010, 0, 1);
		cursoCriteria.setFechaInicio(calendar.getTime());
		calendar.set(2010, 11, 31);
		cursoCriteria.setFechaFin(calendar.getTime());
		cursoCriteria.setOffset(0);
		cursoCriteria.setMaxSize(15);
		return cursoCriteria;
	}
}
