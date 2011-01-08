package edu.ienpop.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;

/**
 * @author neodevelop
 * 
 */
public class UsuarioServiceTest extends
		AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del servicio
	 */
	@Autowired
	UsuarioService usuarioService;

	/**
	 * Prueba la inyeccion del servicio y de sus colaboradores(daos), basados en
	 * configuracion
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(usuarioService);
	}
	
	@Test
	public void buscarUsuarioExistente(){
		UserDetails usuario = usuarioService.loadUserByUsername("neodevelop");
		Assert.notNull(usuario);
	}

	@Test
	@ExpectedException(UsernameNotFoundException.class)
	public void buscarUsuarioNoExistente(){
		usuarioService.loadUserByUsername("no_exists");
	}
}
