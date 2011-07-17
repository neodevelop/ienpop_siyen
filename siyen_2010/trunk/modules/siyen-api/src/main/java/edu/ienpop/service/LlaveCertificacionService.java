package edu.ienpop.service;

import java.util.List;

import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.model.Usuario;

public interface LlaveCertificacionService {
	/**
	 * @param llave
	 * @return LlaveCertificacion
	 * 
	 *         Valida si una llave existe, es valida y no ha sido usada
	 */
	boolean obtenerValidacionDeCursoConLlave(String codigo,long idCursoSinCertificar);

	/**
	 * @param idCurso
	 *            Este metodo crea la llave de Certificacion para un curso
	 *            especifico...
	 * 
	 */
	void crearLlaveParaCertificacion(Long idCursoSinCertificar);

	/**
	 * @param usuario
	 * @return
	 * 
	 *         Este método busca todas las llaves que tiene un usuario basado en
	 *         los instructores y puertos asignados a él
	 */
	List<LlaveCertificacion> obtenerLlavesPorUsuario(Usuario usuario);

	/**
	 * @param usuario
	 * @return
	 * 
	 * 			Este método obtiene todas las llaves con los respectivos cursos sin certificar asociados
	 */
	List<LlaveCertificacion> obtenerLlavesConCursosSinCertificarAsociados();
}
