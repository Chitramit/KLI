package invokeBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class launchChrome {
	
	public static WebDriver driver;
	
	public static void launchChromeDriver() throws Exception {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\chitramitc478\\eclipse-workspace2\\testset\\chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();
		  options.setExperimentalOption("useAutomationExtension", false);
		 options.addArguments("--start-maximized");
		  driver = new ChromeDriver(options);
		   driver.get("http://care.kotaklifeinsurance.com/");

}
}