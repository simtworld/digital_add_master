package com.digitaladd.service.password;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitaladd.dao.password.PasswordDao;
import com.digitaladd.dao.registrationdao.RegistrationDao;
import com.digitaladd.model.UserMO;
import com.digitaladd.util.ResourceUtility;
import com.digitaladd.util.smsAPI.SMSAPIAuditingVO;
import com.digitaladd.util.smsAPI.SMSAPIService;
import com.digitaladd.util.smsAPI.SMSAPITemplateVO;
import com.digitaladd.util.smsAPI.SMSAPIVO;

@Service("passwordService")
public class PasswordServiceImpl implements PasswordService {
	
	@Autowired
	RegistrationDao registrationDao;
	
	@Autowired
	PasswordDao passwordDao;

	@Override
	public Map<String, Object> forgotPassword(String mobile) {
		Map<String, Object> result= new HashMap<>();
		
		try {
			UserMO retUser = registrationDao.checkUserExistOrNot(mobile);

			if (retUser != null) {
				SMSAPITemplateVO smsTemplateVO = new SMSAPITemplateVO();
				SMSAPIService service = new SMSAPIService();
				SMSAPIAuditingVO smsAuditingVO = new SMSAPIAuditingVO();
				SMSAPIVO smsapivo = new SMSAPIVO();
				smsTemplateVO = service.getSmsTemplateByTemplateId(
						ResourceUtility.getCommonConstant("sms.template.id.forgot.password"));

				String smsTemplateId = smsTemplateVO.getSmsTemplateId();

				if (smsTemplateId != null && !"".equals(smsTemplateId)) {
					smsAuditingVO.setSmsTemplateId(smsTemplateId);
					smsapivo.setSmsTemplateId(smsTemplateId);
				}
				String smsbody = smsTemplateVO.getSmsTemplate();
				if (smsbody != null && !"".equals(smsbody)) {
					smsbody = smsbody.replace("{0}", retUser.getMobile());
					smsbody = smsbody.replace("{1}", retUser.getPassword());

					System.out.println("RequestController > forgotPassword > smsTemp====>" + smsbody);
					smsAuditingVO.setSms(smsbody);
				}
				// save sms in audit table
				smsAuditingVO.setUuid(retUser.getUuid());
				service.saveSmsAuditing(smsAuditingVO);

				// send sms
				List<String> vCode = new ArrayList<String>();
				List<String> mNumber = new ArrayList<String>();

				vCode.add(retUser.getMobile());
				vCode.add(retUser.getPassword());
				mNumber.add(retUser.getMobile());

				smsapivo.setSmsTo(mNumber);
				smsapivo.setParameters(vCode);

				boolean flag = service.sendSMS(smsapivo);

				result.put("status", flag);

				System.out.println("RequestController > forgotPassword > send sms > " + flag);
			} else {
				result.put("status", "Mobile Not Exists");
			}
		} catch (Exception e) {
			System.out.println("PasswordServiceImpl > forgotPassword() > exception >" + e);
			result.put("status", "exception");
		}
		return result;
	}

	@Override
	public boolean checkPassword(String uuid, String password) {
		return passwordDao.checkPassword(uuid, password);
	}

	@Override
	public boolean updatePassword(String uuid, String passowrd) {
		return passwordDao.updatePassword(uuid, passowrd);
	}

}
