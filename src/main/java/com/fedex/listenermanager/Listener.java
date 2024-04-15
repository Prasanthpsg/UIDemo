package com.fedex.listenermanager;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.fedex.annotations.FrameworkAnnotation;
import com.fedex.utility.Reports;

public class Listener implements ITestListener,ISuiteListener {

	public void onTestStart(ITestResult result) {
		// before method
		//Reports.createTestcase(result.getMethod().getMethodName());
		Reports.addauthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author());
		Reports.addcategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
	}

	public void onTestSuccess(ITestResult result) {
		Reports.logSuccess(result.getMethod().getMethodName() +" :PASSED");
		System.out.println(result.getMethod().getMethodName() +" :PASSED");
	}

	public void onTestFailure(ITestResult result) {
		Reports.logFail(result.getMethod().getMethodName() +" :FAILED");
		Reports.logFail(result.getThrowable().toString());
		Reports.logFail(Arrays.toString(result.getThrowable().getStackTrace()));
		System.out.println(result.getMethod().getMethodName() +" :FAILED");
	}

	/**
	 * suite level listeners
	 */
	public void onStart(ISuite suite) {
		// suite level implementation
		//Reports.initreports();
	}

	public void onFinish(ISuite suite) {
		// suite level implementation
		//Reports.flushReport();
	}



}
