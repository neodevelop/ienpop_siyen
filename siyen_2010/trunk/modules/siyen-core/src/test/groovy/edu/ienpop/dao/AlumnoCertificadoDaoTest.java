package edu.ienpop.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.model.AlumnoCertificado;

/**
 * @author neodevelop
 * 
 */
public class AlumnoCertificadoDaoTest extends AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del DAO
	 */
	@Autowired
	AlumnoCertificadoDao alumnoCertificadoDao;
	
	static AlumnoCertificado alumnoCertificadoPrueba;
	
	/**
	 * Prueba de la inyeccion(esto prueba el DataSource, SessionFactory y
	 * HibernateTemplate)
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(alumnoCertificadoDao);
	}

	/**
	 * Prueba del metodo que obtiene toda la tabla
	 */
	@Test
	@Ignore
	public void pruebaFindAll() {
		List<AlumnoCertificado> alumnosCertificados = alumnoCertificadoDao.findAll();
		Assert.isTrue(alumnosCertificados.size() > 0);
	}
	
	/**
	 * Prueba de creacion de la entidad
	 */
	@Test
	public void pruebaCreate(){
		alumnoCertificadoPrueba = new AlumnoCertificado();
		alumnoCertificadoPrueba.setFechaHoraRegistro(new Date());
		alumnoCertificadoPrueba.setNombreCompleto("Alumno De Prueba con Nombre y Apellido");
		alumnoCertificadoPrueba.setObservaciones("Observaciones");
		alumnoCertificadoDao.create(alumnoCertificadoPrueba);
		Assert.isTrue(alumnoCertificadoPrueba.getIdAlumno()>0);
	}
	
	/**
	 * Prueba de lectura de la entidad basada en su id
	 */
	@Test
	public void pruebaRead(){
		AlumnoCertificado alumno = alumnoCertificadoDao.read(alumnoCertificadoPrueba.getIdAlumno());
		Assert.notNull(alumno);
	}
	
	/**
	 * Prueba de update de la entidad
	 */
	@Test
	public void pruebaUpdate(){
		AlumnoCertificado alumno = alumnoCertificadoDao.read(alumnoCertificadoPrueba.getIdAlumno());
		alumno.setNumeroControl("II0"+alumno.getIdAlumno());
		alumno.setObservaciones("Los datos del alumno han cambiado");
		alumnoCertificadoDao.update(alumno);
		assert(alumnoCertificadoPrueba.getNumeroControl() != alumno.getNumeroControl());
	}
	
	/**
	 * Prueba de borrado de la entidad
	 */
	@Test
	public void pruebaDelete(){
		alumnoCertificadoDao.delete(alumnoCertificadoPrueba);
		AlumnoCertificado alumno = alumnoCertificadoDao.read(alumnoCertificadoPrueba.getIdAlumno());
		Assert.isNull(alumno);
	}
}
