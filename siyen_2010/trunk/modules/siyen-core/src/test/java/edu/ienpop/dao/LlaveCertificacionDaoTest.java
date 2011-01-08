package edu.ienpop.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.model.LlaveCertificacion;

/**
 * @author neodevelop
 * 
 */
public class LlaveCertificacionDaoTest extends AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del DAO
	 */
	@Autowired
	LlaveCertificacionDao llaveCertificacionDao;
	
	static LlaveCertificacion llaveCertificacionPrueba;
	
	/**
	 * Prueba de la inyeccion(esto prueba el DataSource, SessionFactory y
	 * HibernateTemplate)
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(llaveCertificacionDao);
	}

	/**
	 * Prueba del metodo que obtiene toda la tabla
	 */
	@Test
	public void pruebaFindAll() {
		List<LlaveCertificacion> llavesCertificacion = llaveCertificacionDao.findAll();
		Assert.notEmpty(llavesCertificacion);
	}
	
	/**
	 * Prueba de creacion de la entidad
	 */
	@Test
	public void pruebaCreate(){
		llaveCertificacionPrueba = new LlaveCertificacion();
		llaveCertificacionPrueba.setActivo(false);
		llaveCertificacionPrueba.setFechaGeneracion(new Date());
		llaveCertificacionPrueba.setLlave("12345678901234567890");
		llaveCertificacionDao.create(llaveCertificacionPrueba);
		Assert.isTrue(llaveCertificacionPrueba.getIdLlave() > 0);
	}
	
	/**
	 * Prueba de lectura de la entidad basada en su id
	 */
	@Test
	public void pruebaRead(){
		LlaveCertificacion llave = llaveCertificacionDao.read(llaveCertificacionPrueba.getIdLlave());
		Assert.notNull(llave);
	}
	
	/**
	 * Prueba de update de la entidad
	 */
	@Test
	public void pruebaUpdate(){
		llaveCertificacionPrueba.setActivo(true);
		llaveCertificacionPrueba.setFechaUtilizacion(new Date());
		llaveCertificacionDao.update(llaveCertificacionPrueba);
	}
	
	/**
	 * Prueba de borrado de la entidad
	 */
	@Test
	public void pruebaDelete(){
		llaveCertificacionDao.delete(llaveCertificacionPrueba);
		LlaveCertificacion llave = llaveCertificacionDao.read(llaveCertificacionPrueba.getIdLlave());
		Assert.isNull(llave);
	}
}
