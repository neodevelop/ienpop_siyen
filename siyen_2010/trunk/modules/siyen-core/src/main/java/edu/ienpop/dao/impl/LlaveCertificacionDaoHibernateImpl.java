package edu.ienpop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.LlaveCertificacionDao;
import edu.ienpop.model.LlaveCertificacion;

/**
 * @author neodevelop
 *
 */
public class LlaveCertificacionDaoHibernateImpl extends
		PersistenceGenericDaoHibernateImpl<LlaveCertificacion, Long> implements
		LlaveCertificacionDao {

	public LlaveCertificacionDaoHibernateImpl(
			HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

	public LlaveCertificacion obtenerLlaveConCodigo(String codigo) {
		String sql = "from LlaveCertificacion lc where lc.llave = :codigo ";
		Query query = getSession().createQuery(sql);
		query.setString("codigo", codigo);
		return (LlaveCertificacion)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LlaveCertificacion> obtenerLlavesConCursosSinCertificar() {
		String sql = "from LlaveCertificacion lc join fetch lc.cursoSinCertificar join fetch lc.cursoSinCertificar.puerto join fetch lc.cursoSinCertificar.tipoCurso join fetch lc.cursoSinCertificar.instructor  ";
		Query query = getSession().createQuery(sql);
		return query.list();
	}

}
