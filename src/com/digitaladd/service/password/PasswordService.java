package com.digitaladd.service.password;

import java.util.Map;

public interface PasswordService {
	Map<String,Object> forgotPassword(String mobile);
	boolean checkPassword(String uuid, String password);
	public boolean updatePassword(String uuid, String passowrd);
}
