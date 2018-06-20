package com.digitaladd.dao.password;

public interface PasswordDao {

	public boolean checkPassword(String uuid, String password);
	public boolean updatePassword(String uuid, String passowrd);
		
}
