package com.digitaladd.dao.otpdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.digitaladd.common.DBConnectionHandler;
import com.digitaladd.util.ResourceUtility;

@Repository
public class OtpDaoImpl implements OtpDao {

	@Override
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

	
	@Override
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


	@Override
	public String getOtp(String mobile) {
		
		return null;
	}

}
