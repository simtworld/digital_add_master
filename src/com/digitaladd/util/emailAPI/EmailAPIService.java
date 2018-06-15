package com.digitaladd.util.emailAPI;

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

public class EmailAPIService {
	private static EmailAPIService instance;
	
	private String to;
	private String from;

	static private String userName;
	static private String password;
	static private String host;
	static private String port;
	static private Properties props;
	static private EmailAPIDao emailDAO;
	
	private EmailAPITemplateVO emailAPITemplateVO;
	
	static {
		configurEmailSMTP();
	}
	
	private EmailAPIService() {
		super();
	}
	
	public static synchronized EmailAPIService getInstance() {
		if(instance==null)
			instance=new EmailAPIService();
		return instance;
	}
	
	/**
	 * @param emailAPITemplateVO
	 * @return
	 */
	public boolean changeEmailTemplate(EmailAPITemplateVO emailAPITemplateVO) {
		return emailDAO.saveEmailTemplate(emailAPITemplateVO);
	}
	
	public static void configurEmailSMTP() {
		
		emailDAO=EmailAPIDao.getInstance();
		
		EmailAPIConfigVO emailAPIConfigVO = emailDAO.getEmailSMTPConfig();
		
		userName = emailAPIConfigVO.getUserName();
		password = emailAPIConfigVO.getPassword();
		host = emailAPIConfigVO.getHost();
		port = emailAPIConfigVO.getPort();
		
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
	}

	public boolean sendMail(String templateTypeId,Map<String,String> realValues, String recipiant) {
		boolean flag = false;
		this.setTo(recipiant);
		
		Map<String, String> input = new HashMap<String, String>();
		Properties emailContentKeywords = new Properties();
		from=userName;
		EmailAPITemplateVO emailAPITemplateVO=emailDAO.getEmailTemplateDetailsByTemplateId(templateTypeId);
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
			message.setSubject(emailAPITemplateVO.emailSubject);

			// start template
				MimeMultipart _mulPart = new MimeMultipart();
				BodyPart _bodyPart = new MimeBodyPart();
				
				// HTML mail content
				String htmlText =this.getHtml(createFinalEmailKeywordsMap(emailAPITemplateVO.getEmailKewords(),realValues), emailAPITemplateVO);
				System.out.println(htmlText);
				
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
	 * @param emailAPITemplateVO
	 * @return
	 * @throws IOException
	 */
	protected String getHtml(Map<String, String> input,EmailAPITemplateVO emailAPITemplateVO) throws IOException {
		String msg=emailAPITemplateVO.emailTemplate;
		
		Set<Entry<String, String>> entries = input.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			System.out.println("getHtml :: "+ entry.getKey().trim() + " >> "+ entry.getValue().trim());
			msg = msg.replace(entry.getKey().trim(), entry.getValue().trim());
		}
		return msg;
	}
	
	/**
	 * Desc:- create and returns the final keywords Map
	 * @param emailKeywords
	 * @param realValues
	 * @return
	 */
	private Map<String,String> createFinalEmailKeywordsMap(Map<String,String> emailKeywords, Map<String,String> realValues){
		Map<String,String> finalEmailKeywordsMap= new HashMap<String,String>();
		for (String emailKeywordskey : emailKeywords.keySet()){
			finalEmailKeywordsMap.put(emailKeywords.get(emailKeywordskey), realValues.get(emailKeywordskey));
		}
		System.out.println("createFinalEmailKeywordsMap :: "+ finalEmailKeywordsMap);
		return finalEmailKeywordsMap;
	}
	
	public void setTo(String to) {
		this.to = to;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
