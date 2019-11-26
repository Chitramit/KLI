package gRCenforce;


import org.openqa.selenium.WebDriver;





import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import myFirstTestNG_Project.takeScreenshot;


public class gRCenforce extends takeScreenshot {
	
	public static WebDriver driver;
	
	
	@BeforeSuite
	
	public static void launchChromeDriver() throws Exception {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\chitramitc478\\eclipse-workspace2\\testset\\chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();
		  options.setExperimentalOption("useAutomationExtension", false);
		 options.addArguments("--start-maximized");
		  driver = new ChromeDriver(options);
		   driver.get("http://care.kotaklifeinsurance.com/");
		   takeScreenshot.takeScreenshots();
		  
	}
	
	
	
	@Test(priority=1)
	public void login() throws Exception {
	
		//driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Facebook");
		//driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	
	
			String a = driver.findElement(By.xpath("//*[text()='Benefits of logging in']")).getText();
			System.out.println(a);
			Assert.assertEquals(a, "Benefits of logging in");
			/*if (a.equals("Benefit of logging in"))
			{
					System.out.println("Benefits Of Login is Present");
				
			
			}			
		
			else {
				driver.quit();
			}*/
			
			//User Enters User name
			driver.findElement(By.xpath("//*[@type='text']")).sendKeys("eb.satyabrata@gmail.com");
			System.out.println("User is able to enter the Email ID");
			Thread.sleep(1000);
			//User Clicks Next
			driver.findElement(By.xpath("//*[@type='submit']")).click();
			System.out.println("User clicks on Next");
			Thread.sleep(8000);
			//User Enters OTP
			driver.findElement(By.xpath("//*[@type='password']")).sendKeys("123456");
			System.out.println("User is able to enter the OTP");
			//User Clicks Next
			driver.findElement(By.xpath("//*[text()='LOGIN']")).click();
			System.out.println("User clicks on LOGIN");
			Thread.sleep(30000);
		
			
			
		}
	@Test(priority=2)
	public void dashboardisOpened() throws Exception {
		
		if( driver.findElement(By.xpath("//*[text()='Hi Satyabrata Dutta']")).isDisplayed());
		{
		System.out.println("Dashboard is opened");
		}
		
				
	}
	@Test(priority=3)
	public void openViewDetails() throws Exception {
		
		driver.findElement(By.xpath("//div[@class='owl-item active']//button[@value='00012345']")).click();
		System.out.println("User Clicked on View Details");
		Thread.sleep(10000);
		
	}
	
	@Test(priority=4)
public void paypremium() throws Exception {
		
		driver.findElement(By.xpath("//a[text()='Pay Premium']")).click();
		System.out.println("User Clicked on Pay Premium");
		Thread.sleep(25000);
	}
	
	@Test(priority=5)
	public void paysecurely() throws Exception {
			
			driver.findElement(By.xpath("	//*[text()='PAY SECURELY']")).click();
			System.out.println("User Clicked on Pay Securely");
			Thread.sleep(50000);
	}
	
	@Test(priority=7)
	public void allpay() throws Exception {
			
			driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_rbodisclaimer_0']")).click();
			System.out.println("User Clicked on All Pay");
			Thread.sleep(7000);
	}
	
	@Test(priority=8)
	public void confirmandProceed() throws Exception {
			
			driver.findElement(By.xpath("//input[@value='Confirm and Proceed']")).click();
			System.out.println("User Clicked on All Pay");
			Thread.sleep(5000);
	}
	
	@Test(priority=9)
	public void netbanking() throws Exception {
			
			driver.findElement(By.xpath("//div[@id='OPTNBK']//span[@class='innerpanel-text innerpanel-bg border right-arrow paymentOption']")).click();
			System.out.println("User Clicked on Netbanking");
			Thread.sleep(5000);
	}
	
	@Test(priority=10)
	public void selectNetbankandPays() throws Exception {
			
			Select bank = new Select (driver.findElement(By.xpath("//select[@name='netBankingBank']")));
			bank.selectByVisibleText("AvenuesTest");
		
			System.out.println("User Clicked on bank");
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//a[@class='primary-button primary-button-bg SubmitBillShip']//span[text()='Make Payment']")).click();
			System.out.println("User Clicks on Make Payment");			
			Thread.sleep(8000);
	}
	

	@Test(priority=11)
	public void verifyandreturn() throws Exception {
			
			
			
			
			driver.findElement(By.xpath("//*[@value='Return To the Merchant Site']")).click();
			System.out.println("User Clicks on return to merchant site");			
			Thread.sleep(50000);
	}
	
	

	@AfterTest
	
	public void afterTest()
	{
		System.out.println("Test Completed");
		driver.quit();
	
	}
}