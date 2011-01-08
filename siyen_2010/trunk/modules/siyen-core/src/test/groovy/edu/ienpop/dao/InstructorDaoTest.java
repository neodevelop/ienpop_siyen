package edu.ienpop.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.model.Instructor;

/**
 * @author neodevelop
 * 
 */
public class InstructorDaoTest extends AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del DAO
	 */
	@Autowired
	InstructorDao instructorDao;
	
	static Instructor instructorPrueba;
	
	/**
	 * Prueba de la inyeccion(esto prueba el DataSource, SessionFactory y
	 * HibernateTemplate)
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(instructorDao);
	}

	/**
	 * Prueba del metodo que obtiene toda la tabla
	 */
	@Test
	public void pruebaFindAll() {
		List<Instructor> instructores = instructorDao.findAll();
		Assert.notEmpty(instructores);
	}
	
	/**
	 * Prueba de creacion de la entidad
	 */
	@Test
	public void pruebaCreate(){
		instructorPrueba = new Instructor();
		instructorPrueba.setActivo(false);
		instructorPrueba.setIdInstructor("PRUEBA");
		instructorPrueba.setNombre("NOMBRE DE PRUEBA");
		instructorPrueba.setNumOficio("000000000000000");
		instructorDao.create(instructorPrueba);
	}
	
	/**
	 * Prueba de lectura de la entidad basada en su id
	 */
	@Test
	public void pruebaRead(){
		Instructor instructor = instructorDao.read(instructorPrueba.getIdInstructor());
		Assert.notNull(instructor);
	}
	
	/**
	 * Prueba de update de la entidad
	 */
	@Test
	public void pruebaUpdate(){
		Instructor instructorAntes = instructorDao.read(instructorPrueba.getIdInstructor());
		instructorPrueba.setActivo(true);
		instructorDao.update(instructorPrueba);
		Instructor instructorDespues = instructorDao.read(instructorPrueba.getIdInstructor());
		Assert.isTrue(instructorAntes.getActivo() != instructorDespues.getActivo());
	}
	
	/**
	 * Prueba de borrado de la entidad
	 */
	@Test
	public void pruebaDelete(){
		instructorDao.delete(instructorPrueba);
		Instructor instructor = instructorDao.read(instructorPrueba.getIdInstructor());
		Assert.isNull(instructor);
	}
}
