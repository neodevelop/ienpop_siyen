package edu.ienpop.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.model.TipoCurso;

/**
 * @author neodevelop
 * 
 */
public class TipoCursoDaoTest extends AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del DAO
	 */
	@Autowired
	TipoCursoDao tipoCursoDao;
	
	static TipoCurso tipoCursoPrueba;
	
	/**
	 * Prueba de la inyeccion(esto prueba el DataSource, SessionFactory y
	 * HibernateTemplate)
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(tipoCursoDao);
	}

	/**
	 * Prueba del metodo que obtiene toda la tabla
	 */
	@Test
	public void pruebaFindAll() {
		List<TipoCurso> tiposCurso = tipoCursoDao.findAll();
		Assert.isTrue(tiposCurso.size() > 0);
	}
	
	/**
	 * Prueba de creacion de la entidad
	 */
	@Test
	public void pruebaCreate(){
		tipoCursoPrueba = new TipoCurso();
		tipoCursoPrueba.setActivo(true);
		tipoCursoPrueba.setDuracion(5);
		tipoCursoPrueba.setNombreCurso("Curso de Prueba");
		tipoCursoPrueba.setLibreta("A");
		tipoCursoPrueba.setIdTipoCurso("PRUEBA_CURSO");
		tipoCursoDao.create(tipoCursoPrueba);
		Assert.notNull(tipoCursoPrueba);
	}
	
	/**
	 * Prueba de lectura de la entidad basada en su id
	 */
	@Test
	public void pruebaRead(){
		TipoCurso tipoCurso = tipoCursoDao.read(tipoCursoPrueba.getIdTipoCurso());
		Assert.notNull(tipoCurso);
		Assert.isTrue(tipoCurso.getIdTipoCurso() == tipoCursoPrueba.getIdTipoCurso());
	}
	
	/**
	 * Prueba de update de la entidad
	 */
	@Test
	public void pruebaUpdate(){
		tipoCursoPrueba.setActivo(false);
		tipoCursoPrueba.setDuracion(2);
		tipoCursoPrueba.setNombreCurso("Curso de Prueba Modificado");
		tipoCursoPrueba.setLibreta("B");
		tipoCursoDao.update(tipoCursoPrueba);
		TipoCurso tipoCurso = tipoCursoDao.read(tipoCursoPrueba.getIdTipoCurso());
		Assert.isTrue(!tipoCurso.getActivo());
	}
	
	/**
	 * Prueba de borrado de la entidad
	 */
	@Test
	public void pruebaDelete(){
		tipoCursoDao.delete(tipoCursoPrueba);
		TipoCurso tipoCurso = tipoCursoDao.read(tipoCursoPrueba.getIdTipoCurso());
		Assert.isNull(tipoCurso);
	}
}
