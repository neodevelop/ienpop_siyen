package edu.ienpop.services;

public interface UsuarioService {
	boolean isValidUsuario(String idUsuario,String password);
	String getNombreDelusuario(String usuario);
}
