package com.digitaladd.service.userservice;

import java.util.Map;

import com.digitaladd.model.UserMO;

public interface UserService {
	Map<String,String> customerRegistrationService(UserMO userMO);
	Map<String,Object> checkUserLoginService(String userName, String password);
	Map<String,Object> updateProfileService(UserMO userMO);
	
}
