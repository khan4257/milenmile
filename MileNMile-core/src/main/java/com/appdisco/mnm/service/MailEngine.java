package com.appdisco.mnm.service;

import java.io.Serializable;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * Class for sending e-mail messages based on Velocity templates or with
 * attachments.
 * 
 * @author Sehwan Noh (sehwan@java2go.net)
 * @version 1.0
 */
@Service
public class MailEngine {

	private final Log log = LogFactory.getLog(MailEngine.class);

	@Autowired
	private MailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;

	@Value(value="${dir.template.email}")
	private String templateDir;

	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}

	/**
	 * Send a simple message based on a Velocity template.
	 * 
	 * @param msg
	 *            the message to populate
	 * @param templateName
	 *            the Velocity template to use (relative to classpath)
	 * @param model
	 *            a map containing key/value pairs
	 */
	public void sendMessage(SimpleMailMessage msg, String templateName, Map<String, Serializable> model) {
		String result = null;
		try {
			result = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateDir + "/" + templateName, "UTF-8", model);
		} catch (VelocityException ex) {
			log.error(ex.getMessage());
		}
		log.info("Email Message=" + result);
		msg.setText(result);
		send(msg);
	}

	/**
	 * Send a simple message with pre-populated values.
	 * 
	 * @param msg
	 *            the message to send
	 */
	public void send(SimpleMailMessage msg) {
		try {
			mailSender.send(msg);
		} catch (MailException ex) {
			// log it and go on
			log.error(ex.getMessage());
		}
	}

	public void sendMessage(MimeMessagePreparator preparator) {
		((JavaMailSenderImpl) mailSender).send(preparator);
	}

	/**
	 * Convenience method for sending messages with attachments.
	 * 
	 * @param recipients
	 *            array of e-mail addresses
	 * @param sender
	 *            e-mail address of sender
	 * @param resource
	 *            attachment from classpath
	 * @param bodyText
	 *            text in e-mail
	 * @param subject
	 *            subject of e-mail
	 * @param attachmentName
	 *            name for attachment
	 * @throws MessagingException
	 *             thrown when can't communicate with SMTP server
	 */
	public void sendMessage(String[] recipients, String sender, ClassPathResource resource, String bodyText, String subject, String attachmentName)
			throws MessagingException {
		MimeMessage message = ((JavaMailSenderImpl) mailSender).createMimeMessage();

		// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setTo(recipients);
		helper.setFrom(sender);
		helper.setText(bodyText);
		helper.setSubject(subject);
		helper.addAttachment(attachmentName, resource);

		((JavaMailSenderImpl) mailSender).send(message);
	}
}
