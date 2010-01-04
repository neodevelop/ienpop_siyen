package edu.ienpop.advices

import java.io.IOException

import org.apache.log4j.Logger
import org.hibernate.LazyInitializationException
import org.hibernate.exception.GenericJDBCException
import org.springframework.dao.DataAccessException
import org.springframework.jms.UncategorizedJmsException

import edu.ienpop.services.BusinessException

class ServiceThrowsAdvice{

	Logger log = Logger.getLogger(this.getClass())
	
	void doRecoveryActionDataAccess(DataAccessException dataAccessEx) throws BusinessException{
		log.debug(dataAccessEx.message)
		throw new BusinessException("Error en Persistencia: ",dataAccessEx)
	}
	
	void doRecoveryActionGenericJDBC(GenericJDBCException jdbcException) throws BusinessException{
		log.debug(jdbcException.message)
		throw new BusinessException("Error en Persistencia: ",jdbcException)
	}
	
	void doRecoveryActionNetConnection(UncategorizedJmsException jmsException) throws BusinessException{
		log.debug(jmsException.message)
		throw new BusinessException("Error de Comunicaci—n: ",jmsException)
	}
	
	void doRecoveryActionLazy(LazyInitializationException lazyException) throws BusinessException{
		log.debug(lazyException.message)
		throw new BusinessException("Error en Persistencia: ",lazyException)
	}
	
	void doRecoveryIOException(IOException ioException) throws BusinessException{
		log.debug(ioException.message)
		throw new BusinessException("Error de entrada/salida: ",ioException)
	}
}
