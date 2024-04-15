package com.fedex.utility;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fedex.frameworkconst.Constants;
import com.fedex.framworkenums.CategoryType;

public final class Reports {

	private Reports() {}

	public static ExtentReports extentreports;
	public static ExtentSparkReporter extentsparkreporter;
	public static ExtentTest test;
	private static String strenv = System.getProperty("environment");

	public static void initreports(String strmodulename) {
		if(Objects.isNull(ExtentManager.getExtentreport())) {
			extentreports = new ExtentReports();
			extentsparkreporter = new ExtentSparkReporter(Constants.getExtentfilepath()+"/Extend_Report/"+strmodulename+"/"+strmodulename+".html");
			extentreports.attachReporter(extentsparkreporter);

			extentsparkreporter.config().setProtocol(Protocol.HTTPS);
			extentsparkreporter.config().setEncoding("UTF-8");
			extentsparkreporter.config().setDocumentTitle("Extent Report");  
			extentsparkreporter.config().setReportName("Automation Test Report");
			extentsparkreporter.config().setTheme(Theme.STANDARD);
			extentsparkreporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

			try {
				extentreports.setSystemInfo("Machine", InetAddress.getLocalHost().getHostName());
			} catch (UnknownHostException e) {
				e.printStackTrace();
				throw new RuntimeException("Error in initreport method");
			}
			extentreports.setSystemInfo("Environment",strenv );
			extentreports.setSystemInfo("Build", "Dispatch UI Functional Test Result");
			extentreports.setSystemInfo("Java version", System.getProperty("java.version"));
			extentreports.setSystemInfo("User name",System.getProperty("user.name"));
			extentreports.setSystemInfo("Selenium Version", "v3.141.59");
			extentreports.setSystemInfo("Operating system",System.getProperty("os.name"));
			extentreports.setSystemInfo("OS Version",System.getProperty("os.version"));
			extentreports.setSystemInfo("Country",System.getProperty("user.timezone"));
			System.out.println("Extent report "+strmodulename+" started");
		}
	}

	public static void flushReport() {
		if (Objects.nonNull(ExtentManager.getExtentreport())) {
			extentreports.flush();
			ExtentManager.unload();
			System.out.println("Extent report closed");
		}
	}
	
	public static void createTestcase(String strdescription) {
		test = extentreports.createTest(strdescription);
		ExtentManager.setExtentreport(test);
	}

	public static void logInfo(String strdetails,Boolean isHighlightrequired) {
		if(isHighlightrequired==true) {
			ExtentManager.getExtentreport().log(Status.INFO, MarkupHelper.createLabel(String.valueOf(strdetails), ExtentColor.PURPLE));
		}
		else {
			ExtentManager.getExtentreport().info(strdetails);
		}
	}

	public static void logSuccess(String strdetails) {
		ExtentManager.getExtentreport().pass(strdetails);
	}

	public static void logFail(String strdetails) {
		ExtentManager.getExtentreport().fail(strdetails);
	}
	
	public static void addauthors(String[] author) {
		for (String a : author) {
			ExtentManager.getExtentreport().assignAuthor(a);
		}
	}
	
	public static void addcategories(CategoryType[] categoryTypes) {
		for (CategoryType c : categoryTypes) {
			ExtentManager.getExtentreport().assignCategory(c.toString());
		}
		
//		for (int i = 0; i < categoryTypes.length; i++) {
//			ExtentManager.getExtentreport().assignCategory(categoryTypes[i].toString());
//		}
	}
	
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
