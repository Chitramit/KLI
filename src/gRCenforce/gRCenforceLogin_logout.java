package gRCenforce;


import org.testng.annotations.Test;
import gRCenforce.Elements;
import gRCenforce.Utilities.Xls_Reader;
import gRCenforce.Utilities.generalUtils;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;




public class gRCenforceLogin_logout extends generalUtils {
	
	
	 static Xls_Reader read = new Xls_Reader("C:\\Users\\chitramitc478\\git\\KLI\\Datatable.xlsx");
	
	@BeforeClass
	public static void invokeBrowesers() throws Exception
	
	
	{
	
		generalUtils.launchChromeDriver();
		generalUtils.takeScreenshots();
		  
		  
	}
	
	
	
	@Test(priority=1)
	public static void login() throws Exception {
		
		Thread.sleep(10000);	
		driver.findElement(By.xpath("//*[@title='Login ID']")).sendKeys(read.getCellData("RegisterUserData", "userName", 2));
		driver.findElement(By.xpath("//*[@name='Password']")).sendKeys(read.getCellData("RegisterUserData", "password", 2));
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
				
		Thread.sleep(8000);		
		generalUtils.takeScreenshots();
		System.out.println("User is able to login");
		  
	}
	
	@Test(priority=2)
	public static void logout() throws Exception {
		
		try {
		Thread.sleep(8000);		
		driver.findElement(By.xpath("//*[@title='Settings']")).click();
		driver.findElement(By.xpath("//*[text()='Sign Out']")).click();		
		Thread.sleep(8000);		
		generalUtils.takeScreenshots();
		System.out.println("User is able to logout");
		}catch(Exception e) {
			System.out.println("exception ocurred!");
		}
		 
	}
			
		@AfterClass
	
	public static void afterTest()
	{
		System.out.println("Test Completed");
		driver.quit();
	
	}
}