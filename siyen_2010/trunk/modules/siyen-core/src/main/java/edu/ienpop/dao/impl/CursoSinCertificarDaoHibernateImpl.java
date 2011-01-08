package edu.ienpop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.CursoSinCertificarDao;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoSinCertificar;

public class CursoSinCertificarDaoHibernateImpl extends
		PersistenceGenericDaoHibernateImpl<CursoSinCertificar, Long> implements
		CursoSinCertificarDao {

	public CursoSinCertificarDaoHibernateImpl(
			HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

	@Override
	public List<CursoSinCertificar> obtenerCursosSinCertificarConRelaciones(
			CursoCriteria cursoCriteria, int offset, int maxSize) {
		String hql = "from CursoSinCertificar csc join fetch csc.puerto join fetch csc.tipoCurso join fetch csc.instructor where 1=1";
		Query query = getSession().createQuery(hql);
		
		query.setMaxResults(maxSize);
		query.setFirstResult(offset);
		return query.list();
	}

}
