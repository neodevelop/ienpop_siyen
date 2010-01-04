package edu.ienpop.dao.impl

import org.hibernate.Query
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.orm.hibernate3.HibernateTemplate
import org.springframework.orm.hibernate3.support.HibernateDaoSupport
import org.springframework.stereotype.Repository

import edu.ienpop.dao.LlaveDao

@Repository("llaveDao")
class LlaveDaoImpl extends HibernateDaoSupport implements LlaveDao {

	@Autowired
	LlaveDaoImpl(HibernateTemplate hibernateTemplate) {
		super.setHibernateTemplate(hibernateTemplate)
	}
	
	def getLlaveByLlave(String llave) {
		String sql = "from edu.ienpop.model.LlaveCertificacion where llave=:llave"
		Query query = getSession().createQuery(sql)
		query.setString("llave", llave)
		return query.uniqueResult()
	}

	def getLlaveByIdCurso(long idCursoXCertificar) {
		String sql = "from edu.ienpop.model.LlaveCertificacion where idCursoXCertificar=:idCursoXCertificar"
		Query query = getSession().createQuery(sql)
		query.setLong("idCursoXCertificar", idCursoXCertificar)
		return query.uniqueResult()
	}

}
