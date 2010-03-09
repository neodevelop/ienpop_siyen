package edu.ienpop.dao.impl

import org.hibernate.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.orm.hibernate3.HibernateTemplate
import org.springframework.orm.hibernate3.support.HibernateDaoSupport
import org.springframework.stereotype.Repository

import edu.ienpop.dao.CatalogoDao

@Repository("catalogoDao")
class CatalogoDaoImpl extends HibernateDaoSupport implements CatalogoDao {

	@Autowired
	CatalogoDaoImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate)
	}
	
	Object[] getGrupoCursosXLibreta(String libreta) {
		def sql = "select cp.idTipoCurso from CatalogoCurso cp where libreta=:libreta"
		def query = getSession().createQuery(sql)
		query.setParameter("libreta", libreta)
		query.list().toArray()
	}

}
