package edu.ienpop.service.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import edu.ienpop.dao.UsuarioDao;
import edu.ienpop.model.Usuario;
import edu.ienpop.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDao usuarioDao;
	
	public UsuarioServiceImpl(UsuarioDao usuarioDao){
		this.usuarioDao = usuarioDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		Usuario usuario = usuarioDao.read(username);
		if(usuario == null)
			throw new UsernameNotFoundException(username+ " no encontrado!!!");
		return usuario;
	}


}
