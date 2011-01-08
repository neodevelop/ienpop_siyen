package edu.ienpop.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.model.Puerto;

/**
 * @author neodevelop
 * 
 */
public class PuertoDaoTest extends AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del DAO
	 */
	@Autowired
	PuertoDao puertoDao;
	
	static Puerto puertoPrueba;
	
	/**
	 * Prueba de la inyeccion(esto prueba el DataSource, SessionFactory y
	 * HibernateTemplate)
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(puertoDao);
	}

	/**
	 * Prueba del metodo que obtiene toda la tabla
	 */
	@Test
	public void pruebaFindAll() {
		List<Puerto> puertos = puertoDao.findAll();
		Assert.notEmpty(puertos);
	}
	
	/**
	 * Prueba de creacion de la entidad
	 */
	@Test
	public void pruebaCreate(){
		puertoPrueba = new Puerto();
		puertoPrueba.setActivo(false);
		puertoPrueba.setDireccion("DIRECCION");
		puertoPrueba.setEstado("ESTADO DE MEXICO");
		puertoPrueba.setIdPuerto("TEST");
		puertoPrueba.setPuerto("MOCHOTITLAN");
		puertoDao.create(puertoPrueba);
	}
	
	/**
	 * Prueba de lectura de la entidad basada en su id
	 */
	@Test
	public void pruebaRead(){
		Puerto puerto = puertoDao.read(puertoPrueba.getIdPuerto());
		Assert.notNull(puerto);
	}
	
	/**
	 * Prueba de update de la entidad
	 */
	@Test
	public void pruebaUpdate(){
		Puerto puertoAntes = puertoDao.read(puertoPrueba.getIdPuerto());
		puertoPrueba.setActivo(true);
		puertoPrueba.setDireccion("DIRECCION CAMBIADA");
		puertoPrueba.setEstado("MORELOS");
		puertoPrueba.setPuerto("CUERNAVACA");
		puertoDao.update(puertoPrueba);
		Puerto puertoDespues = puertoDao.read(puertoPrueba.getIdPuerto());
		Assert.isTrue(puertoAntes.isActivo()!=puertoDespues.isActivo());
	}
	
	/**
	 * Prueba de borrado de la entidad
	 */
	@Test
	public void pruebaDelete(){
		puertoDao.delete(puertoPrueba);
		Puerto puerto = puertoDao.read(puertoPrueba.getIdPuerto());
		Assert.isNull(puerto);
	}
}
