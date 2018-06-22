package com.digitaladd.dao.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.digitaladd.common.DBConnectionHandler;
import com.digitaladd.model.CityMO;
import com.digitaladd.model.CountryMO;
import com.digitaladd.model.StateMO;
import com.digitaladd.util.ResourceUtility;

@Repository
public class AddressDAOImpl implements AddressDAO {
	
	@Override
	public List<CountryMO> getCountreies() {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		List<CountryMO> list = new ArrayList<CountryMO>();
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
					CountryMO countryMO = new CountryMO();

					countryMO.setCountryCode(rs.getString("id"));
					countryMO.setCountryName(rs.getString("name"));

					list.add(countryMO);
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

	@Override
	public List<StateMO> getAllStates(String countryCode) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		List<StateMO> list = new ArrayList<StateMO>();
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.getAllStates"));
			preparedStmt.setString(1, countryCode);

			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					StateMO stateMO = new StateMO();

					stateMO.setStateCode(rs.getString("id"));
					stateMO.setStateName(rs.getString("name"));

					list.add(stateMO);
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

	@Override
	public List<CityMO> getAllCities(String stateCode) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		List<CityMO> list = new ArrayList<CityMO>();
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("digitalAdd.getAllCities"));
			preparedStmt.setString(1, stateCode);

			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					CityMO cityMO = new CityMO();

					cityMO.setCityCode(rs.getString("id"));
					cityMO.setCityName(rs.getString("name"));

					list.add(cityMO);
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


}
