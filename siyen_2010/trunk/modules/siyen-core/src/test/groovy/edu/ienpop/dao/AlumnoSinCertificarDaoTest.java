package edu.ienpop.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.model.AlumnoSinCertificar;

/**
 * @author neodevelop
 * 
 */
public class AlumnoSinCertificarDaoTest extends AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del DAO
	 */
	@Autowired
	AlumnoSinCertificarDao alumnoSinCertificarDao;

	static AlumnoSinCertificar alumnoSinCertificarPrueba;

	/**
	 * Prueba de la inyeccion(esto prueba el DataSource, SessionFactory y
	 * HibernateTemplate)
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(alumnoSinCertificarDao);
	}

	/**
	 * Prueba del metodo que obtiene toda la tabla
	 */
	@Test
	public void pruebaFindAll() {
		List<AlumnoSinCertificar> alumnosSinCertificar = alumnoSinCertificarDao
				.findAll();
		Assert.isTrue(alumnosSinCertificar.size() > 0);
	}

	/**
	 * Prueba de creacion de la entidad
	 */
	@Test
	public void pruebaCreate() {
		alumnoSinCertificarPrueba = new AlumnoSinCertificar();
		alumnoSinCertificarPrueba.setFechaHoraRegistro(new Date());
		alumnoSinCertificarPrueba
				.setNombreCompleto("NOMBRE SIN CERTIFICAR DE PRUEBA");
		alumnoSinCertificarPrueba.setObservaciones("OBSERVAIONES");
		alumnoSinCertificarDao.create(alumnoSinCertificarPrueba);
		Assert.isTrue(alumnoSinCertificarPrueba.getIdAlumno() > 0);
	}

	/**
	 * Prueba de lectura de la entidad basada en su id
	 */
	@Test
	public void pruebaRead() {
		AlumnoSinCertificar alumno = alumnoSinCertificarDao
				.read(alumnoSinCertificarPrueba.getIdAlumno());
		Assert.notNull(alumno);
	}

	/**
	 * Prueba de update de la entidad
	 */
	@Test
	public void pruebaUpdate() {
		alumnoSinCertificarPrueba
				.setNombreCompleto("NOMBRE SIN CERTIFICAR CON CAMBIOS");
		alumnoSinCertificarPrueba.setObservaciones("OBSERVACIONES CON CAMBIOS");
		alumnoSinCertificarDao.update(alumnoSinCertificarPrueba);
		AlumnoSinCertificar alumno = alumnoSinCertificarDao
				.read(alumnoSinCertificarPrueba.getIdAlumno());
		Assert.isTrue(alumno.getNombreCompleto().equals(
				alumnoSinCertificarPrueba.getNombreCompleto()));
	}

	/**
	 * Prueba de borrado de la entidad
	 */
	@Test
	public void pruebaDelete() {
		alumnoSinCertificarDao.delete(alumnoSinCertificarPrueba);
		AlumnoSinCertificar alumno = alumnoSinCertificarDao
				.read(alumnoSinCertificarPrueba.getIdAlumno());
		Assert.isNull(alumno);
	}
	
	/**
	 * Prueba del manejo de un la do de una relaci—n basado en el bojeto CursoSinCertificar
	 */
	@Test
	public void pruebaObtenerAlumnosSinCertificarPorIdCurso(){
		List<AlumnoSinCertificar> alumnos = alumnoSinCertificarDao.obtenerAlumnosSinCertificarPorIdCurso(4L);
		Assert.notEmpty(alumnos);
	}
}
