package edu.ienpop.advices;

import org.hibernate.LazyInitializationException;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.dao.DataAccessException;
import org.springframework.jms.UncategorizedJmsException;

import edu.ienpop.services.BusinessException;

public class ServiceThrowsAdvice{

	public void doRecoveryActionDataAccess(DataAccessException dataAccessEx) throws BusinessException{
		throw new BusinessException("Error en Persistencia: ",dataAccessEx);
	}
	
	public void doRecoveryActionGenericJDBC(GenericJDBCException jdbcException) throws BusinessException{
		throw new BusinessException("Error en Persistencia: ",jdbcException);
	}
	
	public void doRecoveryActionNetConnection(UncategorizedJmsException jmsException) throws BusinessException{
		throw new BusinessException("Error de Comunicación: ",jmsException);
	}
	
	public void doRecoveryActionLazy(LazyInitializationException lazyException) throws BusinessException{
		throw new BusinessException("Error en Persistencia: ",lazyException);
	}
	
}
