package com.fedex.testscenarios;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fedex.frameworkconst.Constants;
import com.fedex.frameworkutils.ReadPropertyFile;
import com.fedex.framworkenums.BasePropertiesEnums;
import com.fedex.utility.Reports;
import com.fedex.utility.WebDriverFactory;

public class BaseTest {

	static final int BUFFER = 1024;  

	protected BaseTest() {
	}

	//	@BeforeSuite(alwaysRun = true)
	//	public void startReport() {
	//		Reports.initreports();
	//	}
	//	
	//	@AfterSuite(alwaysRun = true)
	//	public void teardownReport() {
	//		Reports.flushReport();
	//	}

	@BeforeMethod(alwaysRun = true)
	public void initDriver(Method m) {
		try {
			WebDriverFactory.getDriverinstance(ReadPropertyFile.getValue(BasePropertiesEnums.BROWSER));
		} catch (Exception e) {
			System.out.println("Issue in the BaseTest class");
			e.printStackTrace();
		}
		Reports.createTestcase(m.getName()+ " "+m.getAnnotation(Test.class).description());
	}

	@AfterMethod(alwaysRun = true)
	public void teardownDriver() {
		WebDriverFactory.quitDriver();
	}

	@AfterTest(alwaysRun = true)
	public void finalZip() {
		/*ZipOutputStream zos = null;  
		BufferedInputStream bis = null;  

		try  
		{  
			//path of the file that we want to compress  
			String fileName = Constants.getWorkingdir()+"/output/"+"Extend_Report";  
			File file = new File(fileName);  
			FileInputStream fis = new FileInputStream(file);  
			bis = new BufferedInputStream(fis, BUFFER);        
			//creating ZipOutputStream  
			//creates a zip file with the specified name  
			FileOutputStream fos = new FileOutputStream(Constants.getWorkingdir()+"/output/"+"Extend_Report.zip");  
			//ZipOutputStream writes data to an output stream in zip format  
			zos = new ZipOutputStream(fos);                       
			// ZipEntry, here file name can be created using the source file  
			ZipEntry ze = new ZipEntry(file.getName());  
			//putting zipentry in zipoutputstream  
			zos.putNextEntry(ze);  
			byte data[] = new byte[BUFFER];  
			int count;  
			while((count = bis.read(data, 0, BUFFER)) != -1)   
			{  
				zos.write(data, 0, count);  
			}  
		}  
		catch(IOException ioExp)  
		{  
			System.out.println("Error while zipping " + ioExp.getMessage());  
		}  
		finally  
		{  
			if(zos != null)  
			{  
				try   
				{  
					//closing output stream  
					zos.close();  
				}   
				catch (IOException e)   
				{  
					e.printStackTrace();  
				}  
			}  
			if(bis != null)  
			{  
				try   
				{  
					//closing buffered input stream  
					bis.close();  
				}   
				catch (IOException e)   
				{  
					//prints exception  
					e.printStackTrace();  
				}  
			}  
		} */ 
	}

}
