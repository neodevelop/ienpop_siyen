package edu.ienpop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.CursoCertificadoDao;
import edu.ienpop.model.CursoCertificado;
import edu.ienpop.model.CursoCriteria;

public class CursoCertificadoDaoHibernateImpl extends PersistenceGenericDaoHibernateImpl<CursoCertificado, Long>
		implements CursoCertificadoDao {
	
	public CursoCertificadoDaoHibernateImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

	@Override
	public CursoCertificado obtenerCursoCertificadoConAlumnos(
			long idCursoCertificado) {
		String sql = "from CursoCertificado cc join fetch cc.alumnosCertificados where cc.idCurso = :idCurso";
		Query query = getSession().createQuery(sql);
		query.setParameter("idCurso", idCursoCertificado);
		return (CursoCertificado)query.uniqueResult();
	}

	@Override
	public List<CursoCertificado> obtenerCursosCertificadosPorCriteria(
			CursoCriteria curso) {
		// TODO Auto-generated method stub
		return null;
	}

}
