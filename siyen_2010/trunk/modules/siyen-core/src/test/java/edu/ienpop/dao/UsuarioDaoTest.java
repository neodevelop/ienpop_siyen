package edu.ienpop.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;
import edu.ienpop.model.Usuario;

/**
 * @author neodevelop
 * 
 */
public class UsuarioDaoTest extends AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del DAO
	 */
	@Autowired
	UsuarioDao usuarioDao;
	
	static Usuario usuarioPrueba;
	
	/**
	 * Prueba de la inyeccion(esto prueba el DataSource, SessionFactory y
	 * HibernateTemplate)
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(usuarioDao);
	}

	/**
	 * Prueba del metodo que obtiene toda la tabla
	 */
	@Test
	public void pruebaFindAll() {
		List<Usuario> usuarios = usuarioDao.findAll();
		Assert.notEmpty(usuarios);
	}
	
	/**
	 * Prueba de creacion de la entidad
	 */
	@Test
	public void pruebaCreate(){
		usuarioPrueba = new Usuario();
		usuarioPrueba.setEnabled(false);
		usuarioPrueba.setUsername("prueba");
		usuarioPrueba.setPassword("123456");
		usuarioDao.create(usuarioPrueba);
	}
	
	/**
	 * Prueba de lectura de la entidad basada en su id
	 */
	@Test
	public void pruebaRead(){
		Usuario usuario = usuarioDao.read(usuarioPrueba.getUsername());
		Assert.notNull(usuario);
	}
	
	/**
	 * Prueba de update de la entidad
	 */
	@Test
	public void pruebaUpdate(){
		usuarioPrueba.setEnabled(true);
		usuarioPrueba.setPassword("1234567890");
		usuarioDao.update(usuarioPrueba);
		Usuario usuario = usuarioDao.read(usuarioPrueba.getUsername());
		Assert.isTrue(usuario.isEnabled());
	}
	
	/**
	 * Prueba de borrado de la entidad
	 */
	@Test
	public void pruebaDelete(){
		usuarioDao.delete(usuarioPrueba);
		Usuario usuario = usuarioDao.read(usuarioPrueba.getUsername());
		Assert.isNull(usuario);
	}
}
