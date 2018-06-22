package com.digitaladd.dao.registrationdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.digitaladd.common.DBConnectionHandler;
import com.digitaladd.model.UserMO;
import com.digitaladd.util.ResourceUtility;

@Repository("registrationDao")
public class RegistrationDaoImpl implements RegistrationDao {
	/*// singleton implementation
	private RegistrationDaoImpl() {
		// super(DataSources.DEFAULT);
	}

	// singleton implementation
	public static RegistrationDao getInstance() {
		return RegistrationDaoHolder.INSTANCE;
	}

	// singleton implementation
	private static class RegistrationDaoHolder {
		private static final RegistrationDao INSTANCE = new RegistrationDao();
	}*/

	public UserMO checkUserExistOrNot(String mobile) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		UserMO retUser = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.getUserDataWithMobile"));
			preparedStmt.setString(1, mobile);

			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					retUser = new UserMO();

					retUser.setCityCode(rs.getString("city_id"));
					retUser.setCountryCode(rs.getString("country_id"));
					retUser.setCreatedOn(rs.getString("created_at"));
					retUser.setEmail(rs.getString("email"));
					retUser.setEmailStatus(rs.getString("email_verfication_status"));
					retUser.setFirstName(rs.getString("fname"));
					retUser.setLastName(rs.getString("lname"));
					retUser.setMobile(rs.getString("mobile"));
					retUser.setMobileStatus(rs.getString("mobile_verfication_status"));
					retUser.setPassword(rs.getString("password"));
					retUser.setStateCode(rs.getString("state_id"));
					retUser.setModifiedOn(rs.getString("updated_at"));
					retUser.setUserTypeId(rs.getString("user_type_id"));
					retUser.setUuid(rs.getString("uuid"));

					retUser.setCountryName(rs.getString("country_name"));
					retUser.setStateName(rs.getString("state_name"));
					retUser.setCityName(rs.getString("city_name"));
					// retUser.setAddress(rs.getString("address"));
				}
			}
		} catch (SQLException sx) {
			System.out.println("RegistrationDao > checkUserExistOrNot() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > checkUserExistOrNot() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return retUser;
	}

	public boolean customerRegistration(UserMO user) {
		System.out.println(user);
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		boolean flag = false;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.insertUser"));

			preparedStmt.setString(1, user.getUuid()); // incremental umber of uuid
			preparedStmt.setString(2, user.getFirstName());
			preparedStmt.setString(3, user.getLastName());
			preparedStmt.setString(4, user.getEmail());
			preparedStmt.setString(5, user.getMobile());
			preparedStmt.setString(6, ResourceUtility.getCommonConstant("userTypeId.user"));
			preparedStmt.setString(7, ResourceUtility.getCommonConstant("status.inactive"));
			preparedStmt.setString(8, ResourceUtility.getCommonConstant("status.inactive"));
			preparedStmt.setString(9, user.getCountryCode());
			preparedStmt.setString(10, user.getStateCode());
			preparedStmt.setString(11, user.getCityCode());
			preparedStmt.setString(12, user.getPassword());
			preparedStmt.setString(13, ResourceUtility.getCommonConstant("status.inactive"));

			int i = preparedStmt.executeUpdate();

			if (i > 0) {
				flag = true;
			}
		} catch (SQLException sx) {
			System.out.println("RegistrationDao > customerRegistration() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > customerRegistration() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return flag;
	}

	public boolean changeUserStatus(String mobile) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		boolean flag = false;
		try {
			connection = DBConnectionHandler.getDBConnection();

			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.changeMobileStatus"));
			preparedStmt.setString(1, ResourceUtility.getCommonConstant("status.active"));
			preparedStmt.setString(2, mobile);

			int i = preparedStmt.executeUpdate();

			if (i > 0) {
				flag = true;
			}
		} catch (SQLException sx) {
			System.out.println("RegistrationDao > changeUserStatus() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > changeUserStatus() > exception >" + e);
			e.printStackTrace();
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return flag;
	}

	public UserMO checkUserLogin(String userName, String password) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		UserMO retUser = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			System.out.println("RegistrationDao > checkUserLogin() >> "+ connection);
			preparedStmt = connection
					.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.getUserDataWithMobileAndPassword"));
			preparedStmt.setString(1, userName);
			preparedStmt.setString(2, password);

			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					retUser = new UserMO();

					retUser.setCityCode(rs.getString("city_id"));
					retUser.setCountryCode(rs.getString("country_id"));
					retUser.setCreatedOn(rs.getString("created_at"));
					retUser.setEmail(rs.getString("email"));
					retUser.setEmailStatus(rs.getString("email_verfication_status"));
					retUser.setFirstName(rs.getString("fname"));
					retUser.setLastName(rs.getString("lname"));
					retUser.setMobile(rs.getString("mobile"));
					retUser.setMobileStatus(rs.getString("mobile_verfication_status"));
					retUser.setPassword(rs.getString("password"));
					retUser.setStateCode(rs.getString("state_id"));
					retUser.setModifiedOn(rs.getString("updated_at"));
					retUser.setUserTypeId(rs.getString("user_type_id"));
					retUser.setUuid(rs.getString("uuid"));

					retUser.setCountryName(rs.getString("country_name"));
					retUser.setStateName(rs.getString("state_name"));
					retUser.setCityName(rs.getString("city_name"));
					// retUser.setAddress(rs.getString("address"));
				}
			}
		} catch (SQLException sx) {
			System.out.println("RegistrationDao > checkUserLogin() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > checkUserLogin() > exception >" + e);
			e.printStackTrace();
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return retUser;
	}

	public boolean updateProfile(UserMO userMO) {
		//System.out.println("RegistrationDao > updateProfile() >> "+userMO);//for testing

		
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		boolean flag = false;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.updateProifle"));
			preparedStmt.setString(1, userMO.getFirstName());
			preparedStmt.setString(2, userMO.getLastName());
			preparedStmt.setString(3, userMO.getEmail());
			preparedStmt.setString(4, userMO.getCountryCode());
			preparedStmt.setString(5, userMO.getStateCode());
			preparedStmt.setString(6, userMO.getCityCode());
			preparedStmt.setString(7, userMO.getUuid());

			int i = preparedStmt.executeUpdate();

			if (i > 0) {
				flag = true;
			}
		} catch (SQLException sx) {
			System.out.println("RegistrationDao > updateProfile() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > updateProfile() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return flag;
	}

	
}
