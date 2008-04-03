package edu.ienpop.dao;

import java.util.List;

import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;

/**
 * @author ubuntu
 *
 */
public interface CursoDao {
	/**
	 * @param cursoCriteria
	 * @return java.util.List
	 */
	List getCursosPorCriteria(CursoCriteria cursoCriteria);
	/**
	 * @param cursoCriteria
	 * @return java.util.List
	 */
	List getCursoXCertificarPorCriteria(CursoCriteria cursoCriteria);
	/**
	 * @param idCurso
	 * @return String
	 */
	String getTipoCursoByIdCurso(String idCurso);
	
	/**
	 * @param token
	 * @return {@link Curso}
	 */
	Curso getCursoByIdLlaveCertificada(long id);
}
