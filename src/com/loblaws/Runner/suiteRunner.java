package com.loblaws.Runner;

import com.loblaws.createTestCase;
import com.loblaws.readProps;

public class suiteRunner {
	
	static {
		readProps.readProperties("application.properties");
	}
	
	public static void main(String[] args) {
		String result;
		result = createTestCase.createNewID();
		
		 if (result.equals("PASS")) {
			 System.out.println("Create ID is successful");
		 }else {
			 System.out.println("Create ID Failed");
		 }
	}
}
