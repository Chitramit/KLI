package gRCenforce;


import org.testng.annotations.Test;

import gRCenforce.Utilities.Xls_Reader;
import gRCenforce.Utilities.generalUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import java.util.*;


public class gRCenforceView_Total_Compliance_Tasks_Status extends generalUtils  {

	 Xls_Reader read = new Xls_Reader("C:\\Users\\chitramitc478\\git\\KLI\\Datatable.xlsx");
	
	
	
	@BeforeClass
	public void invokeBrowesers() throws Exception
	
	
	{
	
		   generalUtils.launchChromeDriver();
		   generalUtils.takeScreenshots();
		  
	}
	
	
	
	@Test(priority=1)
	public  void login() throws Exception {
		
		driver.findElement(By.xpath("//*[@title='Login ID']")).sendKeys(read.getCellData("GeneralUserData", "userName", 2));
		driver.findElement(By.xpath("//*[@name='Password']")).sendKeys(read.getCellData("GeneralUserData", "password", 2));
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		
		Thread.sleep(15000);
		
		 generalUtils.takeScreenshots();
		 System.out.println("User is able to login");
		  
	}
	
	
	@Test(priority=2)
	
	public void view_In_Compliance() throws Exception{
		
		WebElement element = driver.findElement(By.xpath("//*[contains(@ng-if,'complianceTask.Implemented!')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on In Compliance Tasks");		
		generalUtils.click_compliance_attributes();
		generalUtils.workflow_history();
	    Thread.sleep(5000);
	    generalUtils.takeScreenshots();
	    generalUtils.reopen_task();
	    generalUtils.takeScreenshots();
	    Thread.sleep(4000);
	    
	    
	  
		
		
	}
	
@Test(priority=3)
	
	public void view_total_Compliance() throws Exception{
					
	WebElement element = driver.findElement(By.xpath("//*[contains(@ng-click,'getTotalTask')]"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on pending for Approval Tasks");		
		generalUtils.click_compliance_attributes();
		generalUtils.workflow_history();
		Thread.sleep(4000);
		
		}

@Test(priority=4)

public void view_In_Complaince_With_delay() throws Exception{

						
		WebElement element=	driver.findElement(By.xpath("//*[contains(@ng-click,'getImplementedWith')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on In Compliance with delay Tasks");		
		generalUtils.click_compliance_attributes();
		generalUtils.workflow_history();
		Thread.sleep(4000);
	}

@Test(priority=5)

public void view_Non_Compliance() throws Exception{
				
		WebElement element=	driver.findElement(By.xpath("//*[contains(@ng-click,'getNotImplementedTask')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on Non-Compliance Tasks");		
		generalUtils.click_compliance_attributes();
		generalUtils.workflow_history();
		generalUtils.reopen_task();
		Thread.sleep(4000);
	
		}
@Test(priority=6)

public void view_Not_Applicable() throws Exception{
		WebElement element=	driver.findElement(By.xpath("//*[contains(@ng-click,'getNATask')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on Not Applicable Tasks");		
		generalUtils.click_compliance_attributes();
		generalUtils.workflow_history();
		Thread.sleep(4000);
		
		}
@Test(priority=7)

public void view_Not_Submitted() throws Exception{
		WebElement element=	driver.findElement(By.xpath("//*[contains(@ng-click,'getNUTask')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);			
		Thread.sleep(15000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on Not Submitted Tasks");		
		generalUtils.click_compliance_attributes();
		generalUtils.workflow_history();
		Thread.sleep(4000);
	
		}
@Test(priority=8)

public void view_due() throws Exception{
		WebElement element=	driver.findElement(By.xpath("//*[contains(@ng-click,'getDueTask')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);				
		Thread.sleep(8000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on Due Tasks");		
		generalUtils.click_compliance_attributes();
		generalUtils.workflow_history();
		Thread.sleep(4000);
		
		}

@Test(priority=9)

public void view_overdue() throws Exception{
		WebElement element=	driver.findElement(By.xpath("//*[contains(@ng-click,'getOverDueTask')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);					
		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on Overdue Tasks");		
		generalUtils.click_compliance_attributes();
		generalUtils.workflow_history();
		Thread.sleep(4000);
		
		}



	@Test(priority=10)
	public void logout() throws Exception {
		Thread.sleep(8000);		
		driver.findElement(By.xpath("//*[@title='Settings']")).click();
		driver.findElement(By.xpath("//*[text()='Sign Out']")).click();
		Thread.sleep(8000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to logout");
		 
	}
			
		@AfterTest
	
	public void AfterClass()
	{
		System.out.println("Test Completed");
		driver.quit();
	
	}
}