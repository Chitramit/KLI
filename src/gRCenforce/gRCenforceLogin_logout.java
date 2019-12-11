package gRCenforce;


import org.testng.annotations.Test;

import gRCenforce.Utilities.Xls_Reader;
import gRCenforce.Utilities.generalUtils;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;





import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class gRCenforceLogin_logout extends generalUtils {
	
	
	 Xls_Reader read = new Xls_Reader("C:\\Users\\chitramitc478\\git\\KLI\\Datatable.xlsx");
	
	@BeforeClass
	public void invokeBrowesers() throws Exception
	
	
	{
	
		generalUtils.launchChromeDriver();
		generalUtils.takeScreenshots();
		  
		  
	}
	
	
	
	@Test(priority=1)
	public void login() throws Exception {
		
		Thread.sleep(8000);		
		elements.username.sendKeys(read.getCellData("RegisterUserData", "userName", 2));
		elements.password.sendKeys(read.getCellData("RegisterUserData", "password", 2));
		elements.Signin.click();		
		Thread.sleep(8000);		
		generalUtils.takeScreenshots();
		System.out.println("User is able to login");
		  
	}
	
	@Test(priority=2)
	public void logout() throws Exception {
		Thread.sleep(8000);		
		elements.settings.click();
		elements.signout.click();		
		Thread.sleep(8000);		
		generalUtils.takeScreenshots();
		System.out.println("User is able to logout");
		 
	}
			
		@AfterClass
	
	public void afterTest()
	{
		System.out.println("Test Completed");
		driver.quit();
	
	}
}