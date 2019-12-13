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



public class gRCenforceCreate_Compliance_Admin extends generalUtils {
	
	
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
	public static void click_new_Compliance() throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		Thread.sleep(8000);
		WebElement element =driver.findElement(By.xpath("//*[@class='ng-scope fa fa-angle-right']"));
		executor.executeScript("arguments[0].click();", element);
		System.out.println("User Clicks on COMPLIANCE Tab");
		Thread.sleep(2000);
		generalUtils.takeScreenshots();
		WebElement element_2 = driver.findElement(By.xpath("//span[text()='Compliance Master']"));
		
		executor.executeScript("arguments[0].click();", element_2);
		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		driver.findElement(By.xpath("//span[text()='Create New Compliance']")).click();
		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		//select Location name
		driver.findElement(By.xpath("//*[@name='LocationName']")).click();
		Thread.sleep(2000);		
		WebElement locationname = driver.findElement(By.xpath("//*[@title='"+read.getCellData("RegisterUserData", "compliance_Location", 2)+"']//following-sibling::span[contains(text(),'"+read.getCellData("RegisterUserData", "compliance_Location", 2)+"')]"));		
		
		executor.executeScript("arguments[0].click();", locationname);
		Thread.sleep(3000);		
		//select Business Unit
		driver.findElement(By.xpath("//*[@name='BusinessUnitName']")).click();
		Thread.sleep(2000);
		WebElement buname =driver.findElement(By.xpath("//*[@title='"+read.getCellData("RegisterUserData","compliance_BU", 2)+"']//following-sibling::span[contains(text(),'"+read.getCellData("RegisterUserData", "compliance_BU", 2)+"')]"));
		
		executor.executeScript("arguments[0].click();", buname);
		Thread.sleep(3000);
		//select Department
		driver.findElement(By.xpath("//*[@name='DepartmentName']")).click();
		Thread.sleep(2000);
		WebElement department =driver.findElement(By.xpath("//*[@title='"+read.getCellData("RegisterUserData","compliance_Department", 2)+"']//following-sibling::span[contains(text(),'"+read.getCellData("RegisterUserData", "compliance_Department", 2)+"')]"));
		
		executor.executeScript("arguments[0].click();", department);
		Thread.sleep(3000);
		//Enter Compliance Title
		driver.findElement(By.xpath("//*[@name='ComplianceTitle']")).sendKeys(read.getCellData("RegisterUserData", "compliance_Tilte", 2));
		String compliance_title =  read.getCellData("RegisterUserData", "compliance_Tilte", 2);
		String [] array = compliance_title.split("_");
		int num = Integer.parseInt(array[1]);
		num=num+1;
		String sp2 = Integer.toString(num);
		String sp3= array[0]+"_"+sp2;
		System.out.println(sp3);
		read.setCellData("RegisterUserData", "compliance_Tilte", 2, sp3);
		//Enter Description
		driver.findElement(By.xpath("//*[@name='ComplianceDescription']")).sendKeys(read.getCellData("RegisterUserData", "compliance_Description", 2));
		Thread.sleep(2000);
		//Enter Compliance Type
		driver.findElement(By.xpath("//*[@name='ComplianceTypeName']")).click();
		Thread.sleep(2000);
		WebElement compliancetype =driver.findElement(By.xpath("//*[@title='"+read.getCellData("RegisterUserData","compliance_type", 2)+"']//following-sibling::span[contains(text(),'"+read.getCellData("RegisterUserData", "compliance_type", 2)+"')]"));
		
		executor.executeScript("arguments[0].click();", compliancetype);
		Thread.sleep(3000);
		//select law Type Master
		
		driver.findElement(By.xpath("//*[@name='LawTypeName']")).click();
		Thread.sleep(2000);
		WebElement lawtype =driver.findElement(By.xpath("//*[@title='"+read.getCellData("RegisterUserData","law_type_master", 2)+"']//following-sibling::span[contains(text(),'"+read.getCellData("RegisterUserData", "law_type_master", 2)+"')]"));
		
		executor.executeScript("arguments[0].click();", lawtype);
		Thread.sleep(2000);
		//Select Section
		
		driver.findElement(By.xpath("//*[@name='SectionName']")).click();
		Thread.sleep(2000);
		WebElement section =driver.findElement(By.xpath("//*[@title='"+read.getCellData("RegisterUserData","section", 2)+"']//following-sibling::span[contains(text(),'"+read.getCellData("RegisterUserData", "section", 2)+"')]"));
		
		executor.executeScript("arguments[0].click();", section);
		Thread.sleep(2000);
		
		//select primary legislation
		
		driver.findElement(By.xpath("//*[@name='PrimaryLegislationName']")).click();
		Thread.sleep(2000);
		WebElement PrimaryLegislationName =driver.findElement(By.xpath("//*[@title='"+read.getCellData("RegisterUserData","primary_legislation", 2)+"']//following-sibling::span[contains(text(),'"+read.getCellData("RegisterUserData", "primary_legislation", 2)+"')]"));
		executor.executeScript("arguments[0].click();", PrimaryLegislationName);
		Thread.sleep(2000);
		
		generalUtils.takeScreenshots();
		
		List<WebElement> textbox = driver.findElements(By.xpath("//*[@name='textbox']"));
		//enter Internal Compliance reference
		
		textbox.get(0).sendKeys(read.getCellData("RegisterUserData", "internal_compliance_reference", 2));
		
		//Enter Acceptability
		
		textbox.get(1).sendKeys(read.getCellData("RegisterUserData", "aceptability", 2));
		
		//Enter Helping Hand
		
		textbox.get(2).sendKeys(read.getCellData("RegisterUserData", "helping_hand", 2));
		
		//Enter Due Date as per law
		
		textbox.get(3).sendKeys(read.getCellData("RegisterUserData", "due_date_as_per_law", 2));
		
		//Enter Penalty terms
		
		textbox.get(5).sendKeys(read.getCellData("RegisterUserData", "penalty_terms", 2));
		
		
		//select priority
		List<WebElement> dropdown = driver.findElements(By.xpath("//*[text()='Priority ']/following::select[1]"));
		Select slct = new Select(dropdown.get(0));
		slct.selectByVisibleText(read.getCellData("RegisterUserData", "prioriry", 2));
		generalUtils.takeScreenshots();
		
		//select Assessment frequency
		Select slct1 = new Select(dropdown.get(1));
		slct1.selectByVisibleText(read.getCellData("RegisterUserData", "assessment_frequency", 2));
		
		//Enter Owner name
		
		driver.findElement(By.xpath("//*[@placeholder='Select Owner']")).sendKeys(read.getCellData("RegisterUserData", "owner", 2));
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@placeholder='Select Owner']")).sendKeys(Keys.TAB);
		
		//Enter Approver name
		
		driver.findElement(By.xpath("//*[@placeholder='Select Approver']")).sendKeys(read.getCellData("RegisterUserData", "approver", 2));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@placeholder='Select Approver']")).sendKeys(Keys.TAB);
		generalUtils.takeScreenshots();
		
		//Click Submit
		
		driver.findElement(By.xpath("//*[text()='Submit']")).click();
		Thread.sleep(3000);
		generalUtils.takeScreenshots();
		
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		
		Thread.sleep(6000);
		generalUtils.takeScreenshots();
		
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		
		
	
		
		
	}
	
	
	@Test(priority= 3)
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