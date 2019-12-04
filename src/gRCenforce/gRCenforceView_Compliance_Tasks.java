package gRCenforce;


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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class gRCenforceView_Compliance_Tasks extends generalUtils {
	
	
	
	
	@BeforeSuite
	public void invokeBrowesers() throws Exception
	
	
	{
	
			generalUtils.launchChromeDriver();
		   generalUtils.takeScreenshots();
		  
	}
	
	
	
	@Test(priority=1)
	public void login() throws Exception {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@title='Login ID']")).sendKeys("submitter1");
		driver.findElement(By.xpath("//*[@name='Password']")).sendKeys("pass@123");
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		
		Thread.sleep(8000);
		
		 generalUtils.takeScreenshots();
		 System.out.println("User is able to login");
		  
	}
	
	
	@Test(priority=2)
	
	public void view_total_Complaince() throws Exception{
		
		driver.findElement(By.xpath("//*[contains(@ng-if,'totalComplianceTasksOverdue')]")).click();
		
	}
	@Test(priority=3)
	public void logout() throws Exception {
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("//*[@title='Settings']")).click();
		driver.findElement(By.xpath("//*[text()='Sign Out']")).click();
		
		Thread.sleep(8000);
		
		 generalUtils.takeScreenshots();
		 System.out.println("User is able to logout");
		 
	}
			
		@AfterTest
	
	public void afterTest()
	{
		System.out.println("Test Completed");
		driver.quit();
	
	}
}