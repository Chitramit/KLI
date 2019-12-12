package gRCenforce;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gRCenforce.Utilities.Xls_Reader;
import gRCenforce.Utilities.generalUtils;

public class Elements extends generalUtils {
	public static WebElement username= null;
	public static WebElement password = null;
	public  static WebElement Signin;
	public  static WebElement setting;
	public  static WebElement signout;
	
	
	
	//TextBox
	static {
		try {
			if(driver.findElement(By.xpath("//*[@title='Login ID']")) != null)
	  username =  driver.findElement(By.xpath("//*[@title='Login ID']"));
			if(driver.findElement(By.xpath("//*[@title='Password']")) != null)
	  password = driver.findElement(By.xpath("//*[@title='Password']"));
	

	
	
	
	//Buttons
	
	 Signin = driver.findElement(By.xpath("//*[text()='Sign in']"));
	setting = driver.findElement(By.xpath("//*[@title='Settings']"));
	signout = driver.findElement(By.xpath("//*[text()='Sign Out']"));
		}catch(Exception e) {
			System.out.println("error happened!");
		}
	}
	
	//Compliance Fields
	
	
	

}
