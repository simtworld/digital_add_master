package com.digitaladd.service.smsservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.digitaladd.util.ResourceUtility;
import com.digitaladd.util.smsAPI.SMSAPIService;
import com.digitaladd.util.smsAPI.SMSAPIAuditingVO;
import com.digitaladd.util.smsAPI.SMSAPITemplateVO;
import com.digitaladd.util.smsAPI.SMSAPIVO;


@Component
public class SmsService {
	/**
	 * @param mobile
	 * @param verificationCode
	 * @param uuid
	 * @return
	 * @date 6-19-2018
	 */
	public boolean sendOtpSMS(String mobile, String verificationCode, String uuid) {
		try {
			SMSAPIService service = new SMSAPIService();
			SMSAPIVO smsapivo = new SMSAPIVO();
			SMSAPITemplateVO smsApiTemplateVO = new SMSAPITemplateVO();
			SMSAPIAuditingVO smsApiAuditingVO = new SMSAPIAuditingVO();

			smsApiTemplateVO = service
					.getSmsTemplateByTemplateId(ResourceUtility.getCommonConstant("sms.template.id.send.otp"));

			String smsTemplateId = smsApiTemplateVO.getSmsTemplateId();
			if (smsTemplateId != null && !"".equals(smsTemplateId)) {
				smsApiAuditingVO.setSmsTemplateId(smsTemplateId);
				smsapivo.setSmsTemplateId(smsTemplateId);
			}
			String smsBody = smsApiTemplateVO.getSmsTemplate();
			if (smsBody != null && !"".equals(smsBody)) {
				smsBody = smsBody.replace("{0}", verificationCode);
			}
			smsApiAuditingVO.setSms(smsBody);
			smsApiAuditingVO.setUuid(uuid);
			service.saveSmsAuditing(smsApiAuditingVO);

			List<String> vCode = new ArrayList<String>();
			List<String> mNumber = new ArrayList<String>();

			vCode.add(verificationCode);
			mNumber.add(mobile);

			smsapivo.setSmsTo(mNumber);
			smsapivo.setParameters(vCode);
			service.sendSMS(smsapivo);
		} catch (Exception e) {
			System.out.println("SmsService > sendOtpSMS() > exception >" + e);
		}
		return true;
	}

}
