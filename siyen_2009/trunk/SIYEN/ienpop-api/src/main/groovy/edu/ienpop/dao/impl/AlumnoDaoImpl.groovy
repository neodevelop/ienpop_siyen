package edu.ienpop.dao.impl

import java.util.List

import org.hibernate.Criteria
import org.hibernate.criterion.Order
import org.hibernate.criterion.Projections
import org.hibernate.criterion.Restrictions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.orm.hibernate3.HibernateTemplate
import org.springframework.orm.hibernate3.support.HibernateDaoSupport
import org.springframework.stereotype.Repository

import edu.ienpop.dao.AlumnoDao
import edu.ienpop.model.Alumno
import edu.ienpop.model.AlumnoCriteria
import edu.ienpop.model.AlumnoXCertificar

@Repository("alumnoDao")
class AlumnoDaoImpl extends HibernateDaoSupport implements AlumnoDao {

	@Autowired
	AlumnoDaoImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate)
	}
	
	@SuppressWarnings("unchecked")
	List getAlumnosPorCriteria(AlumnoCriteria alumnoCriteria) {
		def criteria = getSession().createCriteria(Alumno.class)
		if(alumnoCriteria.id)
			criteria.add(Restrictions.eq("id", alumnoCriteria.id))
		if(alumnoCriteria.numeroControl && alumnoCriteria.numeroControl.length())
			criteria.add(Restrictions.like("numeroControl", "%"+alumnoCriteria.numeroControl+"%"))
		if(alumnoCriteria.nombreCompleto && alumnoCriteria.nombreCompleto.length())
			criteria.add(Restrictions.like("nombreCompleto", "%"+alumnoCriteria.nombreCompleto+"%"))
		if(alumnoCriteria.idCurso)
			criteria.add(Restrictions.eq("idCurso", alumnoCriteria.idCurso))
		if(alumnoCriteria.idStatusAlumno)
			criteria.add(Restrictions.eq("idStatusAlumno", alumnoCriteria.idStatusAlumno))
		if((alumnoCriteria.fechaDesde && alumnoCriteria.fechaHasta))
			criteria.add(Restrictions.between("fechaHoraRegistro", alumnoCriteria.fechaDesde,alumnoCriteria.fechaHasta))
		
		criteria.firstResult = alumnoCriteria.firstResult
		criteria.maxResults = AlumnoCriteria.MAX_RESULTS
		criteria.addOrder(Order.asc("id"))
		criteria.list()
	}

	@SuppressWarnings("unchecked")
	List getAlumnosXCertificarPorCriteria(AlumnoCriteria alumnoCriteria) {
		def criteria = getSession().createCriteria(AlumnoXCertificar.class)
		if(alumnoCriteria.id)
				criteria.add(Restrictions.eq("id", alumnoCriteria.id))
		if(alumnoCriteria.nombreCompleto)
			criteria.add(Restrictions.like("nombreCompleto", "%"+alumnoCriteria.nombreCompleto+"%"))
		if(alumnoCriteria.idCurso)
			criteria.add(Restrictions.eq("idCursoXCertificar", alumnoCriteria.idCurso))
		if(alumnoCriteria.idStatusAlumno)
			criteria.add(Restrictions.eq("idStatusAlumno", alumnoCriteria.idStatusAlumno))
		if(alumnoCriteria.fechaDesde && alumnoCriteria.fechaHasta)
			criteria.add(Restrictions.between("fechaHoraRegistro", alumnoCriteria.fechaDesde,alumnoCriteria.fechaHasta))
		
		criteria.firstResult = 0
		criteria.maxResults = 10
		criteria.addOrder(Order.asc("id"))
		criteria.list()
	}

	Integer getCountAlumnosPorCriteria(AlumnoCriteria alumnoCriteria) {
		def criteria = getSession().createCriteria(Alumno.class)
		if(alumnoCriteria.id)
			criteria.add(Restrictions.eq("id", alumnoCriteria.id))
		if(alumnoCriteria.numeroControl && alumnoCriteria.numeroControl.length())
			criteria.add(Restrictions.like("numeroControl", "%"+alumnoCriteria.numeroControl+"%"))
		if(alumnoCriteria.nombreCompleto && alumnoCriteria.nombreCompleto.length())
			criteria.add(Restrictions.like("nombreCompleto", "%"+alumnoCriteria.nombreCompleto+"%"))
		if(alumnoCriteria.idCurso)
			criteria.add(Restrictions.eq("idCurso", alumnoCriteria.idCurso))
		if(alumnoCriteria.idStatusAlumno)
			criteria.add(Restrictions.eq("idStatusAlumno", alumnoCriteria.idStatusAlumno))
		if((alumnoCriteria.fechaDesde && alumnoCriteria.fechaHasta))
			criteria.add(Restrictions.between("fechaHoraRegistro", alumnoCriteria.fechaDesde,alumnoCriteria.fechaHasta))
		criteria.setProjection(Projections.rowCount())
		//criteria.list()
		criteria.uniqueResult() as Integer
	}

}
