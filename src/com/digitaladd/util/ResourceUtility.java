package com.digitaladd.util;

import java.util.ResourceBundle;

public class ResourceUtility {
	final static ResourceBundle sqlMappings = ResourceBundle.getBundle("resources.SQLMappings");
	final static ResourceBundle commonConfig = ResourceBundle.getBundle("resources.CommonConfig");

	public static String getSqlQuery(String key) {
	    String value = "";
		try {
			boolean flag = sqlMappings.containsKey(key);

			if (flag) {
				value = sqlMappings.getString(key);
			}
		} catch (Exception e) {
			System.out.println("ResourceUtility > getSqlQuery > exception-e-" + e);
		}
		return value;
	}
	
	public static String getCommonConstant(String key) {
	    String value = "";
		try {
			boolean flag = commonConfig.containsKey(key);

			if (flag) {
				value = commonConfig.getString(key);
			}
		} catch (Exception e) {
			System.out.println("ResourceUtility > getCommonConstant > exception-e-" + e);
		}
		return value;
	}
}
