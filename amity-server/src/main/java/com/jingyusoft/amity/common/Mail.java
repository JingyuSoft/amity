package com.jingyusoft.amity.common;

import java.util.Properties;

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

public abstract class Mail {

	public static void initializeWith(AmityPropertiesRepository amityProperties) {
		Mail.PROPERTIES.setProperty("mail.transport.protocol",
				amityProperties.getProperty("amity.mail.transport.protocol"));
		Mail.PROPERTIES.setProperty("mail.smtp.host", amityProperties.getProperty("amity.mail.smtp.host"));
		Mail.PROPERTIES.setProperty("mail.smtp.port", amityProperties.getProperty("amity.mail.smtp.port"));
		Mail.PROPERTIES.setProperty("mail.smtp.auth", amityProperties.getProperty("amity.mail.smtp.auth"));
		Mail.PROPERTIES.setProperty("mail.smtp.starttls.enable",
				amityProperties.getProperty("amity.mail.smtp.starttls.enable"));

		Mail.fromAddress = amityProperties.getProperty("amity.mail.smtp.username");

		Mail.authenticator = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(amityProperties.getProperty("amity.mail.smtp.username"),
						SecurityUtils.getPasswordFromFile(amityProperties.getProperty("amity.mail.smtp.password.file")));
			}
		};

		LOGGER.info("Amity mail sender initialized");
	}

	public static void send(final String recipient, final String subject, final String body) {
		send(new String[] { recipient }, subject, body);
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
