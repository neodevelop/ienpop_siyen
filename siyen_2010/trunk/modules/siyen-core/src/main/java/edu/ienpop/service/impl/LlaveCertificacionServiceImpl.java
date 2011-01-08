package edu.ienpop.service.impl;

import java.util.Calendar;

import org.apache.log4j.Logger;

import edu.ienpop.dao.CursoSinCertificarDao;
import edu.ienpop.dao.LlaveCertificacionDao;
import edu.ienpop.model.CursoSinCertificar;
import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.service.LlaveCertificacionService;

public class LlaveCertificacionServiceImpl implements LlaveCertificacionService {

	static Logger log = Logger.getLogger(LlaveCertificacionServiceImpl.class);

	private LlaveCertificacionDao llaveCertificacionDao;
	private CursoSinCertificarDao cursoSinCertificarDao;

	public LlaveCertificacionServiceImpl(
			LlaveCertificacionDao llaveCertificacionDao,
			CursoSinCertificarDao cursoSinCertificarDao) {
		this.llaveCertificacionDao = llaveCertificacionDao;
		this.cursoSinCertificarDao = cursoSinCertificarDao;
	}

	public void cambiarEstadoDeLaLlave(LlaveCertificacion llaveCertificacion) {
		llaveCertificacionDao.update(llaveCertificacion);
	}

	public void crearLlaveParaCertificacion(Long idCursoSinCertificar) {
		// Iniciamos el objeto
		LlaveCertificacion llaveCertificacion = new LlaveCertificacion();
		// Obtenemos el cursoSinCertificar
		CursoSinCertificar cursoSinCertificar = cursoSinCertificarDao
				.read(idCursoSinCertificar);
		//Comenzamos la creaci—n de la llave
		int LONG = 20;
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String llave = "";
		double seed;
		int number;
		for (int i = 0; i < LONG; i++) {
			seed = Math.random() * (CHARACTERS.length() + 1);
			if (log.isDebugEnabled())
				log.debug("Seed = " + seed);
			number = (int) seed;
			if (log.isDebugEnabled())
				log.debug("Number = " + number);
			if (number == CHARACTERS.length())
				llave += CHARACTERS.substring(number);
			else
				llave += CHARACTERS.substring(number, number + 1);
			if (log.isDebugEnabled())
				log.debug("Llave: " + llave);
		}
		// Finalizamos la creaci—n de la llave
		// Establecemos el valor de la llave al objeto
		llaveCertificacion.setLlave(llave);
		// Le asignamos el cursoSinCertificar
		llaveCertificacion.setCursoSinCertificar(cursoSinCertificar);
		// Establecemos la fecha de Generacion de la llavce
		llaveCertificacion.setFechaGeneracion(Calendar.getInstance().getTime());
		// El curso esta listo para certificarse
		cursoSinCertificar.setListoParaCertificar(true);
		// Actualizar el curso
		cursoSinCertificarDao.update(cursoSinCertificar);
		// Crear la llave
		llaveCertificacionDao.create(llaveCertificacion);
		//Actualizar la llave???
	}

	public LlaveCertificacion esLlaveValida(String codigo) {
		// Buscamos la llave
		LlaveCertificacion llaveCertificacion = llaveCertificacionDao.obtenerLlaveConCodigo(codigo);
		// Si no se encontro entonces arrojamos un error
		if(llaveCertificacion==null){
			throw new BusinessException("No existe una llave con ese c—digo...");
		}
		// Encontrada la llave es el valor que regresamos
		return llaveCertificacion;
	}

}
