package com.digitaladd.util.smsAPI;

import java.util.List;

public class SMSVO {
	//SMS Template Id
			private String smsTemplateId = null;

			//SMS receiver MobileNumber
			private List<String> smsTo = null;
			
			//Dynamic parameters if any
			private List<String> parameters = null;

			
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
			 * @return the smsTo
			 */
			public List<String> getSmsTo() {
				return smsTo;
			}

			/**
			 * @param smsTo the smsTo to set
			 */
			public void setSmsTo(List<String> smsTo) {
				this.smsTo = smsTo;
			}

			/**
			 * @return the parameters
			 */
			public List<String> getParameters() {
				return parameters;
			}

			/**
			 * @param parameters the parameters to set
			 */
			public void setParameters(List<String> parameters) {
				this.parameters = parameters;
			}
}
