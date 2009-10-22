package edu.ienpop.integration.mail;

import java.util.Map;

import org.springframework.core.io.FileSystemResource;

public interface MailService {
	void sendMail(String email,String message);
	void sendMimeMail(String email,String message,String subject);
	void sendMailWithAttach(String email,String message,String subject,FileSystemResource attach);
	void sendMailWithInline(String email,String message,String subject,FileSystemResource inline);
	void sendMailWithEngine(String email,Map model,String subject,String template);
	void sendMailWithVelocityEngine(String email,Map model,String subject,String template);
}
