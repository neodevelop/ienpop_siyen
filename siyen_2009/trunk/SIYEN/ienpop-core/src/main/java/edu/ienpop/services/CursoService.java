package edu.ienpop.services;

import java.util.Date;
import java.util.List;

import edu.ienpop.model.Alumno;
import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
@SuppressWarnings("unchecked")
public interface CursoService {
	Curso generateCertificadosXCurso(long idCurso);
	Curso generateCertificadosXCursoRecuperado(long idCurso);
	List getCursosXStatus(CursoCriteria cursoCriteria);
	List getOficio(Date fechaInicio,Date fechaFin, String idPuerto);
	List getInformePeriodico(Date desde, Date hasta);
	List getInformeXTipoLibreta(int mes, int anio, String libreta, String idPuerto);
	long addCursoCertificado(long idCursoXCertificar, String llave);
	long updateCursoCertificado(long idCursoXCertificar, String llave);
	String getIdTipoCursoById(String idCurso);
	Curso getCursoByTokenCertificado(String token);
	Integer getCountCursosByCriteria(CursoCriteria cursoCriteria);
	Curso getCursoById(Long id);
	void recoveryCursoCertificado(Curso cursoModificar, List<String> alumnos);
	void cambiarAgregarAlumnosACurso(List<Alumno> alumnos,Curso curso);
}
