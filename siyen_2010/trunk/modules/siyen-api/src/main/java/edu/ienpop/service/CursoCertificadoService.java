package edu.ienpop.service;

import edu.ienpop.model.CursoCertificado;


public interface CursoCertificadoService {
	void creaCursoCertificado(Long idCursoSinCertificar);
	CursoCertificado certificarCurso(Long idCursoCertificado);
	CursoCertificado obtenerCursoCertificadoConAlumnos(Long idCurso);
	
}
