package com.digitaladd.common;

public enum DataSources {
	DEFAULT ("jdbc/digitalAdd"),
	LOCAL_JDBC_CONNECTION ("LOCAL");

	DataSources(String text) {
		this.text = text;
	}
	@Override
    public String toString() {
        return text;
    }
    // members
    private final String text;
}
