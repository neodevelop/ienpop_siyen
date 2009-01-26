package edu.ienpop.dao.impl;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import edu.ienpop.dao.CatalogoDao;

@Repository("catalogoDao")
public class CatalogoDaoImpl extends HibernateDaoSupport implements CatalogoDao {

	@Autowired
	public CatalogoDaoImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}
	
	public Object[] getGrupoCursosXLibreta(String libreta) {
		String sql = "select cp.idTipoCurso from CatalogoCurso cp where libreta=:libreta";
		Query query = getSession().createQuery(sql);
		query.setParameter("libreta", libreta);
		return query.list().toArray();
	}

}
