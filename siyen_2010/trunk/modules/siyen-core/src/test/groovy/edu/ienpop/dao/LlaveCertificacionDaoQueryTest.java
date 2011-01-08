package edu.ienpop.dao;

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
public class LlaveCertificacionDaoQueryTest extends AbstractJavaConfigBaseClass {

	/**
	 * Inyeccion del DAO
	 */
	@Autowired
	LlaveCertificacionDao llaveCertificacionDao;
	
	static LlaveCertificacion llaveCertificacionPrueba;
	String codigo = "12345678901234567890";
	
	/**
	 * Prueba de la inyeccion(esto prueba el DataSource, SessionFactory y
	 * HibernateTemplate)
	 */
	@Test
	public void pruebaIoC() {
		Assert.notNull(llaveCertificacionDao);
	}

	@Test
	public void pruebaObtenerLlavesConCursosSinCertificar(){
		List<LlaveCertificacion> llaves = llaveCertificacionDao.obtenerLlavesConCursosSinCertificar();
		Assert.notEmpty(llaves);
	}
}
