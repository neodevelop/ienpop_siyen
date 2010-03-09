package edu.ienpop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ienpop.dao.UsuarioDao;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceDefaultImpl implements UsuarioService {

	@Autowired
	UsuarioDao usuarioDao;

	public boolean isValidUsuario(String idUsuario, String password)
			throws BusinessException {
		String bdPassword = usuarioDao.findSimpleUser(idUsuario);
		if(bdPassword==null)
			throw new BusinessException("El usuario no existe...");
		if(!bdPassword.equals(password))
			throw new BusinessException("La contrase–a es incorrecta...");
		return true;
	}

	public String getNombreDelusuario(String usuario) throws BusinessException {
		return usuarioDao.getNombreUsuario(usuario);
	}

}
