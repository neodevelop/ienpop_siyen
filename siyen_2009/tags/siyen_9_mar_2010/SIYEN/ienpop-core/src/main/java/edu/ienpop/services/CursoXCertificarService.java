package edu.ienpop.services;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import edu.ienpop.model.AlumnoXCertificar;
import edu.ienpop.model.CursoXCertificar;

@SuppressWarnings("unchecked")
public interface CursoXCertificarService {
	Serializable createNuevoCurso(CursoXCertificar cursoXCertificar);
	void addAlumnoACursoXCertificar(long idCursoXCertificar,AlumnoXCertificar alumnoXCertificar);
	void removeAlumnoACursoXCertificar(long idCursoXCertificar,AlumnoXCertificar alumnoXCertificar);
	void addAlumnosACursoXCertificar(long idCursoXCertificar,Set alumnosXCertificar);
	void changeAlumnoACursoXCertificar(AlumnoXCertificar alumnoXCertificar);
	Set getAlumnosDeCursoXCertificar(Long idCursoXCertificar);
	List getCursosXCertificarSinLlave(String[] idUsuario,String[] idPuerto);
	List getCursosXCertificarConLlave(String[] idUsuario,String[] idPuerto);
	List getCursosXCertificarReimpresion(String[] idUsuario,String[] idPuerto);
}
