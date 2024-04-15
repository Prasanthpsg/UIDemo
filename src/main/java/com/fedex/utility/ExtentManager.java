package com.fedex.utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> exten = new ThreadLocal<>();

	 public static ExtentTest getExtentreport() {// default -> can be accessed with in the package
		return exten.get();
	}

	 static void setExtentreport(ExtentTest extentref) {
		exten.set(extentref);
	}

	 static void unload() {
		exten.remove();
	}

}
