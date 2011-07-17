package edu.ienpop.dao;

import java.util.List;

import edu.ienpop.model.CursoCertificado;
import edu.ienpop.model.CursoCriteria;

public interface CursoCertificadoDao extends
		PersistenceGenericDao<CursoCertificado, Long> {

	/**
	 * @param idCursoCertificado
	 * @return Un curso certificado con sus relaciones en una sola consulta
	 *         basado solo en el id del curso
	 */
	CursoCertificado obtenerCursoCertificadoConAlumnos(long idCursoCertificado);

	/**
	 * @param curso
	 * @return Una lista de cursos certificados basados en un objeto de criterio
	 */
	List<CursoCertificado> obtenerCursosCertificadosPorCriteria(
			CursoCriteria curso);
}
