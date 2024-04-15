package com.fedex.frameworkutils;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.Test;

import com.fedex.frameworkconst.Constants;

public class RunService {

	//public static String dir = System.getProperty("user.dir");
	public static String dir = Constants.getWorkingdir();
	
	
	@Test
	public void start() {
		
		String key = System.getProperty("testtype");
		String environment = System.getProperty("environment");
//		System.out.println("Test type is: "+key);
//		System.out.println("Test type is: "+environment);
		TestNG testng = new TestNG();
		List<String> suitefiles = new ArrayList<String>();
		//String key="smoke";

		switch (key) {
		case "smoke":
			suitefiles.add(dir+"//XML_Files//smokeSuite_testng.xml");
			testng.setTestSuites(suitefiles);
			testng.run();
			break;
		case "regression":
			suitefiles.add(dir+"//XML_Files//regressionSuite_testng.xml");
			testng.setTestSuites(suitefiles);
			testng.run();
			break;

		default:
			break;
		}
	}

}
