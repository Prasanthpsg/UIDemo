package com.fedex.listenermanager;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.fedex.frameworkutils.ReadPropertyFile;
import com.fedex.framworkenums.BasePropertiesEnums;

public class RetryAnalyzer implements IRetryAnalyzer{

	private int count =0;
	private int maxretry = 1;
	//private boolean blnretry = false;

	@Override
	public boolean retry(ITestResult result) {
		boolean blnretry = false;
		try {
			if(ReadPropertyFile.getValue(BasePropertiesEnums.RETRYOPTION).equalsIgnoreCase("yes")) {
				if(count<maxretry) {
					count++;
					//blnretry = true;
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blnretry;
	}

}
