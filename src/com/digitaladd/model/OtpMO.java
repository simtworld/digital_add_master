package com.digitaladd.model;

public class OtpMO {
	private String otp;
	private String mobile;
	private String doLogin;
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDoLogin() {
		return doLogin;
	}
	public void setDoLogin(String doLogin) {
		this.doLogin = doLogin;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OtpMO [otp=" + otp + ", mobile=" + mobile + ", doLogin=" + doLogin + "]";
	}
	
	
}
