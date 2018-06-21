package com.digitaladd.service.userservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitaladd.dao.otpdao.OtpDao;
import com.digitaladd.dao.registrationdao.RegistrationDao;
import com.digitaladd.model.UserMO;
import com.digitaladd.service.smsservice.SmsService;
import com.digitaladd.util.RandomGenerator;
import com.digitaladd.util.ResourceUtility;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	SmsService smsService;
	
	@Autowired
	RegistrationDao registrationDao;
	
	@Autowired
	OtpDao otpDao;
	
	
	@Override
	public Map<String,String> customerRegistrationService(UserMO userMO) {
		
		Map<String,String> result=new HashMap<String,String>();
		try {
			
			UserMO retUser = registrationDao.checkUserExistOrNot(userMO.getMobile());

			if (retUser == null || "".equals(retUser)) {
				// create user
				StringBuffer buffer = new StringBuffer(ResourceUtility.getCommonConstant("user.uuid.starts.with"));
				buffer.append(RandomGenerator.generateNumericRandom(
						Integer.parseInt(ResourceUtility.getCommonConstant("user.uuid.length"))));

				userMO.setUuid(buffer.toString());
				// System.out.println("inside request controller" + buffer.toString());
				boolean flag = registrationDao.customerRegistration(userMO);

				if (flag) {
					boolean deleteOtp = otpDao.deleteOtp(null, userMO.getMobile());

					String otp = RandomGenerator.generateNumericRandom(
							Integer.parseInt(ResourceUtility.getCommonConstant("user.otp.length")));
					boolean saveOtp = otpDao.saveOtp(userMO.getMobile(), otp);
					if (saveOtp) {
						boolean sendSms = smsService.sendOtpSMS(userMO.getMobile(), otp, userMO.getUuid());
					}

					result.put("status", "true");
					result.put("uuid", userMO.getUuid());
				} else {
					result.put("status", "false");
				}
			} else {
				// user exists
				/*
				 * String mobStatus = retUser.getMobileStatus();
				 * 
				 * if(mobStatus != null && "1".equalsIgnoreCase(mobStatus)){ returnVal =
				 * "mobileEsixts"; }else{ returnVal = "mobileNeedToVerify"; }
				 */
				result.put("status", "mobileExists");
			}
		} catch (Exception e) {
			System.out.println("UserService > customerRegistrationService() > exception >" + e);
		}
		
		return result;
	}


	@Override
	public Map<String, Object> checkUserLoginService(String userName, String password) {
		Map<String, Object> result= new HashMap<>();
		Map<String, Object> jsonMap=new HashMap<>();
		try {

			UserMO user = registrationDao.checkUserLogin(userName, password);

			if (user == null) {
				jsonMap.put("status", false);
			} else {

				if (user.getMobileStatus() != null && user.getMobileStatus()
						.equalsIgnoreCase(ResourceUtility.getCommonConstant("status.active"))) {
					jsonMap.put("status", true);
					result.put("status", true);
					
					result.put("user", user);
					System.out.println(user.getUserTypeId());

				} else {
					jsonMap.put("status", "mobileNeedToVerify");
					jsonMap.put("uuid", user.getUuid());
					result.put("status", false);
				}
			}
		} catch (Exception e) {
			System.out.println("RequestController > checkUserLogin() > exception >" + e);
			e.printStackTrace();
			jsonMap.put("status", "exception");
		}
		result.put("jsonMap", jsonMap);
		return result;
	}


	@Override
	public Map<String,Object> updateProfileService(UserMO userMO) {
		Map<String,Object> result=new HashMap<>();
		boolean flag=registrationDao.updateProfile(userMO);
		if(flag) {
			result.put("userMO", registrationDao.checkUserExistOrNot(userMO.getMobile()) );
		}
		result.put("flag", flag);
		return result;
	}

}
