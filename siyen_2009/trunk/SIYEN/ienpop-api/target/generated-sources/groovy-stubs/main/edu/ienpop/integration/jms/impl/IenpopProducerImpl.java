//
// Generated stub from file:/Users/neodevelop/Documents/Workspaces/ienpopWorkspace/svn/trunk/SIYEN/ienpop-api/src/main/groovy/edu/ienpop/integration/jms/impl/IenpopProducerImpl.groovy
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
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import edu.ienpop.integration.jms.IenpopProducer;
import edu.ienpop.model.Usuario;
import edu.ienpop.services.BusinessException;

public class IenpopProducerImpl
    extends java.lang.Object
    implements groovy.lang.GroovyObject, IenpopProducer
{
    private JmsTemplate jmsTemplate = null;
    public JmsTemplate getJmsTemplate() {
        throw new InternalError("Stubbed method");
    }
    public void setJmsTemplate(JmsTemplate value) {
        throw new InternalError("Stubbed method");
    }

    private Destination destination = null;
    public Destination getDestination() {
        throw new InternalError("Stubbed method");
    }
    public void setDestination(Destination value) {
        throw new InternalError("Stubbed method");
    }

    private Logger log = null;
    public Logger getLog() {
        throw new InternalError("Stubbed method");
    }
    public void setLog(Logger value) {
        throw new InternalError("Stubbed method");
    }

    public void sendMessage(java.lang.String m) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public void generarLLaveQueue(long idCursoXCertificar, java.lang.String email) throws BusinessException {
        throw new InternalError("Stubbed method");
    }

    public void notificarAcceso(Usuario usuario) throws BusinessException {
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
