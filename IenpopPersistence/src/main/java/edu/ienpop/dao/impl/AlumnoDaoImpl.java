package edu.ienpop.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.AlumnoDao;
import edu.ienpop.model.Alumno;
import edu.ienpop.model.AlumnoCriteria;
import edu.ienpop.model.AlumnoXCertificar;

public class AlumnoDaoImpl extends HibernateTemplate implements AlumnoDao {

	public List getAlumnosPorCriteria(AlumnoCriteria alumnoCriteria) {
		Criteria criteria = getSession().createCriteria(Alumno.class);
		if(alumnoCriteria.getId()!=null)
				criteria.add(Restrictions.eq("id", alumnoCriteria.getId()));
		if(alumnoCriteria.getNumeroControl()!=null)
			criteria.add(Restrictions.like("numeroControl", "%"+alumnoCriteria.getNumeroControl()+"%"));
		if(alumnoCriteria.getNombreCompleto()!=null)
			criteria.add(Restrictions.like("nombreCompleto", "%"+alumnoCriteria.getNombreCompleto()+"%"));
		if(alumnoCriteria.getIdCurso()!=0)
			criteria.add(Restrictions.eq("idCurso", alumnoCriteria.getIdCurso()));
		if(alumnoCriteria.getIdStatusAlumno()!=0)
			criteria.add(Restrictions.eq("idStatusAlumno", alumnoCriteria.getIdStatusAlumno()));
		if(alumnoCriteria.getFechaDesde()!=null && alumnoCriteria.getFechaHasta()!=null)
			criteria.add(Restrictions.between("fechaHoraRegistro", alumnoCriteria.getFechaDesde(),alumnoCriteria.getFechaHasta()));
		return criteria.list();
	}

	public List getAlumnosXCertificarPorCriteria(AlumnoCriteria alumnoCriteria) {
		Criteria criteria = getSession().createCriteria(AlumnoXCertificar.class);
		if(alumnoCriteria.getId()!=null)
				criteria.add(Restrictions.eq("id", alumnoCriteria.getId()));
		if(alumnoCriteria.getNombreCompleto()!=null)
			criteria.add(Restrictions.like("nombreCompleto", "%"+alumnoCriteria.getNombreCompleto()+"%"));
		if(alumnoCriteria.getIdCurso()!=0)
			criteria.add(Restrictions.eq("idCursoXCertificar", alumnoCriteria.getIdCurso()));
		if(alumnoCriteria.getIdStatusAlumno()!=0)
			criteria.add(Restrictions.eq("idStatusAlumno", alumnoCriteria.getIdStatusAlumno()));
		if(alumnoCriteria.getFechaDesde()!=null && alumnoCriteria.getFechaHasta()!=null)
			criteria.add(Restrictions.between("fechaHoraRegistro", alumnoCriteria.getFechaDesde(),alumnoCriteria.getFechaHasta()));
		return criteria.list();
	}

}
