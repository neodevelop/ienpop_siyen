package edu.ienpop.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.LlaveCertificacionDao;
import edu.ienpop.model.LlaveCertificacion;

/**
 * @author neodevelop
 *
 */
public class LlaveCertificacionDaoHibernateImpl extends
		PersistenceGenericDaoHibernateImpl<LlaveCertificacion, Long> implements
		LlaveCertificacionDao {

	public LlaveCertificacionDaoHibernateImpl(
			HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

}
