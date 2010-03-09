package edu.ienpop.integration.jms;

import edu.ienpop.model.Usuario;

public interface IenpopProducer {
	public void sendMessage(String m);
	public void generarLLaveQueue(long idCursoXCertificar,String email);
	public void notificarAcceso(Usuario usuario);
}
