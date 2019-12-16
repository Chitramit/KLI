package gRCenforce;


import org.testng.annotations.Test;

import gRCenforce.Utilities.Xls_Reader;
import gRCenforce.Utilities.generalUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import java.util.*;



public class gRCenforceView_My_Remediation_Tasks extends generalUtils {

	static Xls_Reader read = new Xls_Reader("C:\\Users\\chitramitc478\\git\\KLI\\Datatable.xlsx");
	
	
	
	@BeforeClass
	public void invokeBrowesers() throws Exception
	
	
	{
	
			generalUtils.launchChromeDriver();
		   generalUtils.takeScreenshots();
		  
	}
	
	
	
	@Test(priority=1)
	public void login() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@title='Login ID']")).sendKeys(read.getCellData("GeneralUserData", "userName", 2));
		driver.findElement(By.xpath("//*[@name='Password']")).sendKeys(read.getCellData("GeneralUserData", "password", 2));
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		
		
		Thread.sleep(15000);
		
		 generalUtils.takeScreenshots();
		 System.out.println("User is able to login");
		  
	}
	
	
	@Test(priority=2)
	
	public static void view_Overdue_remediation() throws Exception{
					
		driver.findElement(By.xpath("//*[contains(@ng-if,'totalComplianceRemediationTasksOverdue')]")).click();
		Thread.sleep(12000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on Overdue Task");		
	    List<WebElement>  a= driver.findElements(By.xpath("//*[@title='Compliance Attributes']"));
	    a.get(0).click();
	    System.out.println("User Clicks on Comliance Attributes");
	    Thread.sleep(5000);
	    generalUtils.takeScreenshots();
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		System.out.println("User Clicks on OK");
		Thread.sleep(2000);
		
		
	}
	
@Test(priority=3)
	
	public static void view_total_remediation() throws Exception{
					
		driver.findElement(By.xpath("//*[contains(@ng-click,'getTotal')]")).click();
		Thread.sleep(12000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on Total Task");		
	    List<WebElement>  a= driver.findElements(By.xpath("//*[@title='Compliance Attributes']"));
	    a.get(0).click();
	    System.out.println("User Clicks on Comliance Attributes");
	    Thread.sleep(5000);
	    generalUtils.takeScreenshots();
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		System.out.println("User Clicks on OK");
		Thread.sleep(2000);
		}

@Test(priority=4)

public void view_due_remediation() throws Exception{
						
		driver.findElement(By.xpath("//*[contains(@ng-click,'getDue')]")).click();
		Thread.sleep(12000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on Due Task");		
		List<WebElement>  a= driver.findElements(By.xpath("//*[@title='Compliance Attributes']"));
		a.get(0).click();
		System.out.println("User Clicks on Comliance Attributes");
		Thread.sleep(5000);
		generalUtils.takeScreenshots();
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		System.out.println("User Clicks on OK");
		Thread.sleep(2000);
}

@Test(priority=5)

public void view_rejected_remediation() throws Exception{
				
		driver.findElement(By.xpath("//*[contains(@ng-click,'getReject')]")).click();
		Thread.sleep(12000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on Rejected Task");		
		List<WebElement>  a= driver.findElements(By.xpath("//*[@title='Compliance Attributes']"));
		a.get(0).click();
		System.out.println("User Clicks on Comliance Attributes");
		generalUtils.takeScreenshots();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		System.out.println("User Clicks on OK");
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
	
	public void afterClass()
	{
		System.out.println("Test Completed");
		driver.quit();
	
	}
}