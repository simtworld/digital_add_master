package com.digitaladd.util.email;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

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

public class EmailService {
	private String to;
	private String from;

	static private String userName;
	static private String password;
	static private String host;
	static private String port;
	static private Properties props;
	static private EmailDao emailDAO;
	
	private EmailTemplateVO emailTemplateVO;
	
	static {
		configurEmailSMTP();
	}
	
	public EmailService() {
		super();
	}
	
	public static void configurEmailSMTP() {
		
		emailDAO=EmailDao.getInstance();
		
		EmailConfigVO emailConfigVO = emailDAO.getEmailSMTPConfig();
		
		userName = emailConfigVO.getUserName();
		password = emailConfigVO.getPassword();
		host = emailConfigVO.getHost();
		port = emailConfigVO.getPort();
		
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
	}

	public boolean sendMail(String templateId,Class clazz) {
		boolean flag = false;
		Field[] filds=clazz.getFields();
		
		Map<String, String> input = new HashMap<String, String>();
		Properties emailContentKeywords = new Properties();
		from=userName;
		EmailTemplateVO emailTemplateVO=emailDAO.getEmailTemplateByTemplateId(templateId);
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
			message.setSubject(emailTemplateVO.emailSubject);

			// start template
				MimeMultipart _mulPart = new MimeMultipart();
				BodyPart _bodyPart = new MimeBodyPart();
				
				// HTML mail content
				String htmlText =this.getHtml(emailTemplateVO.getEmailKewords(), emailTemplateVO);
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
	
	
	/**
	 * desc this method replace all the keywords with valid data
	 * @param input
	 * @param emailTemplateVO
	 * @return
	 * @throws IOException
	 */
	protected static String getHtml(Map<String, String> input,EmailTemplateVO emailTemplateVO) throws IOException {
		String msg=emailTemplateVO.emailTemplate;
		
		Set<Entry<String, String>> entries = input.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			msg = msg.replace(entry.getKey().trim(), entry.getValue().trim());
		}
		return msg;
	}
	
	public void setTo(String to) {
		this.to = to;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
