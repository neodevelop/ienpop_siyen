package edu.ienpop.integration.jms;

import javax.jms.TextMessage;

public interface TextMessageDelegate {
	void receive(TextMessage message);
}
