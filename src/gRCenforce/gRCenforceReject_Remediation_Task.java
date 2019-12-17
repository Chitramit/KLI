package gRCenforce;


import org.testng.annotations.Test;

import gRCenforce.Utilities.Xls_Reader;
import gRCenforce.Utilities.generalUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.*;



public class gRCenforceReject_Remediation_Task extends generalUtils {

	static Xls_Reader read = new Xls_Reader("C:\\Users\\chitramitc478\\git\\KLI\\Datatable.xlsx");
	
	
	
	@BeforeClass
	public void invokeBrowesers() throws Exception
	
	
	{
	
			generalUtils.launchChromeDriver();
		    generalUtils.takeScreenshots();
		 
		  
		   
		   
		  
		  
	}
	
	
	
	@Test(priority=1)
	public static void login() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@title='Login ID']")).sendKeys(read.getCellData("GeneralUserData", "userName", 5));
		driver.findElement(By.xpath("//*[@name='Password']")).sendKeys(read.getCellData("GeneralUserData", "password", 5));
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();			
		Thread.sleep(15000);
		String Name = driver.findElement(By.xpath("//*[text()='Welcome']//following::span[2]")).getText();
		assertEquals(Name,"Satyabrata Sarkar","Login Succesfull");		
		 generalUtils.takeScreenshots();
		 System.out.println("User is able to login");
		  
		  
	}
	
	
	@Test(priority=2)
	
	public static void go_to_total_Remediation_Approval() throws Exception{
					
		driver.findElement(By.xpath("//*[contains(@ui-sref,'remediationComplianceApprovalTasks')]")).click();
		Thread.sleep(12000);
				
	}
				
		
				
	   
		

@Test(priority=3)

	public static void  select_compliance_approve() throws Exception{
	
	
	String remediation_title =  read.getCellData("RegisterUserData", "remediation_title", 2);
	String [] array = remediation_title.split("_");
	int num = Integer.parseInt(array[1]);
	num=num-1;
	String sp2 = Integer.toString(num);
	String sp3= array[0]+"_"+sp2;
						
		driver.findElement(By.xpath("//*[text()='"+sp3+"']/ancestor::div[@ng-style='Viewport.rowStyle(rowRenderIndex)']//div[@ng-click='selectButtonClick(row, $event)']")).click();
		Thread.sleep(4000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on the Checkbox");
		
		//User Selects Reject Radio Button
		driver.findElement(By.xpath("//*[text()='"+sp3+"']/ancestor::div[@ng-style='Viewport.rowStyle(rowRenderIndex)']//input[contains(@ng-checked,'Reject')]")).click();
		System.out.println("User selects approve checkbox");
		
		Thread.sleep(2000);
		
		generalUtils.takeScreenshots();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='"+sp3+"']/ancestor::div[@ng-style='Viewport.rowStyle(rowRenderIndex)']//textarea[@name='command']")).sendKeys("Test Comments");
		
		Thread.sleep(2000);
		generalUtils.takeScreenshots();
		
		List<WebElement> submit = driver.findElements(By.xpath("//*[text()='Submit']"));
		submit.get(0).click();
		
		Thread.sleep(2000);
		generalUtils.takeScreenshots();
		 
		 driver.findElement(By.xpath("//*[text()='OK']")).click();
		 
		 System.out.println("User is able to submit the Task");
		
		Thread.sleep(3000);
		
}




	@Test(priority=6)
	public static void logout() throws Exception {
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