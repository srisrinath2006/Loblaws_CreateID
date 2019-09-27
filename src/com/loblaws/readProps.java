package com.loblaws;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class readProps {
	
	public static HashMap<String, String> readProperties(final String fileName) {
		Properties props = new Properties();
		File configpath = null;
		HashMap<String, String> propertiesMap = null;
		try {
			configpath = new File("./resources/" + fileName);
			
			if (configpath.exists()) {
				props.load(new FileInputStream(configpath));
				propertiesMap = propertiesToMap(props);
			} else {
				System.out.println("No application.properties file found..");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propertiesMap;
	}
	
	public static HashMap<String, String> propertiesToMap(Properties props) {
		HashMap<String, String> hm = new HashMap<String, String>();
		Enumeration<Object> e = props.keys();
		while (e.hasMoreElements()) {
			String s = (String) e.nextElement();
			hm.put(s.trim(), props.getProperty(s).trim());
		}
		return hm;
	}
}
