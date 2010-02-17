package edu.ienpop.services;

import edu.ienpop.model.LlaveCertificacion;

public interface LlaveService {
	String generateLlaveXCurso(long idCursoXCertificar);
	LlaveCertificacion isValidaLlave(String llave, long idCursoXCertificar);
	LlaveCertificacion getLlavebyIdCurso(long IdCursoXCertificar);
	LlaveCertificacion getLlavebyToken(String token);
}
