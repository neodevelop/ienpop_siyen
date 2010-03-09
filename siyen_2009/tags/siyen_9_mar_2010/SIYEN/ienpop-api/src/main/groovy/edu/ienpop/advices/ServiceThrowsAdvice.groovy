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
		showMessageOrStacktrace(dataAccessEx)
		throw new BusinessException("Error en Persistencia: ",dataAccessEx)
	}
	
	void doRecoveryActionGenericJDBC(GenericJDBCException jdbcException) throws BusinessException{
		showMessageOrStacktrace(jdbcException)
		throw new BusinessException("Error en Persistencia: ",jdbcException)
	}
	
	void doRecoveryActionNetConnection(UncategorizedJmsException jmsException) throws BusinessException{
		showMessageOrStacktrace(jmsException)
		throw new BusinessException("Error de Comunicaci—n: ",jmsException)
	}
	
	void doRecoveryActionLazy(LazyInitializationException lazyException) throws BusinessException{
		showMessageOrStacktrace(lazyException)
		throw new BusinessException("Error en Persistencia: ",lazyException)
	}
	
	void doRecoveryIOException(IOException ioException) throws BusinessException{
		showMessageOrStacktrace(ioException)
		throw new BusinessException("Error de entrada/salida: ",ioException)
	}
	
	private void showMessageOrStacktrace(ex){
		if(log.isDebugEnabled()){
			log.debug(ex.message)
		}else{
			ex.printStackTrace()
		}
	}
}
