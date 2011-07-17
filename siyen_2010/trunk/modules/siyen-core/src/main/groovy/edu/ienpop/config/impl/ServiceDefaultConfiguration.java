package edu.ienpop.config.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import edu.ienpop.config.RepositoryConfiguration;
import edu.ienpop.config.ServiceConfiguration;
import edu.ienpop.service.CursoCertificadoService;
import edu.ienpop.service.CursoSinCertificarService;
import edu.ienpop.service.LlaveCertificacionService;
import edu.ienpop.service.UsuarioService;
import edu.ienpop.service.impl.CursoCertificadoServiceImpl;
import edu.ienpop.service.impl.CursoSinCertificarServiceImpl;
import edu.ienpop.service.impl.LlaveCertificacionServiceImpl;
import edu.ienpop.service.impl.UsuarioServiceImpl;

/**
 * @author neodevelop
 * 
 */
@Configuration
@Import({ RepositoryHibernateConfiguration.class })
public class ServiceDefaultConfiguration implements ServiceConfiguration {

	@Autowired
	private RepositoryConfiguration persistenceConfiguration;

	public void setPersistenceConfiguration(
			RepositoryConfiguration persistenceConfiguration) {
		this.persistenceConfiguration = persistenceConfiguration;
	}

	public @Bean
	LlaveCertificacionService llaveCertificacionService() {
		return new LlaveCertificacionServiceImpl(
				persistenceConfiguration.llaveCertificacionDao(),
				persistenceConfiguration.cursoSinCertificarDao());
	}

	public @Bean
	CursoCertificadoService cursoCertificadoService() {
		return new CursoCertificadoServiceImpl(
				persistenceConfiguration.cursoSinCertificarDao(),
				persistenceConfiguration.cursoCertificadoDao(),
				persistenceConfiguration.tipoCursoDao(),
				persistenceConfiguration.alumnoCertificadoDao(),
				persistenceConfiguration.llaveCertificacionDao());
	}

	public @Bean
	CursoSinCertificarService cursoSinCertificarService() {
		return new CursoSinCertificarServiceImpl(
				persistenceConfiguration.cursoSinCertificarDao(),
				persistenceConfiguration.alumnoSinCertificarDao());
	}

	public @Bean
	UsuarioService usuarioService() {
		return new UsuarioServiceImpl(persistenceConfiguration.usuarioDao());
	}
}
