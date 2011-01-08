package edu.ienpop.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.AlumnoSinCertificarDao;
import edu.ienpop.model.AlumnoSinCertificar;

/**
 * @author neodevelop
 *
 */
public class AlumnoSinCertificarDaoHibernateImpl extends
		PersistenceGenericDaoHibernateImpl<AlumnoSinCertificar, Long> implements
		AlumnoSinCertificarDao {

	public AlumnoSinCertificarDaoHibernateImpl(
			HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

}
