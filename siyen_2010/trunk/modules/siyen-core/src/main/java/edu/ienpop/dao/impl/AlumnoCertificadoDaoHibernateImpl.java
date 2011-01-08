package edu.ienpop.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.AlumnoCertificadoDao;
import edu.ienpop.model.AlumnoCertificado;

/**
 * @author neodevelop
 *
 */
public class AlumnoCertificadoDaoHibernateImpl extends
		PersistenceGenericDaoHibernateImpl<AlumnoCertificado, Long> implements
		AlumnoCertificadoDao {

	public AlumnoCertificadoDaoHibernateImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

}
