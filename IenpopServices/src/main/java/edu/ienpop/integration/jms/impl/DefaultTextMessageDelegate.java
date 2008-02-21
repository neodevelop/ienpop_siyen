package edu.ienpop.integration.jms.impl;

import javax.jms.TextMessage;

import edu.ienpop.integration.jms.TextMessageDelegate;

public class DefaultTextMessageDelegate implements TextMessageDelegate{

	public void receive(TextMessage message) {
		System.out.println("Mensaje recibido");
	}

}
