package com.digitaladd.service.emailservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.digitaladd.dao.productdao.ProductDao;
import com.digitaladd.model.ProductDetailsMO;
import com.digitaladd.util.RandomGenerator;
import com.digitaladd.util.ResourceUtility;
import com.digitaladd.util.emailAPI.EmailAPIConfigVO;
import com.digitaladd.util.emailAPI.EmailAPIService;
import com.digitaladd.util.emailAPI.EmailAPITemplateDetailsVO;


public interface EmailService {
	
	public boolean changeEmailTemplateService(EmailAPITemplateDetailsVO emailAPITemplateDetailsVO);
	public boolean sendProductMail(String productUUID, String recipiant);
	public boolean changeEmailConfigService(EmailAPIConfigVO emailAPIConfigVO);
	
	
}
