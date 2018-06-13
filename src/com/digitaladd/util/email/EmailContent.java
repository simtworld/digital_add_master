package com.digitaladd.util.email;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.digitaladd.util.ResourceUtility;

public class EmailContent {
	static EmailContent instance;
	static String msg;
	static {
		
	}
	
	private EmailContent() {
		//no-op
	}
	
	public synchronized static EmailContent getInstance() {
		if(instance == null) {
			instance=new EmailContent();
		}
		return instance;
	}
	
	private static String readFile(String fileName) throws FileNotFoundException, IOException {
		StringBuffer contents = new StringBuffer();
		
		//use buffering, reading one line at a time
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				contents.append(line);
				contents.append(System.getProperty("line.separator"));
			}
		} finally {
			reader.close();
		}
		return contents.toString();
	}
	
	protected static String readHtml(Map<String, String> input) throws IOException {
		String filePath = ResourceUtility.getCommonConstant("email.smtp.templet.filepath");
		if(msg==null)
			msg = readFile(filePath);
		
		Set<Entry<String, String>> entries = input.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			msg = msg.replace(entry.getKey().trim(), entry.getValue().trim());
		}
		return msg;
	}
}
