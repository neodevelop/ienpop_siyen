package edu.ienpop.dao;

import edu.ienpop.model.CursoSinCertificar;

public interface CursoSinCertificarDao extends
		PersistenceGenericDao<CursoSinCertificar, Long> {
	/**
	 * @param idCurso
	 * @return List<CursoSinCertificar> Este metodo busca con un curso y sus
	 *         respectivos alumnos...
	 */
	CursoSinCertificar obtenerAlumnosSinCertificarPorIdCurso(Long idCurso);
}
