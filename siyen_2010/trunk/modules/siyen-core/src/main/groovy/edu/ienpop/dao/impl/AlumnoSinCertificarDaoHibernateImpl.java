package edu.ienpop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import edu.ienpop.dao.AlumnoSinCertificarDao;
import edu.ienpop.model.AlumnoSinCertificar;

/**
 * @author neodevelop
 * 
 */
public class AlumnoSinCertificarDaoHibernateImpl extends
		PersistenceGenericDaoHibernateImpl<AlumnoSinCertificar, Long> implements
		AlumnoSinCertificarDao {

	public AlumnoSinCertificarDaoHibernateImpl(
			HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}

	/**
	 * @param idCurso
	 * @return List<CursoSinCertificar> Este metodo busca con un curso y sus
	 *         respectivos alumnos...
	 */
	@SuppressWarnings("unchecked")
	public List<AlumnoSinCertificar> obtenerAlumnosSinCertificarPorIdCurso(Long idCurso){
		String queryString = "from AlumnoSinCertificar alumnoSinCertificar where alumnoSinCertificar.cursoSinCertificar.idCurso = :idCurso";
		Query query = getSession().createQuery(queryString);
		query.setLong("idCurso", idCurso);
		return (List<AlumnoSinCertificar>)query.list();
	}
}
