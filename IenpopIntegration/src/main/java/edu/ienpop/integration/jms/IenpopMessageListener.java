package edu.ienpop.integration.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

public class IenpopMessageListener implements MessageListener{

	Logger log = Logger.getLogger(this.getClass());
	
	public void onMessage(Message message) {
		if(message instanceof TextMessage){
			TextMessage textMessage = (TextMessage)message;
			try {
				String m = textMessage.getText();
				String tipo = textMessage.getStringProperty("tipo");
				log.debug("Se ha recibido el mensaje...");
				log.debug("Contenido del mensaje:");
				log.debug(m);
				log.debug("El tipo de mensaje es: "+tipo);
			} catch (JMSException e) {
				throw new RuntimeException("Error al obtener el mensaje", e);
			}
		}else{
			log.debug("Se recibio un mensaje que noe s de texto...");
		}
	}

}
