package edu.ienpop.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.ienpop.dao.UsuarioDao;

public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao {

	public String findSimpleUser(String username) {
		String sql = "Select u.password from Usuario u where idUsuario=:username";
		Query query = getSession().createQuery(sql);
		query.setString("username", username);
		return (String)query.uniqueResult();
	}

}
