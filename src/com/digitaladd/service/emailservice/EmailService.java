package com.digitaladd.service.emailservice;

import com.digitaladd.util.emailAPI.EmailAPIConfigVO;
import com.digitaladd.util.emailAPI.EmailAPITemplateDetailsVO;


public interface EmailService {
	
	public boolean changeEmailTemplateService(EmailAPITemplateDetailsVO emailAPITemplateDetailsVO);
	public boolean sendProductMail(String productUUID, String recipiant);
	public boolean changeEmailConfigService(EmailAPIConfigVO emailAPIConfigVO);
	
	
}
