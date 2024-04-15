package com.fedex.dsmapplicationmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.fedex.utility.DriverManager;
import com.fedex.utility.Reports;

public final class ApplicationMethods {

	private ApplicationMethods() {}

	public static void validateInputtag(String strfieldname, String strvalue,  String stroperation) {

		Actions ac = new Actions(DriverManager.getDriver());
		try {
			WebElement ele = DriverManager.getDriver().findElement(By.xpath("//input[@name='"+strfieldname+"']"));
			
			if(ele.isDisplayed()) {
				switch (stroperation) {
				case "Enter":
					ele.clear();
					ele.click();
					ele.sendKeys(strvalue);
					Reports.logInfo("The value "+strvalue+ " is entered in the "+strfieldname+" field", false);
					break;
				case "Clear":
					ele.clear();
					ele.click();
					Reports.logInfo("The field "+strfieldname+" is cleared", false);
					break;
				case "Click":
					ele.click();
					Reports.logInfo("The field "+strfieldname+" is clicked", false);
					break;
					
				default:
					break;
				}
			}else {
				
			}
		} catch (Exception e) {
			Reports.logFail("Issue with identifying the elements");
			e.printStackTrace();
		}

	}
	
	public static void validateButtontag(String strfieldname, String strvalue,  String stroperation) {
		
		Actions ac = new Actions(DriverManager.getDriver());
		try {
			WebElement ele = DriverManager.getDriver().findElement(By.xpath("//button[@type='"+strfieldname+"']"));
			
			if(ele.isDisplayed()) {
				switch (stroperation) {
				case "Enter":
					ele.clear();
					ele.click();
					ele.sendKeys(strvalue);
					Reports.logInfo("The value "+strvalue+ " is entered in the "+strfieldname+" field", false);
					break;
				case "Clear":
					ele.clear();
					ele.click();
					Reports.logInfo("The field "+strfieldname+" is cleared", false);
					break;
				case "Click":
					ele.click();
					Reports.logInfo("The button "+strfieldname+" is clicked", false);
					break;
					
				default:
					break;
				}
			}else {
				
			}
		} catch (Exception e) {
			Reports.logFail("Issue with identifying the elements");
			e.printStackTrace();
		}
	}
	
	public static void validateButtontagWithTitleattribute(String strfieldname, String strvalue,  String stroperation) {
		
		Actions ac = new Actions(DriverManager.getDriver());
		try {
			WebElement ele = DriverManager.getDriver().findElement(By.xpath("//button[@title='"+strfieldname+"']"));
			
			if(ele.isDisplayed()) {
				switch (stroperation) {
				case "Enter":
					ele.clear();
					ele.click();
					ele.sendKeys(strvalue);
					Reports.logInfo("The value "+strvalue+ " is entered in the "+strfieldname+" field", false);
					break;
				case "Clear":
					ele.clear();
					ele.click();
					Reports.logInfo("The field "+strfieldname+" is cleared", false);
					break;
				case "Click":
					ele.click();
					Reports.logInfo("The button "+strfieldname+" is clicked", false);
					break;
					
				default:
					break;
				}
			}else {
				
			}
		} catch (Exception e) {
			Reports.logFail("Issue with identifying the elements");
			e.printStackTrace();
		}
	}

}
