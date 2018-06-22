package com.digitaladd.service.otpservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitaladd.dao.otpdao.OtpDao;
import com.digitaladd.dao.registrationdao.RegistrationDao;
import com.digitaladd.model.OtpMO;
import com.digitaladd.model.UserMO;
import com.digitaladd.service.smsservice.SmsService;
import com.digitaladd.util.RandomGenerator;
import com.digitaladd.util.ResourceUtility;

import net.sf.json.JSONObject;

@Service("otpService")
public class OtpServiceImpl implements OtpService {

	@Autowired
	RegistrationDao registrationDao;
	
	@Autowired
	OtpDao otpDao;

	@Autowired
	SmsService smsService;

	@Override
	public Map<String, Object> checkOtpService(OtpMO otpMO) {
		Map<String, Object> result = new HashMap<String, Object>();
		JSONObject jsonMap = new JSONObject();
		try {

			boolean flag = otpDao.deleteOtp(otpMO.getOtp(), otpMO.getMobile());

			if (flag) {
				boolean statusChange = registrationDao.changeUserStatus(otpMO.getMobile());

				if (statusChange) {
					jsonMap.put("status", true);
					result.put("status", true);
					if (otpMO.getDoLogin() != null && !"".equalsIgnoreCase(otpMO.getDoLogin())) {
						UserMO user = registrationDao.checkUserExistOrNot(otpMO.getMobile());
						result.put("user", user);
					}
				} else {
					jsonMap.put("status", "exception");
				}
			} else {
				jsonMap.put("status", false);
			}
		} catch (Exception e) {
			System.out.println("RequestController > customerRegistration() > exception >" + e);
		}

		result.put("jsonMap", jsonMap);
		return result;
	}

	@SuppressWarnings("unused")
	@Override
	public Map<String, Object> resendOtpService(OtpMO otpMO, String uuid) {
		Map<String, Object> result = new HashMap<>();
		try {
			String mobile = otpMO.getMobile();

			boolean flag = otpDao.deleteOtp(null, mobile);

			// if(flag){
			String otp = RandomGenerator
					.generateNumericRandom(Integer.parseInt(ResourceUtility.getCommonConstant("user.otp.length")));
			boolean saveOtp = otpDao.saveOtp(mobile, otp);
			if (saveOtp) {
				boolean sendSms = smsService.sendOtpSMS(mobile, otp, uuid);
			}

			if (saveOtp) {
				result.put("status", true);
			} else {
				result.put("status", "exception");
			}

		} catch (Exception e) {
			System.out.println("RequestController > customerRegistration() > exception >" + e);
			result.put("status", "exception");
		}
		
		return result;
	}


	
	@Override
	public boolean saveOtp(String mobile, String otp) {
		return otpDao.saveOtp(mobile, otp);
	}

}
