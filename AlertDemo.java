package HandlingAlertConfor;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertDemo
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
		// Load web page
		d.get("https://retail.onlinesbi.com/retail/login.htm");
		//Verify page title
		assertEquals(d.getTitle(),"State Bank of India - Personal Banking");
		// Click on CONTINUE TO LOGIN
		d.findElement(By.linkText("CONTINUE TO LOGIN")).click();
		// Click on Login button
		d.findElement(By.id("Button2")).click();
		// Switch driver focus to alert
		Alert al=d.switchTo().alert();
		// Verify alert text
		assertEquals(al.getText(),"Enter username");
		// Ok
		al.accept();
		// Enter user name
		d.findElement(By.id("username")).sendKeys("selenium");
		// Click on Login button
		d.findElement(By.id("Button2")).click();
		// Ok
		al.accept();
		// Enter password
		d.findElement(By.id("label2")).sendKeys("selenium");
		Thread.sleep(3000);
	}
	@AfterTest
	public void teardown()
	{
		d.quit();
	}
}
