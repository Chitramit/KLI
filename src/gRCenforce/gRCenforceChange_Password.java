package gRCenforce;


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;



public class gRCenforceChange_Password extends generalUtils {
	
	
	
	
	@BeforeClass
	public void invokeBrowesers() throws Exception
	
	
	{
	
			generalUtils.launchChromeDriver();
		   generalUtils.takeScreenshots();
		  
	}
	
	
	
	@Test()
	public void login() throws Exception {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@title='Login ID']")).sendKeys("submitter1");
		driver.findElement(By.xpath("//*[@name='Password']")).sendKeys("pass@123");
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		
		Thread.sleep(8000);
		
		 generalUtils.takeScreenshots();
		 System.out.println("User is able to login");
		  
	}
	
	@Test()
	public void changepassword() throws Exception {
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("//*[@title='Settings']")).click();
		driver.findElement(By.xpath("//*[text()='Change Password']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='currentPassword']")).sendKeys("pass@123");
		driver.findElement(By.xpath("//*[@name='newPassword']")).sendKeys("pass@234");
		driver.findElement(By.xpath("//*[@name='confirmPassword']")).sendKeys("pass@234");
		
		driver.findElement(By.xpath("//button//span[text()='Change Password']")).click();
		generalUtils.takeScreenshots();
		Thread.sleep(5000);
		generalUtils.takeScreenshots();
		
		
		Thread.sleep(8000);
		
		 generalUtils.takeScreenshots();
		 System.out.println("User is able to change password");
		 
	}
	
	
	@Test()
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