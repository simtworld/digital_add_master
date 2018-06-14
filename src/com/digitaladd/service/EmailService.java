package com.digitaladd.service;

import com.digitaladd.util.emailAPI.EmailAPIService;
import com.digitaladd.util.emailAPI.EmailAPITemplateVO;

public class EmailService {
	private static EmailService instance;
	
	
	public static EmailService getInstance() {
		if(instance==null)
			instance=new EmailService();
		return instance;
	}
	
	private EmailService() {
		super();
		// TODO Auto-generated constructor stub
	}




	public boolean changeEmailTemplateService(EmailAPITemplateVO emailAPITemplateVO) {
		return EmailAPIService.getInstance().changeEmailTemplate(emailAPITemplateVO);
	}
	
	public boolean sendProductMail(String emailTemplateId) {
		
		return false;
	}
	
	
	
}
