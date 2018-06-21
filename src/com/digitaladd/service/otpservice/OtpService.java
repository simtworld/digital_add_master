package com.digitaladd.service.otpservice;

import java.util.Map;

import com.digitaladd.model.OtpMO;

public interface OtpService {
	 Map<String, Object> checkOtpService(OtpMO otpMO);
	 Map<String,Object> resendOtpService(OtpMO otpMO,String uuid);
	 boolean saveOtp(String mobile, String otp);
}
