package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class FbLoginTestNg
{
	
	WebDriver d;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Drivers\\geckodriver.exe");
		 d=new FirefoxDriver();
	}
	
	@Test
	public void testFbLogin() throws Exception
	{
		
		d.get("https://www.facebook.com/");
		d.findElement(By.id("email")).sendKeys("Aditya");
		d.findElement(By.id("pass")).sendKeys("Raj");
		d.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}
	@AfterMethod
	public void display()
	{
		d.quit();
	}
}
