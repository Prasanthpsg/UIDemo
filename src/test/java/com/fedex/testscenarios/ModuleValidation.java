package com.fedex.testscenarios;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fedex.annotations.FrameworkAnnotation;
import com.fedex.dsmapplicationmethods.ApplicationMethods;
import com.fedex.framworkenums.CategoryType;
import com.fedex.listenermanager.RetryAnalyzer;
import com.fedex.utility.DriverManager;
import com.fedex.utility.ExtentManager;
import com.fedex.utility.Reports;
import com.google.common.util.concurrent.Uninterruptibles;

public final class ModuleValidation extends BaseTest {
	
	private ModuleValidation() {
	}
	
	@BeforeClass(alwaysRun = true)
	public void beforeDo() {
		System.out.println("--In before class--");
		Reports.initreports("ModuleValidation");
	}
	
//	@BeforeTest(alwaysRun = true)
//	public void beforeDo() {
//		System.out.println("--In before test");
//		Reports.initreports("ModuleValidation");
//	}
	
	@FrameworkAnnotation(author="Prasanth",category={CategoryType.SMOKE})
	@Test(description = "First tc", groups= {"smoke"})
	private void TC_01(Method m) {
		System.out.println("1st tc");
		//m.get
		ApplicationMethods.validateInputtag("username", "Admin", "Enter");
		ApplicationMethods.validateInputtag("password", "admin123", "Enter");
		ApplicationMethods.validateButtontag("submit", "", "Click");
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		ApplicationMethods.validateButtontagWithTitleattribute("Apply Leave", "", "Click");
		System.out.println("1st tc completed");
//		System.out.println(m.getAnnotation(FrameworkAnnotation.class).author());
		//ExtentManager.getExtentreport().assignAuthor(null);
	}
	
	@FrameworkAnnotation(author="Prasanth Kandasamy",category={CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
	@Test(description = "Second tc")
	private void TC_02(Method m) {
		System.out.println("2nd tc");
		//Reports.createTestcase("TC_02");
		ApplicationMethods.validateInputtag("username", "Admin", "Enter");
		ApplicationMethods.validateInputtag("password", "admin123", "Enter");
		ApplicationMethods.validateButtontag("submit", "", "Click");
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		String strtitle = DriverManager.getDriver().getCurrentUrl();
//		if(strtitle.equals("OrangeHRM")) {
//			Reports.logSuccess("Title matched and validation success");
//		}else {
//			Assert.fail("Test failed");
//		}
		ApplicationMethods.validateButtontagWithTitleattribute("My Leave", "", "Click");
		System.out.println("2nd tc completed");
//		System.out.println(m.getAnnotation(FrameworkAnnotation.class).category());
	}
	
	@AfterClass(alwaysRun = true)
	public void afterDo() {
		System.out.println("--In after class--");
		//Reports.flushReport();
	}
	

}
