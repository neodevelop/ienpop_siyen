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
import edu.ienpop.service.impl.LlaveCertificacionServiceImpl;

/**
 * @author neodevelop
 * 
 */
@Configuration
@Import( { RepositoryHibernateConfiguration.class })
public class ServiceDefaultConfiguration implements ServiceConfiguration {

	@Autowired
	private RepositoryConfiguration persistenceConfiguration;

	public void setPersistenceConfiguration(
			RepositoryConfiguration persistenceConfiguration) {
		this.persistenceConfiguration = persistenceConfiguration;
	}

	public @Bean
	LlaveCertificacionService llaveCertificacionService() {
		return new LlaveCertificacionServiceImpl(persistenceConfiguration
				.llaveCertificacionDao(), persistenceConfiguration
				.cursoSinCertificarDao());
	}

	@Override
	public CursoCertificadoService cursoCertificadoService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CursoSinCertificarService cursoSinCertificarService() {
		// TODO Auto-generated method stub
		return null;
	}
}
