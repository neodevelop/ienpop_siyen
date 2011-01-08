package edu.ienpop.dao;

import java.util.List;

import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoSinCertificar;

public interface CursoSinCertificarDao extends
		PersistenceGenericDao<CursoSinCertificar, Long> {
	public List<CursoSinCertificar> obtenerCursosSinCertificarConRelaciones(CursoCriteria cursoCriteria,int offset,int maxSize);
	public CursoSinCertificar obtenerCursoSinCertificarConRelaciones(long idCursoSinCertificar);
	public int obtenerContadorDeCursosSinCertificar(CursoCriteria cursoCriteria);
}
