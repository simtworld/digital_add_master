package com.digitaladd.util.smsAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Component;

@Component
public class SMSAPIService {
	/**
	 * @Description: To get the SMS Template Master information for the provided
	 *               Template id
	 * @Date: Nov 22, 2017
	 * @param strTemplateId
	 * @return SMSAPITemplateVO
	 */
	public SMSAPITemplateVO getSmsTemplateByTemplateId(String strTemplateId) throws Exception {
		if (strTemplateId == null) {
			System.out.println("SMSAPIService > getSmsTemplateByTemplateId > template id null");
			throw new Exception("Invalid input");
		}

		return SMSAPIDao.getInstance().getSmsTemplateByTemplateId(strTemplateId);
	}

	/**
	 * @Description: Responsible to audit the SMS in data base
	 * @Date: Jan 3, 2014
	 * @param smsauditingVO
	 * @return boolean
	 */
	public boolean saveSmsAuditing(SMSAPIAuditingVO smsauditingVO) throws Exception {
		if (smsauditingVO == null) {
			System.out.println("SMSAPIService > saveSmsAuditing > vo null");
			throw new Exception();
		}
		int status = SMSAPIDao.getInstance().saveSmsAuditing(smsauditingVO);

		if (status > 0)
			return true;
		else
			return false;
	}

	/**
	 * @Description: Responsible to send the SMS
	 * @Date: Nov 22, 2017
	 * @param smsapivo
	 *            (smsTemplateId*,smsTo*,parameters)
	 * @return true | false
	 */
	public boolean sendSMS(SMSAPIVO smsapivo) throws Exception {
		return true;
		//FIXME remove return and coment in last build
		/*String isSMSRequired = ResourceUtility.getCommonConstant("flag.is.sms.required");
		boolean result = false;

		if (smsapivo == null) {
			throw new Exception("Invalid input");
		}
		if ("true".equalsIgnoreCase(isSMSRequired)) {
			String templateId = smsapivo.getSmsTemplateId();
			if (templateId != null && templateId.length() > 0) {
				SMSAPITemplateVO templateVO = getSmsTemplateByTemplateId(templateId);
				if (templateVO != null) {
					String msg = templateVO.getSmsTemplate();
					List<String> params = smsapivo.getParameters();
					if (params != null && params.size() > 0) {
						for (int i = 0; i < params.size(); i++) {
							if (msg.indexOf("{" + i + "}") != -1)
								msg = msg.replace("{" + i + "}", params.get(i));
						}
					}
					msg = msg.replaceAll("&", "%26");

					String url = ResourceUtility.getCommonConstant("sms.url");
					if (url != null && smsapivo.getSmsTo() != null && smsapivo.getSmsTo().size() > 0) {
						url = url.replace("{0}", smsapivo.getSmsTo().get(0));
						url = url.replace("{1}", msg);
						url = url.replace("{2}", ResourceUtility.getCommonConstant("sms.url.sender"));
						String resultStr = sendSMS(url);

						System.out.println("SMSAPIService> sendSMS > result:[" + resultStr + "]");
						if (resultStr != null
								&& resultStr.indexOf(ResourceUtility.getCommonConstant("sms.success")) != -1)
							result = true;
						else
							result = false;
					}
				}
			}
		} else {
			result = true;
		}

		return result;*/
	}

	public String sendSMS(String strURL) {
		StringBuffer finalStr = new StringBuffer();
		BufferedReader in = null;
		try {
			strURL = strURL.replace("%", "%25");
			strURL = strURL.replace(" ", "%20");
			// strURL=strURL.replace(":","%3a");
			strURL = strURL.replace("!", "%21");
			strURL = strURL.replace("@", "%40");
			strURL = strURL.replace("#", "%32");
			strURL = strURL.replace("$", "%24");

			URL url = new URL(strURL);
			URLConnection urlConnection = url.openConnection();

			in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				finalStr.append(inputLine);
		} catch (Exception e) {
			System.out.println("SMSAPIService > sendSMS : Exception:" + e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				System.out.println("SMSAPIService > sendSMS : IOException while closing stream:" + e);
			}
		}
		return finalStr.toString();
	}
}
