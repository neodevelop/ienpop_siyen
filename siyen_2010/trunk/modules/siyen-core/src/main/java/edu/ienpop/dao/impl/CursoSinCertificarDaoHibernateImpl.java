package edu.ienpop.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

	@SuppressWarnings("unchecked")
	public List<CursoSinCertificar> obtenerCursosSinCertificarConRelaciones(
			CursoCriteria cursoCriteria, int offset, int maxSize) {
		Criteria criteria = getSession().createCriteria(
				CursoSinCertificar.class);
		criteria.setFetchMode("puerto", FetchMode.JOIN);
		criteria.setFetchMode("tipoCurso", FetchMode.JOIN);
		criteria.setFetchMode("instructor", FetchMode.JOIN);
		establecerCondiciones(criteria, cursoCriteria);
		criteria.addOrder(Order.desc("idCurso"));
		criteria.setMaxResults(maxSize);
		criteria.setFirstResult(offset);
		return criteria.list();
	}

	@Override
	public int obtenerContadorDeCursosSinCertificar(CursoCriteria cursoCriteria) {
		Criteria criteria = getSession().createCriteria(
				CursoSinCertificar.class);
		criteria.setProjection(Projections.rowCount());
		establecerCondiciones(criteria, cursoCriteria);
		return (Integer) criteria.uniqueResult();
	}

	/**
	 * @param criteria
	 * @param cursoCriteria
	 *            Este m�todo ayuda a concentrar en un solo lugar todas las
	 *            condiciones que podemos aplicar desde el objeto cursoCriteria
	 */
	private void establecerCondiciones(Criteria criteria,
			CursoCriteria cursoCriteria) {
		if (cursoCriteria.getFechaInicio() != null
				&& cursoCriteria.getFechaFin() != null) {
			criteria.add(Restrictions.between("fechaInicio", cursoCriteria
					.getFechaInicio(), cursoCriteria.getFechaFin()));
		}
		if (cursoCriteria.getInstructores() != null
				&& cursoCriteria.getInstructores().size() != 0) {
			criteria.add(Restrictions.in("instructor", cursoCriteria
					.getInstructores()));
		}
		if (cursoCriteria.getPuertos() != null
				&& cursoCriteria.getPuertos().size() != 0) {
			criteria.add(Restrictions.in("puerto", cursoCriteria.getPuertos()));
		}
		if (cursoCriteria.getTiposCursos() != null
				&& cursoCriteria.getTiposCursos().size() != 0) {
			criteria.add(Restrictions.in("tipoCurso", cursoCriteria
					.getTiposCursos()));
		}
	}

}
