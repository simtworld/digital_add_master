package com.digitaladd.registration.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.digitaladd.common.DBConnectionHandler;
import com.digitaladd.registration.model.ProductDetails;
import com.digitaladd.registration.model.User;
import com.digitaladd.util.ResourceUtility;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RegistrationDao {
	// singleton implementation
	private RegistrationDao() {
		// super(DataSources.DEFAULT);
	}

	// singleton implementation
	public static RegistrationDao getInstance() {
		return RegistrationDaoHolder.INSTANCE;
	}

	// singleton implementation
	private static class RegistrationDaoHolder {
		private static final RegistrationDao INSTANCE = new RegistrationDao();
	}

	public List<User> getCountreies() {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		List<User> list = new ArrayList<User>();
		try {
			connection = DBConnectionHandler.getDBConnection();
			// Class.forName("com.mysql.jdbc.Driver");
			// connection =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/digitaladd","root",
			// "");

			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.getAllCountries"));

			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					User user = new User();

					user.setCountryCode(rs.getString("id"));
					user.setCountryName(rs.getString("name"));

					list.add(user);
				}
			}
		} catch (SQLException sx) {
			System.out.println("RegistrationDao > getCountreies() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > getCountreies() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return list;
	}

	public List<User> getAllStates(String countryCode) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		List<User> list = new ArrayList<User>();
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.getAllStates"));
			preparedStmt.setString(1, countryCode);

			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					User user = new User();

					user.setStateCode(rs.getString("id"));
					user.setStateName(rs.getString("name"));

					list.add(user);
				}
			}
		} catch (SQLException sx) {
			System.out.println("RegistrationDao > getAllStates() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > getAllStates() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return list;
	}

	public List<User> getAllCities(String stateCode) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		List<User> list = new ArrayList<User>();
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.getAllCities"));
			preparedStmt.setString(1, stateCode);

			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					User user = new User();

					user.setCityCode(rs.getString("id"));
					user.setCityName(rs.getString("name"));

					list.add(user);
				}
			}
		} catch (SQLException sx) {
			System.out.println("RegistrationDao > getAllCities() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > getAllCities() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return list;
	}

	public User checkUserExistOrNot(String mobile) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		User retUser = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.getUserDataWithMobile"));
			preparedStmt.setString(1, mobile);

			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					retUser = new User();

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

	public boolean customerRegistration(User user) {
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

	public boolean saveOtp(String mobile, String otp) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		boolean flag = false;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.insertOTP"));

			// StringBuffer buffer = new
			// StringBuffer(ResourceUtility.getCommonConstant("user.uuid.starts.with"));
			// buffer.append(RandomGenerator.generateNumericRandom(Integer.parseInt(ResourceUtility.getCommonConstant("user.uuid.length"))));

			preparedStmt.setString(1, mobile);
			preparedStmt.setString(2, otp);

			int i = preparedStmt.executeUpdate();

			if (i > 0) {
				flag = true;
			}
		} catch (SQLException sx) {
			System.out.println("RegistrationDao > saveOtp() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > saveOtp() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return flag;
	}

	public boolean deleteOtp(String otp, String mobile) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		boolean flag = false;
		try {
			connection = DBConnectionHandler.getDBConnection();

			String query = ResourceUtility.getSqlQuery("digitalAdd.deleteOTP");

			if (otp != null && !"".equalsIgnoreCase(otp)) {
				query += " and otp = ?";
			}

			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, mobile);
			if (otp != null && !"".equalsIgnoreCase(otp)) {
				preparedStmt.setString(2, otp);
			}

			int i = preparedStmt.executeUpdate();

			if (i > 0) {
				flag = true;
			}
		} catch (SQLException sx) {
			System.out.println("RegistrationDao > deleteOtp() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > deleteOtp() > exception >" + e);
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
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return flag;
	}

	public User checkUserLogin(String userName, String password) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		User retUser = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection
					.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.getUserDataWithMobileAndPassword"));
			preparedStmt.setString(1, userName);
			preparedStmt.setString(2, password);

			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					retUser = new User();

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
			System.out.println("RegistrationDao > changeUserStatus() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > changeUserStatus() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return retUser;
	}

	public boolean updateProfile(User user) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		boolean flag = false;
		try {
			connection = DBConnectionHandler.getDBConnection();

			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.updateProifle"));
			preparedStmt.setString(1, user.getFirstName());
			preparedStmt.setString(2, user.getLastName());
			preparedStmt.setString(3, user.getEmail());
			preparedStmt.setString(4, user.getCountryCode());
			preparedStmt.setString(5, user.getStateCode());
			preparedStmt.setString(6, user.getCityCode());
			preparedStmt.setString(7, user.getAddress());
			preparedStmt.setString(8, user.getUuid());

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

	public boolean checkPassword(String uuid, String password) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		boolean flag = false;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.checkPassword"));
			preparedStmt.setString(1, uuid);
			preparedStmt.setString(2, password);

			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					int val = rs.getInt("count");

					if (val > 0) {
						flag = true;
					}
				}
			}
		} catch (SQLException sx) {
			System.out.println("RegistrationDao > checkPassword() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > checkPassword() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return flag;
	}

	public boolean updatePassword(String uuid, String passowrd) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		boolean flag = false;
		try {
			connection = DBConnectionHandler.getDBConnection();

			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.updatePassword"));
			preparedStmt.setString(1, passowrd);
			preparedStmt.setString(2, uuid);

			int i = preparedStmt.executeUpdate();

			if (i > 0) {
				flag = true;
			}
		} catch (SQLException sx) {
			System.out.println("RegistrationDao > updatePassword() > sqlexception >" + sx);
		} catch (Exception e) {
			System.out.println("RegistrationDao > updatePassword() > exception >" + e);
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return flag;
	}

	
}
