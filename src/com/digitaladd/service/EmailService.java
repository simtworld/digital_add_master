package com.digitaladd.service;

import java.util.HashMap;
import java.util.Map;

import com.digitaladd.dao.ProductDao;
import com.digitaladd.model.ProductDetailsMO;
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
	
	public boolean sendProductMail(String productUUID, String recipiant) {
		ProductDetailsMO productDetailsMO = ProductDao.getInstance().getProductDetailsById(productUUID);
		System.out.println(productDetailsMO.getProductName());
		Map<String,String> realValues=new HashMap<String,String>();
		
		realValues.put("ProductUUID", productDetailsMO.getProductUuid());
		realValues.put("ProductName", productDetailsMO.getProductName());
		realValues.put("ProductUrl", productDetailsMO.getProductUrl());
		realValues.put("ProductImageExtension", productDetailsMO.getProductImageExtension());
		realValues.put("ProductDescriptionForEmail", productDetailsMO.getProductDescriptionForEmail());
		realValues.put("Country", productDetailsMO.getCountry());
		realValues.put("State", productDetailsMO.getState());
		realValues.put("City", productDetailsMO.getCity());
		System.out.println("sendProductMail >> " + realValues);
		return EmailAPIService.getInstance().sendMail("ProductEmail", realValues, recipiant);
		 
	}
	
	
	
}
