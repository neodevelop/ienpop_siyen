package edu.ienpop.integration.jms;

import edu.ienpop.model.Usuario;
import edu.ienpop.services.BusinessException;

public interface IenpopProducer {
	public void sendMessage(String m) throws BusinessException;
	public void generarLLaveQueue(long idCursoXCertificar,String email) throws BusinessException;
	public void notificarAcceso(Usuario usuario) throws BusinessException;
}
