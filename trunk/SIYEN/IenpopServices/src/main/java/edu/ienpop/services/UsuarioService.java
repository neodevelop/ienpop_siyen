package edu.ienpop.services;


public interface UsuarioService {
	boolean isValidUsuario(String idUsuario,String password) throws BusinessException;
	String getNombreDelusuario(String usuario) throws BusinessException;
}
