package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtilities {

	public static String readConfig(String key) throws Exception
	{
		String path=System.getProperty("user.dir")+"/src/test/resources/Login.properties";
		FileInputStream file= new FileInputStream(path);
		Properties pro= new Properties();
		pro.load(file);
		return pro.getProperty(key);
		
	}
	
}
