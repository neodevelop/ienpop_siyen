package edu.ienpop.services.impl;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ienpop.dao.LlaveDao;
import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.LlaveService;
import edu.ienpop.services.PersistenceService;

@Service("llaveService")
public class LlaveServiceDefaultImpl implements LlaveService {

	static Logger log = Logger.getLogger(LlaveServiceDefaultImpl.class);
	@Autowired
	private PersistenceService persistenceService;
	@Autowired
	private LlaveDao llaveDao;

	public String generateLlaveXCurso(long idCursoXCertificar)
			throws BusinessException {
		// TODO Auto-generated method stub
		LlaveCertificacion llaveCertificacion = new LlaveCertificacion();
		CursoXCertificar cursoXCertificar = (CursoXCertificar)persistenceService.findById(CursoXCertificar.class, idCursoXCertificar);
		if(cursoXCertificar.getIdStatusCurso()==2){
			throw new BusinessException("Este curso ya tiene asignada una llave...");
		}
		int LONG = 20;
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
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
		persistenceService.updateEntity(cursoXCertificar);
		persistenceService.createEntity(llaveCertificacion);
		persistenceService.updateEntity(llaveCertificacion);
		return llave;
	}

	public LlaveCertificacion isValidaLlave(String llave, long IdCursoXCertificar) throws BusinessException {
		// TODO Auto-generated method stub
		LlaveCertificacion llaveCertificacion = (LlaveCertificacion)llaveDao.getLlaveByLlave(llave);
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

	public LlaveCertificacion getLlavebyIdCurso(long IdCursoXCertificar) throws BusinessException {
		return (LlaveCertificacion)llaveDao.getLlaveByIdCurso(IdCursoXCertificar);
	}

	public LlaveCertificacion getLlavebyToken(String token) throws BusinessException {
		return (LlaveCertificacion)llaveDao.getLlaveByLlave(token);
	}

}
