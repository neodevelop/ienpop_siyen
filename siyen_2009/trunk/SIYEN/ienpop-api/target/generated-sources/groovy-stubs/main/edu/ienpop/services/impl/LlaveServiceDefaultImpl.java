//
// Generated stub from file:/Users/neodevelop/Documents/Workspaces/ienpopWorkspace/svn/trunk/SIYEN/ienpop-api/src/main/groovy/edu/ienpop/services/impl/LlaveServiceDefaultImpl.groovy
//

package edu.ienpop.services.impl;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.ienpop.dao.LlaveDao;
import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.LlaveService;
import edu.ienpop.services.PersistenceService;

public class LlaveServiceDefaultImpl
    extends java.lang.Object
    implements groovy.lang.GroovyObject, LlaveService
{
    static private Logger log = null;
    static public Logger getLog() {
        throw new InternalError("Stubbed method");
    }
    static public void setLog(Logger value) {
        throw new InternalError("Stubbed method");
    }

    private PersistenceService persistenceService = null;

    private LlaveDao llaveDao = null;

    public java.lang.String generateLlaveXCurso(long idCursoXCertificar) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public LlaveCertificacion isValidaLlave(java.lang.String llave, long IdCursoXCertificar) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public LlaveCertificacion getLlavebyIdCurso(long IdCursoXCertificar) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public LlaveCertificacion getLlavebyToken(java.lang.String token) throws BusinessException {
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
