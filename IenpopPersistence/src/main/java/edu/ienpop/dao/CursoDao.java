package edu.ienpop.dao;

import java.util.List;

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
	public List getCursosPorCriteria(CursoCriteria cursoCriteria);
	/**
	 * @param cursoCriteria
	 * @return java.util.List
	 */
	public List getCursoXCertificarPorCriteria(CursoCriteria cursoCriteria);
}
