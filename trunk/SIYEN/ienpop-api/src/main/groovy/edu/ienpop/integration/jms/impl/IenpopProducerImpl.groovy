package edu.ienpop.integration.jms.impl;

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

public class IenpopProducerImpl implements IenpopProducer{
	JmsTemplate jmsTemplate;
	Destination destination;
	Logger log = Logger.getLogger(this.getClass());
	
	public void sendMessage(String m) throws BusinessException{
		final String message = m;
		log.debug("Enviando el mensaje...");
		this.jmsTemplate.send(this.destination,[
			createMessage:{ session -> 
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(message);
				textMessage.setStringProperty("tipo", "test");
				return textMessage;
			}] as MessageCreator);
	}
	
	public void generarLLaveQueue(long idCursoXCertificar,String email) throws BusinessException{ 
		final String message = idCursoXCertificar+" "+email;
		log.debug("Enviando el mensaje para certificación ...");
		this.jmsTemplate.send(this.destination, [
			createMessage:{ session ->
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(message);
				textMessage.setStringProperty("tipo", "generacionLlave");
				return textMessage;
			}] as MessageCreator);
	}
	
	public void notificarAcceso(Usuario usuario) throws BusinessException{
		XStream xstream = new XStream(new DomDriver());
		final String xml = xstream.toXML(usuario);
		log.debug("Enviando el mensaje para notificación ...");
		this.jmsTemplate.send(this.destination, [
			createMessage:{ session ->
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(xml);
				textMessage.setStringProperty("tipo", "notificacion");
				return textMessage;
			}] as MessageCreator);
	}
}
