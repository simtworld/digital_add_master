package com.digitaladd.dao.password;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.digitaladd.common.DBConnectionHandler;
import com.digitaladd.util.ResourceUtility;

@Repository("passwordDao")
public class PasswordDaoImpl implements PasswordDao {

	@Override
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

	
	@Override
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
