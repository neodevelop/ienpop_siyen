package edu.ienpop.integration.mail;

import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.core.io.FileSystemResource;

public interface MailService {
	void sendMail(String email,String message);
	void sendMimeMail(String email,String message,String subject);
	void sendMailWithAttach(String email,String message,String subject,FileSystemResource attach) throws MessagingException;
	void sendMailWithInline(String email,String message,String subject,FileSystemResource inline) throws MessagingException;
	void sendMailWithEngine(String email,Map model,String subject,String template);
	void sendMailWithVelocityEngine(String email,Map model,String subject,String template);
}
