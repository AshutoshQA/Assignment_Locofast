package locofastChallenge;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import library.BrowserLaunch;
import library.LoginGithub;

public class Challenge1 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		//BrowserLaunch.launchBrowser();
		driver=LoginGithub.login();
		//********************Repository creation*****************************************************

		//create a repository
		driver.findElement(By.xpath("//summary[(@class='Header-link')]/span")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New repository')]")).click();
		driver.findElement(By.xpath("//input[@id='repository_name']")).sendKeys("GithubAssign");
		driver.findElement(By.xpath("//input[@id='repository_description']")).sendKeys(":smile: For Testing");
		driver.findElement(By.xpath("//button[contains(text(),'Create repository')]")).click();
		System.out.println("Repository created successfully");
		Thread.sleep(3000);


		//Challenge 2
		//create an issue
		driver.findElement(By.xpath("//span[@itemprop='name' and contains(text(),'Issues')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'New issue')]")).click();
		driver.findElement(By.xpath("//input[@id='issue_title']")).sendKeys("Github_Issue1");
		driver.findElement(By.xpath("//textarea[@id='issue_body']")).sendKeys("Github_Issue1");
		driver.findElement(By.xpath("//button[contains(text(),'Submit new issue')]")).click();	
		Thread.sleep(2000);
		//create another issue and mentioned previous issue in the same
		driver.findElement(By.xpath("//span[@itemprop='name' and contains(text(),'Issues')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'New issue')]")).click();
		driver.findElement(By.xpath("//input[@id='issue_title']")).sendKeys("Github_Issue2 #1");
		driver.findElement(By.xpath("//textarea[@id='issue_body']")).sendKeys("Github_Issue2 #1");
		driver.findElement(By.xpath("//button[contains(text(),'Submit new issue')]")).click();	
		Thread.sleep(2000);
		System.out.println("Issues created successfully");
		//Challenge 3
		//edit comment in #2
		driver.findElement(By.xpath("//textarea[@id='new_comment_field']")).sendKeys("Comment updated for 2nd Issue");
		driver.findElement(By.xpath("//button[contains(text(),'Comment')]")).click();	
		Thread.sleep(2000);
		//add emoji in repository
		//added in challenge 1

		//Challenge 4
		//create a new comment and mentioned any of previous issue
		driver.findElement(By.xpath("//span[@itemprop='name' and contains(text(),'Issues')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='issue_2_link']")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='new_comment_field']")).sendKeys("Comment updated again for 2nd Issue... #2");
		driver.findElement(By.xpath("//button[contains(text(),'Comment')]")).click();	
		Thread.sleep(2000);
		//navigate to issue from comment
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// 
		js.executeScript("window.scrollBy(0,-500)", "");				
		try {

			WebElement issueLink2=driver.findElement(By.xpath("//p[contains(text(),'Comment updated again for 2nd Issue')]/a"));					
			if(issueLink2.isDisplayed())
			{
				issueLink2.click();				
				Thread.sleep(3000);
			}
		} 
		catch (Exception e) 
		{

			e.printStackTrace();
		}

		//Challenge 5
		//delete repository	          
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/AshutoshQA/GithubAssign/settings']")).click();
		driver.findElement(By.xpath("//div[@class='Box Box--danger']/ul/li[4]/details/summary")).click();

		String parentHandle = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);								
		}

		WebElement msz2=driver.findElement(By.xpath("//*[@id=\"options_bucket\"]/div[9]/ul/li[4]/details/details-dialog/div[3]/form/p/input"));				
		js.executeScript("arguments[0].click()",msz2 );
		msz2.sendKeys("AshutoshQA/GithubAssign");
		driver.findElement(By.xpath("//button[contains(text(),'delete this repository')]")).click();
		System.out.println("Repository Successfully deleted");
		Thread.sleep(2000);				

		driver.switchTo().window(parentHandle);
		String txtMsz=driver.findElement(By.xpath("//div[contains(@class,'container-lg')]")).getText();
		assertEquals(txtMsz, "Your repository \"AshutoshQA/GithubAssign\" was successfully deleted.");			


	}

}
