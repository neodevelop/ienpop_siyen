package edu.ienpop.dao.impl

import java.io.Serializable
import java.util.List

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.orm.hibernate3.HibernateTemplate
import org.springframework.orm.hibernate3.support.HibernateDaoSupport
import org.springframework.stereotype.Repository

import edu.ienpop.dao.Dao

@Repository("dao")
class DaoImpl extends HibernateDaoSupport implements Dao {

	@Autowired
	DaoImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate)
	}
	
	void delete(Object o) {
		hibernateTemplate.delete o
	}

	List getAll(String entity) {
		hibernateTemplate.find "from $entity"
	}

	Object getByPK(Class clazz, Serializable pk) {
		hibernateTemplate.get clazz, pk
	}

	Serializable save(Object o) {
		hibernateTemplate.save o
	}

	void update(Object o) {
		hibernateTemplate.update o
	}

}
