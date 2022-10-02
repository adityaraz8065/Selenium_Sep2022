package testscripts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeystoneLogin 
{
	WebDriver d;
	@Test
	public void testKeystoneLogin() throws Exception
	{
		d.get("https://ibank.keystonebankng.com/ibank/");
		d.findElement(By.xpath("//input[@id='login-username']")).sendKeys("Aditya");
		Thread.sleep(3000);
		d.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Raj");
		Thread.sleep(3000);
	}
	@BeforeMethod
		public void setUp()
		{
			d=new FirefoxDriver();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));
			d.manage().window().maximize();
			d.manage().deleteAllCookies();
		}
	@AfterMethod
	public void tearDown()
	{
		d.quit();
	}
	}

