package edu.ienpop.dao;

import java.util.List;

import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoSinCertificar;

public interface CursoSinCertificarDao extends
		PersistenceGenericDao<CursoSinCertificar, Long> {
	List<CursoSinCertificar> obtenerCursosSinCertificarConRelaciones(CursoCriteria cursoCriteria);
	CursoSinCertificar obtenerCursoSinCertificarConRelaciones(long idCursoSinCertificar);
	int obtenerContadorDeCursosSinCertificar(CursoCriteria cursoCriteria);
}
