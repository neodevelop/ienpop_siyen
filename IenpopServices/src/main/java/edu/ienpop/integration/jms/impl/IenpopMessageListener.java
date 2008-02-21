package edu.ienpop.integration.jms.impl;

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

public class IenpopMessageListener implements MessageListener {
	MailService mailService;
	LlaveService llaveService;
	PersistenceService persistenceService;
	Logger log = Logger.getLogger(this.getClass());
	
	@SuppressWarnings("unchecked")
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				String m = textMessage.getText();
				String tipo = textMessage.getStringProperty("tipo");
				log.debug("Se ha recibido el mensaje...");
				log.debug("El tipo de mensaje es: " + tipo);
				if (tipo.startsWith("generacionLlave")) {
					String[] datos = m.split(" ");
					Long idCursoXCertificar = Long.parseLong(datos[0]);
					log.debug("ID CursoXCertificar: "+idCursoXCertificar);
					log.debug("Correo de contacto: "+datos[1]);
					String llaveCertificacion = getLlaveService().generateLlaveXCurso(Long.parseLong(datos[0]));
					log.debug("Llave generada y obtenida...");
					CursoXCertificar curso = (CursoXCertificar)getPersistenceService().findById(CursoXCertificar.class,new Long(idCursoXCertificar));
					log.debug("Datos del curso obtenidos...");
					CatalogoCurso tipoCurso = (CatalogoCurso)getPersistenceService().findById(CatalogoCurso.class, curso.getIdTipoCurso());
					log.debug("Tipo de curso obtenido...");
					CatalogoPuerto puerto =(CatalogoPuerto)getPersistenceService().findById(CatalogoPuerto.class, curso.getIdPuerto());
					log.debug("Puerto obtenido...");
					Map model = new HashMap();
					model.put("llaveCertificacion", llaveCertificacion);
					model.put("curso",curso);
					model.put("tipoCurso",tipoCurso);
					model.put("puerto", puerto);
					log.debug("Llave y datos del curso en modelo...");
					mailService.sendMailWithEngine(datos[1], model, "Llave de Certificación para Curso", "mail/SendKey.ftl");
					//mailService.sendMail(datos[1], llaveCertificacion);
					log.debug("La llave ha sido enviada...");
				}
				if (tipo.compareTo("notificacion")==0) {
					log.debug("Iniciando proceso...");
					XStream xstream = new XStream(new DomDriver());
					log.debug("Objeto XStream creado...");
					Usuario usuario =(Usuario)xstream.fromXML(m);
					log.debug("Objeto usuario parseado y casteado...");
					Map model = new HashMap();
					log.debug("Modelo iniciado...");
					Date fecha = GregorianCalendar.getInstance().getTime();
					model.put("usuario", usuario);
					model.put("current",fecha);
					log.debug("Usuario y fecha agregado al modelo...");
					mailService.sendMailWithEngine("juan.reyes@ienpop.net", model, "Notificación de Acceso", "mail/NotificacionAcceso.ftl");
					log.debug("La notificación ha sido enviada...");
				}
				if (tipo.startsWith("test")) {
					log.debug("MENSAJE: "+m);
				}
			} catch (JMSException e) {
				throw new RuntimeException("Error al obtener el mensaje", e);
			} catch (NumberFormatException e) {
				log.debug(e.getMessage());
			} catch (BusinessException e) {
				log.debug(e.getMessage());
			}
		} else {
			log.debug("Se recibio un mensaje que no es de texto...");
		}
	}

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public LlaveService getLlaveService() {
		return llaveService;
	}

	public void setLlaveService(LlaveService llaveService) {
		this.llaveService = llaveService;
	}

	public PersistenceService getPersistenceService() {
		return persistenceService;
	}

	public void setPersistenceService(PersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}
}
