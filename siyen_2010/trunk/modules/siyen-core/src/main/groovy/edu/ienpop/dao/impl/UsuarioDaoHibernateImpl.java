package edu.ienpop.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.UsuarioDao;
import edu.ienpop.model.Usuario;

public class UsuarioDaoHibernateImpl extends PersistenceGenericDaoHibernateImpl<Usuario, String> implements
		UsuarioDao {

	public UsuarioDaoHibernateImpl(HibernateTemplate hibernateTemplate){
		super(hibernateTemplate);
	}

}
