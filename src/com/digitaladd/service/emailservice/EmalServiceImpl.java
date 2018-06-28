package com.digitaladd.service.emailservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitaladd.dao.productdao.ProductDao;
import com.digitaladd.dao.productdao.ProductDaoImpl;
import com.digitaladd.model.ProductDetailsMO;
import com.digitaladd.util.RandomGenerator;
import com.digitaladd.util.ResourceUtility;
import com.digitaladd.util.emailAPI.EmailAPIConfigVO;
import com.digitaladd.util.emailAPI.EmailAPIService;
import com.digitaladd.util.emailAPI.EmailAPITemplateDetailsVO;

@Service("emailService")
public class EmalServiceImpl implements EmailService {
	
	@Autowired
	ProductDao productDao;
	

	@Override
	public boolean changeEmailTemplateService(EmailAPITemplateDetailsVO emailAPITemplateDetailsVO) {

		StringBuffer buffer = new StringBuffer(ResourceUtility.getCommonConstant("email.details.uuid.starts.with"));
		buffer.append(RandomGenerator.generateNumericRandom(
				Integer.parseInt(ResourceUtility.getCommonConstant("email.details.uuid.length"))));
		emailAPITemplateDetailsVO.setEmailTemplateDetailsId(buffer.toString());
		return EmailAPIService.getInstance().changeEmailTemplate(emailAPITemplateDetailsVO);

	}

	@Override
	public boolean sendProductMail(String productUUID, String recipiant) {
		ProductDetailsMO productDetailsMO = productDao.getProductDetailsById(productUUID);
		//System.out.println(productDetailsMO.getProductName());
		Map<String, String> realValues = new HashMap<String, String>();

		realValues.put("ProductUUID", productDetailsMO.getProductUuid());
		realValues.put("ProductName", productDetailsMO.getProductName());
		realValues.put("ProductUrl", productDetailsMO.getProductUrl());
		realValues.put("ProductImageExtension", productDetailsMO.getProductImageExtension());
		realValues.put("ProductDescriptionForEmail", productDetailsMO.getProductDescriptionForEmail());
		realValues.put("Country", productDetailsMO.getCountry());
		realValues.put("State", productDetailsMO.getState());
		realValues.put("City", productDetailsMO.getCity());
		// System.out.println("sendProductMail >> " + realValues);
		
		for(int i=0;i<50;i++) {
			EmailAPIService.getInstance().sendMail("ProductEmail", realValues, recipiant);
		}
		return true;

	}

	@Override
	public boolean changeEmailConfigService(EmailAPIConfigVO emailAPIConfigVO) {

		return false;
	}

}
