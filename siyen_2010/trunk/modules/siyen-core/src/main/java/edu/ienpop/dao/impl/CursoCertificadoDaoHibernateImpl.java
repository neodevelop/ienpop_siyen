package edu.ienpop.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.CursoCertificadoDao;
import edu.ienpop.model.CursoCertificado;

public class CursoCertificadoDaoHibernateImpl extends PersistenceGenericDaoHibernateImpl<CursoCertificado, Long>
		implements CursoCertificadoDao {
	
	public CursoCertificadoDaoHibernateImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

}
