package library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunch {
	public static WebDriver launchBrowser() throws InterruptedException
	{
		//Open Chrome browser
				System.setProperty("webdriver.chrome.silentOutput", "true");
				System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe"); 
				//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				//ChromeOptions options = new ChromeOptions();
				//options.addArguments("chrome.switches","--disable-extensions");
				//WebDriver driver=new ChromeDriver(options);
				WebDriver driver=new ChromeDriver();
				//Maximize the browser window
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("https://github.com");
				System.out.println("site open");
				Thread.sleep(2000);
				return driver;
	}

}
