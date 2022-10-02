package HandlingAlertConfor;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConformationDemo
{
	WebDriver d;
	@BeforeMethod
	public void setUp()
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
	}
	@Test
	public void testAlert() throws Exception
	{
		d.get("https://retail.onlinesbi.com/retail/login.htm");
		//verify title
		assertEquals(d.getTitle(),"State Bank of India - Personal Banking");
		d.findElement(By.linkText("CONTINUE TO LOGIN")).click();
		// Click on New User ? Register here/Activate 
		d.findElement(By.partialLinkText("New User ?")).click();
		Thread.sleep(1000);
		d.switchTo().alert().dismiss();
	}
	@AfterTest
	public void teardown()
	{
		d.quit();
	}
}
