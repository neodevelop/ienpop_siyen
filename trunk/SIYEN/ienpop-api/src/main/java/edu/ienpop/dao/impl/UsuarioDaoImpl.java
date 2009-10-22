package edu.ienpop.dao.impl;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import edu.ienpop.dao.UsuarioDao;

@Repository("usuarioDao")
public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao {

	@Autowired
	public UsuarioDaoImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}
	
	public String findSimpleUser(String username) {
		String sql = "Select u.password from Usuario u where idUsuario=:username";
		Query query = getSession().createQuery(sql);
		query.setString("username", username);
		return (String)query.uniqueResult();
	}

	public String getNombreUsuario(String username) {
		String sql = "Select u.nombre from Usuario u where idUsuario=:username";
		Query query = getSession().createQuery(sql);
		query.setString("username", username);
		return (String)query.uniqueResult();
	}

}
