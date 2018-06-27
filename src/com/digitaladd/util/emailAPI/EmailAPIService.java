package com.digitaladd.util.emailAPI;

import java.util.Map;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailAPIService {
	private static EmailAPIService instance;

	private String to;
	private String from;

	static private String userName;
	static private String password;
	static private String host;
	static private String port;
	static private Properties props;

	static private EmailAPIDao emailAPIDao;

	static {
		configurEmailSMTP();
	}

	private EmailAPIService() {
		super();
	}

	public static synchronized EmailAPIService getInstance() {
		if (instance == null)
			instance = new EmailAPIService();
		return instance;
	}

	/**
	 * This method takes the input and send the mail to the respected recipaiant
	 * 
	 * @param templateTypeId
	 * @param realValues
	 * @param recipiant
	 * @return boolean
	 */
	public boolean sendMail(String templateTypeId, Map<String, String> realValues, String recipiant) {
		
		boolean flag=false;
		try {
		
		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		
		
		EmailAPIServiceThread emailAPIServiceThread=new EmailAPIServiceThread();
		
		emailAPIServiceThread.setRecipiant(recipiant);
		emailAPIServiceThread.setTemplateTypeId(templateTypeId);
		emailAPIServiceThread.setRealValues(realValues);
		emailAPIServiceThread.setFrom(userName);
		//emailAPIServiceThread.setEmailAPITemplateDetailsVO(emailAPITemplateDetailsVO);
		emailAPIServiceThread.setSession(session);
		
		System.out.println("EmailAPIService >> sendmail >> thread STARTED");
		emailAPIServiceThread.start();
		
		
		
		flag=true;
		}catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}

	/**
	 * @param emailAPITemplateDetailsVO
	 * @return
	 */
	public boolean changeEmailTemplate(EmailAPITemplateDetailsVO emailAPITemplateDetailsVO) {
		return emailAPIDao.saveEmailTemplate(emailAPITemplateDetailsVO);
	}

	public static void configurEmailSMTP() {

		emailAPIDao = EmailAPIDao.getInstance();

		EmailAPIConfigVO emailAPIConfigVO = emailAPIDao.getEmailSMTPConfig();

		userName = emailAPIConfigVO.getUserName();
		password = emailAPIConfigVO.getPassword();
		host = emailAPIConfigVO.getHost();
		port = emailAPIConfigVO.getPort();

//		System.out.println(userName);
//		System.out.println(password);
//		System.out.println(host);
//		System.out.println(port);

		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	}

	public boolean changeEmailConfig(EmailAPIConfigVO emailAPIConfigVO) {
		return emailAPIDao.changeEmailConfig(emailAPIConfigVO);
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setFrom(String from) {
		this.from = from;
	}
}
