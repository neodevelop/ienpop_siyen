package edu.ienpop.services.impl;

import java.util.Calendar;

import org.apache.log4j.Logger;

import edu.ienpop.dao.LlaveDao;
import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.LlaveService;
import edu.ienpop.services.PersistenceService;

public class LlaveServiceDefaultImpl implements LlaveService {

	static Logger log = Logger.getLogger(LlaveServiceDefaultImpl.class);
	private PersistenceService persistenceService;
	private LlaveDao llaveDao;

	public LlaveDao getLlaveDao() {
		return llaveDao;
	}

	public void setLlaveDao(LlaveDao llaveDao) {
		this.llaveDao = llaveDao;
	}

	public PersistenceService getPersistenceService() {
		return persistenceService;
	}

	public void setPersistenceService(PersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}

	public String generateLlaveXCurso(long idCursoXCertificar)
			throws BusinessException {
		// TODO Auto-generated method stub
		LlaveCertificacion llaveCertificacion = new LlaveCertificacion();
		CursoXCertificar cursoXCertificar = (CursoXCertificar)getPersistenceService().findById(CursoXCertificar.class, idCursoXCertificar);
		if(cursoXCertificar.getIdStatusCurso()==2){
			throw new BusinessException("Este curso ya tiene asignada una llave...");
		}
		int LONG = 20;
		String CHARACTERS = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789+-/*!#$%&¡?¿";
		String llave = "";
		double seed;
		int number;
		for(int i=0;i<LONG;i++){
			seed = Math.random()*(CHARACTERS.length()+1);
			log.debug("Seed = "+seed);
			number = (int)seed;
			log.debug("Number = "+number);
			if(number==CHARACTERS.length())
				llave+=CHARACTERS.substring(number);
			else
				llave+=CHARACTERS.substring(number,number+1);
			log.debug("Llave: "+llave);
		}
		llaveCertificacion.setLlave(llave);
		llaveCertificacion.setIdCursoXCertificar(idCursoXCertificar);
		llaveCertificacion.setFechaGeneracion(Calendar.getInstance().getTime());
		cursoXCertificar.setIdStatusCurso(2);
		getPersistenceService().updateEntity(cursoXCertificar);
		getPersistenceService().createEntity(llaveCertificacion);
		getPersistenceService().updateEntity(llaveCertificacion);
		return llave;
	}

	public LlaveCertificacion isValidaLlave(String llave, long IdCursoXCertificar) throws BusinessException {
		// TODO Auto-generated method stub
		LlaveCertificacion llaveCertificacion = (LlaveCertificacion)getLlaveDao().getLlaveByLlave(llave);
		if(llaveCertificacion==null){
			throw new BusinessException("La llave no existe o es invalida!!!");
		}else{
			if(llaveCertificacion.getIdStatusLlave()!=0){
				throw new BusinessException("La llave ya fue usada, no se puede utilizar esta llave...");
			}else{
				if(IdCursoXCertificar!=llaveCertificacion.getIdCursoXCertificar()){
					throw new BusinessException("Esta llave no corresponde a este curso...");
				}else{
					return llaveCertificacion;
				}
			}
		}
	}

}
