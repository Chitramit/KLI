package gRCenforce;


import org.testng.annotations.Test;

import gRCenforce.Utilities.Xls_Reader;
import gRCenforce.Utilities.generalUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.*;


public class gRCenforceFilter_Graph_Module_Admin extends generalUtils  {

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
		String Name = driver.findElement(By.xpath("//*[text()='Welcome']//following::span[2]")).getText();
		assertEquals(Name,"Submitter User 1","Login Succesfull");		
		 generalUtils.takeScreenshots();
		 System.out.println("User is able to login");
		  
	}
	
	
	@Test(priority=2)
	
	public void select_Location_BU() throws Exception{
		//User Clicks on Location and BU
		driver.findElement(By.xpath("//*[contains(@select-all,'allBUSelected')]")).click();
		System.out.println("User is able to Click on Location and BU Drop Down");
		Thread.sleep(2000);
		//User unChecks select all checkbox
		List<WebElement> element = driver.findElements(By.xpath("//*[text()='Location and BU']/ancestor::div[1]//span[@ng-if='trvw.useCheckboxes()']"));
		element.get(0).click();
		Thread.sleep(2000);
		generalUtils.takeScreenshots();
		
		List<WebElement> plusIcon = driver.findElements(By.xpath("//*[text()='Location and BU']/ancestor::div[1]//div[@title=\"PwC India\"]//following::span[@class=\"ivh-treeview-twistie\"]"));
		

		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		Thread.sleep(2000);
		element.get(3).click();
		takeScreenshots();
		
			
		
	}
	
@Test(priority=3)
	
	public void select_department() throws Exception{
					
		//User Clicks on Department
		driver.findElement(By.xpath("//*[contains(@data-select-all,'DepartmentSelected')]")).click();
		System.out.println("User is able to Click on Department Drop Down");
		Thread.sleep(2000);
		//User unChecks select all check box
		List<WebElement> element = driver.findElements(By.xpath("//*[text()='Department']/ancestor::div[1]//span[@ng-if='trvw.useCheckboxes()']"));
		element.get(0).click();
		Thread.sleep(2000);
		generalUtils.takeScreenshots();		
		Thread.sleep(2000);
		element.get(3).click();
		generalUtils.takeScreenshots();
		
		}

@Test(priority=4)

public void select_from_date() throws Exception{

						
		//User Clicks on From Date
		driver.findElement(By.xpath("//*[contains(@ng-click,'FromDate')]")).click();
		System.out.println("User is able to Click on From Date Drop Down");
		Thread.sleep(2000);
		//User goes back a month previous
		List<WebElement> date = driver.findElements(By.xpath("//*[text()='From Date']/following::button[@class='btn btn-default btn-sm pull-left']"));
		date.get(0).click();
		Thread.sleep(2000);
		System.out.println("User goes back to previous month");
		generalUtils.takeScreenshots();		
		Thread.sleep(2000);
		List<WebElement> datepick = driver.findElements(By.xpath("//*[text()='From Date']/following::span[text()='13']"));
		datepick.get(0).click();		
		System.out.println("User Selects From Date");
		Thread.sleep(2000);
		generalUtils.takeScreenshots();
		
		
	}

@Test(priority=5)

public void select_to_date() throws Exception{
				
		//User Clicks on To Date
		driver.findElement(By.xpath("//*[contains(@ng-click,'openEffectiveDate')]")).click();
		System.out.println("User is able to Click on To date Drop Down");
		Thread.sleep(2000);
		//User goes back a month previous
		List<WebElement> element = driver.findElements(By.xpath("//*[text()='To Date']/following::button[@class='btn btn-default btn-sm pull-left']"));
		element.get(0).click();
		Thread.sleep(2000);
		System.out.println("User goes back to previous month");
		generalUtils.takeScreenshots();		
		Thread.sleep(2000);
		List<WebElement> datepick = driver.findElements(By.xpath("//*[text()='From Date']/following::span[text()='14']"));
		datepick.get(1).click();
		System.out.println("User Selects To Date");
		Thread.sleep(2000);
		generalUtils.takeScreenshots();
		
	
		}
@Test(priority=6)

public void select_Roles_and_Apply() throws Exception{
	//User Clicks on Roles
	driver.findElement(By.xpath("//*[@select-all='cntlr.selectedAllRoles']")).click();
	System.out.println("User is able to Click on To Role Drop Down");
	Thread.sleep(2000);
	generalUtils.takeScreenshots();		
	Thread.sleep(6000);
	driver.findElement(By.xpath("//*[@value='Module Admin']")).click();
	System.out.println("User Selects Role");
	Thread.sleep(5000);
	generalUtils.takeScreenshots();
	driver.findElement(By.xpath("//*[text()='Apply']")).click();
	Thread.sleep(15000);
	generalUtils.takeScreenshots();
	
		}
@Test(priority=7)

public void clear_all() throws Exception{
	driver.findElement(By.xpath("//*[text()='Clear All']")).click();
	generalUtils.takeScreenshots();
	Thread.sleep(4000);
	System.out.println("User is able to Clear all the FIlter");
}




	@Test(priority=8)
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