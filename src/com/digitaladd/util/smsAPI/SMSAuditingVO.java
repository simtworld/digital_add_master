package com.digitaladd.util.smsAPI;

public class SMSAuditingVO {
	private int smsId;
	private String smsTemplateId=null;
	private String sms=null;
	private String serviceProvidedId=null;
	private String smsSentDate=null;
	private String customerId=null;
	private String friendsMobileNumbers=null;
	private String uuid=null;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * @return the smsId
	 */
	public int getSmsId() {
		return smsId;
	}
	/**
	 * @param smsId the smsId to set
	 */
	public void setSmsId(int smsId) {
		this.smsId = smsId;
	}
	/**
	 * @return the smsTemplateId
	 */
	public String getSmsTemplateId() {
		return smsTemplateId;
	}
	/**
	 * @param smsTemplateId the smsTemplateId to set
	 */
	public void setSmsTemplateId(String smsTemplateId) {
		this.smsTemplateId = smsTemplateId;
	}
	/**
	 * @return the sms
	 */
	public String getSms() {
		return sms;
	}
	/**
	 * @param sms the sms to set
	 */
	public void setSms(String sms) {
		this.sms = sms;
	}
	/**
	 * @return the serviceProvidedId
	 */
	public String getServiceProvidedId() {
		return serviceProvidedId;
	}
	/**
	 * @param serviceProvidedId the serviceProvidedId to set
	 */
	public void setServiceProvidedId(String serviceProvidedId) {
		this.serviceProvidedId = serviceProvidedId;
	}
	/**
	 * @return the smsSentDate
	 */
	public String getSmsSentDate() {
		return smsSentDate;
	}
	/**
	 * @param smsSentDate the smsSentDate to set
	 */
	public void setSmsSentDate(String smsSentDate) {
		this.smsSentDate = smsSentDate;
	}
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the friendsMobileNumbers
	 */
	public String getFriendsMobileNumbers() {
		return friendsMobileNumbers;
	}
	/**
	 * @param friendsMobileNumbers the friendsMobileNumbers to set
	 */
	public void setFriendsMobileNumbers(String friendsMobileNumbers) {
		this.friendsMobileNumbers = friendsMobileNumbers;
	}
}
