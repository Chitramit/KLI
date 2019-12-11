package gRCenforce;


import org.testng.annotations.Test;

import gRCenforce.Utilities.Xls_Reader;
import gRCenforce.Utilities.generalUtils;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;



public class gRCenforceCreate_Compliance_Admin extends generalUtils {
	
	
	Xls_Reader read = new Xls_Reader("C:\\Users\\chitramitc478\\git\\KLI\\Datatable.xlsx");
	
	@BeforeClass
	public void invokeBrowesers() throws Exception
	
	
	{
	
			generalUtils.launchChromeDriver();
		   generalUtils.takeScreenshots();
		  
	}
	
	
	
	@Test(priority = 1)
	public void login() throws Exception {
		driver.findElement(By.xpath("//*[@title='Login ID']")).sendKeys(read.getCellData("RegisterUserData", "userName", 2));
		driver.findElement(By.xpath("//*[@name='Password']")).sendKeys(read.getCellData("RegisterUserData", "password", 2));
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();			
		Thread.sleep(15000);
		String Name = driver.findElement(By.xpath("//*[text()='Welcome']//following::span[2]")).getText();
		assertEquals(Name,"Submitter User 1","Login Succesfull");		
		 generalUtils.takeScreenshots();
		 System.out.println("User is able to login");
		  
	}
	
	@Test(priority = 2)
	public void click_new_Compliance() throws Exception {
		Thread.sleep(8000);
		WebElement element =driver.findElement(By.xpath("//*[@class='ng-scope fa fa-angle-right']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		System.out.println("User Clicks on COMPLIANCE Tab");
		Thread.sleep(2000);
		generalUtils.takeScreenshots();
		WebElement element_2 = driver.findElement(By.xpath("//span[text()='Compliance Master']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element_2);
		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		driver.findElement(By.xpath("//span[text()='Create New Compliance']")).click();
		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		driver.findElement(By.xpath("//*[@name='LocationName']")).click();
		Thread.sleep(6000);
		
		
		
	}
	
	
	@Test(priority= 3)
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