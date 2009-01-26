package edu.ienpop.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import edu.ienpop.dao.Dao;

@Repository("dao")
public class DaoImpl extends HibernateDaoSupport implements Dao {

	@Autowired
	public DaoImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}
	
	public void delete(Object o) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(o);
	}

	@SuppressWarnings("unchecked")
	public List getAll(String entity) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from "+entity);
	}

	@SuppressWarnings("unchecked")
	public Object getByPK(Class clazz, Serializable pk) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(clazz, pk);
	}

	public Serializable save(Object o) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().save(o);
	}

	public void update(Object o) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(o);
	}

}
