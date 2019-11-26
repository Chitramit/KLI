package myFirstTestNG_Project;

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

import invokeBrowser.launchChrome;


public class takeScreenshot extends launchChrome {

	
	
	public static  void takeScreenshots() throws Exception {
	
	 
	String timeStamp;
	File screenShotName;
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//The below method will save the screen shot in d drive with name "screenshot.png"
	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
	screenShotName = new File("C:\\Users\\chitramitc478\\Desktop\\Screenshot\\"+timeStamp+".png");
	FileUtils.copyFile(scrFile, screenShotName);
	 
	String filePath = screenShotName.toString();
	Reporter.log("<br><img src='"+screenShotName+"' height='400' width='400'/><br>");
	 
	}


		
	}	
				
	


