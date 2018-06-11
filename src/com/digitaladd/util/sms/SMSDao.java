package com.digitaladd.util.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.digitaladd.common.DBConnectionHandler;
import com.digitaladd.util.ResourceUtility;

public class SMSDao {
	//singleton implementation
	private SMSDao() {
		//super(DataSources.DEFAULT);
	}
	//singleton implementation
	 public static SMSDao getInstance() {
	    return SMSDaoHolder.INSTANCE;
	 }
	//singleton implementation
    private static class SMSDaoHolder {
       private static final SMSDao INSTANCE = new SMSDao();
    }
	    
	public SMSTemplateVO getSmsTemplateByTemplateId(String templateId){
		Connection connection=null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		SMSTemplateVO vo = null;
		try {			
			connection = DBConnectionHandler.getDBConnection();						
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("get.sms.template.master.by.id"));
			preparedStmt.setString(1, templateId);
			rs = preparedStmt.executeQuery();
						
			if (rs != null) {
				while (rs.next()) {
					vo = new SMSTemplateVO();
					
					vo.setSmsTemplateId(rs.getString("SMS_TEMPLATE_ID"));
					vo.setSmsTemplate(rs.getString("SMS_TEMPLATE"));
					vo.setCreatedDate(rs.getString("CREATED_DATE"));
					vo.setCreatedBy(rs.getString("CREATED_BY"));
					vo.setUpdatedDate(rs.getString("UPDATED_DATE"));
					vo.setUpdatedBy(rs.getString("UPDATED_BY"));
					vo.setStatus(rs.getInt("STATUS"));
					vo.setComments(rs.getString("COMMENTS"));
				}
			} 
		}catch (SQLException sx) {
			System.out.println("SMSDao > getSmsTemplateByTemplateId() > sqlexception >"+sx);
		}catch (Exception e) {
			System.out.println("SMSDao > getSmsTemplateByTemplateId() > exception >"+e);
		}finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return vo;
	}
	
	public int saveSmsAuditing(SMSAuditingVO smsauditingVO){
		Connection connection=null;
		ResultSet rs = null;
		PreparedStatement preparedStmt = null;
		int i = 0;
		try {			
			connection = DBConnectionHandler.getDBConnection();						
			preparedStmt = connection.prepareStatement(ResourceUtility.getSqlQuery("insert.sms.auditing"));
			preparedStmt.setString(1, smsauditingVO.getSmsTemplateId());
			preparedStmt.setString(2, smsauditingVO.getSms());
			preparedStmt.setString(3, smsauditingVO.getUuid());
			i = preparedStmt.executeUpdate(); 
		}catch (SQLException sx) {
			System.out.println("SMSDao > saveSmsAuditing() > sqlexception >"+sx);
		}catch (Exception e) {
			System.out.println("SMSDao > saveSmsAuditing() > exception >"+e);
		}finally {
			DBConnectionHandler.closeJDBCResoucrs(connection, preparedStmt, rs);
		}
		return i;
	}
}
