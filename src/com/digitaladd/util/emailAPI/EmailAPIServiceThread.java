package com.digitaladd.util.emailAPI;

import com.digitaladd.util.emailAPI.EmailAPIDao;
import com.digitaladd.util.emailAPI.EmailAPITemplateDetailsVO;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Address;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailAPIServiceThread extends Thread {
	private String to;
	private String from;
	private String templateTypeId;
	private Map<String, String> realValues;
	private String recipiant;
	private Session session;
	
	static int count=1;
	
	EmailAPIDao emailAPIDao = EmailAPIDao.getInstance();

	public void run() {
		boolean flag = false;
		this.setTo(this.recipiant);
		EmailAPITemplateDetailsVO emailAPITemplateDetailsVO = this.emailAPIDao
				.getEmailTemplateDetailsByTemplateId(this.templateTypeId);

		try {
			MimeMessage e = new MimeMessage(this.session);
			e.setFrom(new InternetAddress(this.from));
			e.setRecipients(RecipientType.TO, InternetAddress.parse(this.to));
			e.setSubject(emailAPITemplateDetailsVO.emailSubject);
			MimeMultipart _mulPart = new MimeMultipart();
			MimeBodyPart _bodyPart = new MimeBodyPart();
			String htmlText = this.getHtml(
					this.createFinalEmailKeywordsMap(emailAPITemplateDetailsVO.getEmailKewords(), this.realValues),
					emailAPITemplateDetailsVO);
			_bodyPart.setContent(htmlText, "text/html");
			_mulPart.addBodyPart(_bodyPart);
			e.setContent(_mulPart);
			
			Transport.send(e);
			flag = true;
			System.out.println("Sent message successfully.... by "+Thread.currentThread().getName()+count++);
		} catch (IOException | MessagingException arg6) {
			flag = false;
			arg6.printStackTrace();
			throw new RuntimeException(arg6);
		}
	}

	protected String getHtml(Map<String, String> input, EmailAPITemplateDetailsVO emailAPITemplateDetailsVO)
			throws IOException {
		String msg = emailAPITemplateDetailsVO.emailTemplateText;
		Set entries = input.entrySet();

		Entry entry;
		for (Iterator arg5 = entries.iterator(); arg5
				.hasNext(); msg = msg.replace(((String) entry.getKey()).trim(), ((String) entry.getValue()).trim())) {
			entry = (Entry) arg5.next();
		}

		return msg;
	}

	private Map<String, String> createFinalEmailKeywordsMap(Map<String, String> emailKeywords,
			Map<String, String> realValues) {
		HashMap finalEmailKeywordsMap = new HashMap();
		Iterator arg4 = emailKeywords.keySet().iterator();

		while (arg4.hasNext()) {
			String emailKeywordskey = (String) arg4.next();
			finalEmailKeywordsMap.put((String) emailKeywords.get(emailKeywordskey),
					(String) realValues.get(emailKeywordskey));
		}

		return finalEmailKeywordsMap;
	}
	
	
	

	public String getTo() {
		return this.to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTemplateTypeId() {
		return this.templateTypeId;
	}

	public void setTemplateTypeId(String templateTypeId) {
		this.templateTypeId = templateTypeId;
	}

	public Map<String, String> getRealValues() {
		return this.realValues;
	}

	public void setRealValues(Map<String, String> realValues) {
		this.realValues = realValues;
	}

	public String getRecipiant() {
		return this.recipiant;
	}

	public void setRecipiant(String recipiant) {
		this.recipiant = recipiant;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	
}