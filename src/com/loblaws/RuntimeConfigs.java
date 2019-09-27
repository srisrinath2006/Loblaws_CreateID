package com.loblaws;

import java.util.HashMap;

public class RuntimeConfigs {
	private static HashMap<String, String> runtimeconfigs = new HashMap<String, String>();
	
	static {
		runtimeconfigs = readProps.readProperties("application.properties");
	}

	public static String getconfigValue(final String key) {
		return runtimeconfigs.get(key);
	}

	public static void setConfigValue(final String key, final String value) {
		if (key != null && value != null) {
			runtimeconfigs.put(key, value);
		}
	}
	
	public static String getProperty(String key) {
		return null;
	}
}
