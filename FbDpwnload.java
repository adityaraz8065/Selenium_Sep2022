package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class FbDpwnload 
{
	WebDriver d;
	@BeforeMethod
	public void setUp()
	{
		d = new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));
		d.manage().deleteAllCookies();
		d.manage().window().maximize();
	}
	
	@Test
	public void testDownload() throws Exception
	{
		
		d.get("https://www.selenium.dev/downloads/");
		d.findElement(By.linkText("4.4.0")).click();
		Thread.sleep(2000);
		
		new ProcessBuilder("F:\\AutoIT\\Download.exe").start(); 
		Thread.sleep(8000);

		
	}
	@AfterMethod
	public void stop()
	{
		d.quit();
	}

}
