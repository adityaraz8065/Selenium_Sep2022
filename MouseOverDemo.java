package handlingmouseandkeyword;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseOverDemo 
{
	WebDriver d;
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
	@Test
	public void testBrowserHistory() throws Exception
	{
		//LoadWebpage
		d.get("https://jqueryui.com/");
		assertEquals(d.getTitle(),"jQuery UI");
		Actions a=new Actions(d);
		//a.moveToElement(d.findElement(By.linkText("Contribute"))).perform();
		d.findElement(By.linkText("Contribute")).click();
		Thread.sleep(3000);
		d.findElement(By.linkText("Bug Triage")).click();
		Thread.sleep(3000);
	}
	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}

}
