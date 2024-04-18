package com.fedex.utility;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.fedex.frameworkutils.ReadPropertyFile;
import com.fedex.framworkenums.BasePropertiesEnums;
import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * @author prasanth.kandasamy
 *
 */
public final class WebDriverFactory {

	private WebDriverFactory() {}

	//protected static WebDriver driver=null ;
	private static String environment = System.getProperty("environment");

	/**
	 * @param strbrowser
	 */
	public static void getDriverinstance(String strbrowser) {

		if(Objects.isNull(DriverManager.getDriver())) {
			if(strbrowser.equalsIgnoreCase("CHROME")) {
				System.out.println("Initializing the chrome browser");
		       // System.setProperty("webdriver.http.factory", "jdk-http-client");
				//WebDriverManager.chromedriver().setup();
				//WebDriverManager.chromedriver().proxy("internet.proxy.fedex.com:3128").setup();
				try {
					WebDriverManager.chromedriver().clearDriverCache().setup();
					ChromeOptions cop = new ChromeOptions();
					cop.addArguments("--disable-gpu");
					cop.addArguments("--disable-dev-shm-usage");
					//cop.addArguments("--no-sandbox");
					//cop.addArguments("--dns-prefetch-disable");
					cop.addArguments("--start-maximized");
					cop.addArguments("--remote-allow-origins=*");
					//cop.addArguments("--headless");
					//cop.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
					//DesiredCapabilities desirecap = new DesiredCapabilities();
					//desirecap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
					//desirecap.setCapability(ChromeOptions.CAPABILITY, cop);
					///cop.merge(desirecap);
					WebDriver driver = WebDriverManager.chromedriver().capabilities(cop).create();
					//WebDriver driver = new ChromeDriver(cop);
					DriverManager.setDriver(driver);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if(strbrowser.equalsIgnoreCase("EDGE")) {
				System.out.println("Initializing the edge browser");
				WebDriverManager.edgedriver().proxy("internet.proxy.fedex.com:3128").setup();
				//WebDriverManager.edgedriver().setup();
				WebDriver driver = WebDriverManager.edgedriver().create();
				DriverManager.setDriver(driver);
			}
			else {

			}

			/*
			 * environment setup
			 */
			switch (environment) {
			case "L1":
				try {
					launchBrowser(ReadPropertyFile.getValue(BasePropertiesEnums.DEVURL));
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Issue in the WebDriverFactory class");
				}
				break;

			case "L2":
				try {
					launchBrowser(ReadPropertyFile.getValue(BasePropertiesEnums.RELURL));
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Issue in the WebDriverFactory class");
				}
				break;

			default:
				break;
			}

			//set the environment
			/*if(environment.equalsIgnoreCase("L1")) {
				try {
					DriverManager.getDriver().get(ReadPropertyFile.getValue(BasePropertiesEnums.DEVURL));
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Issue in the WebDriverFactory class");
				}

			} else if(environment.equalsIgnoreCase("L2")) {
				try {
					DriverManager.getDriver().get(ReadPropertyFile.getValue(BasePropertiesEnums.RELURL));
					System.out.println("Invoking L2 URL");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Issue in the WebDriverFactory class");
				}
			}
			else {

			}*/

		}else {
			System.out.println("Driver object is not null. So no need to invoke the browser again "+DriverManager.getDriver());
		}

	}

	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
			System.out.println("Browser closed");
		}else {
			System.out.println("Webdriver doesnot exist");
		}
	}

	/*
	 * launch browser
	 */
	private static void launchBrowser(String URL) {
		System.out.println("Invoking the URL :" +URL);
		DriverManager.getDriver().navigate().to(URL);
		
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
	}

}
