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
import freemarker.template.Configuration;
import freemarker.template.Template;

public class MailServiceDefaultImpl implements MailService {

	@SuppressWarnings("unused")
	private static final Log log = LogFactory
			.getLog(MailServiceDefaultImpl.class);

	Configuration configuration;

	SimpleMailMessage templateMessage;

	JavaMailSender javaMailSender;

	VelocityEngine velocityEngine;

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public SimpleMailMessage getTemplateMessage() {
		return templateMessage;
	}

	public void setTemplateMessage(SimpleMailMessage templateMessage) {
		this.templateMessage = templateMessage;
	}

	public void sendMail(String email, String message) {
		// TODO Auto-generated method stub
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		msg.setTo(email);
		msg.setText(message);
		this.javaMailSender.send(msg);
	}

	public void sendMimeMail(final String email, final String message,
			final String subject) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO,
						new InternetAddress(email));
				mimeMessage.setFrom(new InternetAddress(
						"jreyes@ingenieriahs.com"));
				mimeMessage.setSubject(subject);
				mimeMessage.setText(message);
			}
		};

		this.javaMailSender.send(preparator);

	}

	public void sendMailWithAttach(String email, String message,
			String subject, FileSystemResource attach) throws MessagingException {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage = getJavaMailSender().createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setTo(email);
		helper.setFrom("jreyes@ingenieriahs.com");
		helper.setText(message);
		helper.setSubject(subject);
		helper.addAttachment(attach.getFilename(), attach);
		getJavaMailSender().send(mimeMessage);
	}

	public void sendMailWithInline(String email, String message,
			String subject, FileSystemResource inline) throws MessagingException {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage = getJavaMailSender().createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setTo(email);
		helper.setFrom("jreyes@ingenieriahs.com");
		helper.setSubject(subject);
		helper.setText(message, true);
		helper.addInline("identifier1", inline);
		getJavaMailSender().send(mimeMessage);

	}

	public void sendMailWithEngine(final String email, final Map model,
			final String subject, final String template) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
						true);
				Template myTemplate = getConfiguration().getTemplate(template);
				message.setTo(email);
				message.setFrom("jreyes@ingenieriahs.com");
				message.setSubject(subject);
				String text = FreeMarkerTemplateUtils
						.processTemplateIntoString(myTemplate, model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}

	public void sendMailWithVelocityEngine(final String email, final Map model,
			final String subject, final String template) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(email);
				message.setSubject(subject);
				message.setFrom("jreyes@ingenieriahs.com");
				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine, template, model);
				message.setText(text, true);
			}
		};
		this.javaMailSender.send(preparator);
	}

}
