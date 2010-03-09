//
// Generated stub from file:/Users/neodevelop/Documents/Workspaces/ienpopWorkspace/svn/trunk/SIYEN/ienpop-api/src/main/groovy/edu/ienpop/integration/mail/impl/MailServiceDefaultImpl.groovy
//

package edu.ienpop.integration.mail.impl;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.ui.velocity.VelocityEngineUtils;
import edu.ienpop.integration.mail.MailService;
import edu.ienpop.services.BusinessException;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class MailServiceDefaultImpl
    extends java.lang.Object
    implements groovy.lang.GroovyObject, MailService
{
    private static final Log log = null;

    private Configuration configuration = null;
    public Configuration getConfiguration() {
        throw new InternalError("Stubbed method");
    }
    public void setConfiguration(Configuration value) {
        throw new InternalError("Stubbed method");
    }

    private SimpleMailMessage templateMessage = null;
    public SimpleMailMessage getTemplateMessage() {
        throw new InternalError("Stubbed method");
    }
    public void setTemplateMessage(SimpleMailMessage value) {
        throw new InternalError("Stubbed method");
    }

    private JavaMailSender javaMailSender = null;
    public JavaMailSender getJavaMailSender() {
        throw new InternalError("Stubbed method");
    }
    public void setJavaMailSender(JavaMailSender value) {
        throw new InternalError("Stubbed method");
    }

    private VelocityEngine velocityEngine = null;
    public VelocityEngine getVelocityEngine() {
        throw new InternalError("Stubbed method");
    }
    public void setVelocityEngine(VelocityEngine value) {
        throw new InternalError("Stubbed method");
    }

    public void sendMail(java.lang.String email, java.lang.String message) {
        throw new InternalError("Stubbed method");
    }

    public void sendMimeMail(java.lang.String email, java.lang.String message, java.lang.String subject) {
        throw new InternalError("Stubbed method");
    }

    public void sendMailWithAttach(java.lang.String email, java.lang.String message, java.lang.String subject, java.lang.String attach) {
        throw new InternalError("Stubbed method");
    }

    public void sendMailWithInline(java.lang.String email, java.lang.String message, java.lang.String subject, java.lang.String inline) {
        throw new InternalError("Stubbed method");
    }

    public void sendMailWithEngine(final java.lang.String email, final Map model, final java.lang.String subject, final java.lang.String template) {
        throw new InternalError("Stubbed method");
    }

    public void sendMailWithVelocityEngine(final java.lang.String email, final Map model, final java.lang.String subject, final java.lang.String template) {
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
