package testscripts;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import config.Common;

public class LoginPage extends Common
{
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get("https://demo.cyclos.org/ui/home");
		// Click on Login link
		d.findElement(By.id("login-link")).click();
		// Enter user name
		d.findElement(By.xpath("//input[@type='text']")).clear();
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("demo");
		String uname=d.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
		// Enter password
		d.findElement(By.xpath("//input[@type='password']")).clear();
		d.findElement(By.xpath("//input[@type='password']")).sendKeys("");
		String password=d.findElement(By.xpath("//input[@type='password']")).getAttribute("value");
		// Click on submit
		d.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
		Thread.sleep(2000);
		
		// Blank user name & blank password
		if(uname.equals("") && password.equals(""))
		{
			assertTrue(d.findElement(By.cssSelector(".principal .invalid-feedback")).getText().contains("This field is required"));
			assertTrue(d.findElement(By.cssSelector(".d-block .invalid-feedback")).getText().contains("This field is required"));
		}
		// Blank user name & Valid/invalid password
		else if(uname.equals("") && !(password.equals("")))
		{
			assertTrue(d.findElement(By.cssSelector(".principal .invalid-feedback")).getText().contains("This field is required"));
		}
		// Blank password & Valid/invalid user name
		else if(!(uname.equals("")) && password.equals(""))
		{
			assertTrue(d.findElement(By.cssSelector(".d-block .invalid-feedback")).getText().contains("This field is required"));
		}
		// Valid user name & valid password
		else if(isElementPresent(d, By.id("logout-trigger")))
		{
			d.findElement(By.id("logout-trigger")).click();
		}
		 //Both are invalid/ Anyone is invalid
		
		Thread.sleep(2000);
		
	}
	
	public boolean isElementPresent(WebDriver driver, By locator)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		try
		{
			driver.findElement(locator);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
			    
	}
	
}
