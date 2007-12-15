package edu.ienpop.services;


public interface UsuarioService {
	public boolean isValidUsuario(String idUsuario,String password) throws BusinessException;
}
