package edu.ienpop.dao;

import java.util.List;

import edu.ienpop.model.LlaveCertificacion;

public interface LlaveCertificacionDao extends PersistenceGenericDao<LlaveCertificacion, Long> {
	LlaveCertificacion obtenerLlaveConCodigo(String codigo);
	List<LlaveCertificacion> obtenerLlavesConCursosSinCertificar();
	LlaveCertificacion obtenerLlaveDeCursoCertificado(long idCursoCertificado);
}
