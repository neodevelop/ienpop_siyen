package edu.ienpop.integration.mail.impl;

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

public class MailServiceDefaultImpl implements MailService {

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(MailServiceDefaultImpl.class);

	Configuration configuration;

	SimpleMailMessage templateMessage;

	JavaMailSender javaMailSender;

	VelocityEngine velocityEngine;

	public void sendMail(String email, String message) {
		// TODO Auto-generated method stub
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		msg.setTo(email);
		msg.setText(message);
		this.javaMailSender.send(msg);
	}

	public void sendMimeMail(String email, String message, String subject) {
		def preparator = [prepare:{ mimeMessage -> 
				mimeMessage.setRecipient(Message.RecipientType.TO,
						new InternetAddress(email));
				mimeMessage.setFrom(new InternetAddress("siyen@ienpop.net"));
				mimeMessage.setSubject(subject);
				mimeMessage.setText(message);
			}] as MimeMessagePreparator
		this.javaMailSender.send(preparator);

	}

	public void sendMailWithAttach(String email, String message,
			String subject, FileSystemResource attach) {
		try {
			MimeMessage mimeMessage = getJavaMailSender().createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(email);
			helper.setFrom("siyen@ienpop.net");
			helper.setText(message);
			helper.setSubject(subject);
			helper.addAttachment(attach.getFilename(), attach);
			getJavaMailSender().send(mimeMessage);
		} catch (MessagingException e) {
			//throw new BusinessException("No se puede enviar el correo", e);
		}
	}

	public void sendMailWithInline(String email, String message,
			String subject, FileSystemResource inline) {
		try {
			MimeMessage mimeMessage = getJavaMailSender().createMimeMessage();
			MimeMessageHelper helper;
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(email);
			helper.setFrom("siyen@ienpop.net");
			helper.setSubject(subject);
			helper.setText(message, true);
			helper.addInline("identifier1", inline);
			getJavaMailSender().send(mimeMessage);
		} catch (MessagingException e) {
			//throw new BusinessException("No se puede enviar el correo", e);
		}

	}

	public void sendMailWithEngine(final String email, final Map model,
			final String subject, final String template) {
		def preparator = [prepare:{ mimeMessage -> 
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true);
				Template myTemplate = getConfiguration().getTemplate(template);
				message.setTo(email);
				message.setFrom("siyen@ienpop.net");
				message.setSubject(subject);
				String text = FreeMarkerTemplateUtils
						.processTemplateIntoString(myTemplate, model);
				message.setText(text, true);
			}] as MimeMessagePreparator
		this.javaMailSender.send(preparator);
	}

	public void sendMailWithVelocityEngine(final String email, final Map model,
			final String subject, final String template) {
		def preparator = [prepare:{ mimeMessage -> 
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(email);
				message.setSubject(subject);
				message.setFrom("siyen@ienpop.net");
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, template, model);
				message.setText(text, true);
			}] as MimeMessagePreparator
		this.javaMailSender.send(preparator);
	}

}
