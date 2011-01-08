package edu.ienpop.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.AlumnoCertificadoDao;
import edu.ienpop.dao.AlumnoSinCertificarDao;
import edu.ienpop.dao.CursoCertificadoDao;
import edu.ienpop.dao.CursoSinCertificarDao;
import edu.ienpop.dao.InstructorDao;
import edu.ienpop.dao.LlaveCertificacionDao;
import edu.ienpop.dao.PuertoDao;
import edu.ienpop.dao.TipoCursoDao;
import edu.ienpop.dao.UsuarioDao;

@Configuration
public interface RepositoryConfiguration {
	/**
	 * @param driverClassName
	 * @param username
	 * @param password
	 * @param url
	 * @return la creacion del bean dataSource listo para usarse
	 */
	@Bean
	DataSource dataSource(String driverClassName, String username,
			String password, String url);

	/**
	 * @return el hibernateTemplate listo para usarse en cualquier clase que use
	 *         el HibernateDaoSupport
	 */
	@Bean
	HibernateTemplate hibernateTemplate();

	/**
	 * @return el dao del TipoCurso
	 */
	@Bean
	TipoCursoDao tipoCursoDao();

	/**
	 * @return el dao del AlumnoCertificado
	 */
	@Bean
	AlumnoCertificadoDao alumnoCertificadoDao();

	/**
	 * @return el dao del AlumnoSinCertificar
	 */
	@Bean
	AlumnoSinCertificarDao alumnoSinCertificarDao();

	/**
	 * @return el dao del CursoCerticado
	 */
	@Bean
	CursoCertificadoDao cursoCertificadoDao();

	/**
	 * @return el dao del CursoSinCertificar
	 */
	@Bean
	CursoSinCertificarDao cursoSinCertificarDao();

	/**
	 * @return el dao del Instructor
	 */
	@Bean
	InstructorDao instructorDao();

	/**
	 * @return el dao de la LLaveCertificacion
	 */
	@Bean
	LlaveCertificacionDao llaveCertificacionDao();

	/**
	 * @return el dao de Puerto
	 */
	@Bean
	PuertoDao puertoDao();
	
	/**
	 * @return el dao del Usuario
	 */
	@Bean
	UsuarioDao usuarioDao();
}
