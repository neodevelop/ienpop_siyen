package edu.ienpop.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.ienpop.dao.LlaveDao;

public class LlaveDaoImpl extends HibernateDaoSupport implements LlaveDao {

	public Object getLlaveByLlave(String llave) {
		// TODO Auto-generated method stub
		String sql = "from edu.ienpop.model.LlaveCertificacion where llave=:llave";
		Query query = getSession().createQuery(sql);
		query.setString("llave", llave);
		return query.uniqueResult();
	}

}
