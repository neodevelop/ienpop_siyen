package edu.ienpop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.ienpop.service.CursoCertificadoService;
import edu.ienpop.service.CursoSinCertificarService;
import edu.ienpop.service.LlaveCertificacionService;

@Configuration
public interface ServiceConfiguration {

	/**
	 * @return LlaveCertificacionService Configuracion de Spring para el
	 *         servicio de LlaveCertificacion
	 */
	@Bean
	LlaveCertificacionService llaveCertificacionService();

	/**
	 * @return CursoSinCertificarService Configuracion de Spring para el
	 *         servicio de CursoSinCertificar
	 */
	@Bean
	CursoSinCertificarService cursoSinCertificarService();

	/**
	 * @return CursoCertificadoService Configuracion de Spring para el servicio
	 *         de CursoCertificado
	 */
	@Bean
	CursoCertificadoService cursoCertificadoService();
}
