package com.digitaladd.util.email;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.digitaladd.util.ResourceUtility;

public class SendEmail {
	String to;
	String from;

	final protected String userName;
	final protected String password;

	// Assuming you are sending email through relay.jangosmtp.net
	String host;
	String port;

	boolean flag;

	protected Properties props;

	public SendEmail() {
		super();
		host = ResourceUtility.getCommonConstant("email.smtp.host");

		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

		userName = ResourceUtility.getCommonConstant("email.smtp.username");
		;
		password = ResourceUtility.getCommonConstant("email.smtp.password");
		;

	}

	public boolean sendMail() {
		boolean flag = false;

		Map<String, String> input = new HashMap<String, String>();
		EmailContent emailTemptet = EmailContent.getInstance();
		Properties emailContentKeywords = new Properties();

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Testing Subject");

			// start template
				MimeMultipart _mulPart = new MimeMultipart();
				BodyPart _bodyPart = new MimeBodyPart();
				// Set key values
				emailContentKeywords.load(SendEmail.class.getResourceAsStream("resources/emailKeywords.properties"));
				input=(Map)emailContentKeywords;
				// HTML mail content
				String htmlText =emailTemptet.readHtml(input);
				_bodyPart.setContent(htmlText, "text/html");
	
				_mulPart.addBodyPart(_bodyPart);
				message.setContent(_mulPart);
			// end template

			// Send message
			Transport.send(message);

			flag = true;
			System.out.println("Sent message successfully....");

		} catch (MessagingException | IOException e) {
			flag = false;
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return flag;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
