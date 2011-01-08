package edu.ienpop.service.impl;

import java.util.Calendar;
import java.util.List;

import edu.ienpop.dao.CursoSinCertificarDao;
import edu.ienpop.dao.LlaveCertificacionDao;
import edu.ienpop.model.CursoSinCertificar;
import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.model.Usuario;
import edu.ienpop.service.LlaveCertificacionService;

public class LlaveCertificacionServiceImpl implements LlaveCertificacionService {

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
		//Cambiamos el status del curso
		cursoSinCertificar.setListoParaCertificar(true);
		//Comenzamos la creaci—n de la llave
		int LONG = 20;
		String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String llave = "";
		double seed;
		int number;
		for (int i = 0; i < LONG; i++) {
			seed = Math.random() * (CHARACTERS.length() + 1);
			number = (int) seed;
			if (number == CHARACTERS.length())
				llave += CHARACTERS.substring(number);
			else
				llave += CHARACTERS.substring(number, number + 1);
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

	public boolean obtenerValidacionDeCursoConLlave(String codigo,long idCursoSinCertificar){
		// Buscamos la llave y el curso
		LlaveCertificacion llaveCertificacion = llaveCertificacionDao.obtenerLlaveConCodigo(codigo);
		//Corroboramos que esta llave pertenece a este curso
		if(llaveCertificacion.getCursoSinCertificar().getIdCurso() == idCursoSinCertificar)
			return true;
		else
			return false;
	}

	@Override
	public List<LlaveCertificacion> obtenerLlavesConCursosSinCertificarAsociados() {
		return llaveCertificacionDao.obtenerLlavesConCursosSinCertificar();
	}

	@Override
	public List<LlaveCertificacion> obtenerLlavesPorUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
