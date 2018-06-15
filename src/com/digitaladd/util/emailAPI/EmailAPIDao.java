package com.digitaladd.util.emailAPI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.digitaladd.common.DBConnectionHandler;
import com.digitaladd.util.ResourceUtility;

public class EmailAPIDao {
	private static EmailAPIDao instance;
	
	public static synchronized EmailAPIDao getInstance() {
		if(instance==null) {
			instance = new EmailAPIDao();
		}
		return instance;
	}
	
	private EmailAPIDao() {
		super();
		//no-op
	}
	
	/**
	 * @param emailAPITemplateVO
	 * @return
	 */
	public boolean saveEmailTemplate(EmailAPITemplateVO emailAPITemplateVO) {
		boolean flag=false;
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		EmailAPITemplateVO vo = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("save.email.template"));
			preparedStmt.setString(1, emailAPITemplateVO.getEmailTemplateId());
			preparedStmt.setString(2, emailAPITemplateVO.getEmailTemplate());
			preparedStmt.setString(3, emailAPITemplateVO.getEmailSubject());
			preparedStmt.setString(4, emailAPITemplateVO.getCreatedDate());
			preparedStmt.setString(5, emailAPITemplateVO.getCreatedBy());
			preparedStmt.setString(6, emailAPITemplateVO.getUpdatedDate());
			preparedStmt.setString(7, emailAPITemplateVO.getUpdatedBy());
			preparedStmt.setInt(8, emailAPITemplateVO.getStatus());
			preparedStmt.setString(9, emailAPITemplateVO.getComments());
			
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
	 * @param emailTemplateTypeId
	 * @return EmailTemplateVO
	 */
	public EmailAPITemplateVO getEmailTemplateDetailsByTemplateId(String emailTemplateTypeId) {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		EmailAPITemplateVO vo = null;
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("get.email.templatedetails.master.by.id"));
			preparedStmt.setString(1, emailTemplateTypeId);
			rs = preparedStmt.executeQuery();
			
			if (rs != null) {
				if (rs.next()) {
					vo = new EmailAPITemplateVO();
					vo.setEmailTemplateId(rs.getString("EMAIL_TEMPLATE_DETAILS_ID"));
					vo.setEmailTemplate(rs.getString("EMAIL_TEMPLATE_TEXT"));
					vo.setEmailSubject(rs.getString("EMAIL_SUBJECT"));
					vo.setEmailKewords(this.getEmailTemplateKeywordsList(emailTemplateTypeId));
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
	private HashMap<String, String> getEmailTemplateKeywordsList(String emailTemplateDetailsId){
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		Map<String,String> emailTemplateKeywordsMap=new HashMap<String,String>();
		try {
			connection = DBConnectionHandler.getDBConnection();
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("get.email.templatekeywords.by.id"));
			preparedStmt.setString(1, emailTemplateDetailsId);
			rs = preparedStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					emailTemplateKeywordsMap.put(rs.getString("EMAIL_TEMPLATE_KEYWORDS_ID"), rs.getString("EMAIL_TEMPLATE_KEYWORDS"));
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
		return (HashMap<String, String>) emailTemplateKeywordsMap;
	}
	
	/**
	 * @Desc method returns email config
	 * @return EmailConfigVO
	 */
	public EmailAPIConfigVO getEmailSMTPConfig() {
		Connection connection=null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		EmailAPIConfigVO vo = null;
		vo = new  EmailAPIConfigVO();
		try {			
			connection = DBConnectionHandler.getDBConnection();						
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("get.email.SMTPConfig.master.by.id"));
			rs = preparedStmt.executeQuery();
						
			if (rs != null) {
				while (rs.next()) {
					
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
		
		/*vo.setHost(ResourceUtility.getCommonConstant("email.smtp.host"));
		vo.setPort(ResourceUtility.getCommonConstant("email.smtp.port"));
		vo.setUserName(ResourceUtility.getCommonConstant("email.smtp.username"));
		vo.setPassword(ResourceUtility.getCommonConstant("email.smtp.password"));*/
		
		return vo;
	}
}
