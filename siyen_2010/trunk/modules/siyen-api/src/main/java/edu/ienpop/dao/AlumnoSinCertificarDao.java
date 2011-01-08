package edu.ienpop.dao;

import java.util.List;

import edu.ienpop.model.AlumnoSinCertificar;

public interface AlumnoSinCertificarDao extends
		PersistenceGenericDao<AlumnoSinCertificar, Long> {
	/**
	 * @param idCurso
	 * @return List<CursoSinCertificar> Este metodo busca con un curso y sus
	 *         respectivos alumnos...
	 */
	List<AlumnoSinCertificar> obtenerAlumnosSinCertificarPorIdCurso(Long idCurso);
}
