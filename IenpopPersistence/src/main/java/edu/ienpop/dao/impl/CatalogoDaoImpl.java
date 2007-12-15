package edu.ienpop.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.ienpop.dao.CatalogoDao;

public class CatalogoDaoImpl extends HibernateDaoSupport implements CatalogoDao {

	public Object[] getGrupoCursosXLibreta(String libreta) {
		String sql = "select cp.idTipoCurso from CatalogoCurso cp where libreta=:libreta";
		Query query = getSession().createQuery(sql);
		query.setParameter("libreta", libreta);
		return query.list().toArray();
	}

}
