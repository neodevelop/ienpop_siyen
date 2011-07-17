package edu.ienpop.dao.impl;

import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.InstructorDao;
import edu.ienpop.model.Instructor;

/**
 * @author neodevelop
 * 
 */
public class InstructorDaoHibernateImpl extends
		PersistenceGenericDaoHibernateImpl<Instructor, String> implements
		InstructorDao {

	public InstructorDaoHibernateImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

}
