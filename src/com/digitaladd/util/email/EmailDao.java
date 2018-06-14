package com.digitaladd.util.email;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.digitaladd.common.DBConnectionHandler;
import com.digitaladd.util.ResourceUtility;

public class EmailDao {
	private static EmailDao instance;
	
	public static synchronized EmailDao getInstance() {
		if(instance==null) {
			instance = new EmailDao();
		}
		return instance;
	}
	
	private EmailDao() {
		super();
		//no-op
	}
	
	/**
	 * @param emailTemplateVO
	 * @return
	 */
	public boolean saveEmailTemplate(EmailTemplateVO emailTemplateVO) {
		boolean flag=false;
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		EmailTemplateVO vo = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("save.email.template"));
			preparedStmt.setString(1, emailTemplateVO.getEmailTemplateId());
			preparedStmt.setString(2, emailTemplateVO.getEmailTemplate());
			preparedStmt.setString(3, emailTemplateVO.getEmailSubject());
			preparedStmt.setString(4, emailTemplateVO.getCreatedDate());
			preparedStmt.setString(5, emailTemplateVO.getCreatedBy());
			preparedStmt.setString(6, emailTemplateVO.getUpdatedDate());
			preparedStmt.setString(7, emailTemplateVO.getUpdatedBy());
			preparedStmt.setInt(8, emailTemplateVO.getStatus());
			preparedStmt.setString(9, emailTemplateVO.getComments());
			
			int i = preparedStmt.executeUpdate();
			if(i!=0) {
				flag=true;
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
	 * @param emailTemplateId
	 * @return EmailTemplateVO
	 */
	public EmailTemplateVO getEmailTemplateByTemplateId(String emailTemplateId) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		EmailTemplateVO vo = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("get.sms.template.master.by.id"));
			preparedStmt.setString(1, emailTemplateId);
			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					vo = new EmailTemplateVO();
					vo.setEmailTemplateId(rs.getString("EMAIL_TEMPLATE_ID"));
					vo.setEmailTemplate(rs.getString("EMAIL_TEMPLATE"));
					vo.setEmailSubject(rs.getString("EMAIL_SUBJECT"));
					vo.setEmailKewords(this.getEmailTemplateKeywordsList(emailTemplateId));
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
		return vo;
	}

	/**
	 * @param emailTemplateId
	 * @return
	 */
	private HashMap<String, String> getEmailTemplateKeywordsList(String emailTemplateId){
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		Map<String,String> emailTemplateKeywordsList=new HashMap<String,String>();
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("get.sms.template.master.by.id"));
			preparedStmt.setString(1, emailTemplateId);
			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					emailTemplateKeywordsList.put(rs.getString("EMAIL_TEMPLATE_KEYWORDS_ID"), rs.getString("EMAIL_TEMPLATE_KEYWORDS"));
				}
			}
		}catch (SQLException sx) {
			System.out.println("EmailDao > getEmailTemplateKeywordsList() > sqlexception >" + sx);
			sx.printStackTrace();
		} catch (Exception e) {
			System.out.println("EmailDao > getEmailTemplateKeywordsList() > exception >" + e);
			e.printStackTrace();
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return (HashMap<String, String>) emailTemplateKeywordsList;
	}
	
	/**
	 * @Desc method returns email config
	 * @return EmailConfigVO
	 */
	public EmailConfigVO getEmailSMTPConfig() {
		Connection connection=null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		EmailConfigVO vo = null;
		try {			
			connection = DBConnectionHandler.getDBConnection();						
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("get.sms.template.master.by.id"));
			rs = preparedStmt.executeQuery();
						
			if (rs != null) {
				while (rs.next()) {
					vo = new  EmailConfigVO();
					vo.setHost(rs.getString("EMAIL_CONFIG_HOST"));
					vo.setPassword(rs.getString("EMAIL_CONFIG_PASSWORD"));
					vo.setPort(rs.getString("EMAIL_CONFIG_PORT"));
					vo.setUserName("EMAIL_CONFIG_USERNAME");
					
				}
			}
		}catch (SQLException sx) {
			System.out.println("EmailDao > getEmailSMTPConfig() > sqlexception >" + sx);
			sx.printStackTrace();
		} catch (Exception e) {
			System.out.println("EmaolDao > getEmailSMTPConfig() > exception >" + e);
			e.printStackTrace();
		} finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		
		return vo;
	}
}
