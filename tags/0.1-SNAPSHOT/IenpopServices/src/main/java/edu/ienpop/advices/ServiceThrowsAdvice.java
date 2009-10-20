package edu.ienpop.advices;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.hibernate.LazyInitializationException;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.dao.DataAccessException;
import org.springframework.jms.UncategorizedJmsException;

import edu.ienpop.services.BusinessException;

public class ServiceThrowsAdvice{

	Logger log = Logger.getLogger(this.getClass());
	
	public void doRecoveryActionDataAccess(DataAccessException dataAccessEx) throws BusinessException{
		log.debug(dataAccessEx.getMessage());
		throw new BusinessException("Error en Persistencia: ",dataAccessEx);
	}
	
	public void doRecoveryActionGenericJDBC(GenericJDBCException jdbcException) throws BusinessException{
		log.debug(jdbcException.getMessage());
		throw new BusinessException("Error en Persistencia: ",jdbcException);
	}
	
	public void doRecoveryActionNetConnection(UncategorizedJmsException jmsException) throws BusinessException{
		log.debug(jmsException.getMessage());
		throw new BusinessException("Error de Comunicaci—n: ",jmsException);
	}
	
	public void doRecoveryActionLazy(LazyInitializationException lazyException) throws BusinessException{
		log.debug(lazyException.getMessage());
		throw new BusinessException("Error en Persistencia: ",lazyException);
	}
	
	public void doRecoveryIOException(IOException ioException) throws BusinessException{
		log.debug(ioException.getMessage());
		throw new BusinessException("Error de entrada/salida: ",ioException);
	}
}
