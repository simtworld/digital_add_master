package com.digitaladd.util.emailAPI;

import java.io.Serializable;
import java.util.HashMap;

public class EmailAPITemplateDetailsVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6389346890160877587L;
	protected String emailTemplateDetailsId = null;
	protected String emailTemplateText = null;
	protected String emailSubject = null;
	protected HashMap<String, String> emailKewords = null;
	protected String createdDate = null;
	protected String createdBy = null;
	protected String updatedDate = null;
	protected String updatedBy = null;
	protected int status;
	protected String comments = null;

	/**
	 * @return the emailTemplateDetailsId
	 */
	public String getEmailTemplateDetailsId() {
		return emailTemplateDetailsId;
	}

	/**
	 * @param emailTemplateDetailsId
	 *            the emailTemplateDetailsId to set
	 */
	public void setEmailTemplateDetailsId(String emailTemplateId) {
		this.emailTemplateDetailsId = emailTemplateId;
	}

	/**
	 * @return the emailTemplate
	 * @deprecated Use {@link #getEmailTemplateText()} instead
	 */
	public String getEmailTemplate() {
		return getEmailTemplateText();
	}

	/**
	 * @return the emailTemplateText
	 */
	public String getEmailTemplateText() {
		return emailTemplateText;
	}

	/**
	 * @param emailTemplate
	 *            the emailTemplate to set
	 * @deprecated Use {@link #setEmailTemplateText(String)} instead
	 */
	public void setEmailTemplate(String emailTemplate) {
		setEmailTemplateText(emailTemplate);
	}

	/**
	 * @param emailTemplateText
	 *            the emailTemplateText to set
	 */
	public void setEmailTemplateText(String emailTemplate) {
		this.emailTemplateText = emailTemplate;
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
		result = prime * result + ((emailTemplateText == null) ? 0 : emailTemplateText.hashCode());
		result = prime * result + ((emailTemplateDetailsId == null) ? 0 : emailTemplateDetailsId.hashCode());
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
		EmailAPITemplateDetailsVO other = (EmailAPITemplateDetailsVO) obj;
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
		if (emailTemplateText == null) {
			if (other.emailTemplateText != null)
				return false;
		} else if (!emailTemplateText.equals(other.emailTemplateText))
			return false;
		if (emailTemplateDetailsId == null) {
			if (other.emailTemplateDetailsId != null)
				return false;
		} else if (!emailTemplateDetailsId.equals(other.emailTemplateDetailsId))
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
