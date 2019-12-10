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

import static org.testng.Assert.assertEquals;

import java.util.*;


public class gRCenforceView_Total_Remediation_Tasks_Status extends generalUtils  {

	 Xls_Reader read = new Xls_Reader("C:\\Users\\chitramitc478\\git\\KLI\\Datatable.xlsx");
	
	
	
	@BeforeClass
	public void invokeBrowesers() throws Exception
	
	
	{
	
		   generalUtils.launchChromeDriver();
		   generalUtils.takeScreenshots();
		  
	}
	
	
	
	@Test(priority=1)
	public  void login() throws Exception {
		
		
		//driver.findElement(By.xpath("//*[@title='Login ID']")).sendKeys(read.getCellData("RegisterUserData", "userName", 2));
		driver.findElement(By.xpath("//*[@name='Password']")).sendKeys(read.getCellData("RegisterUserData", "password", 2));
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();			
		Thread.sleep(15000);
		String Name = driver.findElement(By.xpath("//*[text()='Welcome']//following::span[2]")).getText();
		assertEquals(Name,"Submitter User 1","Login Succesfull");		
		 generalUtils.takeScreenshots();
		 System.out.println("User is able to login");
		  
	}
	
	
	@Test(priority=4)
	
	public void view_Implemented_remediation() throws Exception{
		
		WebElement element = driver.findElement(By.xpath("//*[contains(@ng-if,'RemediationTask.Implemented')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on Implemented Remediation");		
		generalUtils.click_compliance_attributes();
		generalUtils.workflow_history();
	    Thread.sleep(5000);
	    generalUtils.takeScreenshots();
	   // generalUtils.reopen_task();
	    generalUtils.takeScreenshots();
	    
	    
	  
		
		
	}
	
@Test(priority=3)
	
	public void view_total_Remediation() throws Exception{
					
	WebElement element = driver.findElement(By.xpath("//*[contains(@ng-click,'getTotalTask')]"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on Total Remediation");		
		generalUtils.click_compliance_attributes();
		generalUtils.workflow_history();
		
		}

@Test(priority=1)

public void view_Not_Implemented() throws Exception{

						
		WebElement element=	driver.findElement(By.xpath("//*[contains(@ng-click,'getNotImplemented')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on Not Implemented Remediation");		
		generalUtils.click_compliance_attributes();
		generalUtils.workflow_history();
	}

@Test(priority=5)

public void view_Not_Applicable() throws Exception{
				
	WebElement element=	driver.findElement(By.xpath("//*[contains(@ng-click,'getNotApplicable')]"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
	Thread.sleep(6000);
	generalUtils.takeScreenshots();
	System.out.println("User is able to click on Not Applicable Remediation");		
	generalUtils.click_compliance_attributes();
	generalUtils.workflow_history();
	generalUtils.reopen_task();
	Thread.sleep(2000);
	
		}
@Test(priority=6)

public void view_Pedning_for_Approval() throws Exception{
	WebElement element=	driver.findElement(By.xpath("//*[contains(@ng-click,'getpendingTask')]"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
	Thread.sleep(6000);
	generalUtils.takeScreenshots();
	System.out.println("User is able to click on Pending for Approval Remediation");		
	generalUtils.click_compliance_attributes();
	generalUtils.workflow_history();
	Thread.sleep(2000);
	
		}
@Test(priority=7)

public void view_Not_Submitted_Remediation() throws Exception{
	WebElement element=	driver.findElement(By.xpath("//*[contains(@ng-click,'getNotUpdated')]"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);			
	Thread.sleep(6000);
	generalUtils.takeScreenshots();
	System.out.println("User is able to click on Not Submitted Remediation");		
	generalUtils.click_compliance_attributes();
	generalUtils.workflow_history();
	Thread.sleep(2000);
	
		}
@Test(priority=8)

public void view_due_remediation() throws Exception{
	WebElement element=	driver.findElement(By.xpath("//*[contains(@ng-click,'getDueTask')]"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);				
	Thread.sleep(6000);
	generalUtils.takeScreenshots();
	System.out.println("User is able to click on Due Remediation");		
	generalUtils.click_compliance_attributes();
	generalUtils.workflow_history();
	Thread.sleep(2000);
	
		}

@Test(priority=9)

public void view_overdue() throws Exception{
	WebElement element=	driver.findElement(By.xpath("//*[contains(@ng-click,'getOverDueTask')]"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);					
	Thread.sleep(6000);
	generalUtils.takeScreenshots();
	System.out.println("User is able to click on Overdue Remediation");		
	generalUtils.click_compliance_attributes();
	generalUtils.workflow_history();
	Thread.sleep(2000);
	
		}



	@Test(priority=6)
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