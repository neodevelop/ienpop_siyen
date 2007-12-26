package edu.ienpop.services;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.ienpop.model.AlumnoXCertificar;
import edu.ienpop.model.CursoXCertificar;

public interface CursoXCertificarService {
	Serializable createNuevoCurso(CursoXCertificar cursoXCertificar) throws BusinessException;
	void addAlumnoACursoXCertificar(long idCursoXCertificar,AlumnoXCertificar alumnoXCertificar) throws BusinessException;
	void removeAlumnoACursoXCertificar(long idCursoXCertificar,AlumnoXCertificar alumnoXCertificar) throws BusinessException;
	void addAlumnosACursoXCertificar(long idCursoXCertificar,Set alumnosXCertificar) throws BusinessException;
	void changeAlumnoACursoXCertificar(AlumnoXCertificar alumnoXCertificar) throws BusinessException;
	Set getAlumnosDeCursoXCertificar(Long idCursoXCertificar) throws BusinessException;
	List getCursosXCertificarSinLlave(String[] idUsuario,String[] idPuerto)  throws BusinessException;
	Map getMyMap() throws BusinessException;
}
