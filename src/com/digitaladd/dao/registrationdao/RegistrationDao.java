package com.digitaladd.dao.registrationdao;

import com.digitaladd.model.UserMO;

public interface RegistrationDao {
	
	public UserMO checkUserExistOrNot(String mobile);
	public boolean customerRegistration(UserMO user);
	
	public boolean changeUserStatus(String mobile);
	public UserMO checkUserLogin(String userName, String password);
	public boolean updateProfile(UserMO user);
	
}
