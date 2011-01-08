package edu.ienpop.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.model.CursoSinCertificar;

/**
 * @author neodevelop
 * 
 */
public class CursoSinCertificarDaoTest extends AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del DAO
	 */
	@Autowired
	CursoSinCertificarDao cursoSinCertificarDao;

	static CursoSinCertificar cursoSinCertificarPrueba;

	/**
	 * Prueba de la inyeccion(esto prueba el DataSource, SessionFactory y
	 * HibernateTemplate)
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(cursoSinCertificarDao);
	}

	/**
	 * Prueba del metodo que obtiene toda la tabla
	 */
	@Test
	public void pruebaFindAll() {
		List<CursoSinCertificar> cursosSinCertificar = cursoSinCertificarDao
				.findAll();
		Assert.notEmpty(cursosSinCertificar);
	}

	/**
	 * Prueba de creacion de la entidad
	 */
	@Test
	public void pruebaCreate() {
		cursoSinCertificarPrueba = new CursoSinCertificar();
		cursoSinCertificarPrueba.setFechaHoraRegistro(new Date());
		cursoSinCertificarPrueba.setFechaInicio(new Date());
		cursoSinCertificarPrueba.setListoParaCertificar(false);
		cursoSinCertificarDao.create(cursoSinCertificarPrueba);
		Assert.isTrue(cursoSinCertificarPrueba.getIdCurso() > 0);
	}

	/**
	 * Prueba de lectura de la entidad basada en su id
	 */
	@Test
	public void pruebaRead() {
		CursoSinCertificar curso = cursoSinCertificarDao
				.read(cursoSinCertificarPrueba.getIdCurso());
		Assert.notNull(curso);
	}

	/**
	 * Prueba de update de la entidad
	 */
	@Test
	public void pruebaUpdate() {
		CursoSinCertificar cursoAntes = cursoSinCertificarDao
				.read(cursoSinCertificarPrueba.getIdCurso());
		cursoSinCertificarPrueba.setListoParaCertificar(true);
		cursoSinCertificarPrueba.setFechaHoraRegistro(new Date());
		cursoSinCertificarDao.update(cursoSinCertificarPrueba);
		CursoSinCertificar cursoDespues = cursoSinCertificarDao
				.read(cursoSinCertificarPrueba.getIdCurso());
		Assert
				.isTrue(cursoAntes.isListoParaCertificar() != cursoDespues
						.isListoParaCertificar(),
						"El valor 'listoParaCertificar' debe ser diferente en esta aserci—n");
		Assert.isTrue(cursoAntes.getIdCurso() == cursoDespues.getIdCurso(),
				"Los nœmeros de curso deben ser los mismos");
	}

	/**
	 * Prueba de borrado de la entidad
	 */
	@Test
	public void pruebaDelete() {
		cursoSinCertificarDao.delete(cursoSinCertificarPrueba);
		CursoSinCertificar curso = cursoSinCertificarDao
				.read(cursoSinCertificarPrueba.getIdCurso());
		Assert.isNull(curso);
	}
}
