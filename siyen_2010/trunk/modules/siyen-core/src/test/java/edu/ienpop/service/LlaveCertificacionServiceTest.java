package edu.ienpop.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import edu.ienpop.config.AbstractJavaConfigBaseClass;

/**
 * @author neodevelop
 * 
 */
public class LlaveCertificacionServiceTest extends
		AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del servicio
	 */
	@Autowired
	LlaveCertificacionService llaveCertifiacionService;

	/**
	 * Prueba la inyeccion del servicio y de sus colaboradores(daos), basados en
	 * configuracion
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(llaveCertifiacionService);
	}

}
