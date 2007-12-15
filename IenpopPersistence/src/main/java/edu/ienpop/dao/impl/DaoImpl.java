package edu.ienpop.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.ienpop.dao.Dao;

public class DaoImpl extends HibernateDaoSupport implements Dao {

	public void delete(Object o) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(o);
	}

	public List getAll(String entity) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from "+entity);
	}

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
