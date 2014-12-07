package com.jingyusoft.amity.programs;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jingyusoft.amity.authentication.AuthenticationService;
import com.jingyusoft.amity.common.HostPort;
import com.jingyusoft.amity.common.WrappedException;
import com.jingyusoft.amity.data.auditing.AuditQueryService;
import com.jingyusoft.amity.thrift.factories.ThriftClientFactory;
import com.jingyusoft.amity.thrift.factories.ThriftClientFactory.ThriftClientHolder;
import com.jingyusoft.amity.thrift.generated.AmityService;

@Service
public class TestConsole {

	@Value("${amity.server.host}")
	private String host;

	@Value("${amity.server.port.ssl}")
	private int sslPort;

	@Resource
	private ThriftClientFactory thriftClientFactory;

	@Resource
	private AuthenticationService authenticationService;

	@Resource
	private AuditQueryService auditQueryService;

	private void sendMailDemo() {

		// Recipient's email ID needs to be mentioned.
		String to = "univer.shi@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "no-reply@jingyusoft.com";

		// Assuming you are sending email from localhost
		String host = "smtp.jingyusoft.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	@PostConstruct
	public void start() {

		// sendMailDemo();

		// auditQueryService.queryAudit(AmityUserEntity.class);

		thriftDemo();
	}

	private void thriftDemo() {

		HostPort hostPort = HostPort.from(host, sslPort);
		try (ThriftClientHolder<AmityService.Iface> holder = thriftClientFactory.getClient(hostPort,
				AmityService.Iface.class)) {
			System.out.println(holder.getClient().echo("Hello"));
		} catch (Exception e) {
			throw WrappedException.insteadOf(e);
		}
	}
}
