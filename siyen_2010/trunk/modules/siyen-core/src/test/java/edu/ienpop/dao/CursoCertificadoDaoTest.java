package edu.ienpop.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.model.CursoCertificado;

/**
 * @author neodevelop
 * 
 */
public class CursoCertificadoDaoTest extends AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del DAO
	 */
	@Autowired
	CursoCertificadoDao cursoCertificadoDao;

	static CursoCertificado cursoCertificadoPrueba;

	/**
	 * Prueba de la inyeccion(esto prueba el DataSource, SessionFactory y
	 * HibernateTemplate)
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(cursoCertificadoDao);
	}

	/**
	 * Prueba del metodo que obtiene toda la tabla
	 */
	@Test
	public void pruebaFindAll() {
		List<CursoCertificado> cursosCertificados = cursoCertificadoDao
				.findAll();
		Assert.isTrue(cursosCertificados.size() > 0);
	}

	/**
	 * Prueba de creacion de la entidad
	 */
	@Test
	public void pruebaCreate() {
		cursoCertificadoPrueba = new CursoCertificado();
		cursoCertificadoPrueba.setCertificado(false);
		cursoCertificadoPrueba.setFechaHoraRegistro(new Date());
		cursoCertificadoPrueba.setFechaInicio(new Date());
		cursoCertificadoPrueba.setFechaFin(new Date());
		cursoCertificadoDao.create(cursoCertificadoPrueba);
		Assert.isTrue(cursoCertificadoPrueba.getIdCurso() > 0);
	}

	/**
	 * Prueba de lectura de la entidad basada en su id
	 */
	@Test
	public void pruebaRead() {
		CursoCertificado cursoCertificado = cursoCertificadoDao
				.read(cursoCertificadoPrueba.getIdCurso());
		Assert.notNull(cursoCertificado);
		Assert.isTrue(cursoCertificado.getIdCurso() == cursoCertificadoPrueba
				.getIdCurso());
	}

	/**
	 * Prueba de update de la entidad
	 */
	@Test
	public void pruebaUpdate() {
		CursoCertificado cursoCertificadoAntes = cursoCertificadoDao
				.read(cursoCertificadoPrueba.getIdCurso());
		cursoCertificadoAntes.setCertificado(true);
		cursoCertificadoDao.update(cursoCertificadoPrueba);
		CursoCertificado cursoCertificadoDespues = cursoCertificadoDao
				.read(cursoCertificadoPrueba.getIdCurso());
		Assert
				.isTrue(cursoCertificadoAntes.isCertificado() != cursoCertificadoDespues
						.isCertificado());
	}

	/**
	 * Prueba de borrado de la entidad
	 */
	@Test
	public void pruebaDelete() {
		cursoCertificadoDao.delete(cursoCertificadoPrueba);
		CursoCertificado cursoCertificado = cursoCertificadoDao
				.read(cursoCertificadoPrueba.getIdCurso());
		Assert.isNull(cursoCertificado);
	}
}
