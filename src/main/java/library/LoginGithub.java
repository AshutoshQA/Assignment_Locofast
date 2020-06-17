package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginGithub {
	static WebDriver driver;
	public static WebDriver login() throws InterruptedException
	{		
		driver=BrowserLaunch.launchBrowser();
		///login to the github
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]")).click();	
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("AshutoshQA");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ashu@Test123");
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		Thread.sleep(5000);
		return driver;
	}

}
