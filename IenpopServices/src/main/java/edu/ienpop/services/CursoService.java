package edu.ienpop.services;

import java.util.Date;
import java.util.List;

import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
@SuppressWarnings("unchecked")
public interface CursoService {
	Curso generateCertificadosXCurso(long idCurso) throws BusinessException;
	Curso generateCertificadosXCursoRecuperado(long idCurso) throws BusinessException;
	List getCursosXStatus(CursoCriteria cursoCriteria) throws BusinessException;
	List getOficio(Date fechaInicio,Date fechaFin, String idPuerto) throws BusinessException;
	List getInformePeriodico(Date desde, Date hasta) throws BusinessException;
	List getInformeXTipoLibreta(int mes, int anio, String libreta, String idPuerto) throws BusinessException;
	long addCursoCertificado(long idCursoXCertificar, String llave) throws BusinessException;
	long updateCursoCertificado(long idCursoXCertificar, String llave) throws BusinessException;
	String getIdTipoCursoById(String idCurso) throws BusinessException;
	Curso getCursoByTokenCertificado(String token) throws BusinessException;
	Integer getCountCursosByCriteria(CursoCriteria cursoCriteria) throws BusinessException;
	Curso getCursoById(Long id) throws BusinessException;
	void recoveryCursoCertificado(Curso cursoModificar, List<String> alumnos) throws BusinessException;
}
