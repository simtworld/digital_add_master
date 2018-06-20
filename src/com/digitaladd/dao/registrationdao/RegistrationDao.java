package com.digitaladd.dao.registrationdao;

import java.util.List;

import com.digitaladd.model.UserMO;

public interface RegistrationDao {
	public UserMO checkUserExistOrNot(String mobile);
	public boolean customerRegistration(UserMO user);
	
	public boolean changeUserStatus(String mobile);
	public UserMO checkUserLogin(String userName, String password);
	public boolean updateProfile(UserMO user);
	
	//TODO Move to addressDao*
	public List<UserMO> getCountreies();
	public List<UserMO> getAllStates(String countryCode);
	public List<UserMO> getAllCities(String stateCode);
}
