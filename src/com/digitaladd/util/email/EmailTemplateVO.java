package com.digitaladd.util.email;

import java.io.Serializable;
import java.util.HashMap;

public class EmailTemplateVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6389346890160877587L;
	protected String emailTemplateId = null;
	protected String emailTemplate = null;
	protected String emailSubject = null;
	protected HashMap<String, String> emailKewords = null;
	protected String createdDate = null;
	protected String createdBy = null;
	protected String updatedDate = null;
	protected String updatedBy = null;
	protected int status;
	protected String comments = null;

	/**
	 * @return the emailTemplateId
	 */
	public String getEmailTemplateId() {
		return emailTemplateId;
	}

	/**
	 * @param emailTemplateId
	 *            the emailTemplateId to set
	 */
	public void setEmailTemplateId(String emailTemplateId) {
		this.emailTemplateId = emailTemplateId;
	}

	/**
	 * @return the emailTemplate
	 */
	public String getEmailTemplate() {
		return emailTemplate;
	}

	/**
	 * @param emailTemplate
	 *            the emailTemplate to set
	 */
	public void setEmailTemplate(String emailTemplate) {
		this.emailTemplate = emailTemplate;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 *            the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((emailKewords == null) ? 0 : emailKewords.hashCode());
		result = prime * result + ((emailSubject == null) ? 0 : emailSubject.hashCode());
		result = prime * result + ((emailTemplate == null) ? 0 : emailTemplate.hashCode());
		result = prime * result + ((emailTemplateId == null) ? 0 : emailTemplateId.hashCode());
		result = prime * result + status;
		result = prime * result + ((updatedBy == null) ? 0 : updatedBy.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmailTemplateVO other = (EmailTemplateVO) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (emailKewords == null) {
			if (other.emailKewords != null)
				return false;
		} else if (!emailKewords.equals(other.emailKewords))
			return false;
		if (emailSubject == null) {
			if (other.emailSubject != null)
				return false;
		} else if (!emailSubject.equals(other.emailSubject))
			return false;
		if (emailTemplate == null) {
			if (other.emailTemplate != null)
				return false;
		} else if (!emailTemplate.equals(other.emailTemplate))
			return false;
		if (emailTemplateId == null) {
			if (other.emailTemplateId != null)
				return false;
		} else if (!emailTemplateId.equals(other.emailTemplateId))
			return false;
		if (status != other.status)
			return false;
		if (updatedBy == null) {
			if (other.updatedBy != null)
				return false;
		} else if (!updatedBy.equals(other.updatedBy))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		return true;
	}

	/**
	 * @return the emailSubject
	 */
	public String getEmailSubject() {
		return emailSubject;
	}

	/**
	 * @param emailSubject
	 *            the emailSubject to set
	 */
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	/**
	 * @return the emailKewords
	 */
	public HashMap<String, String> getEmailKewords() {
		return emailKewords;
	}

	/**
	 * @param emailKewords the emailKewords to set
	 */
	public void setEmailKewords(HashMap<String, String> emailKewords) {
		this.emailKewords = emailKewords;
	}
}
