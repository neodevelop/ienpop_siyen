package edu.ienpop.dao.impl

import java.util.List

import javax.jms.Session;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.hibernate.Criteria
import org.hibernate.Query
import org.hibernate.criterion.Order
import org.hibernate.criterion.Projections
import org.hibernate.criterion.Restrictions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.orm.hibernate3.HibernateTemplate
import org.springframework.orm.hibernate3.support.HibernateDaoSupport
import org.springframework.stereotype.Repository

import edu.ienpop.dao.CursoDao
import edu.ienpop.model.Curso
import edu.ienpop.model.CursoCriteria
import edu.ienpop.model.CursoXCertificar

@Repository("cursoDao")
class CursoDaoImpl extends HibernateDaoSupport implements CursoDao{
	
	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	CursoDaoImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate)
	}
	
	@SuppressWarnings("unchecked")
	List getCursoXCertificarPorCriteria(CursoCriteria cursoCriteria) {
		def criteria = getSession().createCriteria(CursoXCertificar.class)
		if (cursoCriteria.id)
			criteria.add(Restrictions.eq("id", cursoCriteria.id))
		if (cursoCriteria.getIdPuerto())
			criteria.add(Restrictions.in("idPuerto", cursoCriteria.idPuerto))
		if (cursoCriteria.idTipoCurso)
			criteria.add(Restrictions.in("idTipoCurso", cursoCriteria.idTipoCurso))
		if (cursoCriteria.getIdUsuario())
			criteria.add(Restrictions.in("idUsuario", cursoCriteria.idUsuario))
		if (cursoCriteria.idStatusCurso)
			criteria.add(Restrictions.eq("idStatusCurso", cursoCriteria.idStatusCurso))
		if (cursoCriteria.fechaDesde && cursoCriteria.fechaHasta)
			criteria.add(Restrictions.between("fechaInicio", cursoCriteria.fechaDesde, cursoCriteria.fechaHasta))
		if (cursoCriteria.paginado) {
			criteria.firstResult = cursoCriteria.firstResult
			criteria.maxResults = CursoCriteria.MAX_RESULTS
		}
		criteria.addOrder(Order.asc("id"))
		criteria.list()
	}

	@SuppressWarnings("unchecked")
	List getCursosPorCriteria(CursoCriteria cursoCriteria) {
		if(log.isDebugEnabled()){
			log.debug(ToStringBuilder.reflectionToString(cursoCriteria));
		}
		def criteria = getSession().createCriteria(Curso.class)
		if (cursoCriteria.id)
			criteria.add(Restrictions.eq("id", cursoCriteria.id))
		if (cursoCriteria.idPuerto)
			criteria.add(Restrictions.in("idPuerto", cursoCriteria.idPuerto))
		if (cursoCriteria.idTipoCurso)
			criteria.createCriteria("tipoCurso").add(Restrictions.in("idTipoCurso", cursoCriteria.idTipoCurso))
		if (cursoCriteria.idUsuario)
			criteria.add(Restrictions.in("idUsuario", cursoCriteria.idUsuario))
		if (cursoCriteria.idStatusCurso)
			criteria.add(Restrictions.eq("idStatusCurso", cursoCriteria.idStatusCurso))
		if (cursoCriteria.idLlave)
			criteria.add(Restrictions.eq("idLlave", cursoCriteria.idLlave))
		if (cursoCriteria.fechaDesde && cursoCriteria.fechaHasta)
			criteria.add(Restrictions.between("fechaInicio", cursoCriteria.fechaDesde, cursoCriteria.fechaHasta))
		if (cursoCriteria.paginado) {
			criteria.firstResult = cursoCriteria.firstResult
			criteria.maxResults = CursoCriteria.MAX_RESULTS
		}
		criteria.addOrder(Order.asc("id"))
		criteria.list()
	}

	String getTipoCursoByIdCurso(String idCurso) {
		def sql = "select t.idTipoCurso from Curso c left join c.tipoCurso t  where idCurso=:idCurso"
		def query = getSession().createQuery(sql)
		query.setString("idCurso", idCurso)
		(String) query.uniqueResult()
	}

	Curso getCursoByIdLlaveCertificada(long id) {
		def sql = "from Curso c where c.idLlave=:id"
		def query = getSession().createQuery(sql)
		query.setLong("id", id)
		(Curso) query.uniqueResult()
	}

	Integer getCountCursosPorCriteria(CursoCriteria cursoCriteria) {
		if(log.isDebugEnabled()){
			log.debug(ToStringBuilder.reflectionToString(cursoCriteria));
		}
		def criteria = getSession().createCriteria(Curso.class)
		if (cursoCriteria.id)
			criteria.add(Restrictions.eq("id", cursoCriteria.id))
		if (cursoCriteria.getIdPuerto())
			criteria.add(Restrictions.in("idPuerto", cursoCriteria.idPuerto))
		if (cursoCriteria.idTipoCurso)
			criteria.add(Restrictions.in("idTipoCurso", cursoCriteria.idTipoCurso))
		if (cursoCriteria.getIdUsuario())
			criteria.add(Restrictions.in("idUsuario", cursoCriteria.idUsuario))
		if (cursoCriteria.idStatusCurso)
			criteria.add(Restrictions.eq("idStatusCurso", cursoCriteria.idStatusCurso))
		if (cursoCriteria.fechaDesde && cursoCriteria.fechaHasta)
			criteria.add(Restrictions.between("fechaInicio", cursoCriteria.fechaDesde, cursoCriteria.fechaHasta))
		criteria.projection = Projections.rowCount()
		(Integer)criteria.uniqueResult()
	}

}
