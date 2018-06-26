package com.digitaladd.dao.otpdao;

public interface OtpDao {
		public boolean saveOtp(String mobile, String otp);
		public boolean deleteOtp(String otp, String mobile);
		public String getOtp(String mobile);
}
