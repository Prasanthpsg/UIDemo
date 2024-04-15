package com.fedex.frameworkconst;

public final class Constants 
{
	private Constants(){}
	
	private static final String WORKINGDIR = System.getProperty("user.dir");
	private static final String RESOURCESPATH = WORKINGDIR+"/src/test/resources";
	private static final String CHROMEDRIVERPATH = RESOURCESPATH+"";
	private static final String EDGEDRIVERPATH = RESOURCESPATH+"";
	private static final String FIREFOXDRIVERPATH = RESOURCESPATH+"";
	private static final String PROPERTIESFILEPATH = RESOURCESPATH+"/Basedata.properties";
	private static final String EXTENTFILEPATH = WORKINGDIR+"/output/";
	
	public static String getWorkingdir() {
		return WORKINGDIR;
	}
	public static String getResourcespath() {
		return RESOURCESPATH;
	}
	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
	public static String getEdgedriverpath() {
		return EDGEDRIVERPATH;
	}
	public static String getFirefoxdriverpath() {
		return FIREFOXDRIVERPATH;
	}
	public static String getPropertiesfilepath() {
		return PROPERTIESFILEPATH;
	}
	public static String getExtentfilepath() {
		return EXTENTFILEPATH;
	}
	
}
