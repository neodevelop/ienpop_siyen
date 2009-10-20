package edu.ienpop.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import edu.ienpop.dao.AlumnoDao;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.model.AlumnoXCertificar;

@Repository("alumnoDao")
public class AlumnoDaoImpl extends HibernateDaoSupport implements AlumnoDao {

	@Autowired
	public AlumnoDaoImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate);
	}
	
	@SuppressWarnings("unchecked")
	public List getAlumnosPorCriteria(AlumnoCriteria alumnoCriteria) {
		Criteria criteria = getSession().createCriteria(Alumno.class);
		if(alumnoCriteria.getId()!=null && alumnoCriteria.getId()!=0)
				criteria.add(Restrictions.eq("id", alumnoCriteria.getId()));
		if(alumnoCriteria.getNumeroControl()!=null && alumnoCriteria.getNumeroControl().length()!=0)
			criteria.add(Restrictions.like("numeroControl", "%"+alumnoCriteria.getNumeroControl()+"%"));
		if(alumnoCriteria.getNombreCompleto()!=null && alumnoCriteria.getNombreCompleto().length()!=0)
			criteria.add(Restrictions.like("nombreCompleto", "%"+alumnoCriteria.getNombreCompleto()+"%"));
		if(alumnoCriteria.getIdCurso()!=0 && alumnoCriteria.getIdCurso()!=0)
			criteria.add(Restrictions.eq("idCurso", alumnoCriteria.getIdCurso()));
		if(alumnoCriteria.getIdStatusAlumno()!=0 && alumnoCriteria.getIdStatusAlumno()!=0)
			criteria.add(Restrictions.eq("idStatusAlumno", alumnoCriteria.getIdStatusAlumno()));
		if((alumnoCriteria.getFechaDesde()!=null && alumnoCriteria.getFechaHasta()!=null))
			criteria.add(Restrictions.between("fechaHoraRegistro", alumnoCriteria.getFechaDesde(),alumnoCriteria.getFechaHasta()));
		
		criteria.setFirstResult(alumnoCriteria.getFirstResult());
		criteria.setMaxResults(AlumnoCriteria.MAX_RESULTS);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List getAlumnosXCertificarPorCriteria(AlumnoCriteria alumnoCriteria) {
		Criteria criteria = getSession().createCriteria(AlumnoXCertificar.class);
		if(alumnoCriteria.getId()!=null && alumnoCriteria.getId()!=0)
				criteria.add(Restrictions.eq("id", alumnoCriteria.getId()));
		if(alumnoCriteria.getNombreCompleto()!=null && alumnoCriteria.getNombreCompleto().length()!=0)
			criteria.add(Restrictions.like("nombreCompleto", "%"+alumnoCriteria.getNombreCompleto()+"%"));
		if(alumnoCriteria.getIdCurso()!=0)
			criteria.add(Restrictions.eq("idCursoXCertificar", alumnoCriteria.getIdCurso()));
		if(alumnoCriteria.getIdStatusAlumno()!=0)
			criteria.add(Restrictions.eq("idStatusAlumno", alumnoCriteria.getIdStatusAlumno()));
		if(alumnoCriteria.getFechaDesde()!=null && alumnoCriteria.getFechaHasta()!=null)
			criteria.add(Restrictions.between("fechaHoraRegistro", alumnoCriteria.getFechaDesde(),alumnoCriteria.getFechaHasta()));
		
		criteria.setFirstResult(0);
		criteria.setMaxResults(10);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

	public int getCountAlumnosPorCriteria(AlumnoCriteria alumnoCriteria) {
		Criteria criteria = getSession().createCriteria(Alumno.class);
		if(alumnoCriteria.getId()!=null && alumnoCriteria.getId()!=0)
				criteria.add(Restrictions.eq("id", alumnoCriteria.getId()));
		if(alumnoCriteria.getNumeroControl()!=null && alumnoCriteria.getNumeroControl().length()!=0)
			criteria.add(Restrictions.like("numeroControl", "%"+alumnoCriteria.getNumeroControl()+"%"));
		if(alumnoCriteria.getNombreCompleto()!=null && alumnoCriteria.getNombreCompleto().length()!=0)
			criteria.add(Restrictions.like("nombreCompleto", "%"+alumnoCriteria.getNombreCompleto()+"%"));
		if(alumnoCriteria.getIdCurso()!=0 && alumnoCriteria.getIdCurso()!=0)
			criteria.add(Restrictions.eq("idCurso", alumnoCriteria.getIdCurso()));
		if(alumnoCriteria.getIdStatusAlumno()!=0 && alumnoCriteria.getIdStatusAlumno()!=0)
			criteria.add(Restrictions.eq("idStatusAlumno", alumnoCriteria.getIdStatusAlumno()));
		if((alumnoCriteria.getFechaDesde()!=null && alumnoCriteria.getFechaHasta()!=null))
			criteria.add(Restrictions.between("fechaHoraRegistro", alumnoCriteria.getFechaDesde(),alumnoCriteria.getFechaHasta()));
		criteria.setProjection(Projections.rowCount());
		//criteria.list();
		return (Integer)criteria.uniqueResult();
	}

}
