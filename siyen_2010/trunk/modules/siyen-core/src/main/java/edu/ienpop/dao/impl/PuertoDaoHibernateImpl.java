package edu.ienpop.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.PuertoDao;
import edu.ienpop.model.Puerto;

public class PuertoDaoHibernateImpl extends
		PersistenceGenericDaoHibernateImpl<Puerto, String> implements PuertoDao {

	public PuertoDaoHibernateImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

}
