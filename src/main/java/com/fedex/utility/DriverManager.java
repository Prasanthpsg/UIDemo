package com.fedex.utility;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	private DriverManager() {}

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setDriver(WebDriver webdriverref) {
		dr.set(webdriverref);
	}

	public static void unload() {
		dr.remove();
	}
}
