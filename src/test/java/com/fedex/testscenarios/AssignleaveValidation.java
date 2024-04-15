package com.fedex.testscenarios;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fedex.annotations.FrameworkAnnotation;
import com.fedex.dsmapplicationmethods.ApplicationMethods;
import com.fedex.framworkenums.CategoryType;
import com.fedex.utility.Reports;
import com.google.common.util.concurrent.Uninterruptibles;

public final class AssignleaveValidation extends BaseTest {
	
	private AssignleaveValidation(){
		
	}
	
	@BeforeClass(alwaysRun = true)
	public void beforeDo() {
		System.out.println("--In before class--");
		Reports.initreports("AssignleaveValidation");
	}
	
//	@BeforeTest(alwaysRun = true)
//	public void beforeDo() {
//		System.out.println("--In before test");
//		Reports.initreports("AssignleaveValidation");
//	}
	
	@FrameworkAnnotation(author="Prasanth",category={CategoryType.SMOKE})
	@Test(description = "First tc in assign leave module", groups= {"smoke"})
	public void TC_01(Method m) {
		ApplicationMethods.validateInputtag("username", "Admin", "Enter");
		ApplicationMethods.validateInputtag("password", "admin123", "Enter");
		ApplicationMethods.validateButtontag("submit", "", "Click");
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		ApplicationMethods.validateButtontagWithTitleattribute("Assign Leave", "", "Click");
		//System.out.println("1st tc completed");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterDo() {
		System.out.println("--In after class--");
		Reports.flushReport();
	}

}
