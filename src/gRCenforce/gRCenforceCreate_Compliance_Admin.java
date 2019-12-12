package gRCenforce;


import org.testng.annotations.Test;

import gRCenforce.Utilities.Xls_Reader;
import gRCenforce.Utilities.generalUtils;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		Thread.sleep(9000);
		generalUtils.takeScreenshots();
		//select Location name
		driver.findElement(By.xpath("//*[@name='LocationName']")).click();
		Thread.sleep(6000);		
		WebElement locationname = driver.findElement(By.xpath("//*[@title='"+read.getCellData("RegisterUserData", "compliance_Location", 2)+"']//following-sibling::span[contains(text(),'"+read.getCellData("RegisterUserData", "compliance_Location", 2)+"')]"));		
		JavascriptExecutor executor12= (JavascriptExecutor)driver;
		executor12.executeScript("arguments[0].click();", locationname);
		Thread.sleep(3000);		
		//select Business Unit
		driver.findElement(By.xpath("//*[@name='BusinessUnitName']")).click();
		Thread.sleep(2000);
		WebElement buname =driver.findElement(By.xpath("//*[@title='"+read.getCellData("RegisterUserData","compliance_BU", 2)+"']//following-sibling::span[contains(text(),'"+read.getCellData("RegisterUserData", "compliance_BU", 2)+"')]"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click();", buname);
		Thread.sleep(3000);
		//select Department
		driver.findElement(By.xpath("//*[@name='DepartmentName']")).click();
		Thread.sleep(2000);
		WebElement department =driver.findElement(By.xpath("//*[@title='"+read.getCellData("RegisterUserData","compliance_Department", 2)+"']//following-sibling::span[contains(text(),'"+read.getCellData("RegisterUserData", "compliance_Department", 2)+"')]"));
		JavascriptExecutor executor13 = (JavascriptExecutor)driver;
		executor13.executeScript("arguments[0].click();", department);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='ComplianceTitle']")).sendKeys(read.getCellData("RegisterUserData", "compliance_Tilte", 2));
		String compliance_title =  read.getCellData("RegisterUserData", "compliance_Tilte", 2);
		String [] array = compliance_title.split("_");
		int num = Integer.parseInt(array[1]);
		num=num+1;
		String sp2 = Integer.toString(num);
		String sp3= array[0]+sp2;
		System.out.println(sp3);
		read.setCellData("RegisterUserData", "compliance_Tilte", 2, sp3);
		
		
		
		
		
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