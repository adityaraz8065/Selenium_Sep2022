package handlingmouseandkeyword;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class gmailTabDemo 
{
	WebDriver d;
	@Test
	public void testNewTab() throws Exception
	{
		// Load web page
		d.get("https://www.google.com/");
		//Verify page title
		assertEquals(d.getTitle(),"Google");
		WebElement link1=d.findElement(By.linkText("Gmail"));
		Actions a=new Actions(d);
		a.moveToElement(link1).keyDown(Keys.CONTROL).click(link1).build().perform();
		Thread.sleep(3000);
		ArrayList<String> al=new ArrayList<String>(d.getWindowHandles());
		System.out.println(al);
		// Google ---> GMail
		d.switchTo().window(al.get(1));
		Thread.sleep(2000);
		// GMail ---> Google
		d.switchTo().window(al.get(0));
		Thread.sleep(2000);
	}
	@BeforeMethod
	public void setUp()
	{
		// Launch the browser
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		d.manage().deleteAllCookies();
		  
	}
	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}
}
