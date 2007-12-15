package edu.ienpop.advices;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.dao.DataAccessException;

import edu.ienpop.services.BusinessException;

public class ServiceThrowsAdvice{

	public void doRecoveryActionDataAccess(DataAccessException dataAccessEx) throws BusinessException{
		throw new BusinessException("Error en Persistencia: ",dataAccessEx);
	}
	
	public void doRecoveryActionGenericJDBC(GenericJDBCException jdbcException) throws BusinessException{
		throw new BusinessException("Error en Persistencia: ",jdbcException);
	}
	
}
