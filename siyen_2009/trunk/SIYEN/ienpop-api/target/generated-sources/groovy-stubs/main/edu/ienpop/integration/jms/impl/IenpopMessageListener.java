//
// Generated stub from file:/Users/neodevelop/Documents/Workspaces/ienpopWorkspace/svn/trunk/SIYEN/ienpop-api/src/main/groovy/edu/ienpop/integration/jms/impl/IenpopMessageListener.groovy
//

package edu.ienpop.integration.jms.impl;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import edu.ienpop.integration.mail.MailService;
import edu.ienpop.model.CatalogoCurso;
import edu.ienpop.model.CatalogoPuerto;
import edu.ienpop.model.CursoXCertificar;
import edu.ienpop.model.Usuario;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.LlaveService;
import edu.ienpop.services.PersistenceService;

public class IenpopMessageListener
    extends java.lang.Object
    implements groovy.lang.GroovyObject, MessageListener
{
    private MailService mailService = null;

    private LlaveService llaveService = null;

    private PersistenceService persistenceService = null;

    private Logger log = null;
    public Logger getLog() {
        throw new InternalError("Stubbed method");
    }
    public void setLog(Logger value) {
        throw new InternalError("Stubbed method");
    }

    public void onMessage(Message message) {
        throw new InternalError("Stubbed method");
    }

    public MailService getMailService() {
        throw new InternalError("Stubbed method");
    }

    public void setMailService(MailService mailService) {
        throw new InternalError("Stubbed method");
    }

    public LlaveService getLlaveService() {
        throw new InternalError("Stubbed method");
    }

    public void setLlaveService(LlaveService llaveService) {
        throw new InternalError("Stubbed method");
    }

    public PersistenceService getPersistenceService() {
        throw new InternalError("Stubbed method");
    }

    public void setPersistenceService(PersistenceService persistenceService) {
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
