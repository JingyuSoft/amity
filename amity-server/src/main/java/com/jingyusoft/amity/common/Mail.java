package com.jingyusoft.amity.common;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public abstract class Mail {

	@Component
	public static class MailProperties {

		@Value("${amity.mail.transport.protocol}")
		private String mailTransport;

		@Value("${amity.mail.smtp.host}")
		private String smtpHost;

		@Value("${amity.mail.smtp.port}")
		private String smtpPort;

		@Value("${amity.mail.smtp.auth}")
		private String smtpAuth;

		@Value("${amity.mail.smtp.starttls.enable}")
		private String startTls;

		@Value("${amity.mail.smtp.username}")
		private String username;

		@Value("${amity.mail.smtp.passowrd.file}")
		private String passwordFile;

		@PostConstruct
		private void initialize() {
			Mail.PROPERTIES.setProperty("mail.transport.protocol", mailTransport);
			Mail.PROPERTIES.setProperty("mail.smtp.host", smtpHost);
			Mail.PROPERTIES.setProperty("mail.smtp.auth", smtpAuth);
			Mail.PROPERTIES.setProperty("mail.smtp.port", smtpPort);
			Mail.PROPERTIES.setProperty("mail.smtp.starttls.enable", startTls);

			Mail.fromAddress = username;

			Mail.authenticator = new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, SecurityUtils.getPasswordFromFile(passwordFile));
				}
			};
		}
	}

	public static void send(final String[] recipients, final String subject, final String body) {

		Session session = Session.getDefaultInstance(PROPERTIES, authenticator);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(fromAddress));

			// Set To: header field of the header.
			for (String recipient : recipients) {
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			}

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
			message.setText(body);

			// Send message
			Transport.send(message);

			LOGGER.info("Email sent successfully to [{}]. Subject = [{}]", StringUtils.join(recipients, "; "), subject);
		} catch (MessagingException e) {
			LOGGER.warn("Failed to send email to [{}]. Subject = [{}]", StringUtils.join(recipients, "; "), subject);
			throw WrappedException.insteadOf(e);
		}
	}

	private static final Logger LOGGER = AmityLogger.getLogger();

	private static Authenticator authenticator;

	private static String fromAddress;

	private static final Properties PROPERTIES = new Properties();
}
