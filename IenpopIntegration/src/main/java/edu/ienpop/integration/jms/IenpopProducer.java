package edu.ienpop.integration.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import edu.ienpop.model.Usuario;

public class IenpopProducer {
	private JmsTemplate jmsTemplate;
	private Destination destination;
	Logger log = Logger.getLogger(this.getClass());
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendMessage(){
		final String message = "Mensaje de envío del IENPOP.";
		log.debug("Enviando el mensaje...");
		this.jmsTemplate.send(this.getDestination(), new MessageCreator(){
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(message);
				textMessage.setStringProperty("tipo", "tipo1");
				return textMessage;
			}
		});
	}
	
	public void generarLLaveQueue(long idCursoXCertificar,String email){
		final String message = idCursoXCertificar+"|"+email;
		log.debug("Enviando el mensaje para certificación ...");
		this.jmsTemplate.send(this.getDestination(), new MessageCreator(){
			public Message createMessage(Session session) throws JMSException {
				TextMessage textMessage = session.createTextMessage();
				textMessage.setText(message);
				textMessage.setStringProperty("tipo", "generacionLlave");
				return textMessage;
			}
		});
	}
	
	public void notificarAcceso(Usuario usuario){
		
	}
}
