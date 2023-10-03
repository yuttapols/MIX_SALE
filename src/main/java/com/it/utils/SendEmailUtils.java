package com.it.utils;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SendEmailUtils {

	@Value("${spring.mail.username}")
	private String EMAIL_SERVER;

	@Autowired
	private JavaMailSender emailSender;

	public void sendMail(String to, String subject, String text) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		message.setFrom(EMAIL_SERVER);
		message.setRecipients(MimeMessage.RecipientType.TO, to);
		message.setSubject(subject);
		message.setContent(text, "text/html; charset=utf-8");
		emailSender.send(message);
	}

	public void sendMail(String to, String subject, String text,File file) {

		MimeMessage message = emailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(EMAIL_SERVER);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);

			FileSystemResource fileResource = new FileSystemResource(file);
			helper.addAttachment(fileResource.getFilename(), fileResource);

		} catch (MessagingException e) {
			throw new MailParseException(e);
		}
		emailSender.send(message);
	}

} 