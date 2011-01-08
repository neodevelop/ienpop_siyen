package edu.ienpop.dao.impl;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.CursoSinCertificarDao;
import edu.ienpop.model.CursoSinCertificar;

public class CursoSinCertificarDaoHibernateImpl extends
		PersistenceGenericDaoHibernateImpl<CursoSinCertificar, Long> implements
		CursoSinCertificarDao {

	public CursoSinCertificarDaoHibernateImpl(
			HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

	public CursoSinCertificar obtenerAlumnosSinCertificarPorIdCurso(Long idCurso) {
		String queryString = "from CursoSinCertificar csc inner join fetch csc.alumnosSinCertificar where csc.idCurso = :idCurso";
		Query query = getSession().createQuery(queryString);
		query.setLong("idCurso", idCurso);
		return (CursoSinCertificar) query.uniqueResult();
	}

}
