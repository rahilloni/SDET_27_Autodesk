package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Rahil	
 *
 */
public class FileUtility {
	/**
	 * it is used to read the data from properties file based on key which you pass as an argument
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fis =new FileInputStream("./data/vtigerData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
