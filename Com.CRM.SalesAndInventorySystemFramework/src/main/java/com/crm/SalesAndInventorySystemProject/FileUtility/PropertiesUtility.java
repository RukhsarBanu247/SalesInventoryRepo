package com.crm.SalesAndInventorySystemProject.FileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtility 
{
	public String getDataFromPropertiesFile(String key) throws Exception
	{
		FileInputStream fis=new FileInputStream(".\\configAppData\\SalesAndInventory_CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(key);
		return data;
	}

}
