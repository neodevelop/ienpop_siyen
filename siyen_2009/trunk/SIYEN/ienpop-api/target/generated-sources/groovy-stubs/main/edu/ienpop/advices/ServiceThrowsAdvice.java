//
// Generated stub from file:/Users/neodevelop/Documents/Workspaces/ienpopWorkspace/svn/trunk/SIYEN/ienpop-api/src/main/groovy/edu/ienpop/advices/ServiceThrowsAdvice.groovy
//

package edu.ienpop.advices;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.hibernate.LazyInitializationException;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.dao.DataAccessException;
import org.springframework.jms.UncategorizedJmsException;
import edu.ienpop.services.BusinessException;

public class ServiceThrowsAdvice
    extends java.lang.Object
    implements groovy.lang.GroovyObject
{
    private Logger log = null;
    public Logger getLog() {
        throw new InternalError("Stubbed method");
    }
    public void setLog(Logger value) {
        throw new InternalError("Stubbed method");
    }

    public void doRecoveryActionDataAccess(DataAccessException dataAccessEx) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public void doRecoveryActionGenericJDBC(GenericJDBCException jdbcException) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public void doRecoveryActionNetConnection(UncategorizedJmsException jmsException) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public void doRecoveryActionLazy(LazyInitializationException lazyException) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public void doRecoveryIOException(IOException ioException) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    private void showMessageOrStacktrace(java.lang.Object ex) {
        throw new InternalError("Stubbed method");
    }

    public groovy.lang.MetaClass getMetaClass() {
        throw new InternalError("Stubbed method");
    }

    public void setMetaClass(groovy.lang.MetaClass metaClass) {
        throw new InternalError("Stubbed method");
    }

    public java.lang.Object invokeMethod(java.lang.String name, java.lang.Object args) {
        throw new InternalError("Stubbed method");
    }

    public java.lang.Object getProperty(java.lang.String name) {
        throw new InternalError("Stubbed method");
    }

    public void setProperty(java.lang.String name, java.lang.Object value) {
        throw new InternalError("Stubbed method");
    }
}
