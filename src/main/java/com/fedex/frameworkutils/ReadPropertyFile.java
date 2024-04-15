package com.fedex.frameworkutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.fedex.frameworkconst.Constants;
import com.fedex.framworkenums.BasePropertiesEnums;

@SuppressWarnings("unused")
public final class ReadPropertyFile {

	private ReadPropertyFile() {}

	private static Properties prop = new Properties();
	private static FileInputStream fis = null;
	private static Map<String,String> propmap = new LinkedHashMap<>();

	static {
		try {
			fis = new FileInputStream(Constants.getPropertiesfilepath());
			prop.load(fis);
			System.out.println("In the Static block");
			for (Object iterable_element : prop.keySet()) {
				propmap.put(String.valueOf(iterable_element), String.valueOf(prop.get(iterable_element)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getValue(BasePropertiesEnums strkey) throws Exception {
//		Properties prop = new Properties();
//		FileInputStream fis = null;
//		String strvalue = "";
//		try {
//			fis = new FileInputStream(Constants.getPropertiesfilepath());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			prop.load(fis);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		if((Objects.isNull(propmap.get(strkey.name().toLowerCase()))) && (Objects.isNull(strkey.name().toLowerCase()))) {
			throw new Exception ("The key "+strkey.name().toLowerCase()+" / value is not found. Please check the base data properties file");
		}
		//return prop.getProperty(strkey);
		//System.out.println(propmap.get(strkey.name().toLowerCase()));
		return propmap.get(strkey.name().toLowerCase()).trim();
	}

}
