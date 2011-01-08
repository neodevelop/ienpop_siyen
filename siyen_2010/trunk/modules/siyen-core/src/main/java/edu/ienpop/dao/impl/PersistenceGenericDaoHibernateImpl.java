package edu.ienpop.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.ienpop.dao.PersistenceGenericDao;

public abstract class PersistenceGenericDaoHibernateImpl<T, PK extends Serializable> extends HibernateDaoSupport implements
		PersistenceGenericDao<T, PK> {

	private Class<T> type = null;
	
	@Autowired
	public PersistenceGenericDaoHibernateImpl(HibernateTemplate hibernateTemplate){
		this.setHibernateTemplate(hibernateTemplate);
	}
	
	public void create(T newInstance) {
		this.getHibernateTemplate().save(newInstance);
	}

	
	public void delete(T persistentObject) {
		this.getHibernateTemplate().delete(persistentObject);
	}

	public List<T> findAll() {
		return this.getHibernateTemplate().loadAll(getType());
	}

	/**
	 * Obtiene por reflexion el tipo del DomainObject que usa este DAO
	 * 
	 * @return the type
	 */
	public Class<T> getType() {
		if (type == null) {
			Class clazz = getClass();

			while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
				clazz = clazz.getSuperclass();
			}

			type = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass())
					.getActualTypeArguments()[0];
		}

		return type;
	}

	public T read(PK id) {
		return (T) this.getHibernateTemplate().get(getType(), id);
	}

	
	public void update(T transientObject) {
		this.getHibernateTemplate().update(transientObject);
	}


}
