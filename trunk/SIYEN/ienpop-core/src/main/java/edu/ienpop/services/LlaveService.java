package edu.ienpop.services;

import edu.ienpop.model.LlaveCertificacion;

public interface LlaveService {
	String generateLlaveXCurso(long idCursoXCertificar) throws BusinessException;
	LlaveCertificacion isValidaLlave(String llave, long idCursoXCertificar) throws BusinessException;
	LlaveCertificacion getLlavebyIdCurso(long IdCursoXCertificar) throws BusinessException;
	LlaveCertificacion getLlavebyToken(String token) throws BusinessException;
}
