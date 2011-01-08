package edu.ienpop.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.CursoSinCertificarDao;
import edu.ienpop.model.CursoSinCertificar;

public class CursoSinCertificarDaoHibernateImpl extends PersistenceGenericDaoHibernateImpl<CursoSinCertificar, Long>
		implements CursoSinCertificarDao {
	
	public CursoSinCertificarDaoHibernateImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

}