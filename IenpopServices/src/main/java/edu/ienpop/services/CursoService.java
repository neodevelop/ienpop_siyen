package edu.ienpop.services;

import java.util.Date;
import java.util.List;

import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
@SuppressWarnings("unchecked")
public interface CursoService {
	Curso generateCertificadosXCurso(long idCurso) throws BusinessException;
	List getCursosXStatus(CursoCriteria cursoCriteria) throws BusinessException;
	List getOficio(Date fechaInicio,Date fechaFin, String idPuerto) throws BusinessException;
	List getInformeMensual(int mes, int anio) throws BusinessException;
	List getInformeXTipoLibreta(int mes, int anio, String libreta, String idPuerto) throws BusinessException;
	long addCursoCertificado(long idCursoXCertificar, String llave) throws BusinessException;
}
