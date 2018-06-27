package com.digitaladd.util.emailAPI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.digitaladd.common.DBConnectionHandler;
import com.digitaladd.util.ResourceUtility;

@Repository
public class EmailAPIDao {
	private static EmailAPIDao instance;
	static Map<String,Object> cache=new Hashtable<String,Object>();
	private int count=1;
	private int count2=1;
	protected static synchronized EmailAPIDao getInstance() {
		if (instance == null) {
			instance = new EmailAPIDao();
		}
		return  instance;
	}

	private EmailAPIDao() {
		super();
		// no-op
	}

	/**
	 * @param emailAPITemplateDetailsVO
	 * @return
	 */
	protected boolean saveEmailTemplate(EmailAPITemplateDetailsVO emailAPITemplateDetailsVO) {
		boolean flag = false;
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("save.email.template"));
			preparedStmt.setString(1, emailAPITemplateDetailsVO.getEmailTemplateDetailsId());
			preparedStmt.setString(2, emailAPITemplateDetailsVO.getEmailTemplateText());
			preparedStmt.setString(3, emailAPITemplateDetailsVO.getEmailSubject());
			preparedStmt.setString(4, emailAPITemplateDetailsVO.getCreatedDate());
			preparedStmt.setString(5, emailAPITemplateDetailsVO.getCreatedBy());
			preparedStmt.setString(6, emailAPITemplateDetailsVO.getUpdatedDate());
			preparedStmt.setString(7, emailAPITemplateDetailsVO.getUpdatedBy());
			preparedStmt.setInt(8, emailAPITemplateDetailsVO.getStatus());
			preparedStmt.setString(9, emailAPITemplateDetailsVO.getComments());

			int i = preparedStmt.executeUpdate();
			if (i != 0) {
				flag = true;
			}

		} catch (SQLException sx) {
			System.out.println("EmailDao > saveEmailTemplate() > sqlexception >" + sx);
			sx.printStackTrace();
		} catch (Exception e) {
			System.out.println("EmailDao > saveEmailTemplate() > exception >" + e);
			e.printStackTrace();
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return flag;
	}

	/**
	 * @param emailTemplateTypeId
	 * @return EmailTemplateVO
	 */
	protected synchronized EmailAPITemplateDetailsVO getEmailTemplateDetailsByTemplateId(String emailTemplateTypeId) {
		
		if(cache.containsKey("EmailTemplateDetails"+emailTemplateTypeId)) {
			return  (EmailAPITemplateDetailsVO) cache.get("EmailTemplateDetails"+emailTemplateTypeId);
		}
		
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		EmailAPITemplateDetailsVO vo = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			System.out.println("getEmailTemplateDetailsByTemplateId TEST "+count2+++"  "+connection);
			
			preparedStmt = connection
					.prepareStatement(ResourceUtility.getSqlQuery("get.email.templatedetails.master.by.id"));
			preparedStmt.setString(1, emailTemplateTypeId);
			rs = preparedStmt.executeQuery();

			if (rs != null) {
				if (rs.next()) {
					vo = new EmailAPITemplateDetailsVO();
					vo.setEmailTemplateDetailsId(rs.getString("EMAIL_TEMPLATE_DETAILS_ID"));
					vo.setEmailTemplateText(rs.getString("EMAIL_TEMPLATE_TEXT"));
					vo.setEmailSubject(rs.getString("EMAIL_SUBJECT"));
					vo.setEmailKewords(getEmailTemplateKeywordsList(emailTemplateTypeId));
					vo.setCreatedDate(rs.getString("CREATED_DATE"));
					vo.setCreatedBy(rs.getString("CREATED_BY"));
					vo.setUpdatedDate(rs.getString("UPDATED_DATE"));
					vo.setUpdatedBy(rs.getString("UPDATED_BY"));
					vo.setStatus(rs.getInt("STATUS"));
					vo.setComments(rs.getString("COMMENTS"));
				}
			}
		} catch (SQLException sx) {
			System.out.println("EmailDao > getEmailTemplateByTemplateId() > sqlexception >" + sx);
			sx.printStackTrace();
		} catch (Exception e) {
			System.out.println("EmailDao > getEmailTemplateByTemplateId() > exception >" + e);
			e.printStackTrace();
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		
		cache.put("EmailTemplateDetails"+emailTemplateTypeId, vo);
		
		System.out.println(cache.keySet());
		
		return  (EmailAPITemplateDetailsVO) cache.get("EmailTemplateDetails"+emailTemplateTypeId);
	}

	/**
	 * @param emailTemplateDetailsId
	 * @return
	 */
	private synchronized HashMap<String, String> getEmailTemplateKeywordsList(String emailTemplateDetailsId) {
		
		if(cache.containsKey("EmailTemplateKeywordsList"+emailTemplateDetailsId)) {
			return (HashMap<String, String>) cache.get("EmailTemplateKeywordsList"+emailTemplateDetailsId);
		}
		
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		Map<String, String> emailTemplateKeywordsMap = new HashMap<String, String>();
		try {
			connection = DBConnectionHandler.getDBConnection();
			System.out.println("getEmailTemplateKeywordsList TEST "+count+++"  "+connection);
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("get.email.templatekeywords.by.id"));
			preparedStmt.setString(1, emailTemplateDetailsId);
			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					emailTemplateKeywordsMap.put(rs.getString("EMAIL_TEMPLATE_KEYWORDS_ID"),
							rs.getString("EMAIL_TEMPLATE_KEYWORDS"));
				}
			}
		} catch (SQLException sx) {
			System.out.println("EmailDao > getEmailTemplateKeywordsList() > sqlexception >" + sx);
			sx.printStackTrace();
		} catch (Exception e) {
			System.out.println("EmailDao > getEmailTemplateKeywordsList() > exception >" + e);
			e.printStackTrace();
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		
		cache.put("EmailTemplateKeywordsList"+emailTemplateDetailsId, emailTemplateKeywordsMap);
		System.out.println(cache.keySet());
		
		return (HashMap<String, String>) cache.get("EmailTemplateKeywordsList"+emailTemplateDetailsId);
	}

	/**
	 * @Desc method returns email config
	 * @return EmailConfigVO
	 */
	protected EmailAPIConfigVO getEmailSMTPConfig() {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		EmailAPIConfigVO vo = null;
		vo = new EmailAPIConfigVO();
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection
					.prepareStatement(ResourceUtility.getSqlQuery("get.email.SMTPConfig.master.by.id"));
			rs = preparedStmt.executeQuery();

			if (rs != null) {
				if (rs.next()) {

					vo.setHost(rs.getString("HOST"));
					vo.setPassword(rs.getString("PASSWORD"));
					vo.setPort(rs.getString("PORT"));
					vo.setUserName(rs.getString("USER_NAME"));

				}
			}
		} catch (SQLException sx) {
			System.out.println("EmailDao > getEmailSMTPConfig() > sqlexception >" + sx);
			sx.printStackTrace();
		} catch (Exception e) {
			System.out.println("EmaolDao > getEmailSMTPConfig() > exception >" + e);
			e.printStackTrace();
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}

		/*
		 * vo.setHost(ResourceUtility.getCommonConstant("email.smtp.host"));
		 * vo.setPort(ResourceUtility.getCommonConstant("email.smtp.port"));
		 * vo.setUserName(ResourceUtility.getCommonConstant("email.smtp.username"));
		 * vo.setPassword(ResourceUtility.getCommonConstant("email.smtp.password"));
		 */

		return vo;
	}

	protected boolean changeEmailConfig(EmailAPIConfigVO emailAPIConfigVO) {
		boolean flag = false;
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("save.email.SMTPConfig.master.by.type"));

			preparedStmt.setString(1, emailAPIConfigVO.getUserName());
			preparedStmt.setString(2, emailAPIConfigVO.getPassword());
			preparedStmt.setString(3, emailAPIConfigVO.getHost());
			preparedStmt.setString(4, emailAPIConfigVO.getPort());
			preparedStmt.setString(4, emailAPIConfigVO.getConfigType());

			int i = preparedStmt.executeUpdate();
			if (i != 0) {
				flag = true;
			}

		} catch (SQLException sx) {
			System.out.println("EmailDao > saveEmailTemplate() > sqlexception >" + sx);
			sx.printStackTrace();
		} catch (Exception e) {
			System.out.println("EmailDao > saveEmailTemplate() > exception >" + e);
			e.printStackTrace();
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return flag;

	}
}
