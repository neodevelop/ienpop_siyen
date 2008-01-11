package edu.ienpop.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.ienpop.dao.CursoDao;
import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoXCertificar;

public class CursoDaoImpl extends HibernateDaoSupport implements CursoDao {

	public List getCursoXCertificarPorCriteria(CursoCriteria cursoCriteria) {
		Criteria criteria = getSession().createCriteria(CursoXCertificar.class);
		if (cursoCriteria.getId() != null)
			criteria.add(Restrictions.eq("id", cursoCriteria.getId()));
		if (cursoCriteria.getIdPuerto() != null)
			criteria.add(Restrictions.in("idPuerto", cursoCriteria
					.getIdPuerto()));
		if (cursoCriteria.getIdTipoCurso() != null)
			criteria.add(Restrictions.in("idTipoCurso", cursoCriteria
					.getIdTipoCurso()));
		if (cursoCriteria.getIdUsuario() != null)
			criteria.add(Restrictions.in("idUsuario", cursoCriteria
					.getIdUsuario()));
		if (cursoCriteria.getIdStatusCurso() != 0)
			criteria.add(Restrictions.eq("idStatusCurso", cursoCriteria
					.getIdStatusCurso()));
		if (cursoCriteria.getFechaDesde() != null
				&& cursoCriteria.getFechaHasta() != null)
			criteria.add(Restrictions.between("fechaInicio", cursoCriteria
					.getFechaDesde(), cursoCriteria.getFechaHasta()));
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

	public List getCursosPorCriteria(CursoCriteria cursoCriteria) {
		Criteria criteria = getSession().createCriteria(Curso.class);
		if (cursoCriteria.getId() != null)
			criteria.add(Restrictions.eq("id", cursoCriteria.getId()));
		if (cursoCriteria.getIdPuerto() != null)
			criteria.add(Restrictions.in("idPuerto", cursoCriteria
					.getIdPuerto()));
		if (cursoCriteria.getIdTipoCurso() != null)
			criteria.add(Restrictions.in("idTipoCurso", cursoCriteria
					.getIdTipoCurso()));
		if (cursoCriteria.getIdUsuario() != null)
			criteria.add(Restrictions.in("idUsuario", cursoCriteria
					.getIdUsuario()));
		if (cursoCriteria.getIdStatusCurso() != 0)
			criteria.add(Restrictions.eq("idStatusCurso", cursoCriteria
					.getIdStatusCurso()));
		if (cursoCriteria.getIdLlave() != 0)
			criteria
					.add(Restrictions.eq("idLlave", cursoCriteria.getIdLlave()));
		if (cursoCriteria.getFechaDesde() != null
				&& cursoCriteria.getFechaHasta() != null)
			criteria.add(Restrictions.between("fechaInicio", cursoCriteria
					.getFechaDesde(), cursoCriteria.getFechaHasta()));
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

}
