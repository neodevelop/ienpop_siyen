package edu.ienpop.services.impl;

import edu.ienpop.dao.UsuarioDao;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.UsuarioService;

public class UsuarioServiceDefaultImpl implements UsuarioService {

	UsuarioDao usuarioDao;
	
	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public boolean isValidUsuario(String idUsuario, String password)
			throws BusinessException {
		String bdPassword = getUsuarioDao().findSimpleUser(idUsuario);
		if(bdPassword==null)
			throw new BusinessException("El usuario no existe...");
		if(!bdPassword.equals(password))
			throw new BusinessException("La contrase�a es incorrecta...");
		return true;
	}

	public String getNombreDelusuario(String usuario) throws BusinessException {
		return getUsuarioDao().getNombreUsuario(usuario);
	}

}