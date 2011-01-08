package edu.ienpop.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.AlumnoCertificadoDao;
import edu.ienpop.dao.AlumnoSinCertificarDao;
import edu.ienpop.dao.TipoCursoDao;
import edu.ienpop.dao.impl.AlumnoCertificadoDaoHibernateImpl;
import edu.ienpop.dao.impl.AlumnoSinCertificarDaoHibernateImpl;
import edu.ienpop.dao.impl.TipoCursoDaoHibernateImpl;

/**
 * @author neodevelop
 * 
 */
@Configuration
public class PersistenceConfiguration {

	/**
	 * Inyeccion del sessionFactory que viene de la configuracion xml
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @param driverClassName
	 * @param username
	 * @param password
	 * @param url
	 * @return la creacion del bean dataSource listo para usarse
	 */
	public @Bean
	DataSource dataSource(
			@Value("${jdbc.driverClassName}") String driverClassName,
			@Value("${jdbc.username}") String username,
			@Value("${jdbc.password}") String password,
			@Value("${jdbc.url}") String url) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		return dataSource;
	}

	/**
	 * @return el hibernateTemplate listo para usarse en cualquier clase que use
	 *         el HibernateDaoSupport
	 */
	public @Bean
	HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory);
	}

	/**
	 * @return el dao del TipoCurso
	 */
	public @Bean
	TipoCursoDao tipoCursoDao() {
		return new TipoCursoDaoHibernateImpl(hibernateTemplate());
	}

	/**
	 * @return el dao del AlumnoCertificado
	 */
	public @Bean
	AlumnoCertificadoDao alumnoCertificadoDao() {
		return new AlumnoCertificadoDaoHibernateImpl(hibernateTemplate());
	}

	/**
	 * @return el dao del AlumnoSinCertificar
	 */
	public @Bean
	AlumnoSinCertificarDao alumnoSinCertificarDao() {
		return new AlumnoSinCertificarDaoHibernateImpl(hibernateTemplate());
	}
}
