package testscripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.Common;

public class BrowserHistoryDemo extends Common
{
	
	private static final String Thraed = null;
	
	@Test
	public void testBrowserHistory() throws Exception
	{
		//LoadWebpage
		d.navigate().to("https://www.selenium.dev/");
		assertEquals(d.getTitle(),"Selenium");
		d.findElement(By.linkText("Downloads")).click();
		Thread.sleep(3000);
		d.navigate().back();
		Thread.sleep(3000);
		d.navigate().forward();
		Thread.sleep(3000);
		d.navigate().refresh();
		Thread.sleep(3000);
	}
	
	
}
