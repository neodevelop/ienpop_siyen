package edu.ienpop.dao;

import edu.ienpop.model.CursoCertificado;

public interface CursoCertificadoDao extends PersistenceGenericDao<CursoCertificado, Long> {
	CursoCertificado obtenerCursoCertificadoConAlumnos(long idCursoCertificado);
}
