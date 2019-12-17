package gRCenforce;


import org.testng.annotations.Test;

import gRCenforce.Utilities.Xls_Reader;
import gRCenforce.Utilities.generalUtils;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;



public class gRCenforceCompliance_history extends generalUtils {
	
	
	static Xls_Reader read = new Xls_Reader("C:\\Users\\chitramitc478\\git\\KLI\\Datatable.xlsx");
	
	@BeforeClass
	public void invokeBrowesers() throws Exception
	
	
	{
	
			generalUtils.launchChromeDriver();
		   generalUtils.takeScreenshots();
		  
	}
	
	
	
	@Test(priority = 1)
	public static void login() throws Exception {
		driver.findElement(By.xpath("//*[@title='Login ID']")).sendKeys(read.getCellData("GeneralUserData", "userName", 2));
		driver.findElement(By.xpath("//*[@name='Password']")).sendKeys(read.getCellData("GeneralUserData", "password", 2));
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();			
		Thread.sleep(15000);
		String Name = driver.findElement(By.xpath("//*[text()='Welcome']//following::span[2]")).getText();
		assertEquals(Name,"Submitter User 1","Login Succesfull");		
		 generalUtils.takeScreenshots();
		 System.out.println("User is able to login");
		  
	}
	
	@Test(priority = 2)
	public static void Select_Location_BU() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		Thread.sleep(8000);
		WebElement element =driver.findElement(By.xpath("//*[@class='ng-scope fa fa-angle-right']"));
		executor.executeScript("arguments[0].click();", element);
		System.out.println("User Clicks on COMPLIANCE Tab");
		Thread.sleep(2000);
		generalUtils.takeScreenshots();
		WebElement element_2 = driver.findElement(By.xpath("//span[text()='History']"));
		
		executor.executeScript("arguments[0].click();", element_2);
		Thread.sleep(6000);
		//User CLicks on History Tab
		generalUtils.takeScreenshots();
		driver.findElement(By.xpath("//span[text()='Compliance']")).click();
		Thread.sleep(6000);
		//User Clicks on Compliance History
		generalUtils.takeScreenshots();
		//select Location name and Business Unit
		driver.findElement(By.xpath("//*[contains(@data-select-all,'allLocationsSelected')]")).click();
		Thread.sleep(2000);		
		
		//User unChecks select all checkbox
				List<WebElement> element1 = driver.findElements(By.xpath("//*[contains(text(),'Location')]/ancestor::div[1]//span[@ng-if='trvw.useCheckboxes()']"));
				element1.get(0).click();
				Thread.sleep(2000);
				generalUtils.takeScreenshots();
				element1.get(7).click();
				Thread.sleep(2000);
				generalUtils.takeScreenshots();		
		
	}
	
@Test(priority=3)
	
	public void select_department() throws Exception{
					
		//User Clicks on Department
		driver.findElement(By.xpath("//*[contains(@data-select-all,'alldepartemntsSelected')]")).click();
		System.out.println("User is able to Click on Department Drop Down");
		Thread.sleep(2000);
		//User unChecks select all check box
		List<WebElement> element = driver.findElements(By.xpath("//*[contains(@data-select-all,'alldepartemntsSelected')]//following::span[@ng-if='trvw.useCheckboxes()']"));
		element.get(0).click();
		Thread.sleep(2000);
		generalUtils.takeScreenshots();		
		Thread.sleep(2000);
		element.get(1).click();
		generalUtils.takeScreenshots();
		
		//User Clicks on Apply
		
		driver.findElement(By.xpath("//*[text()='Apply']")).click();
		System.out.println("User Clicks on Apply");
		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		
		// Export report
		
		driver.findElement(By.xpath("//*[@ng-click='hCtrl.export()']")).click();
		Thread.sleep(4000);
		generalUtils.takeScreenshots();
		
		
		//Export attachemnts
		
		driver.findElement(By.xpath("//*[@title='Download Attachments']")).click();
		Thread.sleep(5000);
		generalUtils.takeScreenshots();
		
		}
	
	@Test(priority= 4)
	public static void logout() throws Exception {
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