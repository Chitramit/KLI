package gRCenforce.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;



public class  generalUtils   {

	
	
	public static WebDriver driver;
	
	

	
	public static  void takeScreenshots() throws Exception {
	
	 
	String timeStamp;
	File screenShotName;
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//The below method will save the screen shot in d drive with name "screenshot.png"
	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
	screenShotName = new File("C:\\Users\\chitramitc478\\Desktop\\Screenshot\\"+timeStamp+".png");
	FileUtils.copyFile(scrFile, screenShotName);
	 
	screenShotName.toString();
	Reporter.log("<br><img src='"+screenShotName+"' height='400' width='400'/><br>");
	 
	}

	
	public static void launchChromeDriver() throws Exception {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\chitramitc478\\git\\KLI\\chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();
		  options.setExperimentalOption("useAutomationExtension", false);
		 options.addArguments("--start-maximized");
		  driver = new ChromeDriver(options);
		   driver.get("http://13.71.85.180:8081/");
		   Thread.sleep(5000);
		   
	
	}	
	
	public static void click_compliance_attributes() throws Exception{
		
		List<WebElement>  a= driver.findElements(By.xpath("//*[@title='Compliance Attributes']"));
		if (a.size()>0){
	    a.get(0).click();
	    System.out.println("User Clicks on Comliance Attributes");
	    Thread.sleep(6000);
	    generalUtils.takeScreenshots();
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		System.out.println("User Clicks on OK");
		Thread.sleep(4000);
		}
		else
		{
			System.out.println("There are No Records");
		}
		
	}
	
	public static void reopen_task() throws Exception{
		
		List<WebElement>  b= driver.findElements(By.xpath("//*[@class='fa-reopen']"));
		if (b.size()>0)
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", b.get(0));
			Thread.sleep(5000);
			System.out.println("User Clicks on reopen task");
			generalUtils.takeScreenshots();
			driver.findElement(By.xpath("//*[text()='Cancel']")).click();
		}
	}
	
	public static void workflow_history() throws Exception{
		List<WebElement>  element= driver.findElements(By.xpath("//*[contains(@ng-click,'WorkFlowHistory')]"));
		if (element.size()>0) {
		Actions builder = new Actions(driver);
        builder.moveToElement(element.get(0)).click(element.get(0));
        builder.perform();
	
	    System.out.println("User Clicks on Work Flow History");
	    Thread.sleep(5000);
	    generalUtils.takeScreenshots();
	    driver.findElement(By.xpath("//*[text()='OK']")).click();
		}
}


	
	

}
