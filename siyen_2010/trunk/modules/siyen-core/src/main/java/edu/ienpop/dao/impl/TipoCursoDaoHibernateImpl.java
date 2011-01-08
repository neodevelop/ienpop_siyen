package edu.ienpop.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.TipoCursoDao;
import edu.ienpop.model.TipoCurso;

public class TipoCursoDaoHibernateImpl extends PersistenceGenericDaoHibernateImpl<TipoCurso, String>
		implements TipoCursoDao {
	
	public TipoCursoDaoHibernateImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

}
