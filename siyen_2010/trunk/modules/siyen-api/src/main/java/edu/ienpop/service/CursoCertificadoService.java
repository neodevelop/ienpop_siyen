package edu.ienpop.service;

import java.util.List;

import edu.ienpop.model.CursoCertificado;
import edu.ienpop.model.CursoCriteria;

public interface CursoCertificadoService {
	/**
	 * @param idCursoSinCertificar
	 * @return idCursoCertificado
	 * 
	 *         Este metodo recibe el idCursoSinCertificar, lo consulta y genera
	 *         un cursoCertificado, regresa el id para su posterior consulta
	 */
	long certificarCurso(Long idCursoSinCertificar);

	/**
	 * @param idCursoCertificado
	 * @return CursoCertificado
	 * 
	 *         Este método cambia el status del cursoCertificado para indicar
	 *         que ya se imprimió y cambia los status de los alumnos de dicho
	 *         curso
	 */
	CursoCertificado imprimirConstanciasCurso(Long idCursoCertificado);

	/**
	 * @param idCurso
	 * @return CursoCerticado y List<AlumnoCertificado>
	 * 
	 *         Este es un metodo de consulta unicamente
	 */
	CursoCertificado obtenerCursoCertificadoConAlumnos(Long idCurso);

	/**
	 * @param cursoCriteria
	 * @return List<CursoCertificado>
	 * 
	 *         Este método ayudará a ver los cursos que ya están certificados,
	 *         para conssultarlos o modificarlos...
	 */
	List<CursoCertificado> obtenerCursosCertificados(CursoCriteria cursoCriteria);
}
