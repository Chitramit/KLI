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



public class gRCenforceSubmit_Not_Applicable_Task extends generalUtils {

	 Xls_Reader read = new Xls_Reader("C:\\Users\\chitramitc478\\git\\KLI\\Datatable.xlsx");
	
	
	
	@BeforeClass
	public void invokeBrowesers() throws Exception
	
	
	{
	
			generalUtils.launchChromeDriver();
		   generalUtils.takeScreenshots();
		   gRCenforceCreate_Compliance_Admin.login();
		   gRCenforceCreate_Compliance_Admin.click_new_Compliance();
		   gRCenforceCreate_Compliance_Admin.logout();
		  
		  
	}
	
	
	
	@Test(priority=1)
	public void login() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@title='Login ID']")).sendKeys(read.getCellData("GeneralUserData", "userName", 4));
		driver.findElement(By.xpath("//*[@name='Password']")).sendKeys(read.getCellData("GeneralUserData", "password", 4));
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();			
		Thread.sleep(15000);
		String Name = driver.findElement(By.xpath("//*[text()='Welcome']//following::span[2]")).getText();
		assertEquals(Name,"Chitramit Chatterjee","Login Succesfull");		
		 generalUtils.takeScreenshots();
		 System.out.println("User is able to login");
		  
		  
	}
	
	
	@Test(priority=2)
	
	public void go_to_all_Compliances() throws Exception{
					
		driver.findElement(By.xpath("//*[contains(@ng-if,'totalComplianceTasksOverdue')]")).click();
		Thread.sleep(12000);
		driver.findElement(By.xpath("//*[contains(@ng-click,'getTotal')]")).click();
		Thread.sleep(12000);
		generalUtils.takeScreenshots();
		
		
		
	}
	
@Test(priority=3)
	
	public void filter_compliance() throws Exception{
					
		driver.findElement(By.xpath("//*[text()='Compliance']/following-sibling::div[@ng-repeat='colFilter in col.filters']")).click();
		System.out.println("User is able to click on Filter");		
		generalUtils.takeScreenshots();
		driver.findElement(By.xpath("//*[text()='Text Filters']")).click();
		System.out.println("User Clicks on Text Filter");
		Thread.sleep(2000);
		generalUtils.takeScreenshots();
		Select filtertype = new Select(driver.findElement(By.xpath("//*[text()='Filter Type']//following::select")));
		filtertype.selectByVisibleText("Contains...");
		Thread.sleep(3000);
		
		//Deducting The Compliance Title name
		
		String compliance_title =  read.getCellData("RegisterUserData", "compliance_Tilte", 2);
		String [] array = compliance_title.split("_");
		int num = Integer.parseInt(array[1]);
		num=num-1;
		String sp2 = Integer.toString(num);
		String sp3= array[0]+"_"+sp2;
		

		driver.findElement(By.xpath("//*[@name='filterText']")).sendKeys(sp3);
		Thread.sleep(1000);
		generalUtils.takeScreenshots();
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		Thread.sleep(3000);
		generalUtils.takeScreenshots();
		
	   
		}

@Test(priority=4)

public void select_compliance_not_Applicable() throws Exception{
		//User Selects Check box				
		driver.findElement(By.xpath("//*[@ng-click='selectButtonClick(row, $event)']")).click();
		Thread.sleep(4000);
		generalUtils.takeScreenshots();
		System.out.println("User is able to click on the Checkbox");
		Select action = new Select(driver.findElement(By.xpath("//*[@ng-model='row.entity.Status']")));
		action.selectByVisibleText("Not Applicable");
		Thread.sleep(5000);
		generalUtils.takeScreenshots();		
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@name='naComment']")).sendKeys("Test Comments");
		
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