package edu.ienpop.service;

import edu.ienpop.model.LlaveCertificacion;

public interface LlaveCertificacionService {
	/**
	 * @param llave
	 * @return LlaveCertificacion
	 * 
	 *         Valida si una llave existe, es valida y no ha sido usada
	 */
	LlaveCertificacion esLlaveValida(String codigo);

	/**
	 * @param llaveCertificacion
	 *            Cambia el estado de la llave para saber que se ha usado
	 */
	void cambiarEstadoDeLaLlave(LlaveCertificacion llaveCertificacion);

	/**
	 * @param idCurso
	 *            Este metodo crea la llave de Certificacion para un curso
	 *            especifico...
	 * 
	 */
	void crearLlaveParaCertificacion(Long idCursoSinCertificar);
}
