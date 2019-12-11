package gRCenforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import gRCenforce.Utilities.generalUtils;

public class elements extends generalUtils{
	
	
	//TextBox
	public static final WebElement username = driver.findElement(By.xpath("//*[@title='Login ID']"));
	public static final WebElement password = driver.findElement(By.xpath("//*[@title='Password']"));
	
	
	
	//Buttons
	
	public static final WebElement Signin = driver.findElement(By.xpath("//*[text()='Sign in']"));
	public static final WebElement settings = driver.findElement(By.xpath("//*[@title='Settings']"));
	public static final WebElement signout = driver.findElement(By.xpath("//*[text()='Sign Out']"));
	
	
	

}
